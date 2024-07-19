package io.github.juliano.pokeapi

import io.github.juliano.pokeapi.requests.MachineRequest
import sttp.client4.SyncBackend
import sttp.client4.okhttp.OkHttpSyncBackend

class MachinesSuite extends munit.FunSuite:
  given backend: SyncBackend = OkHttpSyncBackend()
  val client = PokeApiClient()

  test("machine by id") {
    val machine = client.send(MachineRequest(1))
    assert(machine.move.name.contains("mega-punch"))
  }
  test("machine resource list") {
    val list = client.send(MachineRequest.resourceList())
    assert(list.count == 2102)
  }
