package io.github.juliano.pokeapi

import io.github.juliano.pokeapi.models.evolution.*

class EvolutionSuite extends Fs2Suite:
  spec[EvolutionChain]("evolution chain by id", 1, _.babyTriggerItem.isEmpty)
  spec[EvolutionChain]("evolution chain resource list", _.count, 541)

  spec[EvolutionTrigger]("evolution trigger by id", 1, _.name, "level-up")
  spec[EvolutionTrigger]("evolution trigger by name", "level-up", _.id, 1)
  spec[EvolutionTrigger]("evolution trigger resource list", _.count, 13)
