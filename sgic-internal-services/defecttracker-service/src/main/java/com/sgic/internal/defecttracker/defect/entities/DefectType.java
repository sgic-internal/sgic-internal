package com.sgic.internal.defecttracker.defect.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@SuppressWarnings("serial")
@Entity
@Component
@Table(schema = "defectservices", name = "defecttype")
public class DefectType implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id; // Defect type id
	
	@Column(unique=true)
	@Size(min = 2, max = 15)
	@NotEmpty
	private String name; // Defect type name
	
	@Size(min = 10, max = 50)
	@NotEmpty
	private String value; // Defect type value
	
	
	public long getId() {
		return id;
	}
	public DefectType(long id, String name, String value) {
	super();
	this.id = id;
	this.name = name;
	this.value = value;
}
	public DefectType() {
		
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
