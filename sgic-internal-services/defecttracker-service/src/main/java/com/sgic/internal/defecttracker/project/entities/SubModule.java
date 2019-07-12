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
	private String abbre;

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

	
	// create relationship with module
	
		public String getAbbre() {
		return abbre;
	}

	public void setAbbre(String abbre) {
		this.abbre = abbre;
	}


		@ManyToOne
		@JoinColumn(name = "moduleId", nullable = false)
		private Module module;

		public Module getModule() {
			return module;
		}

		public void setModule(Module module) {
			this.module = module;
		}
		
		


}
