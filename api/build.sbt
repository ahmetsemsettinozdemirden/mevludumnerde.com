name := """mevlutumnerde.com"""

version := "1.1.1"

lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean)

scalaVersion := "2.12.4"

// Test Database
libraryDependencies += "org.postgresql" % "postgresql" % "42.2.1"
libraryDependencies += "javax.el" % "javax.el-api" % "3.0.0"
libraryDependencies += "org.glassfish" % "javax.el" % "3.0.0"
libraryDependencies += guice
libraryDependencies += javaJdbc
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1"