package io.github.juliano.pokeapi.requests

import io.github.juliano.pokeapi.PokeApiClient.PokeRequest
import io.github.juliano.pokeapi.models.moves.MoveTarget

final case class MoveTargetRequest(id: String | Long) extends PokeRequest[MoveTarget](id):
  val resource = MoveTargetRequest.resource

object MoveTargetRequest:
  final val resource                                 = "move-target"
  def resourceList(offset: Int = 0, limit: Int = 20) = ResourceListRequest(resource)
