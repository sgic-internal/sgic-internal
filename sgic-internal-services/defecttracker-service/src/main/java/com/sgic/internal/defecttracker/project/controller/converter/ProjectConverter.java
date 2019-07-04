package com.sgic.internal.defecttracker.project.controller.converter;

import java.util.ArrayList;
import java.util.List;

import com.sgic.internal.defecttracker.project.controller.dto.ProjectDto;
import com.sgic.internal.defecttracker.project.entities.Project;

public class ProjectConverter {

	private ProjectConverter() {
	}

	public static ProjectDto projectToProjectData(Project project) {
		ProjectDto projectDto = new ProjectDto();

		if (project != null) {
<<<<<<< HEAD
			projectDto.setProjectId(project.getProjectId());
			projectDto.setAbbrivation(project.getAbbrivation());
			projectDto.setProjectName(project.getProjectName());
			projectDto.setType(project.getType());
			projectDto.setStartDate(project.getStartDate());
			projectDto.setEndDate(project.getEndDate());
			projectDto.setDuration(project.getDuration());
			projectDto.setStatus(project.getStatus());
			projectDto.setConfigId(project.getConfigId());
=======
			projectData.setProjectId(project.getProjectId());
			projectData.setProId(project.getProId());
			projectData.setProjectName(project.getProjectName());
			projectData.setType(project.getType());
			projectData.setStartDate(project.getStartDate());
			projectData.setEndDate(project.getEndDate());
			projectData.setDuration(project.getDuration());
			projectData.setStatus(project.getStatus());
			projectData.setConfigId(project.getConfigId());
>>>>>>> 1722263d35ed290770f31635785ba5317b961c1a

			return projectDto;
		}
		return null;
	}

	public static Project projectDataToProject(ProjectDto projectDto) {
		Project project = new Project();

<<<<<<< HEAD
		project.setProjectId(projectDto.getProjectId());
		project.setAbbrivation(projectDto.getAbbrivation());
		project.setProjectName(projectDto.getProjectName());
		project.setType(projectDto.getType());
		project.setEndDate(projectDto.getEndDate());
		project.setDuration(projectDto.getDuration());
		project.setStatus(projectDto.getStatus());
		project.setConfigId(projectDto.getConfigId());
=======
		project.setProjectId(projectData.getProjectId());
		project.setProId(projectData.getProId());
		project.setProjectName(projectData.getProjectName());
		project.setType(projectData.getType());
		project.setEndDate(projectData.getEndDate());
		project.setDuration(projectData.getDuration());
		project.setStatus(projectData.getStatus());
		project.setConfigId(projectData.getConfigId());
>>>>>>> 1722263d35ed290770f31635785ba5317b961c1a
		return project;
	}

	public static List<ProjectDto> projectToProjectData(List<Project> projectList) {

		if (projectList != null) {
			List<ProjectDto> lProjectData = new ArrayList<>();
			for (Project project : projectList) {
				ProjectDto projectDto = new ProjectDto();

<<<<<<< HEAD
				projectDto.setProjectId(project.getProjectId());
				projectDto.setAbbrivation(project.getAbbrivation());
				projectDto.setProjectName(project.getProjectName());
				projectDto.setType(project.getType());
				projectDto.setStartDate(project.getStartDate());
				projectDto.setEndDate(project.getEndDate());
				projectDto.setDuration(project.getDuration());
				projectDto.setStatus(project.getStatus());
				projectDto.setConfigId(project.getConfigId());
				lProjectData.add(projectDto);
=======
				projectData.setProjectId(project.getProjectId());
				projectData.setProId(project.getProId());
				projectData.setProjectName(project.getProjectName());
				projectData.setType(project.getType());
				projectData.setStartDate(project.getStartDate());
				projectData.setEndDate(project.getEndDate());
				projectData.setDuration(project.getDuration());
				projectData.setStatus(project.getStatus());
				projectData.setConfigId(project.getConfigId());
				lProjectData.add(projectData);
>>>>>>> 1722263d35ed290770f31635785ba5317b961c1a
			}

			return lProjectData;
		}
		return null;

	}

}
