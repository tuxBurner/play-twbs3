name := """example-play-app"""

version := "1.0"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  cache,
  "com.github.tuxBurner" %% "play-twbs3" % "1.0.1-SNAPSHOT",
  "org.webjars" % "bootstrap" % "3.2.0",
  "org.webjars" % "jquery" % "1.11.0-1",
  "org.webjars" % "prettify" % "4-Mar-2013",
  "org.webjars" % "bootstrap-select" % "1.4.2"
)

resolvers ++= Seq(
  "tuxburner.github.io" at "http://tuxburner.github.io/repo",
  "Local Maven Repository" at "file://"+Path.userHome.absolutePath+"/.m2/repository"
)
