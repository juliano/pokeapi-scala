package io.github.juliano.pokeapi.requests

import io.github.juliano.pokeapi.PokeApiClient.PokeRequest
import io.github.juliano.pokeapi.models.pokemon.PokemonHabitat

final case class PokemonHabitatRequest(id: String | Long) extends PokeRequest[PokemonHabitat](id):
  final val resource = PokemonHabitatRequest.resource

object PokemonHabitatRequest:
  final val resource                                 = "pokemon-habitat"
  def resourceList(offset: Int = 0, limit: Int = 20) = ResourceListRequest(resource)
