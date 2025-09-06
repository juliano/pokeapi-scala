package io.github.juliano.pokeapi.models

import io.github.juliano.pokeapi.models.utility.*

import zio.json.*

object items:
  @jsonMemberNames(SnakeCase)
  final case class Item(
      id: Int,
      name: String,
      cost: Int,
      flingPower: Option[Int],
      flingEffect: Option[NamedAPIResource],
      attributes: List[NamedAPIResource],
      category: NamedAPIResource,
      effectEntries: List[VerboseEffect],
      flavorTextEntries: List[VersionGroupFlavorText],
      gameIndices: List[GenerationGameIndex],
      names: List[Name],
      sprites: ItemSprites,
      heldByPokemon: List[ItemHolderPokemon],
      babyTriggerFor: Option[APIResource],
      machines: List[MachineVersionDetail]
  )

  object Item:
    given JsonDecoder[Item] = DeriveJsonDecoder.gen

  final case class ItemSprites(default: Option[String])

  object ItemSprites:
    given JsonDecoder[ItemSprites] = DeriveJsonDecoder.gen

  @jsonMemberNames(SnakeCase)
  final case class ItemHolderPokemon(
      pokemon: NamedAPIResource,
      versionDetails: List[ItemHolderPokemonVersionDetail]
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

  @jsonMemberNames(SnakeCase)
  final case class ItemFlingEffect(
      id: Int,
      name: String,
      effectEntries: List[Effect],
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
