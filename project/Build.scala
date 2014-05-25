import sbt._
import sbt.Keys._

object PlayTemplateBuild extends Build {
  import Templates._

  lazy val buildSettings = Seq(
    scalaVersion := "2.10.3",
    organization := "com.github.tuxBurner",
    version := "0.3-SNAPSHOT",
    publishTo <<= version {
      case v if v.trim.endsWith("SNAPSHOT") => Some(Resolver.file("file",  new File(Path.userHome.absolutePath+"/.m2/repository")))
      case _ => Some(Resolver.file("Github Pages",  new File("../tuxBurner.github.io/repo")))
    }
  )

  lazy val root = Project(
    id = "play-twbs3",
    base = file("."),
    settings = Project.defaultSettings ++ buildSettings ++ templateSettings)

}

object Templates {
  // What are the packages where content types & formats are defined
  val templatePackages = SettingKey[Seq[String]]("template-packages")

  // The mapping from file extension to the content type T and its format Format[T]
  val templateFormats = SettingKey[Map[String, String]]("template-formats")

  lazy val templateDefaults = Seq[Setting[_]](
    templatePackages := Seq("play.api.templates._", "play.api.templates.PlayMagic._","views.twbs._"),
    templateFormats := Map("html" -> "play.api.templates.HtmlFormat")
  )

  val templatesResolver = "Typesafe Releases Repository" at "http://repo.typesafe.com/typesafe/releases/"
  val playLibrary = "com.typesafe.play" %% "play" % play.core.PlayVersion.current
  val templateLibrary = "com.typesafe.play" %% "templates" % play.core.PlayVersion.current

  lazy val templateSettings = templateDefaults ++ Seq(
    resolvers += templatesResolver,
    libraryDependencies  ++= Seq( playLibrary ) ,
    sourceGenerators in Compile <+= (state, unmanagedSourceDirectories in Compile, sourceManaged in Compile, templateFormats, templatePackages) map play.Project.ScalaTemplates
  )
}
