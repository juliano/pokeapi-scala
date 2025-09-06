package io.github.juliano.pokeapi.models

import io.github.juliano.pokeapi.models.utility.{ Name, NamedAPIResource }

import zio.json.*

object evolution:
  @jsonMemberNames(SnakeCase)
  final case class EvolutionChain(
      id: Int,
      babyTriggerItem: Option[NamedAPIResource],
      chain: ChainLink
  )

  object EvolutionChain:
    given JsonDecoder[EvolutionChain] = DeriveJsonDecoder.gen

  @jsonMemberNames(SnakeCase)
  final case class ChainLink(
      isBaby: Boolean,
      species: NamedAPIResource,
      evolutionDetails: List[EvolutionDetail],
      evolvesTo: List[ChainLink]
  )

  object ChainLink:
    given JsonDecoder[ChainLink] = DeriveJsonDecoder.gen

  @jsonMemberNames(SnakeCase)
  final case class EvolutionDetail(
      item: Option[NamedAPIResource],
      trigger: NamedAPIResource,
      gender: Option[Int],
      heldItem: Option[NamedAPIResource],
      knownMove: Option[NamedAPIResource],
      knownMoveType: Option[NamedAPIResource],
      location: Option[NamedAPIResource],
      minLevel: Option[Int],
      minHappiness: Option[Int],
      minBeauty: Option[Int],
      minAffection: Option[Int],
      needsOverworldRain: Boolean,
      partySpecies: Option[NamedAPIResource],
      partyType: Option[NamedAPIResource],
      relativePhysicalStats: Option[Int],
      timeOfDay: String,
      tradeSpecies: Option[NamedAPIResource],
      turnUpsideDown: Boolean
  )

  object EvolutionDetail:
    given JsonDecoder[EvolutionDetail] = DeriveJsonDecoder.gen

  @jsonMemberNames(SnakeCase)
  final case class EvolutionTrigger(
      id: Int,
      name: String,
      names: List[Name],
      pokemonSpecies: List[NamedAPIResource]
  )

  object EvolutionTrigger:
    given JsonDecoder[EvolutionTrigger] = DeriveJsonDecoder.gen
