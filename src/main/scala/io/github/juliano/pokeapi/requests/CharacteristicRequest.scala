package io.github.juliano.pokeapi.requests

import io.github.juliano.pokeapi.PokeApiClient.PokeRequest
import io.github.juliano.pokeapi.models.pokemon.Characteristic

final case class CharacteristicRequest(id: String | Long) extends PokeRequest[Characteristic](id):
  val resource = CharacteristicRequest.resource

object CharacteristicRequest:
  final val resource                                 = "characteristic"
  def resourceList(offset: Int = 0, limit: Int = 20) = ResourceListRequest(resource)
