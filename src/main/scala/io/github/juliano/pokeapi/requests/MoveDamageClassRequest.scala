package io.github.juliano.pokeapi.requests

import io.github.juliano.pokeapi.PokeApiClient.PokeRequest
import io.github.juliano.pokeapi.models.moves.MoveDamageClass

final case class MoveDamageClassRequest(id: String | Long) extends PokeRequest[MoveDamageClass](id):
  val resource = MoveDamageClassRequest.resource

object MoveDamageClassRequest:
  final val resource                                 = "move-damage-class"
  def resourceList(offset: Int = 0, limit: Int = 20) = ResourceListRequest(resource)
