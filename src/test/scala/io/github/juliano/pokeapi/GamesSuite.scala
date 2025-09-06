package io.github.juliano.pokeapi

import io.github.juliano.pokeapi.models.games.*

class GamesSuite extends Fs2Suite:
  spec[Generation]("generation by id", 1, _.name, "generation-i")
  spec[Generation]("generation by name", "generation-i", _.id, 1)
  spec[Generation]("generation resource list", _.count, 9)

  spec[Pokedex]("pokedex by id", 1, _.name, "national")
  spec[Pokedex]("pokedex by name", "national", _.id, 1)
  spec[Pokedex]("pokedex resource list", _.count, 32)

  spec[Version]("version by id", 1, _.name, "red")
  spec[Version]("version by name", "red", _.id, 1)
  spec[Version]("version resource list", _.count, 46)

  spec[VersionGroup]("version group by id", 1, _.name, "red-blue")
  spec[VersionGroup]("version group by name", "red-blue", _.id, 1)
  spec[VersionGroup]("version group resource list", _.count, 29)
