package io.github.juliano.pokeapi.requests

import io.github.juliano.pokeapi.PokeApiClient.PokeRequest
import io.github.juliano.pokeapi.models.berries.Berry

final case class BerryRequest(id: String | Long) extends PokeRequest[Berry](id):
  val resource = BerryRequest.resource

object BerryRequest:
  final val resource                                 = "berry"
  def resourceList(offset: Int = 0, limit: Int = 20) = ResourceListRequest(resource)
