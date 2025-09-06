package io.github.juliano.pokeapi

import io.github.juliano.pokeapi.models.machines.*

class MachinesSuite extends OkSyncSuite:
  spec[Machine]("machine by id", 1, _.move.name.contains("mega-punch"))
  spec[Machine]("machine resource list", _.count, 2102)
