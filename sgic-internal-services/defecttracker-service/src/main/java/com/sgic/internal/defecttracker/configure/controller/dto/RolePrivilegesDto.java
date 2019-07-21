package com.sgic.internal.defecttracker.configure.controller.dto;

public class RolePrivilegesDto {
	private Long rolePrivilegesId;
	private Long roleId;
	private String roleName;
	private Long productPrivilegeId;
	private String productPrivilegeName;
	private boolean productPrivilegeStatus;

	public Long getRolePrivilegesId() {
		return rolePrivilegesId;
	}

	public void setRolePrivilegesId(Long rolePrivilegesId) {
		this.rolePrivilegesId = rolePrivilegesId;
	}

	public String getProductPrivilegeName() {
		return productPrivilegeName;
	}

	public void setProductPrivilegeName(String productPrivilegeName) {
		this.productPrivilegeName = productPrivilegeName;
	}

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


	public Long getProductPrivilegeId() {
		return productPrivilegeId;
	}

	public void setProductPrivilegeId(Long productPrivilegeId) {
		this.productPrivilegeId = productPrivilegeId;
	}

	public boolean isProductPrivilegeStatus() {
		return productPrivilegeStatus;
	}

	public void setProductPrivilegeStatus(boolean productPrivilegeStatus) {
		this.productPrivilegeStatus = productPrivilegeStatus;
	}

	
}
