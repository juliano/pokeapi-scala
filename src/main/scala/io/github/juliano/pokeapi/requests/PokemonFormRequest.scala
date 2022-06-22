package io.github.juliano.pokeapi.requests

import io.github.juliano.pokeapi.models.pokemon.PokemonForm
import io.github.juliano.pokeapi.PokeApiClient.PokeRequest

final case class PokemonFormRequest(id: String | Long) extends PokeRequest[PokemonForm](id):
  final val resource = PokemonFormRequest.resource

object PokemonFormRequest:
  final val resource                                 = "pokemon-form"
  def resourceList(offset: Int = 0, limit: Int = 20) = ResourceListRequest(resource)
