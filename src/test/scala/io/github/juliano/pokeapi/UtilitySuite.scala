package io.github.juliano.pokeapi

import io.github.juliano.pokeapi.models.utility.*

class UtilitySuite extends ArmeriaZIOSuite:
  spec[Language]("language by id", 1, _.name, "ja-Hrkt")
  // Languages with hyphens can't be retrieved by name due to a bug in PokeAPI.
  spec[Language]("language by name", "roomaji", _.id, 2)
  spec[Language]("language resource list", _.count, 13)
