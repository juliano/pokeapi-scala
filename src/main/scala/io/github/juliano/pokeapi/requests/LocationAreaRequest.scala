package io.github.juliano.pokeapi.requests

import io.github.juliano.pokeapi.PokeApiClient.PokeRequest
import io.github.juliano.pokeapi.models.locations.LocationArea

final case class LocationAreaRequest(id: String | Long) extends PokeRequest[LocationArea](id):
  val resource = LocationAreaRequest.resource

object LocationAreaRequest:
  final val resource                                 = "location-area"
  def resourceList(offset: Int = 0, limit: Int = 20) = ResourceListRequest(resource)
