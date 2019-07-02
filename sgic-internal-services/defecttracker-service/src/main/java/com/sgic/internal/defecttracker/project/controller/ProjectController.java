package com.sgic.internal.defecttracker.project.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.sgic.common.api.enums.RestApiResponseStatus;
import com.sgic.common.api.response.ApiResponse;
import com.sgic.internal.defecttracker.project.controller.dto.ProjectDto;
import com.sgic.internal.defecttracker.project.controller.dtomapper.ProjectDtoMapper;
import com.sgic.internal.defecttracker.project.repositories.ProjectRepository;

@CrossOrigin
@RestController
class ProjectController {

	private static Logger logger = LogManager.getLogger(ProjectRepository.class);

	@Autowired
	public ProjectDtoMapper projectDtoMapper;

	// Author :: by Sajitha
	// Post Mapping For Create a Project
	@PostMapping(value = "/createproject")
	public ResponseEntity<Object> createProject(@Valid @RequestBody ProjectDto projectDto) {
		projectDtoMapper.saveProjectforMapper(projectDto);
		logger.info("Project created");
		return new ResponseEntity<>(new ApiResponse(RestApiResponseStatus.OK), HttpStatus.OK);
	}

	// Author :: by Mercy
	// Post Mapping For Create a Project
	@GetMapping(value = "/GetAllproject")
	public ResponseEntity<List<ProjectDto>> listEmployeeInfo() {
		logger.info("Project are listed ");
		return new ResponseEntity<>(projectDtoMapper.getAllProjectForMapper(), HttpStatus.OK);
	}

}
