package io.github.juliano.pokeapi.requests

import io.github.juliano.pokeapi.PokeApiClient.PokeRequest
import io.github.juliano.pokeapi.models.berries.BerryFirmness

final case class BerryFirmnessRequest(id: String | Long) extends PokeRequest[BerryFirmness](id):
  final val resource = BerryFirmnessRequest.resource

object BerryFirmnessRequest:
  final val resource                                 = "berry-firmness"
  def resourceList(offset: Int = 0, limit: Int = 20) = ResourceListRequest(resource)
