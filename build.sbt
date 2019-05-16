name := "AkkaArticleTuto1"

version := "0.1"

scalaVersion := "2.12.8"

lazy val akkaVersion = "2.5.22"

libraryDependencies ++= Seq(
  // la seule dépendance dont on aura besoin pour l'instant sera celle du core d'Akka
  "com.typesafe.akka" %% "akka-actor" % akkaVersion
)