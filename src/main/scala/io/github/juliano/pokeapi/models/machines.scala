package io.github.juliano.pokeapi.models

import io.github.juliano.pokeapi.models.utility.NamedAPIResource

import zio.json.*

object machines:
  @jsonMemberNames(SnakeCase)
  final case class Machine(
      id: Int,
      item: NamedAPIResource,
      move: NamedAPIResource,
      versionGroup: NamedAPIResource
  )

  object Machine:
    given JsonDecoder[Machine] = DeriveJsonDecoder.gen
