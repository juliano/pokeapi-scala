package io.github.juliano.pokeapi.models

import io.github.juliano.pokeapi.models.utility.NamedAPIResource

import zio.json.{ DeriveJsonDecoder, JsonDecoder }

final case class ResourceList(
    count: Int,
    next: Option[String],
    previous: Option[String],
    results: List[NamedAPIResource]
)

object ResourceList:
  given JsonDecoder[ResourceList] = DeriveJsonDecoder.gen
