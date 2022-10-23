package io.github.juliano.pokeapi.models

import io.github.juliano.pokeapi.models.utility.*
import zio.json.{ jsonField, DeriveJsonDecoder, JsonDecoder }

object games:
  final case class Generation(
      id: Int,
      name: String,
      abilities: List[NamedAPIResource],
      names: List[Name],
      @jsonField("main_region") mainRegion: NamedAPIResource,
      moves: List[NamedAPIResource],
      @jsonField("pokemon_species") pokemonSpecies: List[NamedAPIResource],
      types: List[NamedAPIResource],
      @jsonField("version_groups") versionGroups: List[NamedAPIResource]
  )

  object Generation:
    given JsonDecoder[Generation] = DeriveJsonDecoder.gen

  final case class Pokedex(
      id: Int,
      name: String,
      @jsonField("is_main_series") isMainSeries: Boolean,
      descriptions: List[Description],
      names: List[Name],
      @jsonField("pokemon_entries") pokemonEntries: List[PokemonEntry],
      region: Option[NamedAPIResource],
      @jsonField("version_groups") versionGroups: List[NamedAPIResource]
  )

  object Pokedex:
    given JsonDecoder[Pokedex] = DeriveJsonDecoder.gen

  final case class PokemonEntry(entry_number: Int, pokemon_species: NamedAPIResource)

  object PokemonEntry:
    given JsonDecoder[PokemonEntry] = DeriveJsonDecoder.gen

  final case class Version(
      id: Int,
      name: String,
      names: List[Name],
      @jsonField("version_group") versionGroup: NamedAPIResource
  )

  object Version:
    given JsonDecoder[Version] = DeriveJsonDecoder.gen

  final case class VersionGroup(
      id: Int,
      name: String,
      order: Int,
      generation: NamedAPIResource,
      @jsonField("move_learn_methods") moveLearnMethods: List[NamedAPIResource],
      pokedexes: List[NamedAPIResource],
      regions: List[NamedAPIResource],
      versions: List[NamedAPIResource]
  )

  object VersionGroup:
    given JsonDecoder[VersionGroup] = DeriveJsonDecoder.gen
