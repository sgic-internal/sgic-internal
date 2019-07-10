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
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id; // Defect priority id

	@Column(nullable = false)
	private String name; // Defect priority name

	@Column(nullable = false)
	private String value; // Defect priority value

	@Column(nullable = false)
	private String icon; // Defect priority icon

	@Column(nullable = false)
	private String color; // Defect priority color

}
