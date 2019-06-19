package com.sgic.internal.defecttracker.project.controller.dtomapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.internal.defecttracker.project.controller.converter.ProjectConverter;
import com.sgic.internal.defecttracker.project.controller.dto.ProjectData;
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

public ProjectData getByprojectName(String projectName) {
	Project project = projectService.getByprojectName(projectName);
	return ProjectConverter.projectToProjectData(project);
}

public List<ProjectData> getByProjecttype(String type) {
	List<Project> projectList = projectService.getByProjecttype(type);
	return ProjectConverter.projectToProjectData(projectList);
}

public Project UpdateProject(Long projectId, ProjectData projectData) {
	Project project = ProjectConverter.projectDataToProject(projectData);
	return projectService.updateProject(project);
}

public ProjectData deleteById(Long projectId) {
	projectService.deleteByprojectId(projectId);
	return null;

}



}

