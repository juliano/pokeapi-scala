package io.github.juliano.pokeapi.requests

import io.github.juliano.pokeapi.PokeApiClient.PokeRequest
import io.github.juliano.pokeapi.models.pokemon.Ability

final case class AbilityRequest(id: String | Long) extends PokeRequest[Ability](id):
  val resource = AbilityRequest.resource

object AbilityRequest:
  final val resource                                 = "ability"
  def resourceList(offset: Int = 0, limit: Int = 20) = ResourceListRequest(resource)
