package io.github.juliano.pokeapi

import io.github.juliano.pokeapi.requests.*
import sttp.client3.asynchttpclient.zio.AsyncHttpClientZioBackend

class PokemonSuite extends ZIOSuite {
  val client = AsyncHttpClientZioBackend().map(implicit backend => PokeApiClient())

  spec("ability by id", AbilityRequest(1), _.name == "stench")
  spec("ability by name", AbilityRequest("stench"), _.id == 1)
  spec("ability resource list", AbilityRequest.resourceList(), _.count == 327)

  spec("characteristic by id", CharacteristicRequest(1), _.highestStat.name.contains("hp"))
  spec("characteristic resource list", CharacteristicRequest.resourceList(), _.count == 30)

  spec("egg group by id", EggGroupRequest(1), _.name == "monster")
  spec("egg group by name", EggGroupRequest("monster"), _.id == 1)
  spec("egg group resource list", EggGroupRequest.resourceList(), _.count == 15)

  spec("gender by id", GenderRequest(1), _.name == "female")
  spec("gender by name", GenderRequest("female"), _.id == 1)
  spec("gender resource list", GenderRequest.resourceList(), _.count == 3)

  spec("growth rate by id", GrowthRateRequest(1), _.name == "slow")
  spec("growth rate by name", GrowthRateRequest("slow"), _.id == 1)
  spec("growth rate resource list", GrowthRateRequest.resourceList(), _.count == 6)

  spec("nature by id", NatureRequest(1), _.name == "hardy")
  spec("nature by name", NatureRequest("hardy"), _.id == 1)
  spec("nature resource list", NatureRequest.resourceList(), _.count == 25)

  spec("pokeathlon stat by id", PokeathlonStatRequest(1), _.name == "speed")
  spec("pokeathlon stat by name", PokeathlonStatRequest("speed"), _.id == 1)
  spec("pokeathlon stat resource list", PokeathlonStatRequest.resourceList(), _.count == 5)

  spec("pokemon by id", PokemonRequest(1), _.name == "bulbasaur")
  spec("pokemon by name", PokemonRequest("bulbasaur"), _.id == 1)
  spec("pokemon resource list", PokemonRequest.resourceList(), _.count == 1154)

  spec(
    "location area encounter by id",
    LocationAreaEncounterRequest(1),
    _.head.locationArea.name.contains("cerulean-city-area")
  )
  spec(
    "location area encounter by name",
    LocationAreaEncounterRequest("bulbasaur"),
    _.head.locationArea.name.contains("cerulean-city-area")
  )

  spec("pokemon color by id", PokemonColorRequest(1), _.name == "black")
  spec("pokemon color by name", PokemonColorRequest("black"), _.id == 1)
  spec("pokemon color resource list", PokemonColorRequest.resourceList(), _.count == 10)

  spec("pokemon form by id", PokemonFormRequest(1), _.name == "bulbasaur")
  spec("pokemon form by name", PokemonFormRequest("bulbasaur"), _.id == 1)
  spec("pokemon form resource list", PokemonFormRequest.resourceList(), _.count == 1323)

  spec("pokemon habitat by id", PokemonHabitatRequest(1), _.name == "cave")
  spec("pokemon habitat by name", PokemonHabitatRequest("cave"), _.id == 1)
  spec("pokemon habitat resource list", PokemonHabitatRequest.resourceList(), _.count == 9)

  spec("pokemon shape by id", PokemonShapeRequest(1), _.name == "ball")
  spec("pokemon shape by name", PokemonShapeRequest("ball"), _.id == 1)
  spec("pokemon shape resource list", PokemonShapeRequest.resourceList(), _.count == 14)

  spec("pokemon species by id", PokemonSpeciesRequest(1), _.name == "bulbasaur")
  spec("pokemon species by name", PokemonSpeciesRequest("bulbasaur"), _.id == 1)
  spec("pokemon species resource list", PokemonSpeciesRequest.resourceList(), _.count == 905)

  spec("stat by id", StatRequest(1), _.name == "hp")
  spec("stat by name", StatRequest("hp"), _.id == 1)
  spec("stat resource list", StatRequest.resourceList(), _.count == 8)

  spec("type by id", TypeRequest(1), _.name == "normal")
  spec("type by name", TypeRequest("normal"), _.id == 1)
  spec("type resource list", TypeRequest.resourceList(), _.count == 20)
}
