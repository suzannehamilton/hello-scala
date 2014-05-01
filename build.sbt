name := "hello-scala"

version := "1.0"

scalaVersion := "2.10.3"

val akkaV = "2.3.2"

libraryDependencies ++= Seq("org.scalatest" % "scalatest_2.10" % "2.1.0" % "test",
  "com.typesafe.akka"   %%  "akka-actor"    % akkaV,
  "com.typesafe.akka"   %%  "akka-testkit"  % akkaV,
  "org.specs2" %% "specs2" % "2.2.3" % "test",
  "org.mockito" % "mockito-core" % "1.8.5"
)

libraryDependencies += "org.scalatest" % "scalatest_2.10" % "2.1.0" % "test"

libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.10.1" % "test"

libraryDependencies += "org.mockito" % "mockito-core" % "1.8.5"

resolvers += Classpaths.sbtPluginReleases

ScoverageSbtPlugin.instrumentSettings
