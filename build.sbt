import org.scalafmt.sbt.ScalafmtPlugin.autoImport.scalafmtOnCompile

inThisBuild(List(
  organization := "io.github.juliano",
  homepage := Some(url("https://github.com/juliano/pokeapi-scala")),
  licenses := List("MIT License" -> url("https://github.com/juliano/pokeapi-scala/blob/main/LICENSE")),
  developers := List(
    Developer("juliano", "Juliano Alves", "von.juliano@gmail.com", url("https://juliano-alves.com/"))
  )
))

sonatypeCredentialHost := "s01.oss.sonatype.org"
sonatypeRepository := "https://s01.oss.sonatype.org/service/local"

val scala3Version = "3.3.1"

lazy val pokeapi = project
  .in(file("."))
  .settings(
    name := "pokeapi-scala",
    scalaVersion := scala3Version,
    scalafmtOnCompile := true,
    scalacOptions := Seq("-Xmax-inlines", "64"),
    libraryDependencies ++= Seq(
      "com.softwaremill.sttp.client4" %% "core"                           % "4.0.0-M9",
      "com.softwaremill.sttp.client4" %% "zio-json"                       % "4.0.0-M9",
      "com.github.blemale"            %% "scaffeine"                      % "5.2.1",
      "org.scalameta"                 %% "munit"                          % "1.0.0-M11" % Test,
      "com.softwaremill.sttp.client4" %% "armeria-backend-cats"           % "4.0.0-M9"  % Test,
      "com.softwaremill.sttp.client4" %% "async-http-client-backend-cats" % "4.0.0-M9"  % Test,
      "com.softwaremill.sttp.client4" %% "fs2"                            % "4.0.0-M9"  % Test,
      "com.softwaremill.sttp.client4" %% "async-http-client-backend-fs2"  % "4.0.0-M9"  % Test,
      "com.softwaremill.sttp.client4" %% "zio"                            % "4.0.0-M9"  % Test,
      "com.softwaremill.sttp.client4" %% "async-http-client-backend-zio"  % "4.0.0-M9"  % Test,
      "com.softwaremill.sttp.client4" %% "armeria-backend-zio"            % "4.0.0-M9"  % Test,
      "com.softwaremill.sttp.client4" %% "armeria-backend"                % "4.0.0-M9"  % Test,
      "com.softwaremill.sttp.client4" %% "okhttp-backend"                 % "4.0.0-M9"  % Test,
      "com.softwaremill.sttp.client4" %% "pekko-http-backend"             % "4.0.0-M9"  % Test,
      "org.apache.pekko"              %% "pekko-stream"                   % "1.0.2"     % Test
    ),
    excludeDependencies ++= Seq(
      "org.scala-lang.modules" % "scala-collection-compat_2.13"
    ),
    licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
  )
