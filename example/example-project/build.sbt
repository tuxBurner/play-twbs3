name := "example-project"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  cache,
  "com.github.tuxBurner" %% "play-twbs3" % "0.1",
  "org.webjars" %% "webjars-play" % "2.2.1-2",
  "org.webjars" % "bootstrap" % "3.1.0",
  "org.webjars" % "jquery" % "1.11.0-1",
  "org.webjars" % "prettify" % "4-Mar-2013"
)

resolvers ++= Seq(
  "tuxburner.github.io" at "http://tuxburner.github.io/repo",
  "Local Maven Repository" at "file://"+Path.userHome.absolutePath+"/.m2/repository"
)

play.Project.playScalaSettings
