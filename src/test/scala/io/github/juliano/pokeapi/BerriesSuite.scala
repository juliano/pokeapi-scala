package io.github.juliano.pokeapi

import io.github.juliano.pokeapi.requests.*
import sttp.client3.{ HttpClientSyncBackend, Identity, SttpBackend }

class BerriesSuite extends munit.FunSuite:
  given backend: SttpBackend[Identity, Any] = HttpClientSyncBackend()
  val client = PokeApiClient()

  test("berry by id") {
    val berry = client.send(BerryRequest(1))
    assert(berry.name == "cheri")
  }
  test("berry by name") {
    val berry = client.send(BerryRequest("cheri"))
    assert(berry.id == 1)
  }
  test("berry resource list") {
    val list = client.send(BerryRequest.resourceList())
    assert(list.count == 64)
  }

  test("berry firmness by id") {
    val berryFirmness = client.send(BerryFirmnessRequest(1))
    assert(berryFirmness.name == "very-soft")
  }
  test("berry firmness by name") {
    val berryFirmness = client.send(BerryFirmnessRequest("very-soft"))
    assert(berryFirmness.id == 1)
  }
  test("berry firmness resource list") {
    val list = client.send(BerryFirmnessRequest.resourceList())
    assert(list.count == 5)
  }

  test("berry flavor by id") {
    val berryFlavor = client.send(BerryFlavorRequest(1))
    assert(berryFlavor.name == "spicy")
  }
  test("berry flavor by name") {
    val berryFlavor = client.send(BerryFlavorRequest("spicy"))
    assert(berryFlavor.id == 1)
  }
  test("berry flavor resource list") {
    val list = client.send(BerryFlavorRequest.resourceList())
    assert(list.count == 5)
  }
