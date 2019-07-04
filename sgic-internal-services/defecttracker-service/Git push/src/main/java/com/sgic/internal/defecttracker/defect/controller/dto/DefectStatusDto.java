package com.sgic.internal.defecttracker.defect.controller.dto;

public class DefectStatusDto {
	private long id; // Defect status id
	private String name; // Defect status name
	private String value; // Defect status value

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
