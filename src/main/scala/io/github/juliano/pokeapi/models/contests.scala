package io.github.juliano.pokeapi.models

import io.github.juliano.pokeapi.models.utility.*

import zio.json.*

object contests:
  @jsonMemberNames(SnakeCase)
  final case class ContestType(
      id: Int,
      name: String,
      berryFlavor: NamedAPIResource,
      names: List[ContestName]
  )

  object ContestType:
    given JsonDecoder[ContestType] = DeriveJsonDecoder.gen

  final case class ContestName(name: String, color: String, language: NamedAPIResource)

  object ContestName:
    given JsonDecoder[ContestName] = DeriveJsonDecoder.gen

  @jsonMemberNames(SnakeCase)
  final case class ContestEffect(
      id: Int,
      appeal: Int,
      jam: Int,
      effectEntries: List[Effect],
      flavorTextEntries: List[FlavorText]
  )

  object ContestEffect:
    given JsonDecoder[ContestEffect] = DeriveJsonDecoder.gen

  @jsonMemberNames(SnakeCase)
  case class SuperContestEffect(
      id: Int,
      appeal: Int,
      flavorTextEntries: List[FlavorText],
      moves: List[NamedAPIResource]
  )

  object SuperContestEffect:
    given JsonDecoder[SuperContestEffect] = DeriveJsonDecoder.gen
