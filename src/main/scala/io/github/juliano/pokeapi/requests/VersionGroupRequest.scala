package io.github.juliano.pokeapi.requests

import io.github.juliano.pokeapi.PokeApiClient.PokeRequest
import io.github.juliano.pokeapi.models.games.VersionGroup

final case class VersionGroupRequest(id: String | Long) extends PokeRequest[VersionGroup](id):
  val resource = VersionGroupRequest.resource

object VersionGroupRequest:
  final val resource                                 = "version-group"
  def resourceList(offset: Int = 0, limit: Int = 20) = ResourceListRequest(resource)
