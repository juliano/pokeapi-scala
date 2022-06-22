package io.github.juliano.pokeapi.requests

import io.github.juliano.pokeapi.PokeApiClient.PokeRequest
import io.github.juliano.pokeapi.models.items.Item

final case class ItemRequest(id: String | Long) extends PokeRequest[Item](id):
  val resource = ItemRequest.resource

object ItemRequest:
  final val resource                                 = "item"
  def resourceList(offset: Int = 0, limit: Int = 20) = ResourceListRequest(resource)
