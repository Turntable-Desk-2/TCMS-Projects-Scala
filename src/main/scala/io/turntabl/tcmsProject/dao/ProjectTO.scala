package io.turntabl.tcmsProject.dao

 case class ProjectTO(val project_id: Int,
                      val project_name: String,
                      val  project_description: String){
  def this() = this(0, "","")
 }
