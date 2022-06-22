package io.github.juliano.pokeapi.requests

import io.github.juliano.pokeapi.models.ResourceList
import io.github.juliano.pokeapi.PokeApiClient.PokeRequest

final case class ResourceListRequest(resource: String) extends PokeRequest[ResourceList]("")
