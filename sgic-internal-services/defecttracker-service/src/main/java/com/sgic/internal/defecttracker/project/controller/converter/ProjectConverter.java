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

			projectDto.setProjectId(project.getProjectId());
//			projectDto.setAbbr(project.getAbbr());
			projectDto.setProjectName(project.getProjectName());
			projectDto.setType(project.getType());
			projectDto.setStartDate(project.getStartDate());
			projectDto.setEndDate(project.getEndDate());
			projectDto.setDuration(project.getDuration());
			projectDto.setStatus(project.getStatus());
			projectDto.setConfigId(project.getConfigId());

			projectDto.setProjectId(project.getProjectId());
//			projectDto.setAbbr(project.getAbbr());
			projectDto.setProjectName(project.getProjectName());
			projectDto.setType(project.getType());
			projectDto.setStartDate(project.getStartDate());
			projectDto.setEndDate(project.getEndDate());
			projectDto.setDuration(project.getDuration());
			projectDto.setStatus(project.getStatus());
			projectDto.setConfigId(project.getConfigId());


			return projectDto;
		}
		return null;
	}

	public static Project projectDataToProject(ProjectDto projectDto) {
		Project project = new Project();


		project.setProjectId(projectDto.getProjectId());
//		project.setAbbr(projectDto.getAbbr());
		project.setProjectName(projectDto.getProjectName());
		project.setType(projectDto.getType());
		project.setEndDate(projectDto.getEndDate());
		project.setDuration(projectDto.getDuration());
		project.setStatus(projectDto.getStatus());
		project.setConfigId(projectDto.getConfigId());

		project.setProjectId(projectDto.getProjectId());
//		project.setAbbr(projectDto.getAbbr());
		project.setProjectName(projectDto.getProjectName());
		project.setType(projectDto.getType());
		project.setEndDate(projectDto.getEndDate());
		project.setDuration(projectDto.getDuration());
		project.setStatus(projectDto.getStatus());
		project.setConfigId(projectDto.getConfigId());

		return project;
	}

	public static List<ProjectDto> projectToProjectData(List<Project> projectList) {

		if (projectList != null) {
			List<ProjectDto> lProjectData = new ArrayList<>();
			for (Project project : projectList) {
				ProjectDto projectDto = new ProjectDto();


				projectDto.setProjectId(project.getProjectId());
//				projectDto.setAbbr(project.getAbbr());
				projectDto.setProjectName(project.getProjectName());
				projectDto.setType(project.getType());
				projectDto.setStartDate(project.getStartDate());
				projectDto.setEndDate(project.getEndDate());
				projectDto.setDuration(project.getDuration());
				projectDto.setStatus(project.getStatus());
				projectDto.setConfigId(project.getConfigId());
				lProjectData.add(projectDto);

				projectDto.setProjectId(project.getProjectId());
//				projectDto.setAbbr(project.getAbbr());
				projectDto.setProjectName(project.getProjectName());
				projectDto.setType(project.getType());
				projectDto.setStartDate(project.getStartDate());
				projectDto.setEndDate(project.getEndDate());
				projectDto.setDuration(project.getDuration());
				projectDto.setStatus(project.getStatus());
				projectDto.setConfigId(project.getConfigId());
				lProjectData.add(projectDto);

			}

			return lProjectData;
		}
		return null;

	}

}
