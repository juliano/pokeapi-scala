package io.github.juliano.pokeapi.requests

import io.github.juliano.pokeapi.PokeApiClient.PokeRequest
import io.github.juliano.pokeapi.models.pokemon.Gender

final case class GenderRequest(id: String | Long) extends PokeRequest[Gender](id):
  val resource = GenderRequest.resource

object GenderRequest:
  final val resource                                 = "gender"
  def resourceList(offset: Int = 0, limit: Int = 20) = ResourceListRequest(resource)
