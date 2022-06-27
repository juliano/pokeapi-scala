package io.github.juliano.pokeapi

import io.github.juliano.pokeapi.requests.*
import sttp.client3.{ SttpBackend, TryHttpURLConnectionBackend }

import scala.util.Try

class MovesSuite extends TrySuite {
  given backend: SttpBackend[Try, Any] = TryHttpURLConnectionBackend()
  val client = PokeApiClient()

  spec("move by id", MoveRequest(1), _.name == "pound")
  spec("move by name", MoveRequest("pound"), _.id == 1)
  spec("move by resource list", MoveRequest.resourceList(), _.count == 844)

  spec("move ailment by id", MoveAilmentRequest(1), _.name == "paralysis")
  spec("move ailment by name", MoveAilmentRequest("paralysis"), _.id == 1)
  spec("move ailment by resource list", MoveAilmentRequest.resourceList(), _.count == 22)

  spec("move battle style by id", MoveBattleStyleRequest(1), _.name == "attack")
  spec("move battle style by name", MoveBattleStyleRequest("attack"), _.id == 1)
  spec("move battle style by resource list", MoveBattleStyleRequest.resourceList(), _.count == 3)

  spec("move category by id", MoveCategoryRequest(1), _.name == "ailment")
  spec("move category by name", MoveCategoryRequest("ailment"), _.id == 1)
  spec("move category by resource list", MoveCategoryRequest.resourceList(), _.count == 14)

  spec("move damage by id", MoveDamageClassRequest(1), _.name == "status")
  spec("move damage by name", MoveDamageClassRequest("status"), _.id == 1)
  spec("move damage by resource list", MoveDamageClassRequest.resourceList(), _.count == 3)

  spec("move learn method by id", MoveLearnMethodRequest(1), _.name == "level-up")
  spec("move learn method by name", MoveLearnMethodRequest("level-up"), _.id == 1)
  spec("move learn method by resource list", MoveLearnMethodRequest.resourceList(), _.count == 11)

  spec("move target by id", MoveTargetRequest(1), _.name == "specific-move")
  spec("move target by name", MoveTargetRequest("specific-move"), _.id == 1)
  spec("move target by resource list", MoveTargetRequest.resourceList(), _.count == 15)
}
