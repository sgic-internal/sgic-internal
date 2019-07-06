package com.sgic.internal.defecttracker.defect.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(schema="defectservices",name="defectconfig")
public class DefectConfig {
	
	private Long configId;
	private String projectId;
	private String name;
	private String value;
	private String color;
	private String icon;
	
	public Long getConfigId() {
		return configId;
	}
	public void setConfigId(Long configId) {
		this.configId = configId;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
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
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	

}
