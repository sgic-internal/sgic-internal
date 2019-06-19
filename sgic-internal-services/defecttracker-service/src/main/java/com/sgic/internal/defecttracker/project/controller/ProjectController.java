package com.sgic.internal.defecttracker.project.controller;


import java.util.List;


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
import com.sgic.internal.defecttracker.project.controller.dtomapper.ProjectDtoMapper;

import com.sgic.internal.defecttracker.project.services.ProjectService;
@RestController
public class ProjectController {
	@Autowired
	public ProjectDtoMapper projectDtoMapper;

	
	private static  Logger logger = LoggerFactory.getLogger(ProjectService.class);
	
	//Post Mapping For Create a Project by sajitha
	@PostMapping(value = "/createproject")
	public ResponseEntity<Object> createProject(@RequestBody ProjectData projectData) {
		projectDtoMapper.saveProjectforMapper(projectData);
	return new ResponseEntity<>(new ApiResponse(RestApiResponseStatus.OK), HttpStatus.OK);
		}
	//Get Mapping For Get All Project by Mercy
	  @GetMapping(value = "/GetAllproject")
		public ResponseEntity<List<ProjectData>>listEmployeeInfo() {
			return new ResponseEntity<>(projectDtoMapper.getAllProjectForMapper(), HttpStatus.OK);
		}
	//Get Mapping For Get Project By Id Jakki
	  @GetMapping("/getProjectById/{id}")
	  public ResponseEntity<ProjectData>getProjectById(@PathVariable Long id) {
	  	return new ResponseEntity<>(projectDtoMapper.getByProjectId(id),HttpStatus.OK);
	  }
	//Delete Mapping For Project By thadsha
	  @DeleteMapping("DeleteById/{projectId}")
		public ResponseEntity<ProjectData> deleteById(@PathVariable Long projectId) {
			return new ResponseEntity<>(projectDtoMapper.deleteById(projectId), HttpStatus.OK);
		}
	//Put Mapping For  Project By Arany
	  @PutMapping("/updateProject/{id}")
		public ResponseEntity<String>updateProject(@PathVariable Long id,
				@RequestBody ProjectData projectData) {
		  projectDtoMapper.UpdateProject(id, projectData);
			return new ResponseEntity<>("user updated succesfully", HttpStatus.OK);
		}

	//Get  Mapping For  Project Name By Sujanthan
	  @GetMapping("/getName/{projectName}")
	  public ResponseEntity<ProjectData>getByprojectName(@PathVariable String projectName){
	  	return new ResponseEntity<>(projectDtoMapper.getByprojectName(projectName), HttpStatus.OK);
	  }
	//Get  Mapping For  Project Type By Sajitha
	  @GetMapping("/gettype/{type}")
	  public ResponseEntity<List<ProjectData>>getBytype(@PathVariable String type){
	  	return new ResponseEntity<>(projectDtoMapper.getByProjecttype(type), HttpStatus.OK);
	  }
	//Get  Mapping For  Project Start Date By thatsha
//	  @GetMapping("/getDate/{date}")
//	  public ResponseEntity<Project>getByDate(@PathVariable Date date){
//	  	Project project = projectService.getBystartDate(date);
//	  	return new ResponseEntity<Project>(project, HttpStatus.OK);
//	  }
//	  
	//Get  Mapping For  Project Start Date By Aarany
//	  @GetMapping("/getduration/{duration}")
//	  public ResponseEntity<Project>getByduration(@PathVariable String duration){
//	  	Project project = projectService.getByduration(duration);
//	  	return new ResponseEntity<Project>(project, HttpStatus.OK);
//	  }
//	  
	//Get  Mapping For  Project Start Date By Mercy
//	  @GetMapping("/getstatus/{status}")
//	  public ResponseEntity<Project>getBystatus(@PathVariable String status){
//	  	Project project = projectService.getBystatus(status);
//	  	return new ResponseEntity<Project>(project, HttpStatus.OK);
//	  }
	
}
