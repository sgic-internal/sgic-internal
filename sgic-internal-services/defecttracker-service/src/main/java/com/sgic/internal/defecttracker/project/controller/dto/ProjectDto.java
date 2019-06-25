package com.sgic.internal.defecttracker.project.controller.dto;

import org.springframework.stereotype.Component;

@Component
public class ProjectDto {
	
	private String projectId;

	private String projectName;

	private String type;

	private String startDate;

	private String endDate;

	private String duration;

	private String status;

	private String configId;

	public String getProjectId() {
		return projectId;
	}

	public ProjectDto(String projectId, String projectName, String type, String startDate, String endDate,
			String duration, String status, String configId) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.type = type;
		this.startDate = startDate;
		this.endDate = endDate;
		this.duration = duration;
		this.status = status;
		this.configId = configId;
	}

	public ProjectDto() {
		// TODO Auto-generated constructor stub
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getConfigId() {
		return configId;
	}

	public void setConfigId(String configId) {
		this.configId = configId;
	}
}
