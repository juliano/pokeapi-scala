package io.github.juliano.pokeapi.models

import io.github.juliano.pokeapi.models.moves.MoveStatChange
import io.github.juliano.pokeapi.models.utility.*
import zio.json.{ jsonField, DeriveJsonDecoder, JsonDecoder }

object pokemon:
  final case class Ability(
      id: Int,
      name: String,
      @jsonField("is_main_series") isMainSeries: Boolean,
      generation: NamedAPIResource,
      names: List[Name],
      @jsonField("effect_entries") effectEntries: List[VerboseEffect],
      @jsonField("effect_changes") effectChanges: List[AbilityEffectChange],
      @jsonField("flavor_text_entries") flavorTextEntries: List[AbilityFlavorText],
      pokemon: List[AbilityPokemon]
  )

  object Ability:
    given JsonDecoder[Ability] = DeriveJsonDecoder.gen

  final case class AbilityEffectChange(
      @jsonField("effect_entries") effectEntries: List[Effect],
      @jsonField("version_group") versionGroup: NamedAPIResource
  )

  object AbilityEffectChange:
    given JsonDecoder[AbilityEffectChange] = DeriveJsonDecoder.gen

  final case class AbilityFlavorText(
      @jsonField("flavor_text") flavorText: String,
      language: NamedAPIResource,
      @jsonField("version_group") versionGroup: NamedAPIResource
  )

  object AbilityFlavorText:
    given JsonDecoder[AbilityFlavorText] = DeriveJsonDecoder.gen

  final case class AbilityPokemon(
      @jsonField("is_hidden") isHidden: Boolean,
      slot: Int,
      pokemon: NamedAPIResource
  )

  object AbilityPokemon:
    given JsonDecoder[AbilityPokemon] = DeriveJsonDecoder.gen

  final case class Characteristic(
      id: Int,
      descriptions: List[Description],
      @jsonField("gene_modulo") geneModulo: Int,
      @jsonField("possible_values") possibleValues: List[Int],
      @jsonField("highest_stat") highestStat: NamedAPIResource
  )

  object Characteristic:
    given JsonDecoder[Characteristic] = DeriveJsonDecoder.gen

  final case class EggGroup(
      id: Int,
      name: String,
      names: List[Name],
      @jsonField("pokemon_species") pokemonSpecies: List[NamedAPIResource]
  )

  object EggGroup:
    given JsonDecoder[EggGroup] = DeriveJsonDecoder.gen

  final case class Gender(
      id: Int,
      name: String,
      @jsonField("pokemon_species_details") pokemonSpeciesDetails: List[PokemonSpeciesGender],
      @jsonField("required_for_evolution") requiredForEvolution: List[NamedAPIResource]
  )

  object Gender:
    given JsonDecoder[Gender] = DeriveJsonDecoder.gen

  final case class PokemonSpeciesGender(
      rate: Int,
      @jsonField("pokemon_species") pokemonSpecies: NamedAPIResource
  )

  object PokemonSpeciesGender:
    given JsonDecoder[PokemonSpeciesGender] = DeriveJsonDecoder.gen

  final case class GrowthRate(
      id: Int,
      name: String,
      formula: String,
      descriptions: List[Description],
      levels: List[GrowthRateExperienceLevel],
      @jsonField("pokemon_species") pokemonSpecies: List[NamedAPIResource]
  )

  object GrowthRate:
    given JsonDecoder[GrowthRate] = DeriveJsonDecoder.gen

  final case class GrowthRateExperienceLevel(level: Int, experience: Int)

  object GrowthRateExperienceLevel:
    given JsonDecoder[GrowthRateExperienceLevel] = DeriveJsonDecoder.gen

  final case class Nature(
      id: Int,
      name: String,
      @jsonField("decreased_stat") decreasedStat: Option[NamedAPIResource],
      @jsonField("increased_stat") increasedStat: Option[NamedAPIResource],
      @jsonField("hates_flavor") hatesFlavor: Option[NamedAPIResource],
      @jsonField("likes_flavor") likesFlavor: Option[NamedAPIResource],
      @jsonField("pokeathlon_stat_changes") pokeathlonStatChanges: List[NatureStatChange],
      @jsonField("move_battle_style_preferences") moveBattleStylePreferences: List[
        MoveBattleStylePreference
      ],
      names: List[Name]
  )

  object Nature:
    given JsonDecoder[Nature] = DeriveJsonDecoder.gen

  final case class NatureStatChange(
      @jsonField("max_change") maxChange: Int,
      @jsonField("pokeathlon_stat") pokeathlonStat: NamedAPIResource
  )

  object NatureStatChange:
    given JsonDecoder[NatureStatChange] = DeriveJsonDecoder.gen

  final case class MoveBattleStylePreference(
      @jsonField("low_hp_preference") lowHpPreference: Int,
      @jsonField("high_hp_preference") highHpPreference: Int,
      @jsonField("move_battle_style") moveBattleStyle: NamedAPIResource
  )

  object MoveBattleStylePreference:
    given JsonDecoder[MoveBattleStylePreference] = DeriveJsonDecoder.gen

  final case class PokeathlonStat(
      id: Int,
      name: String,
      names: List[Name],
      @jsonField("affecting_natures") affectingNatures: NaturePokeathlonStatAffectSets
  )

  object PokeathlonStat:
    given JsonDecoder[PokeathlonStat] = DeriveJsonDecoder.gen

  final case class NaturePokeathlonStatAffectSets(
      increase: List[NaturePokeathlonStatAffect],
      decrease: List[NaturePokeathlonStatAffect]
  )

  object NaturePokeathlonStatAffectSets:
    given JsonDecoder[NaturePokeathlonStatAffectSets] = DeriveJsonDecoder.gen

  final case class NaturePokeathlonStatAffect(
      @jsonField("max_change") maxChange: Int,
      nature: NamedAPIResource
  )

  object NaturePokeathlonStatAffect:
    given JsonDecoder[NaturePokeathlonStatAffect] = DeriveJsonDecoder.gen

  final case class Pokemon(
      id: Int,
      name: String,
      @jsonField("base_experience") baseExperience: Int,
      height: Int,
      @jsonField("is_default") isDefault: Boolean,
      order: Int,
      weight: Int,
      abilities: List[PokemonAbility],
      forms: List[NamedAPIResource],
      @jsonField("game_indices") gameIndices: List[VersionGameIndex],
      @jsonField("held_items") heldItems: List[PokemonHeldItem],
      @jsonField("location_area_encounters") locationAreaEncounters: String,
      moves: List[PokemonMove],
      @jsonField("past_types") pastTypes: List[PokemonTypePast],
      sprites: PokemonSprites,
      species: NamedAPIResource,
      stats: List[PokemonStat],
      types: List[PokemonType]
  )

  object Pokemon:
    given JsonDecoder[Pokemon] = DeriveJsonDecoder.gen

  final case class PokemonAbility(
      @jsonField("is_hidden") isHidden: Boolean,
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

  final case class PokemonHeldItem(
      item: NamedAPIResource,
      @jsonField("version_details") versionDetails: List[PokemonHeldItemVersion]
  )

  object PokemonHeldItem:
    given JsonDecoder[PokemonHeldItem] = DeriveJsonDecoder.gen

  final case class PokemonHeldItemVersion(version: NamedAPIResource, rarity: Int)

  object PokemonHeldItemVersion {
    given JsonDecoder[PokemonHeldItemVersion] = DeriveJsonDecoder.gen
  }

  final case class PokemonMove(
      move: NamedAPIResource,
      @jsonField("version_group_details") versionGroupDetails: List[PokemonMoveVersion]
  )

  object PokemonMove:
    given JsonDecoder[PokemonMove] = DeriveJsonDecoder.gen

  final case class PokemonMoveVersion(
      @jsonField("move_learn_method") moveLearnMethod: NamedAPIResource,
      @jsonField("version_group") versionGroup: NamedAPIResource,
      @jsonField("level_learned_at") levelLearnedAt: Int
  )

  object PokemonMoveVersion:
    given JsonDecoder[PokemonMoveVersion] = DeriveJsonDecoder.gen

  final case class PokemonStat(
      stat: NamedAPIResource,
      effort: Int,
      @jsonField("base_stat") baseStat: Int
  )

  object PokemonStat:
    given JsonDecoder[PokemonStat] = DeriveJsonDecoder.gen

  final case class PokemonSprites(
      @jsonField("front_default") frontDefault: String,
      @jsonField("front_shiny") frontShiny: String,
      @jsonField("front_female") frontFemale: Option[String],
      @jsonField("front_shiny_female") frontShinyFemale: Option[String],
      @jsonField("back_default") backDefault: String,
      @jsonField("back_shiny") backShiny: String,
      @jsonField("back_female") backFemale: Option[String],
      @jsonField("back_shiny_female") backShinyFemale: Option[String]
  )

  object PokemonSprites:
    given JsonDecoder[PokemonSprites] = DeriveJsonDecoder.gen

  final case class LocationAreaEncounter(
      @jsonField("location_area") locationArea: NamedAPIResource,
      @jsonField("version_details") versionDetails: List[VersionEncounterDetail]
  )

  object LocationAreaEncounter:
    given JsonDecoder[LocationAreaEncounter] = DeriveJsonDecoder.gen

  final case class PokemonColor(
      id: Int,
      name: String,
      names: List[Name],
      @jsonField("pokemon_species") pokemonSpecies: List[NamedAPIResource]
  )

  object PokemonColor:
    given JsonDecoder[PokemonColor] = DeriveJsonDecoder.gen

  final case class PokemonForm(
      id: Int,
      name: String,
      order: Int,
      @jsonField("form_order") formOrder: Int,
      @jsonField("is_default") isDefault: Boolean,
      @jsonField("is_battle_only") isBattleOnly: Boolean,
      @jsonField("is_mega") isMega: Boolean,
      @jsonField("form_name") formName: String,
      pokemon: NamedAPIResource,
      types: List[FormType],
      sprites: PokemonFormSprites,
      @jsonField("version_group") version_group: NamedAPIResource,
      names: List[Name],
      @jsonField("form_names") formNames: List[Name]
  )

  object PokemonForm:
    given JsonDecoder[PokemonForm] = DeriveJsonDecoder.gen

  final case class FormType(slot: Int, `type`: NamedAPIResource)

  object FormType:
    given JsonDecoder[FormType] = DeriveJsonDecoder.gen

  final case class PokemonFormSprites(
      @jsonField("front_default") frontDefault: String,
      @jsonField("front_shiny") frontShiny: String,
      @jsonField("back_default") backDefault: String,
      @jsonField("back_shiny") backShiny: String
  )

  object PokemonFormSprites:
    given JsonDecoder[PokemonFormSprites] = DeriveJsonDecoder.gen

  final case class PokemonHabitat(
      id: Int,
      name: String,
      names: List[Name],
      @jsonField("pokemon_species") pokemonSpecies: List[NamedAPIResource]
  )

  object PokemonHabitat:
    given JsonDecoder[PokemonHabitat] = DeriveJsonDecoder.gen

  final case class PokemonShape(
      id: Int,
      name: String,
      @jsonField("awesome_names") awesomeNames: List[AwesomeName],
      names: List[Name],
      @jsonField("pokemon_species") pokemonSpecies: List[NamedAPIResource]
  )

  object PokemonShape:
    given JsonDecoder[PokemonShape] = DeriveJsonDecoder.gen

  final case class AwesomeName(
      @jsonField("awesome_name") awesomeName: String,
      language: NamedAPIResource
  )

  object AwesomeName:
    given JsonDecoder[AwesomeName] = DeriveJsonDecoder.gen

  final case class PokemonSpecies(
      id: Int,
      name: String,
      order: Int,
      @jsonField("gender_rate") genderRate: Int,
      @jsonField("capture_rate") captureRate: Int,
      @jsonField("base_happiness") baseHappiness: Int,
      @jsonField("is_baby") isBaby: Boolean,
      @jsonField("is_legendary") isLegendary: Boolean,
      @jsonField("is_mythical") isMythical: Boolean,
      @jsonField("hatch_counter") hatchCounter: Int,
      @jsonField("has_gender_differences") hasGenderDifferences: Boolean,
      @jsonField("forms_switchable") formsSwitchable: Boolean,
      @jsonField("growth_rate") growthRate: NamedAPIResource,
      @jsonField("pokedex_numbers") pokedexNumbers: List[PokemonSpeciesDexEntry],
      @jsonField("egg_groups") eggGroups: List[NamedAPIResource],
      color: NamedAPIResource,
      shape: NamedAPIResource,
      @jsonField("evolves_from_species") evolvesFromSpecies: Option[NamedAPIResource],
      @jsonField("evolution_chain") evolutionChain: APIResource,
      habitat: NamedAPIResource,
      generation: NamedAPIResource,
      names: List[Name],
      @jsonField("pal_park_encounters") palParkEncounters: List[PalParkEncounterArea],
      @jsonField("flavor_text_entries") flavorTextEntries: List[FlavorText],
      @jsonField("form_descriptions") formDescriptions: List[Description],
      genera: List[Genus],
      varieties: List[PokemonSpeciesVariety]
  )

  object PokemonSpecies:
    given JsonDecoder[PokemonSpecies] = DeriveJsonDecoder.gen

  final case class Genus(genus: String, language: NamedAPIResource)

  object Genus:
    given JsonDecoder[Genus] = DeriveJsonDecoder.gen

  final case class PokemonSpeciesDexEntry(
      @jsonField("entry_number") entryNumber: Int,
      pokedex: NamedAPIResource
  )

  object PokemonSpeciesDexEntry:
    given JsonDecoder[PokemonSpeciesDexEntry] = DeriveJsonDecoder.gen

  final case class PalParkEncounterArea(
      @jsonField("base_score") baseScore: Int,
      rate: Int,
      area: NamedAPIResource
  )

  object PalParkEncounterArea:
    given JsonDecoder[PalParkEncounterArea] = DeriveJsonDecoder.gen

  final case class PokemonSpeciesVariety(
      @jsonField("is_default") isDefault: Boolean,
      pokemon: NamedAPIResource
  )

  object PokemonSpeciesVariety:
    given JsonDecoder[PokemonSpeciesVariety] = DeriveJsonDecoder.gen

  final case class Stat(
      id: Int,
      name: String,
      @jsonField("game_index") gameIndex: Int,
      @jsonField("is_battle_only") isBattleOnly: Boolean,
      @jsonField("affecting_moves") affectingMoves: MoveStatAffectSets,
      @jsonField("affecting_natures") affectingNatures: NatureStatAffectSets,
      characteristics: List[APIResource],
      @jsonField("move_damage_class") moveDamageClass: Option[NamedAPIResource],
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

  final case class Type(
      id: Int,
      name: String,
      @jsonField("damage_relations") damageRelations: TypeRelations,
      @jsonField("past_damage_relations") pastDamageRelations: List[TypeRelationsPast],
      @jsonField("game_indices") gameIndices: List[GenerationGameIndex],
      generation: NamedAPIResource,
      @jsonField("move_damage_class") moveDamageClass: NamedAPIResource,
      names: List[Name],
      pokemon: List[TypePokemon],
      moves: List[NamedAPIResource]
  )

  object Type:
    given JsonDecoder[Type] = DeriveJsonDecoder.gen

  final case class TypePokemon(slot: Int, pokemon: NamedAPIResource)

  object TypePokemon:
    given JsonDecoder[TypePokemon] = DeriveJsonDecoder.gen

  final case class TypeRelations(
      @jsonField("no_damage_to") noDamageTo: List[NamedAPIResource],
      @jsonField("half_damage_to") halfDamageTo: List[NamedAPIResource],
      @jsonField("double_damage_to") doubleDamageTo: List[NamedAPIResource],
      @jsonField("no_damage_from") noDamageFrom: List[NamedAPIResource],
      @jsonField("half_damage_from") halfDamageFrom: List[NamedAPIResource],
      @jsonField("double_damage_from") doubleDamageFrom: List[NamedAPIResource]
  )

  object TypeRelations:
    given JsonDecoder[TypeRelations] = DeriveJsonDecoder.gen

  final case class TypeRelationsPast(
      generation: NamedAPIResource,
      @jsonField("damage_relations") damageRelations: List[TypeRelations]
  )

  object TypeRelationsPast:
    given JsonDecoder[TypeRelationsPast] = DeriveJsonDecoder.gen
