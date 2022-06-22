package io.github.juliano.pokeapi.requests

import io.github.juliano.pokeapi.PokeApiClient.PokeRequest
import io.github.juliano.pokeapi.models.items.ItemAttribute

final case class ItemAttributeRequest(id: String | Long) extends PokeRequest[ItemAttribute](id):
  val resource = ItemAttributeRequest.resource

object ItemAttributeRequest:
  final val resource                                 = "item-attribute"
  def resourceList(offset: Int = 0, limit: Int = 20) = ResourceListRequest(resource)
