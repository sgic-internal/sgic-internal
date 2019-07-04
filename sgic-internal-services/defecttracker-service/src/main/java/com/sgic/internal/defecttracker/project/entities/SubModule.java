package com.sgic.internal.defecttracker.project.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(schema = "defectservices", name = "submodule")
public class SubModule {
	@Id
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



}