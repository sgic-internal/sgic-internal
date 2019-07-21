package com.sgic.internal.defecttracker.configure.controller.dto;

public class ProductPrivilegeDto {
	private Long productPrivilegeId;
	private Long projectPrivilegeName;
	private String projectPrivilegeStatus;
	private boolean productPrivilegeNameId;
	
	
	
	public Long getProductPrivilegeId() {
		return productPrivilegeId;
	}
	public void setProductPrivilegeId(Long productPrivilegeId) {
		this.productPrivilegeId = productPrivilegeId;
	}
	public Long getProjectPrivilegeName() {
		return projectPrivilegeName;
	}
	public void setProjectPrivilegeName(Long projectPrivilegeName) {
		this.projectPrivilegeName = projectPrivilegeName;
	}
	public String getProjectPrivilegeStatus() {
		return projectPrivilegeStatus;
	}
	public void setProjectPrivilegeStatus(String projectPrivilegeStatus) {
		this.projectPrivilegeStatus = projectPrivilegeStatus;
	}
	public boolean isProductPrivilegeNameId() {
		return productPrivilegeNameId;
	}
	public void setProductPrivilegeNameId(boolean productPrivilegeNameId) {
		this.productPrivilegeNameId = productPrivilegeNameId;
	}
	
	
	
	
	
}
