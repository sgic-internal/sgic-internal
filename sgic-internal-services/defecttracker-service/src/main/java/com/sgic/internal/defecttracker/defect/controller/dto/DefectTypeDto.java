package com.sgic.internal.defecttracker.defect.controller.dto;

public class DefectTypeDto {
	private long id; // Defect type id
	private String name; // Defect type name
	private String value; // Defect type value

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
}
