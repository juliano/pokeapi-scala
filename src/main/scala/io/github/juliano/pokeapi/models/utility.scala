package io.github.juliano.pokeapi.models

import zio.json.{ jsonField, DeriveJsonDecoder, JsonDecoder }

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

  final case class Encounter(
      @jsonField("min_level") minLevel: Int,
      @jsonField("max_level") maxLevel: Int,
      @jsonField("condition_values") conditionValues: List[NamedAPIResource],
      chance: Int,
      method: NamedAPIResource
  )

  object Encounter:
    given JsonDecoder[Encounter] = DeriveJsonDecoder.gen

  final case class FlavorText(
      @jsonField("flavor_text") flavorText: String,
      language: NamedAPIResource
  )

  object FlavorText:
    given JsonDecoder[FlavorText] = DeriveJsonDecoder.gen

  final case class GenerationGameIndex(
      @jsonField("game_index") gameIndex: Int,
      generation: NamedAPIResource
  )

  object GenerationGameIndex:
    given JsonDecoder[GenerationGameIndex] = DeriveJsonDecoder.gen

  final case class MachineVersionDetail(
      machine: APIResource,
      @jsonField("version_group") versionGroup: NamedAPIResource
  )

  object MachineVersionDetail:
    given JsonDecoder[MachineVersionDetail] = DeriveJsonDecoder.gen

  final case class Name(name: String, language: NamedAPIResource)

  object Name:
    given JsonDecoder[Name] = DeriveJsonDecoder.gen

  final case class NamedAPIResource(name: Option[String], url: String)

  object NamedAPIResource:
    given JsonDecoder[NamedAPIResource] = DeriveJsonDecoder.gen

  final case class VerboseEffect(
      effect: String,
      @jsonField("short_effect") shortEffect: String,
      language: NamedAPIResource
  )

  object VerboseEffect:
    given JsonDecoder[VerboseEffect] = DeriveJsonDecoder.gen

  final case class VersionEncounterDetail(
      version: NamedAPIResource,
      @jsonField("max_chance") maxChance: Int,
      @jsonField("encounter_details") encounterDetails: List[Encounter]
  )

  object VersionEncounterDetail:
    given JsonDecoder[VersionEncounterDetail] = DeriveJsonDecoder.gen

  final case class VersionGameIndex(
      @jsonField("game_index") gameIndex: Int,
      version: NamedAPIResource
  )

  object VersionGameIndex:
    given JsonDecoder[VersionGameIndex] = DeriveJsonDecoder.gen

  final case class VersionGroupFlavorText(
      text: String,
      language: NamedAPIResource,
      @jsonField("version_group") versionGroup: NamedAPIResource
  )

  object VersionGroupFlavorText:
    given JsonDecoder[VersionGroupFlavorText] = DeriveJsonDecoder.gen
