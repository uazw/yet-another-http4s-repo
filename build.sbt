val scala3Version = "3.7.4"

val http4sVersion = "1.0.0-M45"
val log4catsVersion = "2.7.1"

lazy val root = project
  .in(file("."))
  .settings(
    name := "rebirth",
    version := "0.1.0-SNAPSHOT",
    scalaVersion := scala3Version,
    libraryDependencies ++= Seq(
      "org.http4s" %% "http4s-ember-client" % http4sVersion,
      "org.http4s" %% "http4s-ember-server" % http4sVersion,
      "org.http4s" %% "http4s-dsl" % http4sVersion,
      "org.typelevel" %% "log4cats-slf4j" % log4catsVersion,
      "org.scalameta" %% "munit" % "1.0.0" % Test
    )
  )
