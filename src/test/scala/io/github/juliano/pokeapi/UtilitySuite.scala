package io.github.juliano.pokeapi

import io.github.juliano.pokeapi.requests.LanguageRequest
import sttp.client4.armeria.zio.ArmeriaZioBackend

class UtilitySuite extends ZIOSuite:
  val client = ArmeriaZioBackend().map(implicit backend => PokeApiClient(backend))

  spec("language by id", LanguageRequest(1), _.name == "ja-Hrkt")
  spec("language by name", LanguageRequest("ja-Hrkt"), _.id == 1)
  spec("language resource list", LanguageRequest.resourceList(), _.count == 13)
