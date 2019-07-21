package com.sgic.internal.product.privileges.controller.dto;

public class ProductPrivilegeDto {
	private Long productPrivilegeId;
	// Privilege Entity -> privilege ID
	private Long productPrivilegeNameId;
	// Privilege Entity -> privilege Name
	private String productPrivilegeName;
	// Product Privilege Entity -> privilege status
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
