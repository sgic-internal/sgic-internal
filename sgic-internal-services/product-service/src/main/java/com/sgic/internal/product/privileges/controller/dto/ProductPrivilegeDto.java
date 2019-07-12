package com.sgic.internal.product.privileges.controller.dto;

public class ProductPrivilegeDto {
	private Long productPrivilegeId;
	private Long ProductPrivilegeNameId;
	private String projectPrivilegeName;
	private boolean projectPrivilegeStatus;
	
	
	public Long getProductPrivilegeNameId() {
		return ProductPrivilegeNameId;
	}
	public void setProductPrivilegeNameId(Long productPrivilegeNameId) {
		ProductPrivilegeNameId = productPrivilegeNameId;
	}

	public Long getProductPrivilegeId() {
		return productPrivilegeId;
	}
	public void setProductPrivilegeId(Long productPrivilegeId) {
		this.productPrivilegeId = productPrivilegeId;
	}
	public String getProjectPrivilegeName() {
		return projectPrivilegeName;
	}
	public void setProjectPrivilegeName(String projectPrivilegeName) {
		this.projectPrivilegeName = projectPrivilegeName;
	}
	public boolean isProjectPrivilegeStatus() {
		return projectPrivilegeStatus;
	}
	public void setProjectPrivilegeStatus(boolean projectPrivilegeStatus) {
		this.projectPrivilegeStatus = projectPrivilegeStatus;
	}
	
	
	
}
