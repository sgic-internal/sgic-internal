package com.sgic.internal.defecttracker.project.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(schema = "defectservices", name = "projectConfig")
public class ProjectPrivilegeConfig implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long projectConfigId;
	
	@ManyToOne
	@JoinColumn(name="projectId", nullable = false)
	private Project project;
	private boolean projectConfigStatus;
	
	public ProjectPrivilegeConfig() {
		super();
	}
	
	public ProjectPrivilegeConfig(Project project) {
		super();
		this.project = project;
	}
	
	

	public ProjectPrivilegeConfig(Project project, boolean projectConfigStatus) {
		super();
		this.project = project;
		this.projectConfigStatus = projectConfigStatus;
	}

	public Long getProjectConfigId() {
		return projectConfigId;
	}
	public void setProjectConfigId(Long projectConfigId) {
		this.projectConfigId = projectConfigId;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public boolean isProjectConfigStatus() {
		return projectConfigStatus;
	}
	public void setProjectConfigStatus(boolean projectConfigStatus) {
		this.projectConfigStatus = projectConfigStatus;
	}
		
}
