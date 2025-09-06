package io.github.juliano.pokeapi

import scala.concurrent.duration.DurationInt

import io.github.juliano.pokeapi.PokeApiClient.*
import io.github.juliano.pokeapi.models.ResourceList

import com.github.blemale.scaffeine.{ Cache, Scaffeine }
import sttp.client3.*
import sttp.client3.ziojson.asJson
import sttp.model.{ MediaType, Uri }
import sttp.model.Uri.AbsolutePath
import sttp.monad.MonadError
import sttp.monad.syntax.MonadErrorOps
import zio.json.JsonDecoder

case class PokeApiClient[F[_], +P](host: ApiHost = ApiHost.default)(using
    backend: SttpBackend[F, P]
):
  given monadError: MonadError[F] = backend.responseMonad

  private def cache[A]: Cache[Uri, A] =
    Scaffeine().build[Uri, A]()

  private def sttpRequest[A: JsonDecoder](uri: Uri): SttpRequest[A] =
    val uriSegments = uri.pathSegments.segments
    basicRequest
      .get( // Remove trailing slash since it can cause PokeAPI to return "OK" instead of a JSON response.
        if uriSegments.last.v.isEmpty then
          uri.copy(pathSegments = AbsolutePath(uriSegments.init.toSeq))
        else uri
      )
      .readTimeout(10.seconds)
      .contentType(MediaType.ApplicationJson)
      .response(asJson[A])

  def getUri[A: JsonDecoder](uri: Uri): F[A] =
    cache.getIfPresent(uri) match
      case Some(value) =>
        monadError.unit(value)
      case None =>
        sttpRequest(uri)
          .send(backend)
          .map(_.body)
          .flatMap {
            case Right(value) =>
              cache.put(uri, value)
              monadError.unit(value)
            case Left(error) =>
              monadError.error(
                Throwable(
                  s"Failed to parse response.\nError was ${error.getMessage}\nURI was ${uri}",
                  error
                )
              )
          }

  def get[A: JsonDecoder: ApiPath](id: String | Long): F[A] =
    getUri(host.uri.addResourcePath[A](id))

  def getResourceList[R: ApiPath](offset: Int = 0, limit: Int = 20): F[ResourceList] =
    getUri(
      host.uri
        .addResourcePath[R]("")
        .addParams(Map("offset" -> offset.toString, "limit" -> limit.toString))
    )

object PokeApiClient:
  type FailureResponse = ResponseException[String, String]
  type SttpRequest[A]  = Request[Either[FailureResponse, A], Any]
  type SttpResponse[A] = Response[Either[FailureResponse, A]]
