package com.sgic.internal.defecttracker.project.controller.dtomapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.internal.defecttracker.project.controller.converter.ProjectConverter;
import com.sgic.internal.defecttracker.project.controller.data.ProjectData;
import com.sgic.internal.defecttracker.project.entities.Project;
import com.sgic.internal.defecttracker.project.services.ProjectService;

@Service
public class ProjectDtoMapper {
	@Autowired
	public ProjectService projectService;
	

public List<ProjectData> getAllProjectForMapper() { // List Method for ProjectMapper
	List<Project> projectList = projectService.getallDetails();
	return ProjectConverter.projectToProjectData(projectList);
	
}
public Project saveProjectforMapper(ProjectData projectData) {
	Project project = ProjectConverter.projectDataToProject(projectData);
	return projectService.createProject(project);
}

public ProjectData getByProjectId(Long projectId) {
	Project project = projectService.getByprojectId(projectId);
	return ProjectConverter.projectToProjectData(project);
}

public ProjectData getByProId(String proId) {
	Project project = projectService.getByproId(proId);
	return ProjectConverter.projectToProjectData(project);
}

public List<ProjectData> getByprojectNameForMapper(String projectName) {
	List<Project> project = projectService.getByprojectName(projectName);
	return ProjectConverter.projectToProjectData(project);
}

public List<ProjectData> getByProjecttype(String type) {
	List<Project> project = projectService.getBytype(type);
	return ProjectConverter.projectToProjectData(project);
}

public List<ProjectData> getBystartDateformapper(String date) {
	List<Project> project = projectService.getBystartDate(date);
	return ProjectConverter.projectToProjectData(project);
}

public List<ProjectData> getBydurationformapper(Long duration) {
	List<Project> project = projectService.getByduration(duration);
	return ProjectConverter.projectToProjectData(project);
}

public List<ProjectData> getBystatusformapper(String status) {
	List<Project> project = projectService.getBystatus(status);
	return ProjectConverter.projectToProjectData(project);
}


public Project UpdateProject(Long projectid, ProjectData projectData) {
	Project project = ProjectConverter.projectDataToProject(projectData);
	return projectService.updateProject(projectid, project);
}

public ProjectData deleteById(String projectId) {
	projectService.deleteById(projectId);
	return null;
}



}

