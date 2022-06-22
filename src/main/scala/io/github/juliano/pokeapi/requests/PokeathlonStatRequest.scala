package io.github.juliano.pokeapi.requests

import io.github.juliano.pokeapi.PokeApiClient.PokeRequest
import io.github.juliano.pokeapi.models.pokemon.PokeathlonStat

final case class PokeathlonStatRequest(id: String | Long) extends PokeRequest[PokeathlonStat](id):
  val resource = PokeathlonStatRequest.resource

object PokeathlonStatRequest:
  final val resource                                 = "pokeathlon-stat"
  def resourceList(offset: Int = 0, limit: Int = 20) = ResourceListRequest(resource)
