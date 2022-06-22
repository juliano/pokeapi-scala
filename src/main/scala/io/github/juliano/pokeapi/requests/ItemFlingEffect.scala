package io.github.juliano.pokeapi.requests

import io.github.juliano.pokeapi.PokeApiClient.PokeRequest
import io.github.juliano.pokeapi.models.items.ItemFlingEffect

final case class ItemFlingEffectRequest(id: String | Long) extends PokeRequest[ItemFlingEffect](id):
  val resource = ItemFlingEffectRequest.resource

object ItemFlingEffectRequest:
  final val resource                                 = "item-fling-effect"
  def resourceList(offset: Int = 0, limit: Int = 20) = ResourceListRequest(resource)
