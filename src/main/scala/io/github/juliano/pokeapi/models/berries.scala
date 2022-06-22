package io.github.juliano.pokeapi.models

import io.github.juliano.pokeapi.models.utility.{ Name, NamedAPIResource }
import zio.json.{ jsonField, DeriveJsonDecoder, JsonDecoder }

object berries:
  final case class Berry(
      id: Int,
      name: String,
      @jsonField("growth_time") growthTime: Int,
      @jsonField("max_harvest") maxHarvest: Int,
      @jsonField("natural_gift_power") naturalGiftPower: Int,
      size: Int,
      smoothness: Int,
      @jsonField("soil_dryness") soilDryness: Int,
      firmness: NamedAPIResource,
      flavors: List[BerryFlavorMap],
      item: NamedAPIResource,
      @jsonField("natural_gift_type") naturalGiftType: NamedAPIResource
  )

  object Berry:
    given decoder: JsonDecoder[Berry] = DeriveJsonDecoder.gen

  final case class BerryFlavorMap(potency: Int, flavor: NamedAPIResource)

  object BerryFlavorMap:
    given decoder: JsonDecoder[BerryFlavorMap] = DeriveJsonDecoder.gen

  final case class BerryFirmness(
      id: Int,
      name: String,
      berries: List[NamedAPIResource],
      names: List[Name]
  )

  object BerryFirmness:
    given decoder: JsonDecoder[BerryFirmness] = DeriveJsonDecoder.gen

  final case class BerryFlavor(
      id: Int,
      name: String,
      berries: List[FlavorBerryMap],
      @jsonField("contest_type") contestType: NamedAPIResource,
      names: List[Name]
  )

  object BerryFlavor:
    given decoder: JsonDecoder[BerryFlavor] = DeriveJsonDecoder.gen

  final case class FlavorBerryMap(potency: Int, berry: NamedAPIResource)

  object FlavorBerryMap:
    given decoder: JsonDecoder[FlavorBerryMap] = DeriveJsonDecoder.gen
