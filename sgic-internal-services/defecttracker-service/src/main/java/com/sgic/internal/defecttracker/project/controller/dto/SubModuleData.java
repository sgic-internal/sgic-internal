package com.sgic.internal.defecttracker.project.controller.dto;

public class SubModuleData {

	private String subModuleId;
	private String subModuleName;

	
	public SubModuleData(String subModuleId, String subModuleName) {
		super();
		this.subModuleId = subModuleId;
		this.subModuleName = subModuleName;
	}

	public SubModuleData() {
		// TODO Auto-generated constructor stub
	}

	// Getters and Setters for Sub Module
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
