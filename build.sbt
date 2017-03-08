name := "hello-case-classy"

version := "1.0"

scalaVersion := "2.12.1"

val caseClassyVersion = "0.3.0"

libraryDependencies ++= Seq(
  "com.fortysevendeg" %% "classy-core"            % caseClassyVersion,
  "com.fortysevendeg" %% "classy-config-typesafe" % caseClassyVersion,
  "com.fortysevendeg" %% "classy-generic"         % caseClassyVersion,
  "org.scalatest"     %% "scalatest"              % "3.0.1" % "test"
)
