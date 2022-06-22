package io.github.juliano.pokeapi.requests

import io.github.juliano.pokeapi.PokeApiClient.PokeRequest
import io.github.juliano.pokeapi.models.locations.Region

final case class RegionRequest(id: String | Long) extends PokeRequest[Region](id):
  val resource = RegionRequest.resource

object RegionRequest:
  final val resource                                 = "region"
  def resourceList(offset: Int = 0, limit: Int = 20) = ResourceListRequest(resource)
