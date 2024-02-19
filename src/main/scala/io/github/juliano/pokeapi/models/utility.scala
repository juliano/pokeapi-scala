package io.github.juliano.pokeapi.models

import zio.json.*

object utility:
  final case class Language(
      id: Int,
      name: String,
      official: Boolean,
      iso639: String,
      iso3166: String,
      names: List[Name]
  )

  object Language:
    given JsonDecoder[Language] = DeriveJsonDecoder.gen

  final case class APIResource(url: String)

  object APIResource:
    given JsonDecoder[APIResource] = DeriveJsonDecoder.gen

  final case class Description(description: String, language: NamedAPIResource)

  object Description:
    given JsonDecoder[Description] = DeriveJsonDecoder.gen

  final case class Effect(effect: String, language: NamedAPIResource)

  object Effect:
    given JsonDecoder[Effect] = DeriveJsonDecoder.gen

  @jsonMemberNames(SnakeCase)
  final case class Encounter(
      minLevel: Int,
      maxLevel: Int,
      conditionValues: List[NamedAPIResource],
      chance: Int,
      method: NamedAPIResource
  )

  object Encounter:
    given JsonDecoder[Encounter] = DeriveJsonDecoder.gen

  @jsonMemberNames(SnakeCase)
  final case class FlavorText(
      flavorText: String,
      language: NamedAPIResource
  )

  object FlavorText:
    given JsonDecoder[FlavorText] = DeriveJsonDecoder.gen

  @jsonMemberNames(SnakeCase)
  final case class GenerationGameIndex(
      gameIndex: Int,
      generation: NamedAPIResource
  )

  object GenerationGameIndex:
    given JsonDecoder[GenerationGameIndex] = DeriveJsonDecoder.gen

  @jsonMemberNames(SnakeCase)
  final case class MachineVersionDetail(
      machine: APIResource,
      versionGroup: NamedAPIResource
  )

  object MachineVersionDetail:
    given JsonDecoder[MachineVersionDetail] = DeriveJsonDecoder.gen

  final case class Name(name: String, language: NamedAPIResource)

  object Name:
    given JsonDecoder[Name] = DeriveJsonDecoder.gen

  final case class NamedAPIResource(name: Option[String], url: String)

  object NamedAPIResource:
    given JsonDecoder[NamedAPIResource] = DeriveJsonDecoder.gen

  @jsonMemberNames(SnakeCase)
  final case class VerboseEffect(
      effect: String,
      shortEffect: String,
      language: NamedAPIResource
  )

  object VerboseEffect:
    given JsonDecoder[VerboseEffect] = DeriveJsonDecoder.gen

  @jsonMemberNames(SnakeCase)
  final case class VersionEncounterDetail(
      version: NamedAPIResource,
      maxChance: Int,
      encounterDetails: List[Encounter]
  )

  object VersionEncounterDetail:
    given JsonDecoder[VersionEncounterDetail] = DeriveJsonDecoder.gen

  @jsonMemberNames(SnakeCase)
  final case class VersionGameIndex(
      gameIndex: Int,
      version: NamedAPIResource
  )

  object VersionGameIndex:
    given JsonDecoder[VersionGameIndex] = DeriveJsonDecoder.gen

  @jsonMemberNames(SnakeCase)
  final case class VersionGroupFlavorText(
      text: String,
      language: NamedAPIResource,
      versionGroup: NamedAPIResource
  )

  object VersionGroupFlavorText:
    given JsonDecoder[VersionGroupFlavorText] = DeriveJsonDecoder.gen
