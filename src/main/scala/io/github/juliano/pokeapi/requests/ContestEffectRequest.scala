package io.github.juliano.pokeapi.requests

import io.github.juliano.pokeapi.PokeApiClient.PokeRequest
import io.github.juliano.pokeapi.models.contests.ContestEffect

final case class ContestEffectRequest(id: String | Long) extends PokeRequest[ContestEffect](id):
  val resource = ContestEffectRequest.resource

object ContestEffectRequest:
  final val resource                                 = "contest-effect"
  def resourceList(offset: Int = 0, limit: Int = 20) = ResourceListRequest(resource)
