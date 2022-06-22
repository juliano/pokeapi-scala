package io.github.juliano.pokeapi.requests

import io.github.juliano.pokeapi.PokeApiClient.PokeRequest
import io.github.juliano.pokeapi.models.contests.ContestType

final case class ContestTypeRequest(id: String | Long) extends PokeRequest[ContestType](id):
  val resource = ContestTypeRequest.resource

object ContestTypeRequest:
  final val resource                                 = "contest-type"
  def resourceList(offset: Int = 0, limit: Int = 20) = ResourceListRequest(resource)
