package io.github.juliano.pokeapi

import cats.effect.IO
import cats.effect.unsafe.implicits.global
import io.github.juliano.pokeapi.requests.*
import sttp.client3.SttpBackend
import sttp.client3.armeria.cats.ArmeriaCatsBackend

class EncountersSuite extends munit.FunSuite {
  given backend: SttpBackend[IO, Any] = ArmeriaCatsBackend[IO]()
  val client: PokeApiClient[IO, Any] = PokeApiClient()

  test("enconter method by id") {
    val encounterMethod = client.send(EncounterMethodRequest(1)).unsafeRunSync()
    assert(encounterMethod.name == "walk")
  }
  test("enconter method by name") {
    val encounterMethod = client.send(EncounterMethodRequest("walk")).unsafeRunSync()
    assert(encounterMethod.id == 1)
  }
  test("enconter method resource list") {
    val list = client.send(EncounterMethodRequest.resourceList()).unsafeRunSync()
    assert(list.count == 27)
  }

  test("enconter condition by id") {
    val encounterCondition = client.send(EncounterConditionRequest(1)).unsafeRunSync()
    assert(encounterCondition.name == "swarm")
  }
  test("enconter condition by name") {
    val encounterCondition = client.send(EncounterConditionRequest("swarm")).unsafeRunSync()
    assert(encounterCondition.id == 1)
  }
  test("enconter condition resource list") {
    val list = client.send(EncounterConditionRequest.resourceList()).unsafeRunSync()
    assert(list.count == 10)
  }

  test("enconter condition value by id") {
    val encounterConditionValue = client.send(EncounterConditionValueRequest(1)).unsafeRunSync()
    assert(encounterConditionValue.name == "swarm-yes")
  }
  test("enconter condition value by name") {
    val encounterConditionValue =
      client.send(EncounterConditionValueRequest("swarm-yes")).unsafeRunSync()
    assert(encounterConditionValue.id == 1)
  }
  test("enconter condition value resource list") {
    val list = client.send(EncounterConditionValueRequest.resourceList()).unsafeRunSync()
    assert(list.count == 39)
  }
}
