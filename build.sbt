name := "hello-case-classy"

version := "1.0"

scalaVersion := "2.12.1"

val caseClassyVersion = "0.3.0"

libraryDependencies ++= Seq(
  // case-classy deps
  "com.fortysevendeg" %% "classy-core"            % caseClassyVersion,
  "com.fortysevendeg" %% "classy-config-typesafe" % caseClassyVersion,
  "com.fortysevendeg" %% "classy-generic"         % caseClassyVersion,

  // ficus
   "com.iheart" %% "ficus" % "1.4.0"
)
