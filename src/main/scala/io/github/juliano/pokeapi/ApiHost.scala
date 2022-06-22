package io.github.juliano.pokeapi

import sttp.model.Uri
import sttp.model.Uri.UriContext

case class ApiHost private (uri: Uri)

object ApiHost:
  final val default = ApiHost(uri"https://pokeapi.co/api/v2")
