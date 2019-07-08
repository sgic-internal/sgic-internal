package com.sgic.internal.defecttracker.defect.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;
import org.springframework.stereotype.Component;
import com.sgic.internal.defecttracker.project.entities.Project;

@SuppressWarnings("serial")
@Entity

@Component
@Table(schema = "defectservices", name = "defectconfig")
public class DefectConfig implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long configId;

	@ManyToOne
	@JoinColumn(name = "projectId", nullable = false)
	private Project project;


	private String name;
	private String value;
	private String color;
	private String icon;

	public long getConfigId() {
		return configId;
	}

	public void setConfigId(long configId) {
		this.configId = configId;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
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
