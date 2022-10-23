package io.github.juliano.pokeapi.models

import io.github.juliano.pokeapi.models.utility.NamedAPIResource
import zio.json.{ jsonField, DeriveJsonDecoder, JsonDecoder }

object machines:
  final case class Machine(
      id: Int,
      item: NamedAPIResource,
      move: NamedAPIResource,
      @jsonField("version_group") version_group: NamedAPIResource
  )

  object Machine:
    given JsonDecoder[Machine] = DeriveJsonDecoder.gen
