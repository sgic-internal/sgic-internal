package com.sgic.internal.product.configure.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(schema = "productservice", name = "defectpriority")
public class DefectPriority implements Serializable {
	// Defect priority id AUTO_INCREMENT
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 

	// Defect priority name NOT_NULL
	@Column(nullable = false)
	private String name; 

	 // Defect priority value NOT_NULL
	@Column(nullable = false)
	private String value;

	 // Defect priority icon NOT_NULL
	@Column(nullable = false)
	private String icon;

	 // Defect priority color NOT_NULL
	@Column(nullable = false)
	private String color;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = "Priority";
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
