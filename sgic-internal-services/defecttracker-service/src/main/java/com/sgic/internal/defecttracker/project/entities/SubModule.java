package com.sgic.internal.defecttracker.project.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

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

	// creating relationship class with module
//	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
//	@OneToMany(mappedBy = "subModule", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	private List<RoleAllocation> roleAllocation;
//
//	public List<RoleAllocation> getRoleAllocation() {
//		return roleAllocation;
//	}
//
//	public void setRoleAllocation(List<RoleAllocation> roleAllocation) {
//		this.roleAllocation = roleAllocation;
//	}

}
