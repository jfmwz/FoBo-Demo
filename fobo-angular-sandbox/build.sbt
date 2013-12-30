name := "FoBo-Angular-Sandbox"

version := "0.0.1-SNAPSHOT"

organization := "net.liftweb"

crossScalaVersions := Seq("2.10.3")

scalaVersion := "2.10.3"

resolvers ++= Seq("snapshots"     at "http://oss.sonatype.org/content/repositories/snapshots",
                  "staging"       at "http://oss.sonatype.org/content/repositories/staging",
                  "releases"      at "http://oss.sonatype.org/content/repositories/releases"
                 )

seq(com.github.siasia.WebPlugin.webSettings :_*)

unmanagedResourceDirectories in Test <+= (baseDirectory) { _ / "src/main/webapp" }

scalacOptions ++= Seq("-deprecation", "-unchecked")

libraryDependencies <++= (liftLatestVersion,liftLatestEdition,version) { (v,e,mv) =>
    "net.liftweb"     %% "lift-webkit"            % v    % "compile" ::
    "net.liftweb"     %% "lift-mapper"            % v    % "compile" ::
    "net.liftmodules" %% ("fobo"+"_"+e)          % "1.2-SNAPSHOT" % "compile" ::
    Nil
}

libraryDependencies ++= Seq(
    "org.eclipse.jetty"       % "jetty-webapp"            % "8.1.7.v20120910"     % "container,test",
    "org.eclipse.jetty.orbit" % "javax.servlet"           % "3.0.0.v201112011016" % "container,test" artifacts Artifact("javax.servlet", "jar", "jar"),
    "ch.qos.logback"          % "logback-classic"         % "1.0.6",
    "org.specs2"              %% "specs2"                 % "1.14"                % "test",
    "com.typesafe.slick"      %% "slick"                  % "2.0.0-M3",
    "com.h2database"          % "h2"                      % "1.3.170"
  )