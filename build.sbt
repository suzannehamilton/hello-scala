name := "hello-scala"

version := "1.0"

scalaVersion := "2.10.3"

val akkaV = "2.2.3"

libraryDependencies ++= Seq("org.scalatest" % "scalatest_2.10" % "2.1.0" % "test",
  "com.typesafe.akka"   %%  "akka-actor"    % akkaV,
  "com.typesafe.akka"   %%  "akka-testkit"  % akkaV
)