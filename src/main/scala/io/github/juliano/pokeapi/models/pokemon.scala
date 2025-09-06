package io.github.juliano.pokeapi.models

import io.github.juliano.pokeapi.models.utility.*

import zio.json.*
import zio.json.ast.*

object pokemon:
  @jsonMemberNames(SnakeCase)
  final case class Ability(
      id: Int,
      name: String,
      isMainSeries: Boolean,
      generation: NamedAPIResource,
      names: List[Name],
      effectEntries: List[VerboseEffect],
      effectChanges: List[AbilityEffectChange],
      flavorTextEntries: List[AbilityFlavorText],
      pokemon: List[AbilityPokemon]
  )

  object Ability:
    given JsonDecoder[Ability] = DeriveJsonDecoder.gen

  @jsonMemberNames(SnakeCase)
  final case class AbilityEffectChange(
      effectEntries: List[Effect],
      versionGroup: NamedAPIResource
  )

  object AbilityEffectChange:
    given JsonDecoder[AbilityEffectChange] = DeriveJsonDecoder.gen

  @jsonMemberNames(SnakeCase)
  final case class AbilityFlavorText(
      flavorText: String,
      language: NamedAPIResource,
      versionGroup: NamedAPIResource
  )

  object AbilityFlavorText:
    given JsonDecoder[AbilityFlavorText] = DeriveJsonDecoder.gen

  @jsonMemberNames(SnakeCase)
  final case class AbilityPokemon(
      isHidden: Boolean,
      slot: Int,
      pokemon: NamedAPIResource
  )

  object AbilityPokemon:
    given JsonDecoder[AbilityPokemon] = DeriveJsonDecoder.gen

  @jsonMemberNames(SnakeCase)
  final case class Characteristic(
      id: Int,
      descriptions: List[Description],
      geneModulo: Int,
      possibleValues: List[Int],
      highestStat: NamedAPIResource
  )

  object Characteristic:
    given JsonDecoder[Characteristic] = DeriveJsonDecoder.gen

  @jsonMemberNames(SnakeCase)
  final case class EggGroup(
      id: Int,
      name: String,
      names: List[Name],
      pokemonSpecies: List[NamedAPIResource]
  )

  object EggGroup:
    given JsonDecoder[EggGroup] = DeriveJsonDecoder.gen

  @jsonMemberNames(SnakeCase)
  final case class Gender(
      id: Int,
      name: String,
      pokemonSpeciesDetails: List[PokemonSpeciesGender],
      requiredForEvolution: List[NamedAPIResource]
  )

  object Gender:
    given JsonDecoder[Gender] = DeriveJsonDecoder.gen

  @jsonMemberNames(SnakeCase)
  final case class PokemonSpeciesGender(
      rate: Int,
      pokemonSpecies: NamedAPIResource
  )

  object PokemonSpeciesGender:
    given JsonDecoder[PokemonSpeciesGender] = DeriveJsonDecoder.gen

  @jsonMemberNames(SnakeCase)
  final case class GrowthRate(
      id: Int,
      name: String,
      formula: String,
      descriptions: List[Description],
      levels: List[GrowthRateExperienceLevel],
      pokemonSpecies: List[NamedAPIResource]
  )

  object GrowthRate:
    given JsonDecoder[GrowthRate] = DeriveJsonDecoder.gen

  final case class GrowthRateExperienceLevel(level: Int, experience: Int)

  object GrowthRateExperienceLevel:
    given JsonDecoder[GrowthRateExperienceLevel] = DeriveJsonDecoder.gen

  @jsonMemberNames(SnakeCase)
  final case class Nature(
      id: Int,
      name: String,
      decreasedStat: Option[NamedAPIResource],
      increasedStat: Option[NamedAPIResource],
      hatesFlavor: Option[NamedAPIResource],
      likesFlavor: Option[NamedAPIResource],
      pokeathlonStatChanges: List[NatureStatChange],
      moveBattleStylePreferences: List[MoveBattleStylePreference],
      names: List[Name]
  )

  object Nature:
    given JsonDecoder[Nature] = DeriveJsonDecoder.gen

  @jsonMemberNames(SnakeCase)
  final case class NatureStatChange(
      maxChange: Int,
      pokeathlonStat: NamedAPIResource
  )

  object NatureStatChange:
    given JsonDecoder[NatureStatChange] = DeriveJsonDecoder.gen

  @jsonMemberNames(SnakeCase)
  final case class MoveBattleStylePreference(
      lowHpPreference: Int,
      highHpPreference: Int,
      moveBattleStyle: NamedAPIResource
  )

  object MoveBattleStylePreference:
    given JsonDecoder[MoveBattleStylePreference] = DeriveJsonDecoder.gen

  @jsonMemberNames(SnakeCase)
  final case class PokeathlonStat(
      id: Int,
      name: String,
      names: List[Name],
      affectingNatures: NaturePokeathlonStatAffectSets
  )

  object PokeathlonStat:
    given JsonDecoder[PokeathlonStat] = DeriveJsonDecoder.gen

  final case class NaturePokeathlonStatAffectSets(
      increase: List[NaturePokeathlonStatAffect],
      decrease: List[NaturePokeathlonStatAffect]
  )

  object NaturePokeathlonStatAffectSets:
    given JsonDecoder[NaturePokeathlonStatAffectSets] = DeriveJsonDecoder.gen

  @jsonMemberNames(SnakeCase)
  final case class NaturePokeathlonStatAffect(
      maxChange: Int,
      nature: NamedAPIResource
  )

  object NaturePokeathlonStatAffect:
    given JsonDecoder[NaturePokeathlonStatAffect] = DeriveJsonDecoder.gen

  @jsonMemberNames(SnakeCase)
  final case class Pokemon(
      id: Int,
      name: String,
      baseExperience: Int,
      height: Int,
      isDefault: Boolean,
      order: Int,
      weight: Int,
      abilities: List[PokemonAbility],
      forms: List[NamedAPIResource],
      gameIndices: List[VersionGameIndex],
      heldItems: List[PokemonHeldItem],
      locationAreaEncounters: String,
      moves: List[PokemonMove],
      pastTypes: List[PokemonTypePast],
      sprites: PokemonSprites,
      species: NamedAPIResource,
      stats: List[PokemonStat],
      types: List[PokemonType]
  )

  object Pokemon:
    given JsonDecoder[Pokemon] = DeriveJsonDecoder.gen

  @jsonMemberNames(SnakeCase)
  final case class PokemonAbility(
      isHidden: Boolean,
      slot: Int,
      ability: NamedAPIResource
  )

  object PokemonAbility:
    given JsonDecoder[PokemonAbility] = DeriveJsonDecoder.gen

  final case class PokemonType(slot: Int, `type`: NamedAPIResource)

  object PokemonType:
    given JsonDecoder[PokemonType] = DeriveJsonDecoder.gen

  final case class PokemonFormType(slot: Int, `type`: NamedAPIResource)

  object PokemonFormType:
    given JsonDecoder[PokemonFormType] = DeriveJsonDecoder.gen

  final case class PokemonTypePast(generation: NamedAPIResource, types: List[PokemonType])

  object PokemonTypePast:
    given JsonDecoder[PokemonTypePast] = DeriveJsonDecoder.gen

  @jsonMemberNames(SnakeCase)
  final case class PokemonHeldItem(
      item: NamedAPIResource,
      versionDetails: List[PokemonHeldItemVersion]
  )

  object PokemonHeldItem:
    given JsonDecoder[PokemonHeldItem] = DeriveJsonDecoder.gen

  final case class PokemonHeldItemVersion(version: NamedAPIResource, rarity: Int)

  object PokemonHeldItemVersion:
    given JsonDecoder[PokemonHeldItemVersion] = DeriveJsonDecoder.gen

  @jsonMemberNames(SnakeCase)
  final case class PokemonMove(
      move: NamedAPIResource,
      versionGroupDetails: List[PokemonMoveVersion]
  )

  object PokemonMove:
    given JsonDecoder[PokemonMove] = DeriveJsonDecoder.gen

  @jsonMemberNames(SnakeCase)
  final case class PokemonMoveVersion(
      moveLearnMethod: NamedAPIResource,
      versionGroup: NamedAPIResource,
      levelLearnedAt: Int
  )

  object PokemonMoveVersion:
    given JsonDecoder[PokemonMoveVersion] = DeriveJsonDecoder.gen

  @jsonMemberNames(SnakeCase)
  final case class PokemonStat(
      stat: NamedAPIResource,
      effort: Int,
      baseStat: Int
  )

  object PokemonStat:
    given JsonDecoder[PokemonStat] = DeriveJsonDecoder.gen

  @jsonMemberNames(SnakeCase)
  final case class PokemonSprites(
      frontDefault: Option[String],
      frontShiny: Option[String],
      frontFemale: Option[String],
      frontShinyFemale: Option[String],
      backDefault: Option[String],
      backShiny: Option[String],
      backFemale: Option[String],
      backShinyFemale: Option[String]
  )

  object PokemonSprites:
    given JsonDecoder[PokemonSprites] = DeriveJsonDecoder.gen

  @jsonMemberNames(SnakeCase)
  final case class LocationAreaEncounter(
      locationArea: NamedAPIResource,
      versionDetails: List[VersionEncounterDetail]
  )

  object LocationAreaEncounter:
    given JsonDecoder[LocationAreaEncounter] = DeriveJsonDecoder.gen

  type LocationAreaEncounters = List[LocationAreaEncounter]

  @jsonMemberNames(SnakeCase)
  final case class PokemonColor(
      id: Int,
      name: String,
      names: List[Name],
      pokemonSpecies: List[NamedAPIResource]
  )

  object PokemonColor:
    given JsonDecoder[PokemonColor] = DeriveJsonDecoder.gen

  @jsonMemberNames(SnakeCase)
  final case class PokemonForm(
      id: Int,
      name: String,
      order: Int,
      formOrder: Int,
      isDefault: Boolean,
      isBattleOnly: Boolean,
      isMega: Boolean,
      formName: String,
      pokemon: NamedAPIResource,
      types: List[FormType],
      sprites: PokemonFormSprites,
      versionGroup: NamedAPIResource,
      names: List[Name],
      formNames: List[Name]
  )

  object PokemonForm:
    given JsonDecoder[PokemonForm] = DeriveJsonDecoder.gen

  final case class FormType(slot: Int, `type`: NamedAPIResource)

  object FormType:
    given JsonDecoder[FormType] = DeriveJsonDecoder.gen

  @jsonMemberNames(SnakeCase)
  final case class PokemonFormSprites(
      frontDefault: Option[String],
      frontShiny: Option[String],
      backDefault: Option[String],
      backShiny: Option[String]
  )

  object PokemonFormSprites:
    given JsonDecoder[PokemonFormSprites] = DeriveJsonDecoder.gen

  @jsonMemberNames(SnakeCase)
  final case class PokemonHabitat(
      id: Int,
      name: String,
      names: List[Name],
      pokemonSpecies: List[NamedAPIResource]
  )

  object PokemonHabitat:
    given JsonDecoder[PokemonHabitat] = DeriveJsonDecoder.gen

  @jsonMemberNames(SnakeCase)
  final case class PokemonShape(
      id: Int,
      name: String,
      awesomeNames: List[AwesomeName],
      names: List[Name],
      pokemonSpecies: List[NamedAPIResource]
  )

  object PokemonShape:
    given JsonDecoder[PokemonShape] = DeriveJsonDecoder.gen

  @jsonMemberNames(SnakeCase)
  final case class AwesomeName(
      awesomeName: String,
      language: NamedAPIResource
  )

  object AwesomeName:
    given JsonDecoder[AwesomeName] = DeriveJsonDecoder.gen

  @jsonMemberNames(SnakeCase)
  final case class PokemonSpecies(
      id: Int,
      name: String,
      order: Int,
      genderRate: Int,
      captureRate: Int,
      baseHappiness: Int,
      isBaby: Boolean,
      isLegendary: Boolean,
      isMythical: Boolean,
      hatchCounter: Int,
      hasGenderDifferences: Boolean,
      formsSwitchable: Boolean,
      growthRate: NamedAPIResource,
      pokedexNumbers: List[PokemonSpeciesDexEntry],
      eggGroups: List[NamedAPIResource],
      color: NamedAPIResource,
      shape: NamedAPIResource,
      evolvesFromSpecies: Option[NamedAPIResource],
      evolutionChain: APIResource,
      habitat: Option[NamedAPIResource],
      generation: NamedAPIResource,
      names: List[Name],
      palParkEncounters: List[PalParkEncounterArea],
      flavorTextEntries: List[FlavorText],
      formDescriptions: List[Description],
      genera: List[Genus],
      varieties: List[PokemonSpeciesVariety]
  )

  object PokemonSpecies:
    given JsonDecoder[PokemonSpecies] = DeriveJsonDecoder.gen

  final case class Genus(genus: String, language: NamedAPIResource)

  object Genus:
    given JsonDecoder[Genus] = DeriveJsonDecoder.gen

  @jsonMemberNames(SnakeCase)
  final case class PokemonSpeciesDexEntry(
      entryNumber: Int,
      pokedex: NamedAPIResource
  )

  object PokemonSpeciesDexEntry:
    given JsonDecoder[PokemonSpeciesDexEntry] = DeriveJsonDecoder.gen

  @jsonMemberNames(SnakeCase)
  final case class PalParkEncounterArea(
      baseScore: Int,
      rate: Int,
      area: NamedAPIResource
  )

  object PalParkEncounterArea:
    given JsonDecoder[PalParkEncounterArea] = DeriveJsonDecoder.gen

  @jsonMemberNames(SnakeCase)
  final case class PokemonSpeciesVariety(
      isDefault: Boolean,
      pokemon: NamedAPIResource
  )

  object PokemonSpeciesVariety:
    given JsonDecoder[PokemonSpeciesVariety] = DeriveJsonDecoder.gen

  @jsonMemberNames(SnakeCase)
  final case class Stat(
      id: Int,
      name: String,
      gameIndex: Int,
      isBattleOnly: Boolean,
      affectingMoves: MoveStatAffectSets,
      affectingNatures: NatureStatAffectSets,
      characteristics: List[APIResource],
      moveDamageClass: Option[NamedAPIResource],
      names: List[Name]
  )

  object Stat:
    given JsonDecoder[Stat] = DeriveJsonDecoder.gen

  final case class MoveStatAffectSets(
      increase: List[MoveStatAffect],
      decrease: List[MoveStatAffect]
  )

  object MoveStatAffectSets:
    given JsonDecoder[MoveStatAffectSets] = DeriveJsonDecoder.gen

  final case class MoveStatAffect(change: Int, move: NamedAPIResource)

  object MoveStatAffect:
    given JsonDecoder[MoveStatAffect] = DeriveJsonDecoder.gen

  final case class NatureStatAffectSets(
      increase: List[NamedAPIResource],
      decrease: List[NamedAPIResource]
  )

  object NatureStatAffectSets:
    given JsonDecoder[NatureStatAffectSets] = DeriveJsonDecoder.gen

  @jsonMemberNames(SnakeCase)
  final case class Type(
      id: Int,
      name: String,
      damageRelations: TypeRelations,
      pastDamageRelations: List[TypeRelationsPast],
      gameIndices: List[GenerationGameIndex],
      generation: NamedAPIResource,
      moveDamageClass: Option[NamedAPIResource],
      names: List[Name],
      pokemon: List[TypePokemon],
      moves: List[NamedAPIResource]
  )

  object Type:
    given JsonDecoder[Type] = DeriveJsonDecoder.gen

  final case class TypePokemon(slot: Int, pokemon: NamedAPIResource)

  object TypePokemon:
    given JsonDecoder[TypePokemon] = DeriveJsonDecoder.gen

  @jsonMemberNames(SnakeCase)
  final case class TypeRelations(
      noDamageTo: List[NamedAPIResource],
      halfDamageTo: List[NamedAPIResource],
      doubleDamageTo: List[NamedAPIResource],
      noDamageFrom: List[NamedAPIResource],
      halfDamageFrom: List[NamedAPIResource],
      doubleDamageFrom: List[NamedAPIResource]
  )

  object TypeRelations:
    given JsonDecoder[TypeRelations] = DeriveJsonDecoder.gen

  @jsonMemberNames(SnakeCase)
  final case class TypeRelationsPast(
      generation: NamedAPIResource,
      damageRelations: List[TypeRelations]
  )

  object TypeRelationsPast:
    // ripped from docs at https://zio.dev/zio-json/decoding#approach-4-decode-to-json-use-cursors
    private def sequence[A, B](eithers: List[Either[A, B]]): Either[A, List[B]] =
      eithers.partition(_.isLeft) match {
        case (Nil, rights) => Right(rights.collect { case Right(r) => r })
        case (lefts, _)    => Left(lefts.collect { case Left(l) => l }.head)
      }

    // damage_relations is an object instead of a list when there's only one, so wrap it in a list in that case.
    given JsonDecoder[TypeRelationsPast] = JsonDecoder[Json].mapOrFail { c =>
      for {
        generation <- c.get(JsonCursor.field("generation")).flatMap(_.as[NamedAPIResource])
        damageRelationsC = JsonCursor.field("damage_relations")
        damageRelations <-
          c.get(damageRelationsC >>> JsonCursor.isArray)
            .flatMap(damageRelationsChunk =>
              sequence(damageRelationsChunk.elements.toList.map(_.as[TypeRelations]))
            )
            .orElse(
              c.get(damageRelationsC >>> JsonCursor.isObject)
                .flatMap(_.as[TypeRelations].map(List(_)))
            )
      } yield TypeRelationsPast(generation, damageRelations)
    }
