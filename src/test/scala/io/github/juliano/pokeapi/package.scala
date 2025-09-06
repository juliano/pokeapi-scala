package io.github.juliano

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.Try

import io.github.juliano.pokeapi.models.ResourceList

import cats.effect.IO
import cats.implicits.*
import cats.syntax.all.*
import munit.{ AfterEach, AnyFixture, BeforeEach, Compare, FunSuite }
import sttp.client3.{ Identity, SttpBackend, UriContext }
import sttp.monad.MonadError
import sttp.monad.syntax.*
import zio.{ Task, ZIO }
import zio.json.JsonDecoder

package object pokeapi:
  given MonadError[Identity] = sttp.client3.monad.IdMonad
  given MonadError[Try] = sttp.monad.TryMonad
  given MonadError[Future] = sttp.monad.FutureMonad()
  given MonadError[IO] = sttp.client3.impl.cats.CatsMonadError[IO]
  given MonadError[Task] = sttp.client3.impl.zio.RIOMonadAsyncError[Any]

  private abstract class EffectFixture[F[_], T](name: String)(using mf: MonadError[F])
      extends AnyFixture[T](name) {
    override def beforeAll(): F[Unit]                     = mf.unit(())
    override def beforeEach(context: BeforeEach): F[Unit] = mf.unit(())
    override def afterEach(context: AfterEach): F[Unit]   = mf.unit(())
    override def afterAll(): F[Unit]                      = mf.unit(())
  }

  trait EffectSuite[F[_]](using mf: MonadError[F]) extends FunSuite:
    protected val backend: F[SttpBackend[F, Any]]

    protected val finalizer: F[Unit] = mf.unit(())

    protected val client = new EffectFixture[F, PokeApiClient[F, Any]]("client") {
      private var client: PokeApiClient[F, Any] = null

      def apply() = client

      override def beforeAll() = backend.map(implicit b => client = PokeApiClient())
      override def afterAll()  = finalizer
    }

    override def munitFixtures = List(client)

    override def munitValueTransforms = super.munitValueTransforms ++ List(
      new ValueTransform(
        "Try",
        { case t: Try[Any] => Future.fromTry(t) }
      ),
      new ValueTransform(
        "ZIO",
        { case z: ZIO[?, ?, ?] =>
          zio.Unsafe.unsafe { implicit u =>
            zio.Runtime.default.unsafe.runToFuture(z.asInstanceOf[Task[Any]])
          }
        }
      ),
      new ValueTransform(
        "Cats",
        { case io: IO[Any] =>
          import cats.effect.unsafe.implicits.global
          io.unsafeToFuture()
        }
      )
    )

    extension (client: PokeApiClient[F, Any])
      def fullResourceList[R: ApiPath] = client.getResourceList[R](limit = 100000)

    def spec[A: JsonDecoder: ApiPath](
        label: String,
        id: String | Long,
        predicate: A => Boolean
    ): Unit = test(label) {
      client().get(id).map(result => assert(predicate(result)))
    }

    def spec[A: JsonDecoder: ApiPath, B](
        label: String,
        id: String | Long,
        keyFn: A => B,
        expected: B
    ): Unit = test(label) {
      client().get(id).map(result => assertEquals(keyFn(result), expected))
    }

    def spec[A: JsonDecoder: ApiPath](
        label: String,
        id: String | Long,
        keyFn: A => String,
        expected: String
    ): Unit = spec[A, String](label, id, keyFn, expected)

    def spec[A: JsonDecoder: ApiPath](
        label: String,
        id: String | Long,
        keyFn: A => Int,
        expected: Int
    ): Unit = spec[A, Int](label, id, keyFn, expected)

    def spec[R: ApiPath, B](
        label: String,
        keyFn: ResourceList => B,
        expected: B
    ): Unit = test(label) {
      client().getResourceList(limit = 100000).map(result => assertEquals(keyFn(result), expected))
    }

    def spec[R: ApiPath](
        label: String,
        keyFn: ResourceList => String,
        expected: String
    ): Unit = spec[R, String](label, keyFn, expected)

    def spec[R: ApiPath](
        label: String,
        keyFn: ResourceList => Int,
        expected: Int
    ): Unit = spec[R, Int](label, keyFn, expected)

  trait FutureSuite extends EffectSuite[Future]:
    import scala.concurrent.ExecutionContext.Implicits.global
    override val backend = Future(sttp.client3.HttpClientFutureBackend())

  trait TrySuite extends EffectSuite[Try]:
    override val backend = scala.util.Success(sttp.client3.TryHttpURLConnectionBackend())

  trait SyncSuite extends EffectSuite[Identity]:
    override val backend = sttp.client3.HttpClientSyncBackend()

  trait OkSyncSuite extends SyncSuite:
    override val backend = sttp.client3.okhttp.OkHttpSyncBackend()

  trait ZIOSuite extends EffectSuite[[A] =>> ZIO[Any, Throwable, A]]:
    override val backend = sttp.client3.asynchttpclient.zio.AsyncHttpClientZioBackend()

  trait ArmeriaZIOSuite extends ZIOSuite:
    override val backend = sttp.client3.armeria.zio.ArmeriaZioBackend()

  trait CatsSuite extends EffectSuite[IO]:
    override val backend = sttp.client3.asynchttpclient.cats.AsyncHttpClientCatsBackend()

  trait ArmeriaCatsSuite extends CatsSuite:
    override val backend = IO(sttp.client3.armeria.cats.ArmeriaCatsBackend[IO]())

    def queryAll[A: JsonDecoder: ApiPath](label: String) = test(label) {
      for {
        resourceList <- client().fullResourceList[A]
        uris = resourceList.results.map(res => uri"${res.url}")
        resps <- uris.parTraverse(client().getUri)
      } yield assertEquals(resps.length, resourceList.count)
    }

  trait Fs2Suite extends EffectSuite[IO]:
    private val backendAndFinalizer =
      sttp.client3.asynchttpclient.fs2.AsyncHttpClientFs2Backend.resource[IO]().allocated

    override val backend   = backendAndFinalizer.map(_._1)
    override val finalizer = backendAndFinalizer.flatMap(_._2)
