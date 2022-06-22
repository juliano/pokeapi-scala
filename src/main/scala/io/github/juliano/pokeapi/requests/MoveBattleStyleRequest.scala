package io.github.juliano.pokeapi.requests

import io.github.juliano.pokeapi.PokeApiClient.PokeRequest
import io.github.juliano.pokeapi.models.moves.MoveBattleStyle

final case class MoveBattleStyleRequest(id: String | Long) extends PokeRequest[MoveBattleStyle](id):
  val resource = MoveBattleStyleRequest.resource

object MoveBattleStyleRequest:
  final val resource                                 = "move-battle-style"
  def resourceList(offset: Int = 0, limit: Int = 20) = ResourceListRequest(resource)
