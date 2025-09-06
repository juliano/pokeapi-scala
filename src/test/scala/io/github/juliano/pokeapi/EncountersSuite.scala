package io.github.juliano.pokeapi

import io.github.juliano.pokeapi.models.encounters.*

class EncountersSuite extends ArmeriaCatsSuite:
  spec[EncounterMethod]("enconter method by id", 1, _.name, "walk")
  spec[EncounterMethod]("enconter method by name", "walk", _.id, 1)
  spec[EncounterMethod]("enconter method resource list", _.count, 37)

  spec[EncounterCondition]("enconter condition by id", 1, _.name, "swarm")
  spec[EncounterCondition]("enconter condition by name", "swarm", _.id, 1)
  spec[EncounterCondition]("enconter condition resource list", _.count, 14)

  spec[EncounterConditionValue]("enconter condition value by id", 1, _.name, "swarm-yes")
  spec[EncounterConditionValue]("enconter condition value by name", "swarm-yes", _.id, 1)
  spec[EncounterConditionValue]("enconter condition value resource list", _.count, 105)
