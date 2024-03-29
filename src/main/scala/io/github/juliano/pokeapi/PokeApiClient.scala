package io.github.juliano.pokeapi

import com.github.blemale.scaffeine.{ Cache, Scaffeine }
import io.github.juliano.pokeapi.PokeApiClient.*
import sttp.client3.*
import sttp.client3.ziojson.asJson
import sttp.model.{ MediaType, Uri }
import sttp.monad.MonadError
import sttp.monad.syntax.MonadErrorOps
import zio.json.JsonDecoder

import scala.concurrent.duration.DurationInt

case class PokeApiClient[F[_], +P](host: ApiHost = ApiHost.default)(using
    backend: SttpBackend[F, P]
):
  given monadError: MonadError[F] = backend.responseMonad
  private val cache: Cache[String, Product] = Scaffeine().build[String, Product]()

  def send[A](request: PokeRequest[A])(using JsonDecoder[A]): F[A] =
    cache.getIfPresent(request.toString) match
      case Some(value) =>
        monadError.unit(value.asInstanceOf[A])
      case None =>
        doSend(request).flatMap {
          case Right(value) =>
            cache.put(request.toString, value.asInstanceOf[Product])
            monadError.unit(value)
          case Left(error) => monadError.error(error)
        }

  private def doSend[A](
      request: PokeRequest[A]
  )(using JsonDecoder[A]): F[Either[FailureResponse, A]] =
    request
      .sttpRequest(host)
      .send(backend)
      .map(_.body)

object PokeApiClient:
  type FailureResponse = ResponseException[String, String]
  type SttpRequest[A]  = Request[Either[FailureResponse, A], Any]

  trait PokeRequest[A](id: String | Long):
    val resource: String

    def sttpRequest(host: ApiHost)(using JsonDecoder[A]): SttpRequest[A] =
      makeRequest(host.uri.addPath(resource, id.toString))

  def makeRequest[A](uri: Uri)(using JsonDecoder[A]): SttpRequest[A] =
    basicRequest
      .get(uri)
      .readTimeout(10.seconds)
      .contentType(MediaType.ApplicationJson)
      .response(asJson[A])
