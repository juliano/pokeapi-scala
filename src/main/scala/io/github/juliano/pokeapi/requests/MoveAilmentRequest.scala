package io.github.juliano.pokeapi.requests

import io.github.juliano.pokeapi.PokeApiClient.PokeRequest
import io.github.juliano.pokeapi.models.moves.MoveAilment

final case class MoveAilmentRequest(id: String | Long) extends PokeRequest[MoveAilment](id):
  val resource = MoveAilmentRequest.resource

object MoveAilmentRequest:
  final val resource                                 = "move-ailment"
  def resourceList(offset: Int = 0, limit: Int = 20) = ResourceListRequest(resource)
