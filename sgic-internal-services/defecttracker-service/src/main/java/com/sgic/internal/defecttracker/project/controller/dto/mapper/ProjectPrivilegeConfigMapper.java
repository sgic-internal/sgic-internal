package com.sgic.internal.defecttracker.project.controller.dto.mapper;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.internal.defecttracker.project.controller.converter.ProjectPrivilegeConfigConverter;
import com.sgic.internal.defecttracker.project.controller.dto.ProjectPrivilegeConfigDto;
import com.sgic.internal.defecttracker.project.entities.ProjectPrivilegeConfig;
import com.sgic.internal.defecttracker.project.services.ProjectPrivilegeConfigService;

@Service
public class ProjectPrivilegeConfigMapper {
	@Autowired
	private ProjectPrivilegeConfigService projectPrivilegeConfigService;
	@Autowired
	private ProjectPrivilegeConfigConverter projectPrivilegeConfigConverter;
	
	private static Logger logger = LogManager.getLogger(ProjectPrivilegeConfigDto.class);
	
	// Get All Project Privilege Configuration
		@SuppressWarnings("static-access")
		public List<ProjectPrivilegeConfigDto> getAllProjectPrivilegeConfiguration() {
			logger.info("Project Privilege Configuration Mapper INFO -> Get All Project Privilege Configuration Method Started");
			try {
				List<ProjectPrivilegeConfig> projectPrivilegeConfigList = projectPrivilegeConfigService.getAllProjectPrivilegeConfig();
				return projectPrivilegeConfigConverter.EntityListTODtoList(projectPrivilegeConfigList);
			} finally {
				logger.info("Project Privilege Configuration Mapper INFO -> Get All Project Privilege Configuration Method Finished");
			}
		}
		
		
		// Save Project Privilege Configuration
		@SuppressWarnings("static-access")
		public ProjectPrivilegeConfig saveProjectPrivilegeConfig(ProjectPrivilegeConfigDto projectPrivilegeConfigDto) {
			logger.info("Project Privilege Configuration Mapper INFO -> Save Project Privilege Configuration Method Started");
			try {
				logger.info("Project Privilege Configuration Mapper INFO -> Project Privilege Configuration Saved");
				return projectPrivilegeConfigService.createProjectPrivilegeConfig(projectPrivilegeConfigConverter.DtoToEntity(projectPrivilegeConfigDto));
			} finally {
				logger.info("Project Privilege Configuration Mapper INFO -> Save Project Privilege Configuration Method Finished");
			}
		}
		
		// Update Project Privilege Configuration
		@SuppressWarnings("static-access")
		public ProjectPrivilegeConfig updateProjectPrivilegeConfig(ProjectPrivilegeConfigDto projectPrivilegeConfigDto) {
			logger.info("Project Privilege Configuration Mapper INFO -> Update Project Privilege Configuration Method Started");
			try {
				return projectPrivilegeConfigService.updateProjectPrivilegeConfig(projectPrivilegeConfigConverter.DtoToEntityUpdate(projectPrivilegeConfigDto));

			} finally {
				logger.info("Project Privilege Configuration Mapper INFO -> Update Project Privilege Configuration Method Finished");
			}
		}
		
		
		// Delete Project Privilege Configuration
		public ProjectPrivilegeConfigDto deleteProjectPrivilegeConfigById(Long projectConfigId) {
			logger.info("Project Privilege Configuration Mapper INFO -> Delete Project Privilege Configuration Method Started");
			try {
				projectPrivilegeConfigService.deleteProjectPrivilegeConfigById(projectConfigId);
			} finally {
				logger.info("Project Privilege Configuration Mapper INFO -> Delete Project Privilege Configuration Method Finished");
			}
			return null;
		}

		
		// Get Project Privilege Configuration By Id
		@SuppressWarnings("static-access")
		public ProjectPrivilegeConfigDto getProjectPrivilegeConfigById(Long projectConfigId) {
			logger.info("Project Privilege Configuration Mapper -> Get Project Privilege Configuration By Id Method Started");
			try {
				ProjectPrivilegeConfig projectPrivilegeConfig = projectPrivilegeConfigService.getProjectPrivilegeConfigById(projectConfigId);
				return projectPrivilegeConfigConverter.EntityToDto(projectPrivilegeConfig);
			} finally {
				logger.info("Project Privilege Configuration Mapper -> Get Project Privilege Configuration By Id Method Finished");
			}
		}
		
	
}
