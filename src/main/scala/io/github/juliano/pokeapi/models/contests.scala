package io.github.juliano.pokeapi.models

import zio.json.{ jsonField, DeriveJsonDecoder, JsonDecoder }
import io.github.juliano.pokeapi.models.utility.*

object contests:
  final case class ContestType(
      id: Int,
      name: String,
      @jsonField("berry_flavor") berryFlavor: NamedAPIResource,
      names: List[ContestName]
  )

  object ContestType:
    given decoder: JsonDecoder[ContestType] = DeriveJsonDecoder.gen

  final case class ContestName(name: String, color: String, language: NamedAPIResource)

  object ContestName:
    given decoder: JsonDecoder[ContestName] = DeriveJsonDecoder.gen

  final case class ContestEffect(
      id: Int,
      appeal: Int,
      jam: Int,
      @jsonField("effect_entries") effectEntries: List[Effect],
      @jsonField("flavor_text_entries") flavorTextEntries: List[FlavorText]
  )

  object ContestEffect:
    given decoder: JsonDecoder[ContestEffect] = DeriveJsonDecoder.gen

  case class SuperContestEffect(
      id: Int,
      appeal: Int,
      @jsonField("flavor_text_entries") flavorTextEntries: List[FlavorText],
      moves: List[NamedAPIResource]
  )

  object SuperContestEffect:
    given decoder: JsonDecoder[SuperContestEffect] = DeriveJsonDecoder.gen
