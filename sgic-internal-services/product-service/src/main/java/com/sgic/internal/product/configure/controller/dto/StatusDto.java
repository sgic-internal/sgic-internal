package com.sgic.internal.product.configure.controller.dto;

public class StatusDto {
	// Status Entity -> id
	private long statusId;
	// Status Entity -> name
	private String statusName;
	// Status Entity -> value
	private String statusValue;
	
	public long getStatusId() {
		return statusId;
	}
	public void setStatusId(long statusId) {
		this.statusId = statusId;
	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	public String getStatusValue() {
		return statusValue;
	}
	public void setStatusValue(String statusValue) {
		this.statusValue = statusValue;
	}
	
	
	
}
