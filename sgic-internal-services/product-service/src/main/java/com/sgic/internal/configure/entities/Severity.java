package com.sgic.internal.configure.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

//severity entity table created by:N.Harilojunan 02.06.2019
@Entity
@Table(schema="productservice", name="severity")
public class Severity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	//Id Auto Increment
	private Long severeId;
	
	@NotEmpty
	@Size(min = 3, max = 10)
	private String severeName;
	
	@NotEmpty
	@Size(min = 3, max = 15)
	private String severeColour;
	
	//its not be an image
	@NotEmpty
	private enum severeIcon{
		up , down
	};
	
	//Getter And Setter Above Entity Attribute
	public Long getSevereId() {
		return severeId;
	}

	public void setSevereId(Long severeId) {
		this.severeId = severeId;
	}

	public String getSevereName() {
		return severeName;
	}

	public void setSevereName(String severeName) {
		this.severeName = severeName;
	}

	public String getSevereColour() {
		return severeColour;
	}

	public void setSevereColour(String severeColour) {
		this.severeColour = severeColour;
	}
	
}
