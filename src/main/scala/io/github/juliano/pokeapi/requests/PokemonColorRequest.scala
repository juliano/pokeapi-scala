package io.github.juliano.pokeapi.requests

import io.github.juliano.pokeapi.models.pokemon.PokemonColor
import io.github.juliano.pokeapi.PokeApiClient.PokeRequest

final case class PokemonColorRequest(id: String | Long) extends PokeRequest[PokemonColor](id):
  final val resource = PokemonColorRequest.resource

object PokemonColorRequest:
  final val resource                                 = "pokemon-color"
  def resourceList(offset: Int = 0, limit: Int = 20) = ResourceListRequest(resource)
