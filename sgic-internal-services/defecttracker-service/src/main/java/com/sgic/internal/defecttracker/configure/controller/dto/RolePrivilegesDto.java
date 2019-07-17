package com.sgic.internal.defecttracker.configure.controller.dto;

public class RolePrivilegesDto {
	private Long rolePrivilegesId;
	private Long roleId;
	private String roleName;
	private Long productprivilegeId;

	public Long getRolePrivilegesId() {
		return rolePrivilegesId;
	}

	public void setRolePrivilegesId(Long rolePrivilegesId) {
		this.rolePrivilegesId = rolePrivilegesId;
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

	public Long getProductprivilegeId() {
		return productprivilegeId;
	}

	public void setProductprivilegeId(Long productprivilegeId) {
		this.productprivilegeId = productprivilegeId;
	}

}
