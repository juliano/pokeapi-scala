package io.github.juliano.pokeapi.requests

import io.github.juliano.pokeapi.PokeApiClient.PokeRequest
import io.github.juliano.pokeapi.models.pokemon.Nature

final case class NatureRequest(id: String | Long) extends PokeRequest[Nature](id):
  val resource = NatureRequest.resource

object NatureRequest:
  final val resource                                 = "nature"
  def resourceList(offset: Int = 0, limit: Int = 20) = ResourceListRequest(resource)
