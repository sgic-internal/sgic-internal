package com.sgic.internal.product.configure.controller.dto;

public class PriorityDto {
	// Priority Entity -> id
	private Long priorityId;
	// Priority Entity -> name
	private String priorityName;
	// Priority Entity -> value
	private String priorityValue;
	// Priority Entity -> color
	private String priorityColor;
	// Priority Entity -> icon
	private String priorityIcon;
	
	public Long getPriorityId() {
		return priorityId;
	}
	public void setPriorityId(Long priorityId) {
		this.priorityId = priorityId;
	}
	public String getPriorityName() {
		return priorityName;
	}
	public void setPriorityName(String priorityName) {
		this.priorityName = priorityName;
	}
	
	public String getPriorityValue() {
		return priorityValue;
	}
	public void setPriorityValue(String priorityValue) {
		this.priorityValue = priorityValue;
	}
	public String getPriorityColor() {
		return priorityColor;
	}
	public void setPriorityColor(String priorityColor) {
		this.priorityColor = priorityColor;
	}
	public String getPriorityIcon() {
		return priorityIcon;
	}
	public void setPriorityIcon(String priorityIcon) {
		this.priorityIcon = priorityIcon;
	}
	
	
	
}
