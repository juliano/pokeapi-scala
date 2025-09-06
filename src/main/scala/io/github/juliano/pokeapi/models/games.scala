package io.github.juliano.pokeapi.models

import io.github.juliano.pokeapi.models.utility.*

import zio.json.*

object games:
  @jsonMemberNames(SnakeCase)
  final case class Generation(
      id: Int,
      name: String,
      abilities: List[NamedAPIResource],
      names: List[Name],
      mainRegion: NamedAPIResource,
      moves: List[NamedAPIResource],
      pokemonSpecies: List[NamedAPIResource],
      types: List[NamedAPIResource],
      versionGroups: List[NamedAPIResource]
  )

  object Generation:
    given JsonDecoder[Generation] = DeriveJsonDecoder.gen

  @jsonMemberNames(SnakeCase)
  final case class Pokedex(
      id: Int,
      name: String,
      isMainSeries: Boolean,
      descriptions: List[Description],
      names: List[Name],
      pokemonEntries: List[PokemonEntry],
      region: Option[NamedAPIResource],
      versionGroups: List[NamedAPIResource]
  )

  object Pokedex:
    given JsonDecoder[Pokedex] = DeriveJsonDecoder.gen

  final case class PokemonEntry(entry_number: Int, pokemon_species: NamedAPIResource)

  object PokemonEntry:
    given JsonDecoder[PokemonEntry] = DeriveJsonDecoder.gen

  @jsonMemberNames(SnakeCase)
  final case class Version(
      id: Int,
      name: String,
      names: List[Name],
      versionGroup: NamedAPIResource
  )

  object Version:
    given JsonDecoder[Version] = DeriveJsonDecoder.gen

  @jsonMemberNames(SnakeCase)
  final case class VersionGroup(
      id: Int,
      name: String,
      order: Int,
      generation: NamedAPIResource,
      moveLearnMethods: List[NamedAPIResource],
      pokedexes: List[NamedAPIResource],
      regions: List[NamedAPIResource],
      versions: List[NamedAPIResource]
  )

  object VersionGroup:
    given JsonDecoder[VersionGroup] = DeriveJsonDecoder.gen
