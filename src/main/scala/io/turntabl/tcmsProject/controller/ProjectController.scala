package io.turntabl.tcmsProject.controller

import io.turntabl.tcmsProject.dao.ProjectDAOI
import org.json4s.NoTypeHints
import org.json4s.native.Serialization
import org.springframework.beans.factory.annotation.Autowire
import org.springframework.web.bind.annotation.{GetMapping, RequestMapping, RestController}

@RestController
@RequestMapping(Array("/projects"))
class ProjectController(@Autowire private val projectDAOI: ProjectDAOI) {
  implicit val format = Serialization.formats(NoTypeHints)

  @GetMapping(Array("/list"))
  def list = Serialization.write(projectDAOI.getAllProjects)


}
