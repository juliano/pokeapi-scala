package io.github.juliano.pokeapi.requests

import io.github.juliano.pokeapi.PokeApiClient.PokeRequest
import io.github.juliano.pokeapi.models.evolution.EvolutionTrigger

final case class EvolutionTriggerRequest(id: String | Long)
    extends PokeRequest[EvolutionTrigger](id):
  val resource = EvolutionTriggerRequest.resource

object EvolutionTriggerRequest:
  final val resource                                 = "evolution-trigger"
  def resourceList(offset: Int = 0, limit: Int = 20) = ResourceListRequest(resource)
