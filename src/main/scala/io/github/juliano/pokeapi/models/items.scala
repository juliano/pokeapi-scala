package io.github.juliano.pokeapi.models

import io.github.juliano.pokeapi.models.utility.*
import zio.json.{ jsonField, DeriveJsonDecoder, JsonDecoder }

object items:
  final case class Item(
      id: Int,
      name: String,
      cost: Int,
      @jsonField("fling_power") flingPower: Option[Int],
      @jsonField("fling_effect") flingEffect: Option[NamedAPIResource],
      attributes: List[NamedAPIResource],
      category: NamedAPIResource,
      @jsonField("effect_entries") effectEntries: List[VerboseEffect],
      @jsonField("flavor_text_entries") flavorTextEntries: List[VersionGroupFlavorText],
      @jsonField("game_indices") gameIndices: List[GenerationGameIndex],
      names: List[Name],
      sprites: ItemSprites,
      @jsonField("held_by_pokemon") heldByPokemon: List[ItemHolderPokemon],
      @jsonField("baby_trigger_for") babyTriggerFor: Option[APIResource],
      machines: List[MachineVersionDetail]
  )

  object Item:
    given JsonDecoder[Item] = DeriveJsonDecoder.gen

  final case class ItemSprites(default: String)

  object ItemSprites:
    given JsonDecoder[ItemSprites] = DeriveJsonDecoder.gen

  final case class ItemHolderPokemon(
      pokemon: NamedAPIResource,
      @jsonField("version_details") versionDetails: List[ItemHolderPokemon]
  )

  object ItemHolderPokemon:
    given JsonDecoder[ItemHolderPokemon] = DeriveJsonDecoder.gen

  final case class ItemHolderPokemonVersionDetail(rarity: Int, version: NamedAPIResource)

  object ItemHolderPokemonVersionDetail:
    given JsonDecoder[ItemHolderPokemonVersionDetail] = DeriveJsonDecoder.gen

  final case class ItemAttribute(
      id: Int,
      name: String,
      items: List[NamedAPIResource],
      names: List[Name],
      descriptions: List[Description]
  )

  object ItemAttribute:
    given JsonDecoder[ItemAttribute] = DeriveJsonDecoder.gen

  final case class ItemCategory(
      id: Int,
      name: String,
      items: List[NamedAPIResource],
      names: List[Name],
      pocket: NamedAPIResource
  )

  object ItemCategory:
    given JsonDecoder[ItemCategory] = DeriveJsonDecoder.gen

  final case class ItemFlingEffect(
      id: Int,
      name: String,
      @jsonField("effect_entries") effectEntries: List[Effect],
      items: List[NamedAPIResource]
  )

  object ItemFlingEffect:
    given JsonDecoder[ItemFlingEffect] = DeriveJsonDecoder.gen

  final case class ItemPocket(
      id: Int,
      name: String,
      categories: List[NamedAPIResource],
      names: List[Name]
  )

  object ItemPocket:
    given JsonDecoder[ItemPocket] = DeriveJsonDecoder.gen
