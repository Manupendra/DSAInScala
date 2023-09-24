ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.12"

lazy val root = (project in file("."))
  .settings(
    name := "DSAInScala"
  )

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.2.11" % Test,
  "junit" % "junit" % "4.12" % "test"
)

