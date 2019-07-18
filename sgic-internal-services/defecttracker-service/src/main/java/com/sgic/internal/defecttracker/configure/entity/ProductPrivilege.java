package com.sgic.internal.defecttracker.configure.entity;

public class ProductPrivilege {
	private Long productPrivilegeId;
	private Long productPrivilegeNameId;
	private String productPrivilegeName;
	private boolean productPrivilegeStatus;
	
	public Long getProductPrivilegeId() {
		return productPrivilegeId;
	}
	public void setProductPrivilegeId(Long productPrivilegeId) {
		this.productPrivilegeId = productPrivilegeId;
	}
	public Long getProductPrivilegeNameId() {
		return productPrivilegeNameId;
	}
	public void setProductPrivilegeNameId(Long productPrivilegeNameId) {
		this.productPrivilegeNameId = productPrivilegeNameId;
	}
	public String getProductPrivilegeName() {
		return productPrivilegeName;
	}
	public void setProductPrivilegeName(String productPrivilegeName) {
		this.productPrivilegeName = productPrivilegeName;
	}
	public boolean isProductPrivilegeStatus() {
		return productPrivilegeStatus;
	}
	public void setProductPrivilegeStatus(boolean productPrivilegeStatus) {
		this.productPrivilegeStatus = productPrivilegeStatus;
	}
	
	
}
