package com.sgic.internal.defecttracker.project.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(schema = "defectservices", name = "module")
public class Module {

	@Id
	private String moduleId;
	private String moduleName;
//	private String abbr;

	
//getters and setters for module
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

//	public String getAbbr() {
//		return abbr;
//	}
//
//	public void setAbbr(String abbr) {
//		this.abbr = abbr;
//	}

	// create relationship with project
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "projectid", nullable = false)
	private Project project;

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	
	
//	@ManyToOne
//	@JoinColumn(name = "subModuleId", nullable = false)
//
//	private List<SubModule> submodule;
//
//
//	public List<SubModule> getSubmodule() {
//		return submodule;
//	}
//
//	public void setSubmodule(List<SubModule> submodule) {
//		this.submodule = submodule;
//	}

	
	
	

}
