package io.github.juliano.pokeapi.requests

import io.github.juliano.pokeapi.PokeApiClient.PokeRequest
import io.github.juliano.pokeapi.models.games.Version

final case class VersionRequest(id: String | Long) extends PokeRequest[Version](id):
  val resource = VersionRequest.resource

object VersionRequest:
  final val resource                                 = "version"
  def resourceList(offset: Int = 0, limit: Int = 20) = ResourceListRequest(resource)
