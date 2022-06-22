package io.github.juliano.pokeapi.requests

import io.github.juliano.pokeapi.PokeApiClient.PokeRequest
import io.github.juliano.pokeapi.models.moves.MoveCategory

final case class MoveCategoryRequest(id: String | Long) extends PokeRequest[MoveCategory](id):
  val resource = MoveCategoryRequest.resource

object MoveCategoryRequest:
  final val resource                                 = "move-category"
  def resourceList(offset: Int = 0, limit: Int = 20) = ResourceListRequest(resource)
