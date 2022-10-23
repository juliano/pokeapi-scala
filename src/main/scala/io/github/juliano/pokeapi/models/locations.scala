package io.github.juliano.pokeapi.models

import io.github.juliano.pokeapi.models.utility.*
import zio.json.{ jsonField, DeriveJsonDecoder, JsonDecoder }

object locations:
  final case class Location(
      id: Int,
      name: String,
      region: NamedAPIResource,
      names: List[Name],
      @jsonField("game_indices") gameIndices: List[GenerationGameIndex],
      areas: List[NamedAPIResource]
  )

  object Location:
    given JsonDecoder[Location] = DeriveJsonDecoder.gen

  final case class LocationArea(
      id: Int,
      name: String,
      @jsonField("game_index") gameIndex: Int,
      @jsonField("encounter_method_rates") encounterMethodRates: List[EncounterMethodRate],
      location: NamedAPIResource,
      names: List[Name],
      @jsonField("pokemon_encounters") pokemonEncounters: List[PokemonEncounter]
  )

  object LocationArea:
    given JsonDecoder[LocationArea] = DeriveJsonDecoder.gen

  final case class EncounterMethodRate(
      @jsonField("encounter_method") encounterMethod: NamedAPIResource,
      @jsonField("version_details") versionDetails: List[EncounterVersionDetails]
  )

  object EncounterMethodRate:
    given JsonDecoder[EncounterMethodRate] = DeriveJsonDecoder.gen

  final case class EncounterVersionDetails(rate: Int, version: NamedAPIResource)

  object EncounterVersionDetails:
    given JsonDecoder[EncounterVersionDetails] = DeriveJsonDecoder.gen

  final case class PokemonEncounter(
      pokemon: NamedAPIResource,
      @jsonField("version_details") versionDetails: List[VersionEncounterDetail]
  )

  object PokemonEncounter:
    given JsonDecoder[PokemonEncounter] = DeriveJsonDecoder.gen

  final case class PalParkArea(
      id: Int,
      name: String,
      names: List[Name],
      @jsonField("pokemon_encounters") pokemonEncounters: List[PalParkEncounterSpecies]
  )

  object PalParkArea:
    given JsonDecoder[PalParkArea] = DeriveJsonDecoder.gen

  final case class PalParkEncounterSpecies(
      base_score: Int,
      rate: Int,
      @jsonField("pokemon_species") pokemonSpecies: NamedAPIResource
  )

  object PalParkEncounterSpecies:
    given JsonDecoder[PalParkEncounterSpecies] = DeriveJsonDecoder.gen

  final case class Region(
      id: Int,
      locations: List[NamedAPIResource],
      name: String,
      names: List[Name],
      @jsonField("main_generation") mainGeneration: NamedAPIResource,
      pokedexes: List[NamedAPIResource],
      @jsonField("version_groups") versionGroups: List[NamedAPIResource]
  )

  object Region:
    given JsonDecoder[Region] = DeriveJsonDecoder.gen
