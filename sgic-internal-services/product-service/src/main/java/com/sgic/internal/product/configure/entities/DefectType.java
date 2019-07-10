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
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id; // Defect type id

	@NotEmpty
	private String name; // Defect type name

	@NotEmpty
	private String value; // Defect type value
}
