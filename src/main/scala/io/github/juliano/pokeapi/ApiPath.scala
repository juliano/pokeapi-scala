package io.github.juliano.pokeapi

import io.github.juliano.pokeapi.models.all.*

import sttp.model.Uri

trait ApiPath[A]:
  def resource: String
  def path(id: String): List[String] = List(resource, id)

object ApiPath:
  def apply[A: ApiPath]: ApiPath[A] = summon[ApiPath[A]]

extension (uri: Uri)
  def addResourcePath[A: ApiPath](id: String | Long): Uri =
    uri.addPath(ApiPath[A].path(id.toString))

given ApiPath[Ability] with
  def resource = "ability"

given ApiPath[BerryFirmness] with
  def resource = "berry-firmness"

given ApiPath[BerryFlavor] with
  def resource = "berry-flavor"

given ApiPath[Berry] with
  def resource = "berry"

given ApiPath[Characteristic] with
  def resource = "characteristic"

given ApiPath[ContestEffect] with
  def resource = "contest-effect"

given ApiPath[ContestType] with
  def resource = "contest-type"

given ApiPath[EggGroup] with
  def resource = "egg-group"

given ApiPath[EncounterCondition] with
  def resource = "encounter-condition"

given ApiPath[EncounterConditionValue] with
  def resource = "encounter-condition-value"

given ApiPath[EncounterMethod] with
  def resource = "encounter-method"

given ApiPath[EvolutionChain] with
  def resource = "evolution-chain"

given ApiPath[EvolutionTrigger] with
  def resource = "evolution-trigger"

given ApiPath[Gender] with
  def resource = "gender"

given ApiPath[Generation] with
  def resource = "generation"

given ApiPath[GrowthRate] with
  def resource = "growth-rate"

given ApiPath[ItemAttribute] with
  def resource = "item-attribute"

given ApiPath[ItemCategory] with
  def resource = "item-category"

given ApiPath[ItemFlingEffect] with
  def resource = "item-fling-effect"

given ApiPath[ItemPocket] with
  def resource = "item-pocket"

given ApiPath[Item] with
  def resource = "item"

given ApiPath[Language] with
  def resource = "language"

given ApiPath[LocationArea] with
  def resource = "location-area"

given ApiPath[Location] with
  def resource = "location"

given ApiPath[Machine] with
  def resource = "machine"

given ApiPath[MoveAilment] with
  def resource = "move-ailment"

given ApiPath[MoveBattleStyle] with
  def resource = "move-battle-style"

given ApiPath[MoveCategory] with
  def resource = "move-category"

given ApiPath[MoveDamageClass] with
  def resource = "move-damage-class"

given ApiPath[MoveLearnMethod] with
  def resource = "move-learn-method"

given ApiPath[Move] with
  def resource = "move"

given ApiPath[MoveTarget] with
  def resource = "move-target"

given ApiPath[Nature] with
  def resource = "nature"

given ApiPath[PalParkArea] with
  def resource = "pal-park-area"

given ApiPath[PokeathlonStat] with
  def resource = "pokeathlon-stat"

given ApiPath[Pokedex] with
  def resource = "pokedex"

given ApiPath[PokemonColor] with
  def resource = "pokemon-color"

given ApiPath[PokemonForm] with
  def resource = "pokemon-form"

given ApiPath[PokemonHabitat] with
  def resource = "pokemon-habitat"

given ApiPath[Pokemon] with
  def resource = "pokemon"

given ApiPath[PokemonShape] with
  def resource = "pokemon-shape"

given ApiPath[PokemonSpecies] with
  def resource = "pokemon-species"

given ApiPath[Region] with
  def resource = "region"

given ApiPath[Stat] with
  def resource = "stat"

given ApiPath[SuperContestEffect] with
  def resource = "super-contest-effect"

given ApiPath[Type] with
  def resource = "type"

given ApiPath[VersionGroup] with
  def resource = "version-group"

given ApiPath[Version] with
  def resource = "version"

given ApiPath[LocationAreaEncounters] with
  def resource                  = "encounters"
  override def path(id: String) = ApiPath[Pokemon].path(id) :+ resource
