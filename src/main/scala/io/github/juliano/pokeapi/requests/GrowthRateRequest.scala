package io.github.juliano.pokeapi.requests

import io.github.juliano.pokeapi.PokeApiClient.PokeRequest
import io.github.juliano.pokeapi.models.pokemon.GrowthRate

final case class GrowthRateRequest(id: String | Long) extends PokeRequest[GrowthRate](id):
  val resource = GrowthRateRequest.resource

object GrowthRateRequest:
  final val resource                                 = "growth-rate"
  def resourceList(offset: Int = 0, limit: Int = 20) = ResourceListRequest(resource)
