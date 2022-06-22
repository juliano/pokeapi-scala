package io.github.juliano.pokeapi.models

import io.github.juliano.pokeapi.models.utility.{ Name, NamedAPIResource }
import zio.json.{ jsonField, DeriveJsonDecoder, JsonDecoder }

object evolution:
  final case class EvolutionChain(
      id: Int,
      @jsonField("baby_trigger_item") babyTriggerItem: Option[NamedAPIResource],
      chain: ChainLink
  )

  object EvolutionChain:
    given decoder: JsonDecoder[EvolutionChain] = DeriveJsonDecoder.gen

  final case class ChainLink(
      @jsonField("is_baby") isBaby: Boolean,
      species: NamedAPIResource,
      @jsonField("evolution_details") evolutionDetails: List[EvolutionDetail],
      @jsonField("evolves_to") evolvesTo: List[ChainLink]
  )

  object ChainLink:
    given decoder: JsonDecoder[ChainLink] = DeriveJsonDecoder.gen

  final case class EvolutionDetail(
      item: Option[NamedAPIResource],
      trigger: NamedAPIResource,
      gender: Option[Int],
      @jsonField("held_item") heldItem: Option[NamedAPIResource],
      @jsonField("known_move") knownMove: Option[NamedAPIResource],
      @jsonField("known_move_type") knownMoveType: Option[NamedAPIResource],
      location: Option[NamedAPIResource],
      @jsonField("min_level") minLevel: Int,
      @jsonField("min_happiness") minHappiness: Option[Int],
      @jsonField("min_beauty") minBeauty: Option[Int],
      @jsonField("min_affection") minAffection: Option[Int],
      @jsonField("needs_overworld_rain") needsOverworldRain: Boolean,
      @jsonField("party_species") partySpecies: Option[NamedAPIResource],
      @jsonField("party_type") partyType: Option[NamedAPIResource],
      @jsonField("relative_physical_stats") relativePhysicalStats: Option[Int],
      @jsonField("time_of_day") timeOfDay: String,
      @jsonField("trade_species") tradeSpecies: Option[NamedAPIResource],
      @jsonField("turn_upside_down") turnUpsideDown: Boolean
  )

  object EvolutionDetail:
    given decoder: JsonDecoder[EvolutionDetail] = DeriveJsonDecoder.gen

  final case class EvolutionTrigger(
      id: Int,
      name: String,
      names: List[Name],
      @jsonField("pokemon_species") pokemonSpecies: List[NamedAPIResource]
  )

  object EvolutionTrigger:
    given decoder: JsonDecoder[EvolutionTrigger] = DeriveJsonDecoder.gen
