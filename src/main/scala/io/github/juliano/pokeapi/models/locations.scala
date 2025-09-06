package io.github.juliano.pokeapi.models

import io.github.juliano.pokeapi.models.utility.*

import zio.json.*

object locations:
  @jsonMemberNames(SnakeCase)
  final case class Location(
      id: Int,
      name: String,
      region: Option[NamedAPIResource],
      names: List[Name],
      gameIndices: List[GenerationGameIndex],
      areas: List[NamedAPIResource]
  )

  object Location:
    given JsonDecoder[Location] = DeriveJsonDecoder.gen

  @jsonMemberNames(SnakeCase)
  final case class LocationArea(
      id: Int,
      name: String,
      gameIndex: Int,
      encounterMethodRates: List[EncounterMethodRate],
      location: NamedAPIResource,
      names: List[Name],
      pokemonEncounters: List[PokemonEncounter]
  )

  object LocationArea:
    given JsonDecoder[LocationArea] = DeriveJsonDecoder.gen

  @jsonMemberNames(SnakeCase)
  final case class EncounterMethodRate(
      encounterMethod: NamedAPIResource,
      versionDetails: List[EncounterVersionDetails]
  )

  object EncounterMethodRate:
    given JsonDecoder[EncounterMethodRate] = DeriveJsonDecoder.gen

  final case class EncounterVersionDetails(rate: Int, version: NamedAPIResource)

  object EncounterVersionDetails:
    given JsonDecoder[EncounterVersionDetails] = DeriveJsonDecoder.gen

  @jsonMemberNames(SnakeCase)
  final case class PokemonEncounter(
      pokemon: NamedAPIResource,
      versionDetails: List[VersionEncounterDetail]
  )

  object PokemonEncounter:
    given JsonDecoder[PokemonEncounter] = DeriveJsonDecoder.gen

  @jsonMemberNames(SnakeCase)
  final case class PalParkArea(
      id: Int,
      name: String,
      names: List[Name],
      pokemonEncounters: List[PalParkEncounterSpecies]
  )

  object PalParkArea:
    given JsonDecoder[PalParkArea] = DeriveJsonDecoder.gen

  @jsonMemberNames(SnakeCase)
  final case class PalParkEncounterSpecies(
      base_score: Int,
      rate: Int,
      pokemonSpecies: NamedAPIResource
  )

  object PalParkEncounterSpecies:
    given JsonDecoder[PalParkEncounterSpecies] = DeriveJsonDecoder.gen

  @jsonMemberNames(SnakeCase)
  final case class Region(
      id: Int,
      locations: List[NamedAPIResource],
      name: String,
      names: List[Name],
      mainGeneration: Option[NamedAPIResource],
      pokedexes: List[NamedAPIResource],
      versionGroups: List[NamedAPIResource]
  )

  object Region:
    given JsonDecoder[Region] = DeriveJsonDecoder.gen
