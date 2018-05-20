import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "org.sparcs",
      scalaVersion := "2.12.5",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "Neobjugi-Bus",
    libraryDependencies += scalaTest % Test,
    libraryDependencies += "io.spray" %%  "spray-json" % "1.3.3"
  )
