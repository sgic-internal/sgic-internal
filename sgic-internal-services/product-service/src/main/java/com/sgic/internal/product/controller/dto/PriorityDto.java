package com.sgic.internal.product.controller.dto;

public class PriorityDto {

	private Long priorityId;
	private String priorityName;
	private String priorityValue;
	private String priorityColor;
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
