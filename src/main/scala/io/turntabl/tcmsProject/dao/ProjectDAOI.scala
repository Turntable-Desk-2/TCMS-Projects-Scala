package io.turntabl.tcmsProject.dao

import io.swagger.annotations.{Api, ApiOperation}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.jdbc.core.{BeanPropertyRowMapper, JdbcTemplate, RowMapper}
import org.springframework.web.bind.annotation.{GetMapping, RestController}
import

@Api
@RestController
class ProjectDAOI(@Autowired val template: JdbcTemplate) extends ProjectDAO {

  @ApiOperation("Add new project")
  @GetMapping ("/api/v1/projects")
  override def getAllProjects: List[ProjectTO] = {
    this.template.query("select * from projects",
    new BeanPropertyRowMapper[ProjectTO](classOf[ProjectTO])) }

  override def searchProjectByName(project_name: String): List[ProjectTO] = ???

  override def addNewProject(project: ProjectTO): Unit = ???

  override def updateProjectInfo(id: Int, project: ProjectTO): Unit = ???

  override def deleteProjectById(id: Nothing): Unit = ???

}
@Bean
object ProjectMapper extends RowMapper[ProjectTO]{
  override def mapRow(rs: ResultSet, rowNum: Int): ProjectTO = {
    val project_id = rs.getInt("project_id")
    val project_name = rs.getString("project_name")
    val project_description = rs.getstring("project_description")
    ProjectTO(project_id, project_name, project_description)
  }
}
