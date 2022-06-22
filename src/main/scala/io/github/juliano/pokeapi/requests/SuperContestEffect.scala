package io.github.juliano.pokeapi.requests

import io.github.juliano.pokeapi.PokeApiClient.PokeRequest
import io.github.juliano.pokeapi.models.contests.SuperContestEffect

final case class SuperContestEffectRequest(id: String | Long)
    extends PokeRequest[SuperContestEffect](id):
  val resource = SuperContestEffectRequest.resource

object SuperContestEffectRequest:
  final val resource                                 = "super-contest-effect"
  def resourceList(offset: Int = 0, limit: Int = 20) = ResourceListRequest(resource)
