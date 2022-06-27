package io.github.juliano

import io.github.juliano.pokeapi.PokeApiClient.PokeRequest
import zio.json.JsonDecoder

package object pokeapi {
  trait ZIOSuite extends munit.FunSuite {
    import zio.{ Runtime, ZIO }

    val client: ZIO[Any, Throwable, PokeApiClient[[A] =>> zio.ZIO[Any, Throwable, A], _]]

    def spec[T](label: String, request: PokeRequest[T], f: T => Boolean)(using
        JsonDecoder[T]
    ): Unit = test(label) {
      val zio    = client.flatMap(_.send(request))
      val result = Runtime.default.unsafeRun(zio)
      assert(f(result))
    }
  }

  trait CatsSuite extends munit.FunSuite {
    import cats.effect.IO
    import cats.effect.unsafe.implicits.global

    val client: IO[PokeApiClient[IO, Any]]

    def spec[T](label: String, request: PokeRequest[T], f: T => Boolean)(using
        JsonDecoder[T]
    ): Unit = test(label) {
      val result = client.flatMap(_.send(request)).unsafeRunSync()
      assert(f(result))
    }
  }

  trait TrySuite extends munit.FunSuite {
    import scala.util.{ Failure, Success, Try }

    val client: PokeApiClient[Try, Any]

    def spec[T](label: String, request: PokeRequest[T], f: T => Boolean)(using
        JsonDecoder[T]
    ): Unit = test(label) {
      client.send(request) match {
        case Success(result) => assert(f(result))
        case Failure(t)      => fail("test failed", t)
      }
    }
  }

  trait FutureSuite extends munit.FunSuite {
    import scala.concurrent.ExecutionContext.Implicits.global
    import scala.concurrent.Future
    import scala.util.{ Failure, Success }

    val client: PokeApiClient[Future, Any]

    def spec[T](label: String, request: PokeRequest[T], f: T => Boolean)(using
        JsonDecoder[T]
    ): Unit = test(label) {
      client.send(request).onComplete {
        case Success(result) => assert(f(result))
        case Failure(t)      => fail("test failed", t)
      }
    }
  }

  trait Fs2Suite extends munit.FunSuite {
    import cats.effect.IO
    import cats.effect.kernel.Resource
    import cats.effect.unsafe.implicits.global
    import sttp.capabilities.WebSockets
    import sttp.capabilities.fs2.Fs2Streams

    val client: Resource[IO, PokeApiClient[IO, Fs2Streams[cats.effect.IO] & WebSockets]]

    def spec[T](label: String, request: PokeRequest[T], f: T => Boolean)(using
        JsonDecoder[T]
    ): Unit = test(label) {
      val result = client.use(_.send(request)).unsafeRunSync()
      assert(f(result))
    }
  }
}
