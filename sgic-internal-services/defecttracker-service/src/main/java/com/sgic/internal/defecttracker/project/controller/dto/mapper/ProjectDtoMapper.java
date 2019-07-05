package com.sgic.internal.defecttracker.project.controller.dto.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.internal.defecttracker.project.controller.converter.ProjectConverter;
import com.sgic.internal.defecttracker.project.controller.dto.ProjectDto;
import com.sgic.internal.defecttracker.project.entities.Project;
import com.sgic.internal.defecttracker.project.services.ProjectService;

@Service
public class ProjectDtoMapper {

	@Autowired
	public ProjectService projectService;
	

public List<ProjectDto> getAllProjectForMapper() { // List Method for ProjectMapper
	List<Project> projectList = projectService.getallDetails();
	return ProjectConverter.projectToProjectData(projectList);
	
}
public Project saveProjectforMapper(ProjectDto projectDto) {
	Project project = ProjectConverter.projectDataToProject(projectDto);
	return projectService.createProject(project);
}




}

