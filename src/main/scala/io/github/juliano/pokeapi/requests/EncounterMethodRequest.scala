package io.github.juliano.pokeapi.requests

import io.github.juliano.pokeapi.PokeApiClient.PokeRequest
import io.github.juliano.pokeapi.models.encounters.EncounterMethod

final case class EncounterMethodRequest(id: String | Long) extends PokeRequest[EncounterMethod](id):
  val resource = EncounterMethodRequest.resource

object EncounterMethodRequest:
  final val resource                                 = "encounter-method"
  def resourceList(offset: Int = 0, limit: Int = 20) = ResourceListRequest(resource)
