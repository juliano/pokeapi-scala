package io.github.juliano.pokeapi.requests

import io.github.juliano.pokeapi.PokeApiClient.PokeRequest
import io.github.juliano.pokeapi.models.pokemon.PokemonShape

final case class PokemonShapeRequest(id: String | Long) extends PokeRequest[PokemonShape](id):
  final val resource = PokemonShapeRequest.resource

object PokemonShapeRequest:
  final val resource                                 = "pokemon-shape"
  def resourceList(offset: Int = 0, limit: Int = 20) = ResourceListRequest(resource)
