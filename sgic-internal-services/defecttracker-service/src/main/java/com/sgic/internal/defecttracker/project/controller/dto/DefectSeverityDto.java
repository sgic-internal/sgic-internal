package com.sgic.internal.defecttracker.project.controller.dto;

public class DefectSeverityDto {
	private long id; // Defect severity id
	private String name; // Defect severity name 
	private String value; // Defect severity value
	private String icon; // Defect severity icon
	private String color; // Defect severity color

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