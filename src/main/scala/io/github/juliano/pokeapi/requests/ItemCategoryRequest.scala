package io.github.juliano.pokeapi.requests

import io.github.juliano.pokeapi.PokeApiClient.PokeRequest
import io.github.juliano.pokeapi.models.items.ItemCategory

final case class ItemCategoryRequest(id: String | Long) extends PokeRequest[ItemCategory](id):
  val resource = ItemCategoryRequest.resource

object ItemCategoryRequest:
  final val resource                                 = "item-category"
  def resourceList(offset: Int = 0, limit: Int = 20) = ResourceListRequest(resource)
