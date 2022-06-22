package io.github.juliano.pokeapi.requests

import io.github.juliano.pokeapi.PokeApiClient.PokeRequest
import io.github.juliano.pokeapi.models.locations.Location

final case class LocationRequest(id: String | Long) extends PokeRequest[Location](id):
  val resource = LocationRequest.resource

object LocationRequest:
  final val resource                                 = "location"
  def resourceList(offset: Int = 0, limit: Int = 20) = ResourceListRequest(resource)
