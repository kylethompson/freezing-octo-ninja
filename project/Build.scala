import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "webFrontEnd"
  val appVersion      = "0.1"

  val appDependencies = Seq(
    // Add your project dependencies here,
    javaCore,
    javaJdbc,
    javaEbean
  )

  def kcopy(finder: PathFinder, dst: File) = {
    IO.copy(finder.get map {f => (f, dst / f.getName)})
  }

  val capDBDAOProject = Project("capDBDAO", file("libraries/capDBDAO"))

  val capDelivery = Project("capDelivery", file(""))
  val webFrontEnd = play.Project(
    appName, appVersion, appDependencies, path = file("webFrontEnd")
  )

  val dropWizardService = Project("services", file("services"))

}
