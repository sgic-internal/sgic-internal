package com.sgic.internal.product.privileges.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

//Privilege Table Created By:N.Harilojunan 03.07.2019
@SuppressWarnings("serial")
@Entity
@Table(schema = "productservice", name = "privilege")
public class Privilege implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false)
	private Long privilegeId;
	@NotEmpty
	@Size(min = 3 , max = 15)
	@Column(nullable = false)
	private String privilageNameString;
	
	public Long getPrivilegeId() {
		return privilegeId;
	}
	public void setPrivilegeId(Long privilegeId) {
		this.privilegeId = privilegeId;
	}
	public String getPrivilageNameString() {
		return privilageNameString;
	}
	public void setPrivilageNameString(String privilageNameString) {
		this.privilageNameString = privilageNameString;
	}
	
}
