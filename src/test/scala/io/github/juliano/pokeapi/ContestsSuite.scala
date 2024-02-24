package io.github.juliano.pokeapi

import io.github.juliano.pokeapi.requests.*
import sttp.client4.httpclient.HttpClientFutureBackend

class ContestsSuite extends FutureSuite:
  val client = PokeApiClient(HttpClientFutureBackend())

  spec("contest type by id", ContestTypeRequest(1), _.name == "cool")
  spec("contest type by name", ContestTypeRequest("cool"), _.id == 1)
  spec("contest type resource list", ContestTypeRequest.resourceList(), _.count == 5)

  spec("contest effect by id", ContestEffectRequest(1), _.appeal == 4)
  spec("contest effect resource list", ContestEffectRequest.resourceList(), _.count == 33)

  spec("super contest effect by id", SuperContestEffectRequest(1), _.appeal == 2)
  spec(
    "super contest effect resource list",
    SuperContestEffectRequest.resourceList(),
    _.count == 22
  )
