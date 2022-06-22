package io.github.juliano.pokeapi.requests

import io.github.juliano.pokeapi.models.pokemon.Pokemon
import io.github.juliano.pokeapi.PokeApiClient.PokeRequest

final case class PokemonRequest(id: String | Long) extends PokeRequest[Pokemon](id):
  final val resource = PokemonRequest.resource

object PokemonRequest:
  final val resource                                 = "pokemon"
  def resourceList(offset: Int = 0, limit: Int = 20) = ResourceListRequest(resource)
