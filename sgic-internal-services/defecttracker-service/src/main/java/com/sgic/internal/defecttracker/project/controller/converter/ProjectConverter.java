package com.sgic.internal.defecttracker.project.controller.converter;


import java.util.ArrayList;
import java.util.List;

import com.sgic.internal.defecttracker.project.controller.dto.ProjectData;
import com.sgic.internal.defecttracker.project.entities.Project;

public class ProjectConverter {

	private ProjectConverter() {
	}

	public static ProjectData projectToProjectData(Project project) {
		ProjectData projectDto = new ProjectData();

		if (project != null) {

			projectDto.setProjectId(project.getProjectId());
			projectDto.setProjectName(project.getProjectName());
			projectDto.setType(project.getType());
			projectDto.setStartDate(project.getStartDate());
			projectDto.setEndDate(project.getEndDate());
			projectDto.setDuration(project.getDuration());
			projectDto.setStatus(project.getStatus());
			projectDto.setConfigId(project.getConfigId());

			projectDto.setProjectId(project.getProjectId());
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

	public static Project projectDataToProject(ProjectData projectData) {
		Project project = new Project();


		project.setProjectId(projectData.getProjectId());
		project.setProjectName(projectData.getProjectName());
		project.setType(projectData.getType());
		project.setEndDate(projectData.getEndDate());
		project.setDuration(projectData.getDuration());
		project.setStatus(projectData.getStatus());
		project.setConfigId(projectData.getConfigId());

		project.setProjectId(projectData.getProjectId());
		project.setProjectName(projectData.getProjectName());
		project.setType(projectData.getType());
		project.setEndDate(projectData.getEndDate());
		project.setDuration(projectData.getDuration());
		project.setStatus(projectData.getStatus());
		project.setConfigId(projectData.getConfigId());

		return project;
	}

	public static List<ProjectData> projectToProjectData(List<Project> projectList) {

		if (projectList != null) {
			List<ProjectData> lProjectData = new ArrayList<>();
			for (Project project : projectList) {
				ProjectData projectData = new ProjectData();


				projectData.setProjectId(project.getProjectId());
//				projectDto.setAbbr(project.getAbbr());
				projectData.setProjectName(project.getProjectName());
				projectData.setType(project.getType());
				projectData.setStartDate(project.getStartDate());
				projectData.setEndDate(project.getEndDate());
				projectData.setDuration(project.getDuration());
				projectData.setStatus(project.getStatus());
				projectData.setConfigId(project.getConfigId());
				lProjectData.add(projectData);

				projectData.setProjectId(project.getProjectId());
				projectData.setProjectName(project.getProjectName());
				projectData.setType(project.getType());
				projectData.setStartDate(project.getStartDate());
				projectData.setEndDate(project.getEndDate());
				projectData.setDuration(project.getDuration());
				projectData.setStatus(project.getStatus());
				projectData.setConfigId(project.getConfigId());
				lProjectData.add(projectData);

			}

			return lProjectData;
		}
		return null;

	}

}