import org.scalafmt.sbt.ScalafmtPlugin.autoImport.scalafmtOnCompile

val scala3Version = "3.1.3"

lazy val root = project
  .in(file("."))
  .settings(
    name := "pokeapi-sdk",
    version := "0.1.0",
    scalaVersion := scala3Version,
    scalafmtOnCompile := true,
    libraryDependencies ++= Seq(
      "com.softwaremill.sttp.client3" %% "zio-json" % "3.6.2",
      "org.scalameta"                 %% "munit"    % "1.0.0-M5" % Test
    ),
    excludeDependencies ++= Seq(
      "org.scala-lang.modules" % "scala-collection-compat_2.13"
    )
  )
