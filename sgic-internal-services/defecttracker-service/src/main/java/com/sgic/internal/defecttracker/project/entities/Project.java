package com.sgic.internal.defecttracker.project.entities;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;


@Entity
@Table(schema = "defectservices", name = "project")
public class Project implements Serializable {
	
	LocalDate todayDate = LocalDate.now();
	java.sql.Date currentDay = java.sql.Date.valueOf(todayDate);
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long projectId;

	private String abbrivation;

	private String projectName;

	private String type;

	@DateTimeFormat(iso=ISO.DATE)
	private Date startDate = currentDay;

	@DateTimeFormat(iso=ISO.DATE)
	private Date endDate = currentDay;

	private Long duration;

	private String status;

	private String configId;

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getAbbrivation() {
		return abbrivation;
	}

	public void setAbbrivation(String abbrivation) {
		this.abbrivation = abbrivation;
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
		this.startDate = currentDay;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
//		LocalDate ld = currentDay.toLocalDate();
//		LocalDate monthLater = ld.plusMonths(duration);
//		java.sql.Date sqlEndDate = java.sql.Date.valueOf(monthLater);
		this.endDate = currentDay;
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
