package io.github.juliano.pokeapi.requests

import io.github.juliano.pokeapi.PokeApiClient.PokeRequest
import io.github.juliano.pokeapi.models.utility.Language

final case class LanguageRequest(id: String | Long) extends PokeRequest[Language](id):
  final val resource = LanguageRequest.resource

object LanguageRequest:
  final val resource                                 = "language"
  def resourceList(offset: Int = 0, limit: Int = 20) = ResourceListRequest(resource)
