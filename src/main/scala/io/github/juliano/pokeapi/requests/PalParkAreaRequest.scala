package io.github.juliano.pokeapi.requests

import io.github.juliano.pokeapi.PokeApiClient.PokeRequest
import io.github.juliano.pokeapi.models.locations.PalParkArea

final case class PalParkAreaRequest(id: String | Long) extends PokeRequest[PalParkArea](id):
  val resource = PalParkAreaRequest.resource

object PalParkAreaRequest:
  final val resource                                 = "pal-park-area"
  def resourceList(offset: Int = 0, limit: Int = 20) = ResourceListRequest(resource)
