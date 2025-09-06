package io.github.juliano.pokeapi

import io.github.juliano.pokeapi.models.all.*

class ExhaustiveSuite extends ArmeriaCatsSuite:
  queryAll[Berry]("every Berry is retrieved successfully")
  queryAll[BerryFirmness]("every BerryFirmness is retrieved successfully")
  queryAll[BerryFlavor]("every BerryFlavor is retrieved successfully")

  queryAll[ContestType]("every ContestType is retrieved successfully")
  queryAll[ContestEffect]("every ContestEffect is retrieved successfully")
  queryAll[SuperContestEffect]("every SuperContestEffect is retrieved successfully")

  queryAll[EncounterMethod]("every EncounterMethod is retrieved successfully")
  queryAll[EncounterCondition]("every EncounterCondition is retrieved successfully")
  queryAll[EncounterConditionValue]("every EncounterConditionValue is retrieved successfully")

  queryAll[EvolutionChain]("every EvolutionChain is retrieved successfully")
  queryAll[EvolutionTrigger]("every EvolutionTrigger is retrieved successfully")

  queryAll[Generation]("every Generation is retrieved successfully")
  queryAll[Pokedex]("every Pokedex is retrieved successfully")
  queryAll[Version]("every Version is retrieved successfully")
  queryAll[VersionGroup]("every VersionGroup is retrieved successfully")

  queryAll[Item]("every Item is retrieved successfully")
  queryAll[ItemAttribute]("every ItemAttribute is retrieved successfully")
  queryAll[ItemCategory]("every ItemCategory is retrieved successfully")
  queryAll[ItemFlingEffect]("every ItemFlingEffect is retrieved successfully")
  queryAll[ItemPocket]("every ItemPocket is retrieved successfully")

  queryAll[Location]("every Location is retrieved successfully")
  queryAll[LocationArea]("every LocationArea is retrieved successfully")
  queryAll[PalParkArea]("every PalParkArea is retrieved successfully")
  queryAll[Region]("every Region is retrieved successfully")

  queryAll[Machine]("every Machine is retrieved successfully")

  queryAll[Move]("every Move is retrieved successfully")
  queryAll[MoveAilment]("every MoveAilment is retrieved successfully")
  queryAll[MoveBattleStyle]("every MoveBattleStyle is retrieved successfully")
  queryAll[MoveCategory]("every MoveCategory is retrieved successfully")
  queryAll[MoveDamageClass]("every MoveDamageClass is retrieved successfully")
  queryAll[MoveLearnMethod]("every MoveLearnMethod is retrieved successfully")
  queryAll[MoveTarget]("every MoveTarget is retrieved successfully")

  queryAll[Ability]("every Ability is retrieved successfully")
  queryAll[Characteristic]("every Characteristic is retrieved successfully")
  queryAll[EggGroup]("every EggGroup is retrieved successfully")
  queryAll[Gender]("every Gender is retrieved successfully")
  queryAll[GrowthRate]("every GrowthRate is retrieved successfully")
  queryAll[Nature]("every Nature is retrieved successfully")
  queryAll[PokeathlonStat]("every PokeathlonStat is retrieved successfully")
  queryAll[Pokemon]("every Pokemon is retrieved successfully")
  queryAll[PokemonColor]("every PokemonColor is retrieved successfully")
  queryAll[PokemonForm]("every PokemonForm is retrieved successfully")
  queryAll[PokemonHabitat]("every PokemonHabitat is retrieved successfully")
  queryAll[PokemonShape]("every PokemonShape is retrieved successfully")
  queryAll[PokemonSpecies]("every PokemonSpecies is retrieved successfully")
  queryAll[Stat]("every Stat is retrieved successfully")
  queryAll[Type]("every Type is retrieved successfully")

  queryAll[Language]("every Language is retrieved successfully")
