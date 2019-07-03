package com.sgic.internal.defecttracker.defect.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema="defectservices",name="check")
public class Check {
	

	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String abbre;
	@Id
	private String pk;
	private String address;
}
