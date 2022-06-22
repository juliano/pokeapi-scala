package io.github.juliano.pokeapi.requests

import io.github.juliano.pokeapi.PokeApiClient.PokeRequest
import io.github.juliano.pokeapi.models.berries.BerryFlavor

final case class BerryFlavorRequest(id: String | Long) extends PokeRequest[BerryFlavor](id):
  val resource = BerryFlavorRequest.resource

object BerryFlavorRequest:
  final val resource                                 = "berry-flavor"
  def resourceList(offset: Int = 0, limit: Int = 20) = ResourceListRequest(resource)
