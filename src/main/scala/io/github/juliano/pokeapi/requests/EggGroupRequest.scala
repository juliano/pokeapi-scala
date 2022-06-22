package io.github.juliano.pokeapi.requests

import io.github.juliano.pokeapi.PokeApiClient.PokeRequest
import io.github.juliano.pokeapi.models.pokemon.EggGroup

final case class EggGroupRequest(id: String | Long) extends PokeRequest[EggGroup](id):
  val resource = EggGroupRequest.resource

object EggGroupRequest:
  final val resource                                 = "egg-group"
  def resourceList(offset: Int = 0, limit: Int = 20) = ResourceListRequest(resource)
