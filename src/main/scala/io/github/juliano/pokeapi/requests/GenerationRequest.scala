package io.github.juliano.pokeapi.requests

import io.github.juliano.pokeapi.PokeApiClient.PokeRequest
import io.github.juliano.pokeapi.models.games.Generation

final case class GenerationRequest(id: String | Long) extends PokeRequest[Generation](id):
  val resource = GenerationRequest.resource

object GenerationRequest:
  final val resource                                 = "generation"
  def resourceList(offset: Int = 0, limit: Int = 20) = ResourceListRequest(resource)
