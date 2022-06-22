package io.github.juliano.pokeapi.requests

import io.github.juliano.pokeapi.PokeApiClient.PokeRequest
import io.github.juliano.pokeapi.models.games.Pokedex

final case class PokedexRequest(id: String | Long) extends PokeRequest[Pokedex](id):
  val resource = PokedexRequest.resource

object PokedexRequest:
  final val resource                                 = "pokedex"
  def resourceList(offset: Int = 0, limit: Int = 20) = ResourceListRequest(resource)
