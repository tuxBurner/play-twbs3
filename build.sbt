name := """play-twbs3"""

organization := "com.github.tuxBurner"

version := "1.0.1-SNAPSHOT"

scalaVersion := "2.11.1"

crossScalaVersions := Seq("2.10.4")

libraryDependencies ++= Seq(
  "com.typesafe.play" %% "play" % "2.3.5"
)

lazy val root = (project in file(".")).enablePlugins(SbtTwirl)

TwirlKeys.templateImports += "views.twbs._"

TwirlKeys.templateImports += "play.api.templates.PlayMagic._"

publishTo <<= version {
  case v if v.trim.endsWith("SNAPSHOT") => Some(Resolver.file("file",  new File(Path.userHome.absolutePath+"/.m2/repository")))
  case _ => Some(Resolver.file("Github Pages",  new File("../tuxBurner.github.io/repo")))
}
