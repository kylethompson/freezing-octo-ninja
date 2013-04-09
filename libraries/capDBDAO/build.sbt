
libraryDependencies ++= Seq(
"com.novocode" % "junit-interface" % "0.10-M3" % "test->default"
)

organization := "your.group.id"

version := "1.0-SNAPSHOT"

autoScalaLibrary := false

resolvers += Resolver.url("sbt-plugin-releases", new URL(
  "http://scalasbt.artifactoryonline.com/scalasbt/sbt-plugin-releases/"))(
  Resolver.ivyStylePatterns)

resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"