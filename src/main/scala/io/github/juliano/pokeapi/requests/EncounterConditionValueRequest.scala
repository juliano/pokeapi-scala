package io.github.juliano.pokeapi.requests

import io.github.juliano.pokeapi.PokeApiClient.PokeRequest
import io.github.juliano.pokeapi.models.encounters.EncounterConditionValue

final case class EncounterConditionValueRequest(id: String | Long)
    extends PokeRequest[EncounterConditionValue](id):
  val resource = EncounterConditionValueRequest.resource

object EncounterConditionValueRequest:
  final val resource                                 = "encounter-condition-value"
  def resourceList(offset: Int = 0, limit: Int = 20) = ResourceListRequest(resource)
