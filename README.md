# PokeAPI Scala Client <a href="https://pokeapi.co/api/v2/pokemon/6"><img src='https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/6.png' height=70px/></a>
[![CI](https://github.com/juliano/pokeapi-scala/actions/workflows/ci.yml/badge.svg)](https://github.com/juliano/pokeapi-scala/actions/workflows/release.yml)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/io.github.juliano/pokeapi-scala_3/badge.svg)](https://maven-badges.herokuapp.com/maven-central/io.github.juliano/pokeapi-scala_3)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

Scala 3 client implementation for the [Pokemon API](https://pokeapi.co/)

To get started check the documentation on [https://pokeapi.co/docs/v2](https://pokeapi.co/docs/v2)

## Getting Started

Add the following to your build.sbt:

```scala
libraryDependencies += "io.github.juliano" % "pokeapi-scala_3" % "0.3.0"
```

### `Sttp` backends support

This client is written using [sttp](https://sttp.softwaremill.com/en/latest/index.html), so all of the [sttp backends](https://sttp.softwaremill.com/en/latest/backends/summary.html) published for Scala 3 are supported.

## Usage

First, `import io.github.juliano.pokeapi.given`. Then instantiate a backend implicitly, create a `PokeApiClient()` and start consuming the api, calling `client.get(id | name)`. Most requests accept an `id: Long` or `name: String` (have a look at [Scala 3 Union Types](https://docs.scala-lang.org/scala3/book/types-union.html)).

It's possible to [list / paginate resources](https://pokeapi.co/docs/v2#resource-listspagination-section) as well, calling `client.getResourceList(offset: Int, limit: Int)`.

All `PokeApiClient.get` methods take a type parameter, which is the data model being requested. For example, you could call `client.get[Pokemon]("bulbasaur")` to retrieve [Bulbasaur's data](https://pokeapi.co/api/v2/pokemon/bulbasaur/) or `client.getResourceList[Pokemon]()` to retrieve [a list of all Pokemon](https://pokeapi.co/api/v2/pokemon/). All model types are available under `io.github.juliano.pokeapi.models`.

### Caching

Every response is automatically cached in memory, making all subsequent requests to the same resource pull cached data.

## Examples

### HttpClient

```scala
import io.github.juliano.pokeapi.requests.BerryRequest
import sttp.client3.{ HttpClientSyncBackend, Identity, SttpBackend }

given backend: SttpBackend[Identity, Any] = HttpClientSyncBackend()
val client = PokeApiClient()

val berry = client.send(BerryRequest(1))
println(berry.name)
```

### Try

```scala
import io.github.juliano.pokeapi.requests.MoveRequest
import sttp.client3.{ SttpBackend, TryHttpURLConnectionBackend }
import scala.util.*

given backend: SttpBackend[Try, Any] = TryHttpURLConnectionBackend()
val client = PokeApiClient()

client.send(MoveRequest("pound")) match {
    case Success(move) => println(move.names)
    case Failure(t)    => println(s"Failed with: $t")
}
```

### Future

```scala
import io.github.juliano.pokeapi.requests.ContestTypeRequest
import sttp.capabilities.WebSockets
import sttp.client3.{ HttpClientFutureBackend, SttpBackend }
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.*

given backend: SttpBackend[Future, WebSockets] = HttpClientFutureBackend()
val client = PokeApiClient()

client.send(ContestTypeRequest(1)).onComplete {
    case Success(contest) => println(contest.names)
    case Failure(t)       => println(s"Failed with: $t")
}
```

### ZIO

```scala
import io.github.juliano.pokeapi.requests.PokemonRequest
import sttp.client3.asynchttpclient.zio.AsyncHttpClientZioBackend
import zio.{ Runtime, Unsafe, ZIO }

val client = AsyncHttpClientZioBackend().map(implicit backend => PokeApiClient())

val zio = client.flatMap(_.send(PokemonRequest("bulbasaur")))
val pokemon = Unsafe.unsafeCompat { implicit u =>
  Runtime.default.unsafe.run(zio).getOrThrowFiberFailure()
}
print(pokemon.id)
```

### Cats Effect

```scala
import cats.effect.IO
import cats.effect.unsafe.implicits.global
import io.github.juliano.pokeapi.requests.LocationRequest
import sttp.client3.asynchttpclient.cats.AsyncHttpClientCatsBackend

val client = AsyncHttpClientCatsBackend[IO]().map(implicit backend => PokeApiClient())

val list = client.flatMap(_.send(LocationRequest.resourceList())).unsafeRunSync()
print(list.count)
```

You can find more examples using Fs2, Armaria and okhttp [in the tests](https://github.com/juliano/pokeapi-scala/tree/main/src/test/scala/io/github/juliano/pokeapi)

## Contributing

Feel free to open pull requests or submit issues!

## License

pokeapi-scala is available as open source under the terms of the [MIT license](https://opensource.org/licenses/MIT).
