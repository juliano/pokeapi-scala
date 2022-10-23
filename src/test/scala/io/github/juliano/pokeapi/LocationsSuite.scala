package io.github.juliano.pokeapi

import cats.effect.IO
import io.github.juliano.pokeapi.requests.*
import sttp.client3.asynchttpclient.cats.AsyncHttpClientCatsBackend

class LocationsSuite extends CatsSuite:
  val client = AsyncHttpClientCatsBackend[IO]().map(implicit backend => PokeApiClient())

  spec("location by id", LocationRequest(1), _.name == "canalave-city")
  spec("location by name", LocationRequest("canalave-city"), _.id == 1)
  spec("location resource list", LocationRequest.resourceList(), _.count == 797)

  spec("location area by id", LocationAreaRequest(1), _.name == "canalave-city-area")
  spec("location area by name", LocationAreaRequest("canalave-city-area"), _.id == 1)
  spec("location area resource list", LocationAreaRequest.resourceList(), _.count == 732)

  spec("pal park area by id", PalParkAreaRequest(1), _.name == "forest")
  spec("pal park area by name", PalParkAreaRequest("forest"), _.id == 1)
  spec("pal park area resource list", PalParkAreaRequest.resourceList(), _.count == 5)

  spec("region by id", RegionRequest(1), _.name == "kanto")
  spec("region by name", RegionRequest("kanto"), _.id == 1)
  spec("region resource list", RegionRequest.resourceList(), _.count == 9)
