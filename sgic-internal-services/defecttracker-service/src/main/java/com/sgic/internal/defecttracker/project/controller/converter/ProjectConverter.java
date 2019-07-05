package com.sgic.internal.defecttracker.project.controller.converter;

import java.util.ArrayList;
import java.util.List;

import com.sgic.internal.defecttracker.project.controller.dto.ProjectDto;
import com.sgic.internal.defecttracker.project.entities.Project;



public class ProjectConverter {

	private ProjectConverter() {
	}

	public static ProjectDto projectToProjectDto(Project project) {
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

	public static Project projectDtoToProject(ProjectDto projectDto) {
		Project project = new Project();


<<<<<<< HEAD
		project.setProjectId(projectDto.getProjectId());
//		project.setAbbr(projectDto.getAbbr());
		project.setProjectName(projectDto.getProjectName());
		project.setType(projectDto.getType());
		project.setEndDate(projectDto.getEndDate());
		project.setDuration(projectDto.getDuration());
		project.setStatus(projectDto.getStatus());
		project.setConfigId(projectDto.getConfigId());

=======
>>>>>>> f1bb3f266238a45ba97d2ec2eb6348085a0c1f87
		project.setProjectId(projectDto.getProjectId());
//		project.setAbbr(projectDto.getAbbr());
		project.setProjectName(projectDto.getProjectName());
		project.setType(projectDto.getType());
		project.setEndDate(projectDto.getEndDate());
		project.setDuration(projectDto.getDuration());
		project.setStatus(projectDto.getStatus());
		project.setConfigId(projectDto.getConfigId());

<<<<<<< HEAD
=======
		project.setProjectId(projectDto.getProjectId());
//		project.setAbbr(projectDto.getAbbr());
		project.setProjectName(projectDto.getProjectName());
		project.setType(projectDto.getType());
		project.setEndDate(projectDto.getEndDate());
		project.setDuration(projectDto.getDuration());
		project.setStatus(projectDto.getStatus());
		project.setConfigId(projectDto.getConfigId());

>>>>>>> f1bb3f266238a45ba97d2ec2eb6348085a0c1f87
		return project;
	}

	public static List<ProjectDto> projectToProjectDto(List<Project> projectList) {

		if (projectList != null) {
			List<ProjectDto> lProjectDto = new ArrayList<>();
			for (Project project : projectList) {
				ProjectDto projectDto = new ProjectDto();


<<<<<<< HEAD
=======
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

>>>>>>> f1bb3f266238a45ba97d2ec2eb6348085a0c1f87
				projectDto.setProjectId(project.getProjectId());
//				projectDto.setAbbr(project.getAbbr());
				projectDto.setProjectName(project.getProjectName());
				projectDto.setType(project.getType());
				projectDto.setStartDate(project.getStartDate());
				projectDto.setEndDate(project.getEndDate());
				projectDto.setDuration(project.getDuration());
				projectDto.setStatus(project.getStatus());
				projectDto.setConfigId(project.getConfigId());
<<<<<<< HEAD
				lProjectDto.add(projectDto);

				projectDto.setProjectId(project.getProjectId());
//				projectDto.setAbbr(project.getAbbr());
				projectDto.setProjectName(project.getProjectName());
				projectDto.setType(project.getType());
				projectDto.setStartDate(project.getStartDate());
				projectDto.setEndDate(project.getEndDate());
				projectDto.setDuration(project.getDuration());
				projectDto.setStatus(project.getStatus());
				projectDto.setConfigId(project.getConfigId());
				lProjectDto.add(projectDto);
=======
				lProjectData.add(projectDto);
>>>>>>> f1bb3f266238a45ba97d2ec2eb6348085a0c1f87

			}

			return lProjectDto;
		}
		return null;

	}

}
