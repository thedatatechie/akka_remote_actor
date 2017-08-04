name := "AkkaRemoteActors"

version := "1.1"

scalaVersion := "2.11.8"

scalacOptions := Seq("-deprecation", "-unchecked", "-optimize", "-feature")

libraryDependencies ++= Seq(
  "com.typesafe.akka" % "akka-actor_2.11" % "2.5.3",
  "com.typesafe.akka" % "akka-cluster_2.11" % "2.5.3",
  "com.typesafe.akka" % "akka-remote_2.11" % "2.5.3"
)

resolvers ++= Seq(
  "Local Maven" at Path.userHome.asFile.toURI.toURL + ".m2/repository",
  "Local Ivy Repository" at Path.userHome.asFile.toURI.toURL + ".ivy2/local",
  "maven2-repository.dev.java.net" at "http://download.java.net/maven/2",
  "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"
)


assemblyMergeStrategy in assembly := {
  case PathList("META-INF", "MANIFEST.MF") => MergeStrategy.discard
  case PathList("reference.conf") => MergeStrategy.concat
  case x => MergeStrategy.first
}
