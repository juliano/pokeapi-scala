package io.github.juliano.pokeapi

import io.github.juliano.pokeapi.models.pokemon.*

class PokemonSuite extends ZIOSuite:
  spec[Ability]("ability by id", 1, _.name, "stench")
  spec[Ability]("ability by name", "stench", _.id, 1)
  spec[Ability]("ability resource list", _.count, 367)

  spec[Characteristic]("characteristic by id", 1, _.highestStat.name.contains("hp"))
  spec[Characteristic]("characteristic resource list", _.count, 30)

  spec[EggGroup]("egg group by id", 1, _.name, "monster")
  spec[EggGroup]("egg group by name", "monster", _.id, 1)
  spec[EggGroup]("egg group resource list", _.count, 15)

  spec[Gender]("gender by id", 1, _.name, "female")
  spec[Gender]("gender by name", "female", _.id, 1)
  spec[Gender]("gender resource list", _.count, 3)

  spec[GrowthRate]("growth rate by id", 1, _.name, "slow")
  spec[GrowthRate]("growth rate by name", "slow", _.id, 1)
  spec[GrowthRate]("growth rate resource list", _.count, 6)

  spec[Nature]("nature by id", 1, _.name, "hardy")
  spec[Nature]("nature by name", "hardy", _.id, 1)
  spec[Nature]("nature resource list", _.count, 25)

  spec[PokeathlonStat]("pokeathlon stat by id", 1, _.name, "speed")
  spec[PokeathlonStat]("pokeathlon stat by name", "speed", _.id, 1)
  spec[PokeathlonStat]("pokeathlon stat resource list", _.count, 5)

  spec[Pokemon]("pokemon by id", 1, _.name, "bulbasaur")
  spec[Pokemon]("pokemon by name", "bulbasaur", _.id, 1)
  spec[Pokemon]("pokemon resource list", _.count, 1302)

  spec[LocationAreaEncounters](
    "location area encounter by id",
    1,
    _.head.locationArea.name.contains("cerulean-city-area")
  )
  spec[LocationAreaEncounters](
    "location area encounter by name",
    "bulbasaur",
    _.head.locationArea.name.contains("cerulean-city-area")
  )

  spec[PokemonColor]("pokemon color by id", 1, _.name, "black")
  spec[PokemonColor]("pokemon color by name", "black", _.id, 1)
  spec[PokemonColor]("pokemon color resource list", _.count, 10)

  spec[PokemonForm]("pokemon form by id", 1, _.name, "bulbasaur")
  spec[PokemonForm]("pokemon form by name", "bulbasaur", _.id, 1)
  spec[PokemonForm]("pokemon form resource list", _.count, 1527)

  spec[PokemonHabitat]("pokemon habitat by id", 1, _.name, "cave")
  spec[PokemonHabitat]("pokemon habitat by name", "cave", _.id, 1)
  spec[PokemonHabitat]("pokemon habitat resource list", _.count, 9)

  spec[PokemonShape]("pokemon shape by id", 1, _.name, "ball")
  spec[PokemonShape]("pokemon shape by name", "ball", _.id, 1)
  spec[PokemonShape]("pokemon shape resource list", _.count, 14)

  spec[PokemonSpecies]("pokemon species by id", 1, _.name, "bulbasaur")
  spec[PokemonSpecies]("pokemon species by name", "bulbasaur", _.id, 1)
  spec[PokemonSpecies]("pokemon species resource list", _.count, 1025)

  spec[Stat]("stat by id", 1, _.name, "hp")
  spec[Stat]("stat by name", "hp", _.id, 1)
  spec[Stat]("stat resource list", _.count, 8)

  spec[Type]("type by id", 1, _.name, "normal")
  spec[Type]("type by name", "normal", _.id, 1)
  spec[Type]("type resource list", _.count, 21)
