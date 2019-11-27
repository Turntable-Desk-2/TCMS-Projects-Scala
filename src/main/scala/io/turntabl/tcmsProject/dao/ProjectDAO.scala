package io.turntabl.tcmsProject.dao
import io.turntabl.tcmsProject.dao.ProjectTO

trait ProjectDAO {
  def getAllProjects
  def searchProjectByName(project_name: String): List[ProjectTO]
  def addNewProject (project: ProjectTO): Unit
  def updateProjectInfo(id: Int, project: ProjectTO): Unit
  def deleteProjectById (id: Nothing): Unit
}
