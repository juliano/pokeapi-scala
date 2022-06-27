package io.github.juliano.pokeapi

import cats.effect.IO
import io.github.juliano.pokeapi.requests.*
import sttp.client3.httpclient.fs2.HttpClientFs2Backend

class GamesSuite extends Fs2Suite {
  val client = HttpClientFs2Backend.resource[IO]().map(implicit backend => PokeApiClient())

  spec("generation by id", GenerationRequest(1), _.name == "generation-i")
  spec("generation by name", GenerationRequest("generation-i"), _.id == 1)
  spec("generation resource list", GenerationRequest.resourceList(), _.count == 8)

  spec("pokedex by id", PokedexRequest(1), _.name == "national")
  spec("pokedex by name", PokedexRequest("national"), _.id == 1)
  spec("pokedex resource list", PokedexRequest.resourceList(), _.count == 28)

  spec("version by id", VersionRequest(1), _.name == "red")
  spec("version by name", VersionRequest("red"), _.id == 1)
  spec("version resource list", VersionRequest.resourceList(), _.count == 39)

  spec("version group by id", VersionGroupRequest(1), _.name == "red-blue")
  spec("version group by name", VersionGroupRequest("red-blue"), _.id == 1)
  spec("version group resource list", VersionGroupRequest.resourceList(), _.count == 24)
}
