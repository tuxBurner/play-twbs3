name := """example-play-app"""

version := "1.0"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  cache,
  "com.github.tuxBurner" %% "play-twbs3" % "1.0.1-SNAPSHOT",
  "org.webjars.npm" % "bootstrap" % "3.3.6",
  "org.webjars.npm" % "jquery" % "1.11.3",
  "org.webjars" % "prettify" % "4-Mar-2013",
  "org.webjars.npm" % "bootstrap-select" % "1.9.3"
)

resolvers ++= Seq(
  "tuxburner.github.io" at "http://tuxburner.github.io/repo",
  "Local Maven Repository" at "file://"+Path.userHome.absolutePath+"/.m2/repository"
)
