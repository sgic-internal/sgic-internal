package com.sgic.internal.defecttracker.project.controller.converter;

import java.util.ArrayList;
import java.util.List;

import com.sgic.internal.defecttracker.project.controller.dto.ProjectDto;
import com.sgic.internal.defecttracker.project.entities.Project;

public class ProjectConverter {
//	
//	private ProjectConverter() {
//	}

	public static ProjectDto projectToProjectData(Project project) {
		ProjectDto projectDto = new ProjectDto();

		if (project != null) {
		//	projectDto.setPid(project.getPid());
			projectDto.setProjectId(project.getProjectId());
			projectDto.setProjectName(project.getProjectName());
	

			return projectDto;
		}
		return null;
	}

	public static Project projectDataToProject(ProjectDto projectDto) {
		Project project = new Project();

		project.setProjectId(projectDto.getProjectId());
		project.setProjectName(projectDto.getProjectName());
	//	project.setPid(projectDto.getPid());
		return project;
	}

	public static List<ProjectDto> projectToProjectData(List<Project> projectList) {

		if (projectList != null) {
			List<ProjectDto> lProjectData = new ArrayList<>();
			for (Project project : projectList) {
				ProjectDto projectDto = new ProjectDto();
		//		projectDto.setPid(project.getPid());
				projectDto.setProjectId(project.getProjectId());
				projectDto.setProjectName(project.getProjectName());
				lProjectData.add(projectDto);
			}

			return lProjectData;
		}
		return null;

	}

	  }


