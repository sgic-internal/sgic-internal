package com.sgic.internal.defecttracker.project.entities;

import javax.persistence.Entity;
<<<<<<< HEAD
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema="defectservices" ,name="module")
public class Module {
	
    @Id
	private String moduleId;
	private String moduleName;
=======
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	
>>>>>>> 2abd14002e2c632b7456f4e8d098e5f21d4b008f
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
	
<<<<<<< HEAD
	

=======
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

		
>>>>>>> 2abd14002e2c632b7456f4e8d098e5f21d4b008f
}
