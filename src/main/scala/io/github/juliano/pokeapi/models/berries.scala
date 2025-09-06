package io.github.juliano.pokeapi.models

import io.github.juliano.pokeapi.models.utility.{ Name, NamedAPIResource }

import zio.json.*

object berries:
  @jsonMemberNames(SnakeCase)
  final case class Berry(
      id: Int,
      name: String,
      growthTime: Int,
      maxHarvest: Int,
      naturalGiftPower: Int,
      size: Int,
      smoothness: Int,
      soilDryness: Int,
      firmness: NamedAPIResource,
      flavors: List[BerryFlavorMap],
      item: NamedAPIResource,
      naturalGiftType: NamedAPIResource
  )

  object Berry:
    given JsonDecoder[Berry] = DeriveJsonDecoder.gen

  final case class BerryFlavorMap(potency: Int, flavor: NamedAPIResource)

  object BerryFlavorMap:
    given JsonDecoder[BerryFlavorMap] = DeriveJsonDecoder.gen

  final case class BerryFirmness(
      id: Int,
      name: String,
      berries: List[NamedAPIResource],
      names: List[Name]
  )

  object BerryFirmness:
    given JsonDecoder[BerryFirmness] = DeriveJsonDecoder.gen

  @jsonMemberNames(SnakeCase)
  final case class BerryFlavor(
      id: Int,
      name: String,
      berries: List[FlavorBerryMap],
      contestType: NamedAPIResource,
      names: List[Name]
  )

  object BerryFlavor:
    given JsonDecoder[BerryFlavor] = DeriveJsonDecoder.gen

  final case class FlavorBerryMap(potency: Int, berry: NamedAPIResource)

  object FlavorBerryMap:
    given JsonDecoder[FlavorBerryMap] = DeriveJsonDecoder.gen
