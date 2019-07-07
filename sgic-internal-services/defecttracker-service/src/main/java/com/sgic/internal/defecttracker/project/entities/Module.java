package com.sgic.internal.defecttracker.project.entities;

import javax.persistence.Entity;
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
	private String abbr;

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

	public String getAbbr() {
		return abbr;
	}

	public void setAbbr(String abbr) {
		this.abbr = abbr;
	}

	// create relationship with project
	@ManyToOne
	@JoinColumn(name = "projectid", nullable = false)

	private Project project;

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
	
//	@ManyToOne
//	@JoinColumn(name = "sub_module_id", nullable = false)
//
//	private SubModule submodule;
//
//	public SubModule getSubmodule() {
//		return submodule;
//	}
//
//	public void setSubmodule(SubModule submodule) {
//		this.submodule = submodule;
//	}
	
	

}
