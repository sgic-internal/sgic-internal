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
@Table(schema = "productservice", name = "defectseverity")
public class DefectSeverity implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id; // Defect severity id

	@Column(nullable = false)
	private String name; // Defect severity name

	@Column(nullable = false)
	private String value; // Defect severity value

	@Column(nullable = false)
	private String icon; // Defect severity icon

	@Column(nullable = false)
	private String color; // Defect severity color

}
