package io.github.juliano.pokeapi

import io.github.juliano.pokeapi.models.moves.*

class MovesSuite extends TrySuite:
  spec[Move]("move by id", 1, _.name, "pound")
  spec[Move]("move by name", "pound", _.id, 1)
  spec[Move]("move by resource list", _.count, 937)

  spec[MoveAilment]("move ailment by id", 1, _.name, "paralysis")
  spec[MoveAilment]("move ailment by name", "paralysis", _.id, 1)
  spec[MoveAilment]("move ailment by resource list", _.count, 22)

  spec[MoveBattleStyle]("move battle style by id", 1, _.name, "attack")
  spec[MoveBattleStyle]("move battle style by name", "attack", _.id, 1)
  spec[MoveBattleStyle]("move battle style by resource list", _.count, 3)

  spec[MoveCategory]("move category by id", 1, _.name, "ailment")
  spec[MoveCategory]("move category by name", "ailment", _.id, 1)
  spec[MoveCategory]("move category by resource list", _.count, 14)

  spec[MoveDamageClass]("move damage by id", 1, _.name, "status")
  spec[MoveDamageClass]("move damage by name", "status", _.id, 1)
  spec[MoveDamageClass]("move damage by resource list", _.count, 3)

  spec[MoveLearnMethod]("move learn method by id", 1, _.name, "level-up")
  spec[MoveLearnMethod]("move learn method by name", "level-up", _.id, 1)
  spec[MoveLearnMethod]("move learn method by resource list", _.count, 11)

  spec[MoveTarget]("move target by id", 1, _.name, "specific-move")
  spec[MoveTarget]("move target by name", "specific-move", _.id, 1)
  spec[MoveTarget]("move target by resource list", _.count, 16)
