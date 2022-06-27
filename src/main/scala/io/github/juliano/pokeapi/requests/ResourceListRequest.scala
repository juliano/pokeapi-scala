package io.github.juliano.pokeapi.requests

import io.github.juliano.pokeapi.PokeApiClient.PokeRequest
import io.github.juliano.pokeapi.models.ResourceList

final case class ResourceListRequest(resource: String) extends PokeRequest[ResourceList]("")
