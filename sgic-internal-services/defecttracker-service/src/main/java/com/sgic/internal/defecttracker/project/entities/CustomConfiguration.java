package com.sgic.internal.defecttracker.project.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(schema = "defectservices", name = "configuration")

public class CustomConfiguration {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long configureId;

	public Long getConfigureId() {
		return configureId;
	}

	public void setConfigureId(Long configureId) {
		this.configureId = configureId;
	}

	// create relationship with DefectType
	@ManyToOne
	@JoinColumn(name = "configureId", nullable = false)

	private DefectType defectType;

	public DefectType getProject() {
		return defectType;
	}

	public void setDefectType(DefectType defectType) {
		this.defectType = defectType;
	}

}
