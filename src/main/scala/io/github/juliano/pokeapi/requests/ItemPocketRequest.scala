package io.github.juliano.pokeapi.requests

import io.github.juliano.pokeapi.PokeApiClient.PokeRequest
import io.github.juliano.pokeapi.models.items.ItemPocket

final case class ItemPocketRequest(id: String | Long) extends PokeRequest[ItemPocket](id):
  val resource = ItemPocketRequest.resource

object ItemPocketRequest:
  final val resource                                 = "item-pocket"
  def resourceList(offset: Int = 0, limit: Int = 20) = ResourceListRequest(resource)
