package io.github.juliano.pokeapi

import io.github.juliano.pokeapi.models.berries.*

class BerriesSuite extends SyncSuite:
  spec[Berry]("berry by id", 1, _.name, "cheri")
  spec[Berry]("berry by name", "cheri", _.id, 1)
  spec[Berry]("berry resource list", _.count, 64)

  spec[BerryFirmness]("berry firmness by id", 1, _.name, "very-soft")
  spec[BerryFirmness]("berry firmness by name", "very-soft", _.id, 1)
  spec[BerryFirmness]("berry firmness resource list", _.count, 5)

  spec[BerryFlavor]("berry flavor by id", 1, _.name, "spicy")
  spec[BerryFlavor]("berry flavor by name", "spicy", _.id, 1)
  spec[BerryFlavor]("berry flavor resource list", _.count, 5)
