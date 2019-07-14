package com.sgic.internal.product.configure.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@SuppressWarnings("serial")
@Entity
@Table(schema = "productservice", name = "defecttype")
public class DefectType implements Serializable {
	// Defect type id AUTO_INCREMENT
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id; 

	// Defect type name NOT_NULL
	@NotEmpty
	private String name; 

	// Defect type value NOT_NULL
	@NotEmpty
	private String value; 

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
		this.name = "Type";
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
}
