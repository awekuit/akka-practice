ThisBuild / scalaVersion := "2.12.8"
ThisBuild / version := "0.0.1-SNAPSHOT"
ThisBuild / organization := "com.awekuit"
ThisBuild / organizationName := "awekuit"

val root = (project in file("."))
  .settings(name := "akka-practice-root")
  .aggregate(
    `akka-streams-practce`
  )

val `akka-streams-practce` =
  (project in file("akka-streams-practce"))
    .settings(
      name := "akka-streams-practce",
      libraryDependencies ++= Seq(
          "com.typesafe.akka" %% "akka-slf4j"               % "2.6.6",
          "com.typesafe.akka" %% "akka-actor"               % "2.6.6",
          "com.typesafe.akka" %% "akka-testkit"             % "2.6.6",
          "com.typesafe.akka" %% "akka-actor-typed"         % "2.6.6",
          "com.typesafe.akka" %% "akka-actor-testkit-typed" % "2.6.6",
          "com.typesafe.akka" %% "akka-stream"              % "2.6.6",
          "com.typesafe.akka" %% "akka-stream-testkit"      % "2.6.6",
          "org.scalatest"     %% "scalatest"                % "3.0.5"
        )
    )
