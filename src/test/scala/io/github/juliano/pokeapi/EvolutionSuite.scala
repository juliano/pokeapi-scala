package io.github.juliano.pokeapi

import cats.effect.IO
import io.github.juliano.pokeapi.requests.{ EvolutionChainRequest, EvolutionTriggerRequest }
import sttp.client3.asynchttpclient.fs2.AsyncHttpClientFs2Backend

class EvolutionSuite extends Fs2Suite {
  val client = AsyncHttpClientFs2Backend.resource[IO]().map(implicit backend => PokeApiClient())

  spec("evolution chain by id", EvolutionChainRequest(1), _.babyTriggerItem.isEmpty)
  spec("evolution chain resource list", EvolutionChainRequest.resourceList(), _.count == 468)

  spec("evolution trigger by id", EvolutionTriggerRequest(1), _.name == "level-up")
  spec("evolution trigger by name", EvolutionTriggerRequest("level-up"), _.id == 1)
  spec("evolution trigger resource list", EvolutionTriggerRequest.resourceList(), _.count == 10)
}
