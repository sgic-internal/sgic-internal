package com.sgic.internal.defecttracker.project.controller.dto;

public class ProjectPrivilegeConfigDto {
	private Long projectConfigurationId;
	private String projectId;
	private String projectName;
	private boolean projectConfigurationStatus;
	
	public Long getProjectConfigurationId() {
		return projectConfigurationId;
	}
	public void setProjectConfigurationId(Long projectConfigurationId) {
		this.projectConfigurationId = projectConfigurationId;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public boolean isProjectConfigurationStatus() {
		return projectConfigurationStatus;
	}
	public void setProjectConfigurationStatus(boolean projectConfigurationStatus) {
		this.projectConfigurationStatus = projectConfigurationStatus;
	}
	
	
	
}
