package com.sgic.internal.defecttracker.project.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(schema = "defectservices", name = "project")
public class Project implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@NotBlank(message = "ProjectId is mandatory")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long projectId;
	
	private String abbr;

	private String projectName;

	private String type;

	private String startDate;

	private String endDate;

	private String duration;

	private String status;

	private String configId;

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
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

	public String getAbbre() {
		return abbr;
	}

	public void setAbbre(String abbre) {
		this.abbr = abbre;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
