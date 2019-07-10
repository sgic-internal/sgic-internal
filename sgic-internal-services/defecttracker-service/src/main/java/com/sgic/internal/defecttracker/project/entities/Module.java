package com.sgic.internal.defecttracker.project.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="module", schema="project_service")
public class Module {
	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String moduleId;
	private String moduleName;
	
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
	
	// create relationship with project
		@ManyToOne
		@JoinColumn(name="projectId",nullable=false)
		
		private Module module;

		public Module getModule() {
			return module;
		}
		public void setModule(Module module) {
			this.module = module;
		}

		
}
