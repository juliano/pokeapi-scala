package io.github.juliano

import io.github.juliano.pokeapi.PokeApiClient.PokeRequest
import zio.json.JsonDecoder

package object pokeapi:
  trait ZIOSuite extends munit.FunSuite:
    import zio.{ Runtime, Unsafe, ZIO }

    val client: ZIO[Any, Throwable, PokeApiClient[[A] =>> ZIO[Any, Throwable, A]]]

    def spec[T](label: String, request: PokeRequest[T], f: T => Boolean)(using
        JsonDecoder[T]
    ): Unit = test(label) {
      val zio = client.flatMap(_.send(request))
      val result = Unsafe.unsafeCompat { implicit u =>
        Runtime.default.unsafe.run(zio).getOrThrowFiberFailure()
      }
      assert(f(result))
    }

  trait CatsSuite extends munit.FunSuite:
    import cats.effect.IO
    import cats.effect.unsafe.implicits.global

    val client: IO[PokeApiClient[IO]]

    def spec[T](label: String, request: PokeRequest[T], f: T => Boolean)(using
        JsonDecoder[T]
    ): Unit = test(label) {
      val result = client.flatMap(_.send(request)).unsafeRunSync()
      assert(f(result))
    }

  trait TrySuite extends munit.FunSuite:
    import scala.util.{ Failure, Success, Try }

    val client: PokeApiClient[Try]

    def spec[T](label: String, request: PokeRequest[T], f: T => Boolean)(using
        JsonDecoder[T]
    ): Unit = test(label) {
      client.send(request) match {
        case Success(result) => assert(f(result))
        case Failure(t)      => fail("test failed", t)
      }
    }

  trait FutureSuite extends munit.FunSuite:
    import scala.concurrent.ExecutionContext.Implicits.global
    import scala.concurrent.Future
    import scala.util.{ Failure, Success }

    val client: PokeApiClient[Future]

    def spec[T](label: String, request: PokeRequest[T], f: T => Boolean)(using
        JsonDecoder[T]
    ): Unit = test(label) {
      client.send(request).onComplete {
        case Success(result) => assert(f(result))
        case Failure(t)      => fail("test failed", t)
      }
    }

  trait Fs2Suite extends munit.FunSuite:
    import cats.effect.IO
    import cats.effect.kernel.Resource
    import cats.effect.unsafe.implicits.global

    val client: Resource[IO, PokeApiClient[IO]]

    def spec[T](label: String, request: PokeRequest[T], f: T => Boolean)(using
        JsonDecoder[T]
    ): Unit = test(label) {
      val result = client.use(_.send(request)).unsafeRunSync()
      assert(f(result))
    }
