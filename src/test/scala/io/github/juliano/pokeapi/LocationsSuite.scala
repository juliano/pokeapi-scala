package io.github.juliano.pokeapi

import io.github.juliano.pokeapi.models.locations.*

class LocationsSuite extends CatsSuite:
  spec[Location]("location by id", 1, _.name, "canalave-city")
  spec[Location]("location by name", "canalave-city", _.id, 1)
  spec[Location]("location resource list", _.count, 1070)

  spec[LocationArea]("location area by id", 1, _.name, "canalave-city-area")
  spec[LocationArea]("location area by name", "canalave-city-area", _.id, 1)
  spec[LocationArea]("location area resource list", _.count, 1089)

  spec[PalParkArea]("pal park area by id", 1, _.name, "forest")
  spec[PalParkArea]("pal park area by name", "forest", _.id, 1)
  spec[PalParkArea]("pal park area resource list", _.count, 5)

  spec[Region]("region by id", 1, _.name, "kanto")
  spec[Region]("region by name", "kanto", _.id, 1)
  spec[Region]("region resource list", _.count, 10)
