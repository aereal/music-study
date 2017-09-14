val leastScalacOptions =
  "-unchecked" ::
    "-deprecation" ::
    "-feature" ::
    "-encoding" :: "UTF-8" ::
    Nil

val commonScalacOptions =
  "-Xlint" ::
    "-Xlint:-missing-interpolator" ::
    "-Ywarn-unused" ::
    "-Ywarn-value-discard" ::
    "-Ywarn-dead-code" ::
    "-Ywarn-unused-import" ::
    leastScalacOptions

lazy val core = (project in file("core"))
  .disablePlugins(PlayScala)
  .settings(
    scalaVersion := "2.12.3",
    scalacOptions ++= commonScalacOptions,
    scalacOptions in Test := leastScalacOptions,
    scalacOptions in (Compile, console) := leastScalacOptions,
    scalacOptions in (Test, console) := leastScalacOptions,
    javaOptions ++= Nil :::
      "-Dfile.encoding=UTF-8" ::
      Nil,
    fork in Test := true,
    libraryDependencies ++= Seq(
      "org.scalactic" %% "scalactic" % "3.0.1",
      "org.scalatest" %% "scalatest" % "3.0.1"
    ),
    scalafmtOnCompile in ThisBuild := true,
    scalafmtTestOnCompile in ThisBuild := true
  )

lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  .settings(
    scalaVersion := "2.12.3",
    scalacOptions ++= commonScalacOptions,
    scalacOptions in Test := leastScalacOptions,
    scalacOptions in (Compile, console) := leastScalacOptions,
    scalacOptions in (Test, console) := leastScalacOptions,
    javaOptions ++= Nil :::
      "-Dfile.encoding=UTF-8" ::
      Nil,
    fork in Test := true,
    libraryDependencies ++= Seq(
      guice,
      "org.scalactic" %% "scalactic" % "3.0.1",
      "org.scalatest" %% "scalatest" % "3.0.1"
    ),
    scalafmtOnCompile in ThisBuild := true,
    scalafmtTestOnCompile in ThisBuild := true
  )
