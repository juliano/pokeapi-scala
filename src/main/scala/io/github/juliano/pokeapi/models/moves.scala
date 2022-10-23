package io.github.juliano.pokeapi.models

import io.github.juliano.pokeapi.models.pokemon.AbilityEffectChange
import io.github.juliano.pokeapi.models.utility.*
import zio.json.{ jsonField, DeriveJsonDecoder, JsonDecoder }

object moves:
  final case class Move(
      id: Int,
      name: String,
      accuracy: Int,
      @jsonField("effect_chance") effectChance: Option[Int],
      pp: Int,
      priority: Int,
      power: Int,
      @jsonField("contest_combos") contestCombos: ContestComboSets,
      @jsonField("contest_type") contestType: NamedAPIResource,
      @jsonField("contest_effect") contestEffect: APIResource,
      @jsonField("damage_class") damageClass: NamedAPIResource,
      @jsonField("effect_entries") effectEntries: List[VerboseEffect],
      @jsonField("effect_changes") effectChanges: List[AbilityEffectChange],
      @jsonField("learned_by_pokemon") learnedByPokemon: List[NamedAPIResource],
      @jsonField("flavor_text_entries") flavorTextEntries: List[MoveFlavorText],
      generation: NamedAPIResource,
      machines: List[MachineVersionDetail],
      meta: MoveMetaData,
      names: List[Name],
      @jsonField("past_values") pastValues: List[PastMoveStatValues],
      @jsonField("stat_changes") statChanges: List[MoveStatChange],
      @jsonField("super_contest_effect") superContestEffect: APIResource,
      target: NamedAPIResource,
      `type`: NamedAPIResource
  )

  object Move:
    given JsonDecoder[Move] = DeriveJsonDecoder.gen

  final case class ContestComboSets(normal: ContestComboDetail, `super`: ContestComboDetail)

  object ContestComboSets:
    given JsonDecoder[ContestComboSets] = DeriveJsonDecoder.gen

  final case class ContestComboDetail(
      @jsonField("use_before") useBefore: Option[List[NamedAPIResource]],
      @jsonField("use_after") useAfter: Option[List[NamedAPIResource]]
  )

  object ContestComboDetail:
    given JsonDecoder[ContestComboDetail] = DeriveJsonDecoder.gen

  final case class MoveFlavorText(
      @jsonField("flavor_text") flavorText: String,
      language: NamedAPIResource,
      @jsonField("version_group") versionGroup: NamedAPIResource
  )

  object MoveFlavorText:
    given JsonDecoder[MoveFlavorText] = DeriveJsonDecoder.gen

  final case class MoveMetaData(
      ailment: NamedAPIResource,
      category: NamedAPIResource,
      @jsonField("min_hits") minHits: Option[Int],
      @jsonField("max_hits") maxHits: Option[Int],
      @jsonField("min_turns") minTurns: Option[Int],
      @jsonField("max_turns") maxTurns: Option[Int],
      drain: Int,
      healing: Int,
      @jsonField("crit_rate") critRate: Int,
      @jsonField("ailment_chance") ailmentChance: Int,
      @jsonField("flinch_chance") flinchChance: Int,
      @jsonField("stat_chance") statChance: Int
  )

  object MoveMetaData:
    given JsonDecoder[MoveMetaData] = DeriveJsonDecoder.gen

  final case class MoveStatChange(change: Int, stat: NamedAPIResource)

  object MoveStatChange:
    given JsonDecoder[MoveStatChange] = DeriveJsonDecoder.gen

  final case class PastMoveStatValues(
      accuracy: Int,
      @jsonField("effect_chance") effectChance: Int,
      power: Int,
      pp: Int,
      @jsonField("effect_entries") effectEntries: List[VerboseEffect],
      `type`: NamedAPIResource,
      @jsonField("version_group") versionGroup: NamedAPIResource
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

  final case class MoveLearnMethod(
      id: Int,
      name: String,
      descriptions: List[Description],
      names: List[Name],
      @jsonField("version_groups") versionGroups: List[NamedAPIResource]
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
