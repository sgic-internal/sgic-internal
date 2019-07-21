package com.sgic.internal.defecttracker.project.services.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.internal.defecttracker.project.entities.ProjectPrivilegeConfig;
import com.sgic.internal.defecttracker.project.repositories.ProjectPrivilegeConfigRepository;
import com.sgic.internal.defecttracker.project.services.ProjectPrivilegeConfigService;

@Service
public class ProjectPrivilegeConfigServiceImpl implements ProjectPrivilegeConfigService{

	@Autowired
	ProjectPrivilegeConfigRepository projectPrivilegeConfigRepository;
	
	private static Logger logger = LogManager.getLogger(ProjectPrivilegeConfig.class);
	
	@Override
	public ProjectPrivilegeConfig createProjectPrivilegeConfig(ProjectPrivilegeConfig projectPrivilegeConfig) {
		logger.info("Project Privilege Config Service ->  Save Project Privilege Config Method Started");
		try {
		return projectPrivilegeConfigRepository.save(projectPrivilegeConfig);
		} catch (Exception ex) {
			logger.error("Project Privilege Config Service ERROR! -> " + ex.getMessage());
		} finally {
			logger.info("Project Privilege Config Service -> Save Project Privilege Config Method Finished");
		}
		return null;
	}

	@Override
	public ProjectPrivilegeConfig updateProjectPrivilegeConfig(ProjectPrivilegeConfig projectPrivilegeConfig) {
		logger.info("Project Privilege Config Service ->  Update Project Privilege Config Method Started");
		Long projectConfigId = projectPrivilegeConfig.getProjectConfigId();
		try {
		boolean isExist = projectPrivilegeConfigRepository.findProjectPrivilegeConfigByProjectConfigId(projectConfigId) != null;
		if (isExist) {
			logger.info("Project Privilege Config Service  -> Project Privilege Config Id Found & Updated");
			return projectPrivilegeConfigRepository.save(projectPrivilegeConfig);
		} else {
			logger.info("Project Privilege Config Service  -> Project Privilege Config Id Not Found & Update Failed!");
		}
		} catch (Exception ex) {
			logger.error("Project Privilege Config Service ERROR! -> " + ex.getMessage());
		} finally {
			logger.info("Project Privilege Config Service -> Update Project Privilege Config Method Finished");
		}
		return null;
	}

	@Override
	public ProjectPrivilegeConfig getProjectPrivilegeConfigById(Long projectConfigId) {
		logger.info("Project Privilege Config Service ->  Get Project Privilege Config By Id Method Started");
		try {
			return projectPrivilegeConfigRepository.findProjectPrivilegeConfigByProjectConfigId(projectConfigId);
		} catch (Exception ex) {
			logger.error("Project Privilege Config Service ERROR! -> " + ex.getMessage());
		} finally {
			logger.info("Project Privilege Config Service -> Get Project Privilege Config By Id Method Finished");
		}
		return null;
	}

	@Override
	public List<ProjectPrivilegeConfig> getAllProjectPrivilegeConfig() {
		logger.info("Project Privilege Config Service INFO ->  Get All Project Privilege Config Method Started");
		try {
			return projectPrivilegeConfigRepository.findAll();
		} catch (Exception ex) {
			logger.error("Project Privilege Config Service ERROR! -> " + ex.getMessage());
		} finally {
			logger.info("Project Privilege Config Service INFO -> Get All Project Privilege Config Method Finished");
		}
		return null;
		
	}

	@Override
	public ProjectPrivilegeConfig deleteProjectPrivilegeConfigById(Long projectConfigId) {
		logger.info("Project Privilege Config Service INFO ->  Delete Project Privilege Config Method Started");
		try {
			projectPrivilegeConfigRepository.deleteById(projectConfigId);
		} catch (Exception ex) {
			logger.error("Project Privilege Config Service ERROR! -> " + ex.getMessage());
		} finally {
			logger.info("Project Privilege Config Service INFO -> Delete Project Privilege Config Method Finished");
		}
		return null;
	}

}
