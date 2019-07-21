package com.sgic.internal.defecttracker.project.controller.converter;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.sgic.internal.defecttracker.project.controller.dto.ProjectPrivilegeConfigDto;
import com.sgic.internal.defecttracker.project.entities.Project;
import com.sgic.internal.defecttracker.project.entities.ProjectPrivilegeConfig;

@Service
public class ProjectPrivilegeConfigConverter {
	private static Logger logger = LogManager.getLogger(ProjectPrivilegeConfig.class);

	// Convert All List<Entity> to List<DTO>
	public static List<ProjectPrivilegeConfigDto> EntityListTODtoList(
			List<ProjectPrivilegeConfig> projectPrivilegeConfigList) {
		if (projectPrivilegeConfigList != null) {
			logger.info("Defect Status Converter -> Convert Lists Entity to DTO");
			List<ProjectPrivilegeConfigDto> listprojectPrivilegeConfigDto = new ArrayList<>();
			for (ProjectPrivilegeConfig projectPrivilegeConfig : projectPrivilegeConfigList) {
				ProjectPrivilegeConfigDto projectPrivilegeConfigDto = new ProjectPrivilegeConfigDto();
				projectPrivilegeConfigDto.setProjectConfigurationId(projectPrivilegeConfig.getProjectConfigId());
				projectPrivilegeConfigDto.setProjectId(projectPrivilegeConfig.getProject().getProjectId());
				projectPrivilegeConfigDto.setProjectName(projectPrivilegeConfig.getProject().getProjectName());
				projectPrivilegeConfigDto.setProjectConfigurationStatus(projectPrivilegeConfig.isProjectConfigStatus());

				listprojectPrivilegeConfigDto.add(projectPrivilegeConfigDto);
			}
			return listprojectPrivilegeConfigDto;
		}
		return null;
	}

	// Convert Data To Entity
	public static ProjectPrivilegeConfig DtoToEntity(ProjectPrivilegeConfigDto projectPrivilegeConfigDto) {
		ProjectPrivilegeConfig projectPrivilegeConfig = new ProjectPrivilegeConfig();
		if (projectPrivilegeConfigDto != null) {
			logger.info("Defect Status Converter -> Convert Object DTO to Entity For Save");
			projectPrivilegeConfig.setProjectConfigId(projectPrivilegeConfigDto.getProjectConfigurationId());

			Project project = new Project();
			project.setProjectId(projectPrivilegeConfigDto.getProjectId());
			project.setProjectName(projectPrivilegeConfigDto.getProjectName());
			projectPrivilegeConfig.setProject(project);

			projectPrivilegeConfig.setProjectConfigStatus(projectPrivilegeConfigDto.isProjectConfigurationStatus());

			return projectPrivilegeConfig;
		}
		return null;
	}

	// Convert Data To Entity
	public static ProjectPrivilegeConfig DtoToEntityUpdate(ProjectPrivilegeConfigDto projectPrivilegeConfigDto) {
		ProjectPrivilegeConfig projectPrivilegeConfig = new ProjectPrivilegeConfig();
		if (projectPrivilegeConfigDto != null) {
			projectPrivilegeConfig.setProjectConfigId(projectPrivilegeConfigDto.getProjectConfigurationId());

			Project project = new Project();
			project.setProjectId(projectPrivilegeConfigDto.getProjectId());
			project.setProjectName(projectPrivilegeConfigDto.getProjectName());
			projectPrivilegeConfig.setProject(project);

			projectPrivilegeConfig.setProjectConfigStatus(projectPrivilegeConfigDto.isProjectConfigurationStatus());

			return projectPrivilegeConfig;
		}
		return null;
	}

	// Convert Entity To Data
	
	public static ProjectPrivilegeConfigDto EntityToDto(ProjectPrivilegeConfig projectPrivilegeConfig) {
		ProjectPrivilegeConfigDto projectPrivilegeConfigDto = new ProjectPrivilegeConfigDto();
		if (projectPrivilegeConfig != null) {
			logger.info("Defect Status Converter -> Convert Object Entity to DTO");
			projectPrivilegeConfigDto.setProjectConfigurationId(projectPrivilegeConfig.getProjectConfigId());
			projectPrivilegeConfigDto.setProjectId(projectPrivilegeConfig.getProject().getProjectId());
			projectPrivilegeConfigDto.setProjectName(projectPrivilegeConfig.getProject().getProjectName());
			projectPrivilegeConfigDto.setProjectConfigurationStatus(projectPrivilegeConfig.isProjectConfigStatus());
			return projectPrivilegeConfigDto;
		}
		return null;
	}

}
