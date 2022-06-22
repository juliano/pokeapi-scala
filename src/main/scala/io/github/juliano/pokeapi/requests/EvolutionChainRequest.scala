package io.github.juliano.pokeapi.requests

import io.github.juliano.pokeapi.PokeApiClient.PokeRequest
import io.github.juliano.pokeapi.models.evolution.EvolutionChain

final case class EvolutionChainRequest(id: String | Long) extends PokeRequest[EvolutionChain](id):
  val resource = EvolutionChainRequest.resource

object EvolutionChainRequest:
  final val resource                                 = "evolution-chain"
  def resourceList(offset: Int = 0, limit: Int = 20) = ResourceListRequest(resource)
