package com.sgic.internal.defecttracker.project.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(schema="project_service",name="submodule")

public class SubModule {
	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String subModuleId;
	private String subModuleName;
	public String getSubModuleId() {
		return subModuleId;
	}
	public void setSubModuleId(String subModuleId) {
		this.subModuleId = subModuleId;
	}
	public String getSubModuleName() {
		return subModuleName;
	}
	public void setSubModuleName(String subModuleName) {
		this.subModuleName = subModuleName;
	}
	
	// create relationship with Module
	@ManyToOne
	@JoinColumn(name = "moduleId", nullable = false)

	private SubModule subModule;

	public SubModule getSubModule() {
		return subModule;
	}

	public void setSubModule(SubModule subModule) {
		this.subModule = subModule;
	}
			
}
