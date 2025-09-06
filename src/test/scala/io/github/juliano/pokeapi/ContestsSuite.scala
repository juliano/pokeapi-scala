package io.github.juliano.pokeapi

import io.github.juliano.pokeapi.models.contests.*

class ContestsSuite extends FutureSuite:
  spec[ContestType]("contest type by id", 1, _.name, "cool")
  spec[ContestType]("contest type by name", "cool", _.id, 1)
  spec[ContestType]("contest type resource list", _.count, 5)

  spec[ContestEffect]("contest effect by id", 1, _.appeal, 4)
  spec[ContestEffect]("contest effect resource list", _.count, 33)

  spec[SuperContestEffect]("super contest effect by id", 1, _.appeal, 2)
  spec[SuperContestEffect]("super contest effect resource list", _.count, 22)
