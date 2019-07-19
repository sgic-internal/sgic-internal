package com.sgic.internal.defecttracker.project.controller.dto;

import org.springframework.stereotype.Component;

@Component
public class ModuleData {

	private String moduleId;
	private String moduleName;
	private String projectid;


	public ModuleData(String moduleId, String moduleName) {
		super();
		this.moduleId = moduleId;
		this.moduleName = moduleName;
	}

	public ModuleData() {
	}

	// getters setters for module DTO
	public String getModuleId() {
		return moduleId;
	}

	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;

	}

// getters setters for project id
	public String getProjectid() {
		return projectid;
	}

	public void setProjectid(String projectid) {
		this.projectid = projectid;
	}

}
