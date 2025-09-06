package io.github.juliano.pokeapi.models

import io.github.juliano.pokeapi.models.pokemon.AbilityEffectChange
import io.github.juliano.pokeapi.models.utility.*

import zio.json.*

object moves:
  @jsonMemberNames(SnakeCase)
  final case class Move(
      id: Int,
      name: String,
      accuracy: Option[Int],
      effectChance: Option[Int],
      pp: Option[Int],
      priority: Int,
      power: Option[Int],
      contestCombos: Option[ContestComboSets],
      contestType: Option[NamedAPIResource],
      contestEffect: Option[APIResource],
      damageClass: NamedAPIResource,
      effectEntries: List[VerboseEffect],
      effectChanges: List[AbilityEffectChange],
      learnedByPokemon: List[NamedAPIResource],
      flavorTextEntries: List[MoveFlavorText],
      generation: NamedAPIResource,
      machines: List[MachineVersionDetail],
      meta: Option[MoveMetaData],
      names: List[Name],
      pastValues: List[PastMoveStatValues],
      statChanges: List[MoveStatChange],
      superContestEffect: Option[APIResource],
      target: NamedAPIResource,
      `type`: NamedAPIResource
  )

  object Move:
    given JsonDecoder[Move] = DeriveJsonDecoder.gen

  final case class ContestComboSets(normal: ContestComboDetail, `super`: ContestComboDetail)

  object ContestComboSets:
    given JsonDecoder[ContestComboSets] = DeriveJsonDecoder.gen

  @jsonMemberNames(SnakeCase)
  final case class ContestComboDetail(
      useBefore: Option[List[NamedAPIResource]],
      useAfter: Option[List[NamedAPIResource]]
  )

  object ContestComboDetail:
    given JsonDecoder[ContestComboDetail] = DeriveJsonDecoder.gen

  @jsonMemberNames(SnakeCase)
  final case class MoveFlavorText(
      flavorText: String,
      language: NamedAPIResource,
      versionGroup: NamedAPIResource
  )

  object MoveFlavorText:
    given JsonDecoder[MoveFlavorText] = DeriveJsonDecoder.gen

  @jsonMemberNames(SnakeCase)
  final case class MoveMetaData(
      ailment: NamedAPIResource,
      category: NamedAPIResource,
      minHits: Option[Int],
      maxHits: Option[Int],
      minTurns: Option[Int],
      maxTurns: Option[Int],
      drain: Int,
      healing: Int,
      critRate: Int,
      ailmentChance: Int,
      flinchChance: Int,
      statChance: Int
  )

  object MoveMetaData:
    given JsonDecoder[MoveMetaData] = DeriveJsonDecoder.gen

  final case class MoveStatChange(change: Int, stat: NamedAPIResource)

  object MoveStatChange:
    given JsonDecoder[MoveStatChange] = DeriveJsonDecoder.gen

  @jsonMemberNames(SnakeCase)
  final case class PastMoveStatValues(
      accuracy: Option[Int],
      effectChance: Option[Int],
      power: Option[Int],
      pp: Option[Int],
      effectEntries: List[VerboseEffect],
      `type`: Option[NamedAPIResource],
      versionGroup: NamedAPIResource
  )

  object PastMoveStatValues:
    given JsonDecoder[PastMoveStatValues] = DeriveJsonDecoder.gen

  final case class MoveAilment(
      id: Int,
      name: String,
      moves: List[NamedAPIResource],
      names: List[Name]
  )

  object MoveAilment:
    given JsonDecoder[MoveAilment] = DeriveJsonDecoder.gen

  final case class MoveBattleStyle(
      id: Int,
      name: String,
      names: List[Name]
  )

  object MoveBattleStyle:
    given JsonDecoder[MoveBattleStyle] = DeriveJsonDecoder.gen

  final case class MoveCategory(
      id: Int,
      name: String,
      moves: List[NamedAPIResource],
      descriptions: List[Description]
  )

  object MoveCategory:
    given JsonDecoder[MoveCategory] = DeriveJsonDecoder.gen

  final case class MoveDamageClass(
      id: Int,
      name: String,
      descriptions: List[Description],
      moves: List[NamedAPIResource],
      names: List[Name]
  )

  object MoveDamageClass:
    given JsonDecoder[MoveDamageClass] = DeriveJsonDecoder.gen

  @jsonMemberNames(SnakeCase)
  final case class MoveLearnMethod(
      id: Int,
      name: String,
      descriptions: List[Description],
      names: List[Name],
      versionGroups: List[NamedAPIResource]
  )

  object MoveLearnMethod:
    given JsonDecoder[MoveLearnMethod] = DeriveJsonDecoder.gen

  final case class MoveTarget(
      id: Int,
      name: String,
      descriptions: List[Description],
      moves: List[NamedAPIResource],
      names: List[Name]
  )

  object MoveTarget:
    given JsonDecoder[MoveTarget] = DeriveJsonDecoder.gen
