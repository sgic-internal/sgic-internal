package com.sgic.internal.defecttracker.project.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(schema = "defectservices", name = "role")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long roleId;
	private String roleName;

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	// create relationship with SubModule //
	@OneToMany(mappedBy = "role", cascade = { CascadeType.ALL })
	public List<RoleAllocation> roleAllocation;

	public List<RoleAllocation> getRoleAllocation() {
		return roleAllocation;
	}

	public void setRoleAllocation(List<RoleAllocation> roleAllocation) {
		this.roleAllocation = roleAllocation;
	}
	
	

	
	

}