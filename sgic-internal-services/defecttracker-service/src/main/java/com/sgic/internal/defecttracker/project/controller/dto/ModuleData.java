package com.sgic.internal.defecttracker.project.controller.dto;

import org.springframework.stereotype.Component;

@Component
public class ModuleData {
	
	private String moduleId;
	private String moduleName;
	 private String abbr;
	
	
	public ModuleData(String moduleId, String moduleName) {
		super();
		this.moduleId = moduleId;
		this.moduleName = moduleName;
		
	}
	public ModuleData() {
		// TODO Auto-generated constructor stub
	}
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
		
	}public String getAbbr() {
			return abbr;
		}
		public void setAbbr(String abbr) {
			this.abbr = abbr;
		}
	}
	


