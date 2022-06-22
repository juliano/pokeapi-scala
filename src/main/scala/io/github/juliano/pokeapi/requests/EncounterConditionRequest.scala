package io.github.juliano.pokeapi.requests

import io.github.juliano.pokeapi.PokeApiClient.PokeRequest
import io.github.juliano.pokeapi.models.encounters.EncounterCondition

final case class EncounterConditionRequest(id: String | Long)
    extends PokeRequest[EncounterCondition](id):
  val resource = EncounterConditionRequest.resource

object EncounterConditionRequest:
  final val resource                                 = "encounter-condition"
  def resourceList(offset: Int = 0, limit: Int = 20) = ResourceListRequest(resource)
