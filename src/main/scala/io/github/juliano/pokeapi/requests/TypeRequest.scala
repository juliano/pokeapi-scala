package io.github.juliano.pokeapi.requests

import io.github.juliano.pokeapi.PokeApiClient.PokeRequest
import io.github.juliano.pokeapi.models.pokemon.Type

final case class TypeRequest(id: String | Long) extends PokeRequest[Type](id):
  final val resource = TypeRequest.resource

object TypeRequest:
  final val resource                                 = "type"
  def resourceList(offset: Int = 0, limit: Int = 20) = ResourceListRequest(resource)
