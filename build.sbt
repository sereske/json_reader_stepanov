name := "json_reader_stepanov"

version := "0.1"

scalaVersion := "2.11.12"

val circeVersion = "0.7.0"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-sql" % "2.4.7" % Provided,
  "io.circe"  %% "circe-core"     % circeVersion,
  "io.circe"  %% "circe-generic"  % circeVersion,
  "io.circe"  %% "circe-parser"   % circeVersion
)