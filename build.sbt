name := "Word-Count-Job"

version := "0.0.1"

organization := "livetex"

scalaVersion := "2.10.4"

com.twitter.scrooge.ScroogeSBT.newSettings

scroogeThriftSourceFolder in Compile := baseDirectory.value

scroogeThriftOutputFolder in Compile := baseDirectory.value / "src/main/scala/"

resolvers ++= Seq(
  "Hortonworks Releases" at "http://repo.hortonworks.com/content/repositories/releases/",
  "Hortonworks Jetty" at "http://repo.hortonworks.com/content/repositories/jetty-hadoop/",
  "Sonatype OSS" at "https://oss.sonatype.org/content/repositories/releases/",
  "repo.codahale.com" at "http://repo.codahale.com"
)

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "1.5.1" % "provided",
  "org.apache.thrift" % "libthrift" % "0.9.3",
  "org.scalatest" %% "scalatest" % "2.0" % "test",
  "net.liftweb" %% "lift-json" % "2.5.1" % "test",
  "com.twitter" %% "scrooge-core" % "3.16.3",
  "com.twitter" %% "scrooge-linter" % "3.16.3",
  "com.twitter" %% "finagle-thrift" % "6.5.0"
)

pomIncludeRepository := { _ => false }

pomExtra := <url>https://github.com/LiveTex/Lead-Hub-Jobs</url>
  <licenses>
    <license>
      <name>BSD-style</name>
      <url>http://www.opensource.org/licenses/bsd-license.php</url>
      <distribution>repo</distribution>
    </license>
  </licenses>
  <scm>
    <url>git@github.com:vazyzy/Word-Count-Job.git</url>
    <connection>scm:git@github.com:vazyzy/Word-Count-Job.git</connection>
  </scm>
  <developers>
    <developer>
      <id>vazyzy</id>
      <name>Igor Korshunov</name>
    </developer>
  </developers>

