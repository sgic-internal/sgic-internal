package com.sgic.internal.defecttracker.project.entities;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(schema = "defectservices", name = "submodule")
public class SubModule {
	@Id
	private String subModuleId;
	private String subModuleName;
	private String abbr;

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

	public String getAbbr() {
		return abbr;
	}

	public void setAbbr(String abbr) {
		this.abbr = abbr;
	}
	
	// create relationship with project
		@ManyToOne
		@JoinColumn(name = "projectId", nullable = false)

		private Project project;

		public Project getProject() {
			return project;
		}

		public void setProject(Project project) {
			this.project = project;
		}

}
