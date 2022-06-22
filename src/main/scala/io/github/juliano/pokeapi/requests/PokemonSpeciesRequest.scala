package io.github.juliano.pokeapi.requests

import io.github.juliano.pokeapi.PokeApiClient.PokeRequest
import io.github.juliano.pokeapi.models.pokemon.PokemonSpecies

final case class PokemonSpeciesRequest(id: String | Long) extends PokeRequest[PokemonSpecies](id):
  final val resource = PokemonSpeciesRequest.resource

object PokemonSpeciesRequest:
  final val resource                                 = "pokemon-species"
  def resourceList(offset: Int = 0, limit: Int = 20) = ResourceListRequest(resource)
