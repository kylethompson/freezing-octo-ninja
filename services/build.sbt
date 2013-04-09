import AssemblyKeys._ // put this at the top of the file

name:="sbt-dropwizard-template"

resolvers ++= Seq(
   "Coda Hale repo" at "http://repo.codahale.com/"
 )

libraryDependencies ++= Seq(
  "com.yammer.dropwizard" % "dropwizard-core" % "0.6.2",
  "com.yammer.dropwizard" % "dropwizard-testing" % "0.6.2",
  "javax.servlet" % "javax.servlet-api" % "3.0.1",
  "org.codehaus.jackson" % "jackson-mapper-asl" % "1.9.12"
)

ivyXML :=
  <dependency org="org.eclipse.jetty.orbit" name="javax.servlet" rev="3.0.0.v201112011016">
    <artifact name="javax.servlet" type="orbit" ext="jar"/>
  </dependency>

organization := "cap"

version := "1.0-SNAPSHOT"

autoScalaLibrary := false

assemblySettings

assembleArtifact in packageScala := false

jarName in assembly := "services.jar"

mergeStrategy in assembly <<= (mergeStrategy in assembly) { (old) =>
  {
    case PathList("org", "hamcrest", xs @ _*) => MergeStrategy.first
    case x => old(x)
  }
}