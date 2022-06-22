package io.github.juliano.pokeapi.requests

import io.github.juliano.pokeapi.PokeApiClient.PokeRequest
import io.github.juliano.pokeapi.models.pokemon.Stat

final case class StatRequest(id: String | Long) extends PokeRequest[Stat](id):
  final val resource = StatRequest.resource

object StatRequest:
  final val resource                                 = "stat"
  def resourceList(offset: Int = 0, limit: Int = 20) = ResourceListRequest(resource)
