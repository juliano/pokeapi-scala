package io.github.juliano.pokeapi.requests

import io.github.juliano.pokeapi.PokeApiClient.PokeRequest
import io.github.juliano.pokeapi.models.moves.MoveLearnMethod

final case class MoveLearnMethodRequest(id: String | Long) extends PokeRequest[MoveLearnMethod](id):
  val resource = MoveLearnMethodRequest.resource

object MoveLearnMethodRequest:
  final val resource                                 = "move-learn-method"
  def resourceList(offset: Int = 0, limit: Int = 20) = ResourceListRequest(resource)
