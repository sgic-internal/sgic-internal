package com.sgic.internal.defecttracker.project.entities;

import javax.persistence.Id;

public class ModuleAllocation {
	@Id
	private Long moduleAllocationId;
	private String moduleAllocationName;
	private String name;
	private String role;

	
	
	public Long getModuleAllocationId() {
		return moduleAllocationId;
	}
	public void setModuleAllocationId(Long moduleAllocationId) {
		this.moduleAllocationId = moduleAllocationId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getModuleAllocationName() {
		return moduleAllocationName;
	}
	public void setModuleAllocationName(String moduleAllocationName) {
		this.moduleAllocationName = moduleAllocationName;
	}

	
}
