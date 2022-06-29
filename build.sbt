import org.scalafmt.sbt.ScalafmtPlugin.autoImport.scalafmtOnCompile

val scala3Version = "3.1.3"

lazy val pokeapi = project
  .in(file("."))
  .settings(
    name := "pokeapi-scala",
    version := "0.1.0",
    scalaVersion := scala3Version,
    scalafmtOnCompile := true,
    libraryDependencies ++= Seq(
      "com.softwaremill.sttp.client3" %% "core"                           % "3.6.2",
      "com.softwaremill.sttp.client3" %% "zio-json"                       % "3.6.2",
      "com.github.blemale"            %% "scaffeine"                      % "5.2.0",
      "org.scalameta"                 %% "munit"                          % "1.0.0-M5" % Test,
      "com.softwaremill.sttp.client3" %% "armeria-backend-cats"           % "3.6.2"    % Test,
      "com.softwaremill.sttp.client3" %% "async-http-client-backend-cats" % "3.6.2"    % Test,
      "com.softwaremill.sttp.client3" %% "fs2"                            % "3.6.2"    % Test,
      "com.softwaremill.sttp.client3" %% "async-http-client-backend-fs2"  % "3.6.2"    % Test,
      "com.softwaremill.sttp.client3" %% "zio"                            % "3.6.2"    % Test,
      "com.softwaremill.sttp.client3" %% "async-http-client-backend-zio"  % "3.6.2"    % Test,
      "com.softwaremill.sttp.client3" %% "armeria-backend-zio"            % "3.6.2"    % Test,
      "com.softwaremill.sttp.client3" %% "armeria-backend"                % "3.6.2"    % Test,
      "com.softwaremill.sttp.client3" %% "okhttp-backend"                 % "3.6.2"    % Test
    ),
    excludeDependencies ++= Seq(
      "org.scala-lang.modules" % "scala-collection-compat_2.13"
    )
  )
