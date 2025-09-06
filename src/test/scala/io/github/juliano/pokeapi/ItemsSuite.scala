package io.github.juliano.pokeapi;

import io.github.juliano.pokeapi.models.items.*

class ItemsSuite extends ZIOSuite:
  spec[Item]("item by id", 1, _.name, "master-ball")
  spec[Item]("item by name", "master-ball", _.id, 1)
  spec[Item]("item resource list", _.count, 2180)

  spec[ItemAttribute]("item attribute by id", 1, _.name, "countable")
  spec[ItemAttribute]("item attribute by name", "countable", _.id, 1)
  spec[ItemAttribute]("item attribute resource list", _.count, 8)

  spec[ItemCategory]("item category by id", 1, _.name, "stat-boosts")
  spec[ItemCategory]("item category by name", "stat-boosts", _.id, 1)
  spec[ItemCategory]("item category resource list", _.count, 54)

  spec[ItemFlingEffect]("item fling effect by id", 1, _.name, "badly-poison")
  spec[ItemFlingEffect]("item fling effect by name", "badly-poison", _.id, 1)
  spec[ItemFlingEffect]("item fling effect resource list", _.count, 7)

  spec[ItemPocket]("item pocket by id", 1, _.name, "misc")
  spec[ItemPocket]("item pocket by name", "misc", _.id, 1)
  spec[ItemPocket]("item pocket resource list", _.count, 8)
