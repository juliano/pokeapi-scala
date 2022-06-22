package io.github.juliano.pokeapi.requests

import io.github.juliano.pokeapi.ApiHost
import io.github.juliano.pokeapi.PokeApiClient.*
import io.github.juliano.pokeapi.models.pokemon.{ LocationAreaEncounter, Pokemon }
import zio.json.JsonDecoder

final case class LocationAreaEncounterRequest(id: String | Long)
    extends PokeRequest[List[LocationAreaEncounter]](id):
  def this(pokemon: Pokemon) = this(pokemon.id)
  val resource = s"pokemon/$id/encounters"

  override def sttpRequest(host: ApiHost)(using
      JsonDecoder[List[LocationAreaEncounter]]
  ): SttpRequest[List[LocationAreaEncounter]] =
    makeRequest(host.uri.addPath("pokemon", id.toString, "encounters"))
