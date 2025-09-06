package io.github.juliano.pokeapi.models

import io.github.juliano.pokeapi.models.utility.{ Name, NamedAPIResource }

import zio.json.{ DeriveJsonDecoder, JsonDecoder }

object encounters:
  case class EncounterMethod(id: Int, name: String, order: Int, names: List[Name])

  object EncounterMethod:
    given JsonDecoder[EncounterMethod] = DeriveJsonDecoder.gen

  case class EncounterCondition(
      id: Int,
      name: String,
      names: List[Name],
      values: List[NamedAPIResource]
  )

  object EncounterCondition:
    given JsonDecoder[EncounterCondition] = DeriveJsonDecoder.gen

  case class EncounterConditionValue(
      id: Int,
      name: String,
      condition: NamedAPIResource,
      names: List[Name]
  )

  object EncounterConditionValue:
    given JsonDecoder[EncounterConditionValue] = DeriveJsonDecoder.gen
