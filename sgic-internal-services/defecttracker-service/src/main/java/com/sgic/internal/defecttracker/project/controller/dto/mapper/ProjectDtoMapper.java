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
<<<<<<< HEAD
		return ProjectConverter.projectToProjectDto(projectList);
=======
		return ProjectConverter.projectToProjectData(projectList);
>>>>>>> f1bb3f266238a45ba97d2ec2eb6348085a0c1f87

	}

	public Project saveProjectforMapper(ProjectDto projectDto) {
<<<<<<< HEAD
		Project project = ProjectConverter.projectDtoToProject(projectDto);
=======
		Project project = ProjectConverter.projectDataToProject(projectDto);
>>>>>>> f1bb3f266238a45ba97d2ec2eb6348085a0c1f87
		return projectService.createProject(project);
	}

	public ProjectDto getByProjectId(String projectId) {
		Project project = projectService.getByprojectId(projectId);
<<<<<<< HEAD
		return ProjectConverter.projectToProjectDto(project);
=======
		return ProjectConverter.projectToProjectData(project);
>>>>>>> f1bb3f266238a45ba97d2ec2eb6348085a0c1f87
	}

	public List<ProjectDto> getByprojectNameForMapper(String projectName) {
		List<Project> project = projectService.getByprojectName(projectName);
<<<<<<< HEAD
		return ProjectConverter.projectToProjectDto(project);
=======
		return ProjectConverter.projectToProjectData(project);
>>>>>>> f1bb3f266238a45ba97d2ec2eb6348085a0c1f87
	}

	public List<ProjectDto> getByProjecttype(String type) {
		List<Project> project = projectService.getBytype(type);
<<<<<<< HEAD
		return ProjectConverter.projectToProjectDto(project);
=======
		return ProjectConverter.projectToProjectData(project);
>>>>>>> f1bb3f266238a45ba97d2ec2eb6348085a0c1f87
	}

	public List<ProjectDto> getBystartDateformapper(String date) {
		List<Project> project = projectService.getBystartDate(date);
<<<<<<< HEAD
		return ProjectConverter.projectToProjectDto(project);
=======
		return ProjectConverter.projectToProjectData(project);
>>>>>>> f1bb3f266238a45ba97d2ec2eb6348085a0c1f87
	}

	public List<ProjectDto> getBydurationformapper(Long duration) {
		List<Project> project = projectService.getByduration(duration);
<<<<<<< HEAD
		return ProjectConverter.projectToProjectDto(project);
=======
		return ProjectConverter.projectToProjectData(project);
>>>>>>> f1bb3f266238a45ba97d2ec2eb6348085a0c1f87
	}

	public List<ProjectDto> getBystatusformapper(String status) {
		List<Project> project = projectService.getBystatus(status);
<<<<<<< HEAD
		return ProjectConverter.projectToProjectDto(project);
	}

	public Project UpdateProject(String projectid, ProjectDto projectDto) {
		Project project = ProjectConverter.projectDtoToProject(projectDto);
=======
		return ProjectConverter.projectToProjectData(project);
	}

	public Project UpdateProject(String projectid, ProjectDto projectDto) {
		Project project = ProjectConverter.projectDataToProject(projectDto);
>>>>>>> f1bb3f266238a45ba97d2ec2eb6348085a0c1f87
		return projectService.updateProject(projectid, project);
	}

	public ProjectDto deleteById(String projectId) {
		projectService.deleteById(projectId);
		return null;
	}

}
