package io.turntabl.tcmsProject.dao

import java.sql.ResultSet

import io.swagger.annotations.{Api, ApiOperation}
import javax.sql.DataSource
import org.json4s.NoTypeHints
import org.json4s.native.Serialization
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.jdbc.core.{BeanPropertyRowMapper, JdbcTemplate, RowMapper}
import org.springframework.stereotype.Service
import org.springframework.stereotype.{Component, Service}
import org.springframework.web.bind.annotation.{GetMapping, RestController}

@Service
class ProjectDAOI @Autowired ()( val dataSource: DataSource){
  private val jdbcTemplate = new JdbcTemplate(dataSource)

    def getAllProjects = {
    this.jdbcTemplate.query("select * from projects",
    new BeanPropertyRowMapper[ProjectTO](classOf[ProjectTO]))
  }

//  override def searchProjectByName(project_name: String): List[ProjectTO] = ???
//
//  override def addNewProject(project: ProjectTO): Unit = ???
//
//  override def updateProjectInfo(id: Int, project: ProjectTO): Unit = ???
//
//  override def deleteProjectById(id: Nothing): Unit = ???

}
@Bean
object ProjectMapper extends RowMapper[ProjectTO]{
   def mapRow(rs: ResultSet, rowNum: Int): ProjectTO = {
    val project_id = rs.getInt("project_id")
    val project_name = rs.getString("project_name")
    val project_description = rs.getString("project_description")
    ProjectTO(project_id, project_name, project_description)
  }
}
