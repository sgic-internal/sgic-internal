package com.sgic.internal.defecttracker.project.entities;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

@Entity
@Table(schema = "defectservices", name = "roleallocation")
public class RoleAllocation {

	@Id
	private String roleId;

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	// creating relationship class with sub_Module
	@ManyToOne
	@JoinColumn(name = "subModuleId", nullable = false)
	private SubModule subModule;

	public SubModule getSubModule() {
		return subModule;
	}

	public void setSubModule(SubModule subModule) {
		this.subModule = subModule;
	}

}
