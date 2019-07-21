package com.sgic.internal.defecttracker.project.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.internal.defecttracker.project.controller.dto.ProjectPrivilegeConfigDto;
import com.sgic.internal.defecttracker.project.controller.dto.mapper.ProjectPrivilegeConfigMapper;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ProjectPrivilegeConfigController {

	@Autowired
	ProjectPrivilegeConfigMapper projectPrivilegeConfigMapper;
	private static Logger logger = LogManager.getLogger(ProjectPrivilegeConfigMapper.class);

	// Get All Project Privilege Configuration
	@GetMapping("/ProjectPrivilegeConfigurations")
	public List<ProjectPrivilegeConfigDto> getProjectPrivilegeConfig() {
		try {
			logger.info("Project Privilege Configuration Controller INFO -> Get All Project Privilege Configuration Method Started");
			return projectPrivilegeConfigMapper.getAllProjectPrivilegeConfiguration();
		} catch (Exception ex) {
			logger.error("Project Privilege Configuration Controller INFO -> Get All Project Privilege Configuration Method Failed!");
			logger.error("Project Privilege Configuration Controller ERROR! :-> " + ex.getMessage());
		} finally {
			logger.info("Project Privilege Configuration Controller INFO -> Get All Project Privilege Configuration Method Finished");
		}
		return null;
	}

	// Get Project Privilege Configuration By Id
		@GetMapping("/ProjectPrivilegeConfiguration/{projectConfigId}")
		public Object getProjectPrivilegeConfigById(@PathVariable(name = "severityId") Long projectConfigId) {
			try {
				logger.info("Project Privilege Configuration Controller INFO -> Get Project Privilege Configuration By Id Method Started");
				//check severity id
				
				if (projectPrivilegeConfigMapper.getProjectPrivilegeConfigById(projectConfigId) != null) {
					logger.info("Project Privilege Configuration Controller INFO -> Project Privilege Configuration Id Found -> Project Config Id : " + projectConfigId);
					return projectPrivilegeConfigMapper.getProjectPrivilegeConfigById(projectConfigId);
				} else {
					logger.warn("Project Privilege Configuration Controller WARNING! -> Project Privilege Configuration Id Not Found -> Project Config Id : " + projectConfigId);
					return "Project Privilege Configuration Not Found For this Id : " + projectConfigId;
				}
			} catch (Exception ex) {
				logger.error("Project Privilege Configuration Controller ERROR! :-> " + ex.getMessage());
			} finally {
				logger.info("Project Privilege Configuration Controller INFO -> Get All Project Privilege Configuration Method Finished");
			}
			return null;
		}
	
		
		// Save All Project Privilege Configuration
		@PostMapping("/ProjectPrivilegeConfiguration")
		public ResponseEntity<String> saveSeverity(@Valid @RequestBody ProjectPrivilegeConfigDto projectPrivilegeConfigDto) {
			try {
				logger.info("Project Privilege Configuration Controller INFO -> Save Project Privilege Configuration Method Started");
				if (projectPrivilegeConfigMapper.saveProjectPrivilegeConfig(projectPrivilegeConfigDto) != null) {
					logger.info("Project Privilege Configuration Controller -> Project Privilege Configuration Created Successful");
					return new ResponseEntity<>("Project Privilege Configuration added succesfully", HttpStatus.OK);
				}
				logger.info("Project Privilege Configuration Controller INFO -> Project Privilege Configuration Creation FAILED!!!");
				return new ResponseEntity<>("SAVE FAILED!", HttpStatus.BAD_REQUEST);
			} catch (Exception ex) {
				logger.error("Project Privilege Configuration Controller ERROR! :-> " + ex.getMessage());
			} finally {
				logger.info("Project Privilege Configuration Controller INFO -> Save Project Privilege Configuration Method Finished");
			}
			return null;
		}
	
		// Update Project Privilege Configuration
		@PutMapping("/ProjectPrivilegeConfiguration")
		public ResponseEntity<String> updateSeverity(@RequestBody ProjectPrivilegeConfigDto projectPrivilegeConfigDto) {
			logger.info("Project Privilege Configuration Controller -> Update Project Privilege Configuration Method Started");
			try {
				if (projectPrivilegeConfigMapper.updateProjectPrivilegeConfig(projectPrivilegeConfigDto) != null) {
					return new ResponseEntity<>("Project Privilege Configuration Updated Sucessfully", HttpStatus.OK);
				}
				logger.info("Project Privilege Configuration Controller -> Project Privilege Configuration Updated Failed!!!");
				return new ResponseEntity<>("Update FAILED!!!", HttpStatus.BAD_REQUEST);
			} finally {
				logger.info("Project Privilege Configuration Controller -> Update Project Privilege Configuration Method Finished");
			}
		}
		
		
		// Delete Project Privilege Configuration 
		@DeleteMapping("/ProjectPrivilegeConfiguration/{projectConfigId}")
		public ResponseEntity<String> deleteSeverity(@PathVariable(name = "projectConfigId") Long projectConfigId) {
			logger.info("Project Privilege Configuration Controller -> Delete Project Privilege Configuration Method Started");
			try {
				//check severity id
				if (projectPrivilegeConfigMapper.getProjectPrivilegeConfigById(projectConfigId) != null) {
					//deleted severity by id
					if (projectPrivilegeConfigMapper.deleteProjectPrivilegeConfigById(projectConfigId) == null) {
						logger.info("Project Privilege Configuration Controller -> Project Privilege Configuration Deleted Successful");
						return new ResponseEntity<>("Project Privilege Configuration Sucessfully deleted", HttpStatus.OK);
					} else {
						logger.info("Project Privilege Configuration Controller -> Delete Project Privilege Configuration Failed, Project Privilege Configuration Id Not Found -> Severity Id :"
								+ projectConfigId);
						return new ResponseEntity<>("No Project Privilege Configuration Found For This Id : " + projectConfigId,
								HttpStatus.BAD_REQUEST);
					}
				}
			} finally {
				logger.info("Project Privilege Configuration Controller -> Delete Project Privilege Configuration Method Finished");
			}
			return null;
		}

		
		
}
