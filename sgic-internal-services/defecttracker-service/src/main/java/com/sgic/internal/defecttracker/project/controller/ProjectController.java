package com.sgic.internal.defecttracker.project.controller;

import java.sql.Date;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.common.api.enums.RestApiResponseStatus;
import com.sgic.common.api.response.ApiResponse;
import com.sgic.internal.defecttracker.project.controller.dto.ProjectData;
import com.sgic.internal.defecttracker.project.entities.Project;
import com.sgic.internal.defecttracker.project.services.ProjectService;
@RestController
public class ProjectController {
	@Autowired
	public ProjectService  projectService;
	
	private static  Logger logger = LoggerFactory.getLogger(ProjectService.class);
	
	 @PostMapping(value = "/project")
	  public ResponseEntity<Object> createGrampa(@RequestBody ProjectData projectData) {
		logger.info("sp starting saving");
	    Project project =new Project();
	    project.setProjectName(projectData.getProjectName());
	    project.setType(projectData.getType());
	    project.setStartDate(projectData.getStartDate());
	    project.setEndDate(projectData.getEndDate());
	    project.setDuration(projectData.getDuration());
	    project.setStatus(projectData.getStatus());
	    projectService.createProject(project);
	    logger.info("saved");
	    return new ResponseEntity<>(new ApiResponse(RestApiResponseStatus.OK), HttpStatus.OK);
	   
	  }
	  @GetMapping(value="/ViewProject")
	  public List<Project>getallDetils() {
		return projectService.getallDetails();
	} 
	  @DeleteMapping("/deleteProject/{id}")
		public ResponseEntity<String> createGrampa(@PathVariable Long id){
		  projectService.delete(id);
			return new ResponseEntity<String>("Project Task Deleted",HttpStatus.OK);
		}
	  @PutMapping("/updateProject")
		public ResponseEntity<Project>updateProject(@Valid @RequestBody Project project){
		  projectService.updateProject(project);
			return new ResponseEntity<Project>(project,HttpStatus.NO_CONTENT);
		}
	  @GetMapping("/getId/{id}")
	  public ResponseEntity<Project>getProjectById(@PathVariable Long id){
	  	Project project = projectService.getByprojectId(id);
	  	return new ResponseEntity<Project>(project, HttpStatus.OK);
	  }
	  @GetMapping("/getName/{name}")
	  public ResponseEntity<Project>getByprojectName(@PathVariable String name){
	  	Project project = projectService.getByprojectName(name);
	  	return new ResponseEntity<Project>(project, HttpStatus.OK);
	  }
	  @GetMapping("/gettype/{type}")
	  public ResponseEntity<Project>getBytype(@PathVariable String type){
	  	Project project = projectService.getBytype(type);
	  	return new ResponseEntity<Project>(project, HttpStatus.OK);
	  }
	  @GetMapping("/getDate/{date}")
	  public ResponseEntity<Project>getByDate(@PathVariable Date date){
	  	Project project = projectService.getBystartDate(date);
	  	return new ResponseEntity<Project>(project, HttpStatus.OK);
	  }
	  
	  @GetMapping("/getduration/{duration}")
	  public ResponseEntity<Project>getByduration(@PathVariable String duration){
	  	Project project = projectService.getByduration(duration);
	  	return new ResponseEntity<Project>(project, HttpStatus.OK);
	  }
	  
	  @GetMapping("/getstatus/{status}")
	  public ResponseEntity<Project>getBystatus(@PathVariable String status){
	  	Project project = projectService.getBystatus(status);
	  	return new ResponseEntity<Project>(project, HttpStatus.OK);
	  }
	
}
