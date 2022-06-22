package io.github.juliano.pokeapi.requests

import io.github.juliano.pokeapi.PokeApiClient.PokeRequest
import io.github.juliano.pokeapi.models.machines.Machine

final case class MachineRequest(id: String | Long) extends PokeRequest[Machine](id):
  val resource = MachineRequest.resource

object MachineRequest:
  final val resource                                 = "machine"
  def resourceList(offset: Int = 0, limit: Int = 20) = ResourceListRequest(resource)
