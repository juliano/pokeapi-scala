package io.github.juliano.pokeapi

import io.github.juliano.pokeapi.PokeApiClient.PokeRequest
import io.github.juliano.pokeapi.models.ResourceList
import io.github.juliano.pokeapi.models.berries.Berry
import io.github.juliano.pokeapi.models.pokemon.Pokemon
import io.github.juliano.pokeapi.requests.*
import sttp.client3.*
import zio.json.JsonDecoder

class PokeApiClientSpec extends munit.FunSuite {
  given backend: SttpBackend[Identity, Any] = HttpURLConnectionBackend()
  val client = PokeApiClient(ApiHost.default)

  def check[T](name: String, req: PokeRequest[T], f: T => Boolean)(using
      munit.Location,
      JsonDecoder[T]
  ): Unit = test(name) {
    val response = client.send(req)
    assert(f(response))
  }

  def suite[T, U <: PokeRequest[T]](
      title: String,
      req: (String | Long) => U,
      firstName: String,
      f1: T => String,
      f2: T => Int
  )(using munit.Location, JsonDecoder[T]) =
    check(s"$title by id", req(1), f1.andThen(_ == firstName))
    check(s"$title by name", req(firstName), f2.andThen(_ == 1))
    check(
      s"$title resource list",
      ResourceListRequest(req(1).resource),
      _.results.head.name.contains(firstName)
    )

  // suite("berry", BerryRequest.apply, "cheri", _.name, _.id)
  // suite("berry firmness", BerryFirmnessRequest.apply, "very-soft", _.name, _.id)
  // suite("berry flavor", BerryFlavorRequest.apply, "spicy", _.name, _.id)

  // suite("contest type", ContestTypeRequest.apply, "cool", _.name, _.id)

  // check("contest effect by id", ContestEffectRequest(1), _.appeal == 4)
  // check("contest effect resource list", ContestEffectRequest.resourceList(), _.count == 33)

  // check("super contest effect by id", SuperContestEffectRequest(1), _.appeal == 2)
  // check(
  //   "super contest effect resource list",
  //   SuperContestEffectRequest.resourceList(),
  //   _.count == 22
  // )

  // suite("encounter method", EncounterMethodRequest.apply, "walk", _.name, _.id)
  // suite("encounter condition", EncounterConditionRequest.apply, "swarm", _.name, _.id)
  // suite("encounter condition value", EncounterConditionValueRequest.apply, "swarm-yes", _.name, _.id)

  // check("evolution chain by id", EvolutionChainRequest(1), _.babyTriggerItem.isEmpty)
  // check("evolution chain resource list", EvolutionChainRequest.resourceList(), _.count == 468)

  // suite("evolution trigger", EvolutionTriggerRequest.apply, "level-up", _.name, _.id)

  // suite("generation", GenerationRequest.apply, "generation-i", _.name, _.id)
  // suite("pokedex", PokedexRequest.apply, "national", _.name, _.id)
  // suite("version", VersionRequest.apply, "red", _.name, _.id)
  // suite("version-group", VersionGroupRequest.apply, "red-blue", _.name, _.id)

  // suite("item", ItemRequest.apply, "master-ball", _.name, _.id)
  // suite("item attribute", ItemAttributeRequest.apply, "countable", _.name, _.id)
  // suite("item category", ItemCategoryRequest.apply, "stat-boosts", _.name, _.id)
  // suite("item fling effect", ItemFlingEffectRequest.apply, "badly-poison", _.name, _.id)
  // suite("item pocket", ItemPocketRequest.apply, "misc", _.name, _.id)

  // suite("location", LocationRequest.apply, "canalave-city", _.name, _.id)
  // suite("location area", LocationAreaRequest.apply, "canalave-city-area", _.name, _.id)
  // suite("pal park area", PalParkAreaRequest.apply, "forest", _.name, _.id)
  // suite("region", RegionRequest.apply, "kanto", _.name, _.id)

  // check("machine chain by id", MachineRequest(1), _.move.name.contains("mega-punch"))

  // suite("move", MoveRequest.apply, "pound", _.name, _.id)
  // // can't use suite because move-ailment starts in -1 (?!?)
  // check("move ailment by id", MoveAilmentRequest(1), _.name == "paralysis")
  // check("move ailment by name", MoveAilmentRequest("paralysis"), _.id == 1)
  // check("move ailment resource list", MoveAilmentRequest.resourceList(), _.count == 22)
  // suite("move battle style", MoveBattleStyleRequest.apply, "attack", _.name, _.id)
  // // same, move-category starts in 0
  // check("move category by id", MoveCategoryRequest(1), _.name == "ailment")
  // check("move category by name", MoveCategoryRequest("ailment"), _.id == 1)
  // check("move category resource list", MoveCategoryRequest.resourceList(), _.count == 14)

  // suite("move damage class", MoveDamageClassRequest.apply, "status", _.name, _.id)
  // suite("move learn method", MoveLearnMethodRequest.apply, "level-up", _.name, _.id)
  // suite("move target", MoveTargetRequest.apply, "specific-move", _.name, _.id)

  // suite("ability", AbilityRequest.apply, "stench", _.name, _.id)

  // check("characteristic by id", CharacteristicRequest(1), _.highestStat.name.contains("hp"))

  // suite("egg group", EggGroupRequest.apply, "monster", _.name, _.id)
  // suite("gender", GenderRequest.apply, "female", _.name, _.id)
  // suite("growth rate", GrowthRateRequest.apply, "slow", _.name, _.id)
  // suite("nature", NatureRequest.apply, "hardy", _.name, _.id)
  // suite("pokeathon stat", PokeathlonStatRequest.apply, "speed", _.name, _.id)
  // suite("pokemon", PokemonRequest.apply, "bulbasaur", _.name, _.id)

  // check("location area encounter by id", LocationAreaEncounterRequest(1), _.head.locationArea.name.contains("cerulean-city-area"))

  // suite("pokemon color", PokemonColorRequest.apply, "black", _.name, _.id)
  // suite("pokemon form", PokemonFormRequest.apply, "bulbasaur", _.name, _.id)
  // suite("pokemon habitat", PokemonHabitatRequest.apply, "cave", _.name, _.id)
  // suite("pokemon shape", PokemonShapeRequest.apply, "ball", _.name, _.id)
  // suite("pokemon species", PokemonSpeciesRequest.apply, "bulbasaur", _.name, _.id)
  // suite("stat", StatRequest.apply, "hp", _.name, _.id)
  // suite("type", TypeRequest.apply, "normal", _.name, _.id)

  suite("language", LanguageRequest.apply, "ja-Hrkt", _.name, _.id)
}
