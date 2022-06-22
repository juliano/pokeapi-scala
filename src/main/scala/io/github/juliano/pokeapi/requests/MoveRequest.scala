package io.github.juliano.pokeapi.requests

import io.github.juliano.pokeapi.PokeApiClient.PokeRequest
import io.github.juliano.pokeapi.models.moves.Move

final case class MoveRequest(id: String | Long) extends PokeRequest[Move](id):
  val resource = MoveRequest.resource

object MoveRequest:
  final val resource                                 = "move"
  def resourceList(offset: Int = 0, limit: Int = 20) = ResourceListRequest(resource)
