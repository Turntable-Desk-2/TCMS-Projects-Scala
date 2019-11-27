package io.turntabl.tcmsProject.dao

abstract case class ProjectTO(project_id: Int,
                              project_name: String,
                              project_description: String)