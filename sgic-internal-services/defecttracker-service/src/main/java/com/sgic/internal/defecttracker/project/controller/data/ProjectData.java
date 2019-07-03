package com.sgic.internal.defecttracker.project.controller.data;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class ProjectData {
	
	private Long projectId;
	
	private String proId;

	private String projectName;

	private String type;

	private Date startDate;

	private Date endDate ;

	private Long duration;

	private String status;

	private String configId;

	
	public ProjectData(Long projectId, String projectName, String type, Date startDate, Date endDate,
			Long duration, String status, String configId) {
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

	public ProjectData() {
		// TODO Auto-generated constructor stub
	}
	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
	
	public String getProId() {
		return proId;
	}

	public void setProId(String proId) {
		this.proId = proId;
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


	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	
	public Long getDuration() {
		return duration;
	}

	public void setDuration(Long duration) {
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
