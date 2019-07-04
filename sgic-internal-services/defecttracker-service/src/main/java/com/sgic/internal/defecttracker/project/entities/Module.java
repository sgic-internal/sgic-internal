package com.sgic.internal.defecttracker.project.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema="defectservices" ,name="module")
public class Module {
	
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
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
	
	

}
