package com.sgic.internal.defecttracker.project.controller.dtomapper;


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

public ProjectDto getByProjectId(String projectId) {
	Project project = projectService.getByprojectId(projectId);
	return ProjectConverter.projectToProjectData(project);
}

public List<ProjectDto> getByprojectNameForMapper(String projectName) {
	List<Project> project = projectService.getByprojectName(projectName);
	return ProjectConverter.projectToProjectData(project);
}

public List<ProjectDto> getByProjecttype(String type) {
	List<Project> project = projectService.getBytype(type);
	return ProjectConverter.projectToProjectData(project);
}

public List<ProjectDto> getBystartDateformapper(String date) {
	List<Project> project = projectService.getBystartDate(date);
	return ProjectConverter.projectToProjectData(project);
}

public List<ProjectDto> getBydurationformapper(String duration) {
	List<Project> project = projectService.getByduration(duration);
	return ProjectConverter.projectToProjectData(project);
}

public List<ProjectDto> getBystatusformapper(String status) {
	List<Project> project = projectService.getBystatus(status);
	return ProjectConverter.projectToProjectData(project);
}


public Project UpdateProject(String projectid, ProjectDto projectDto) {
	Project project = ProjectConverter.projectDataToProject(projectDto);
	return projectService.updateProject(projectid, project);
}

public ProjectDto deleteById(String projectId) {
	projectService.deleteById(projectId);
	return null;
}


public class ProjectDtoMapper {




}

