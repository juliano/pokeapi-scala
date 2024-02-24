package io.github.juliano.pokeapi;

import io.github.juliano.pokeapi.requests.*
import sttp.client4.httpclient.zio.HttpClientZioBackend

class ItemsSuite extends ZIOSuite:
  val client = HttpClientZioBackend().map(implicit backend => PokeApiClient(backend))

  spec("item by id", ItemRequest(1), _.name == "master-ball")
  spec("item by name", ItemRequest("master-ball"), _.id == 1)
  spec("item resource list", ItemRequest.resourceList(), _.count == 2110)

  spec("item attribute by id", ItemAttributeRequest(1), _.name == "countable")
  spec("item attribute by name", ItemAttributeRequest("countable"), _.id == 1)
  spec("item attribute resource list", ItemAttributeRequest.resourceList(), _.count == 8)

  spec("item category by id", ItemCategoryRequest(1), _.name == "stat-boosts")
  spec("item category by name", ItemCategoryRequest("stat-boosts"), _.id == 1)
  spec("item category resource list", ItemCategoryRequest.resourceList(), _.count == 54)

  spec("item fling effect by id", ItemFlingEffectRequest(1), _.name == "badly-poison")
  spec("item fling effect by name", ItemFlingEffectRequest("badly-poison"), _.id == 1)
  spec("item fling effect resource list", ItemFlingEffectRequest.resourceList(), _.count == 7)

  spec("item pocket by id", ItemPocketRequest(1), _.name == "misc")
  spec("item pocket by name", ItemPocketRequest("misc"), _.id == 1)
  spec("item pocket resource list", ItemPocketRequest.resourceList(), _.count == 8)
