package com.sgic.internal.defecttracker.project.controller.dto;

public class DefectPriorityDto {
	private long id; // Defect priority id
	private String name; // Defect priority name 
	private String value; // Defect priority value
	private String icon; // Defect priority icon
	private String color; // Defect priority color
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	
}