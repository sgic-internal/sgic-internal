package com.sgic.internal.privileges.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

//Privilege Table Created By:N.Harilojunan 03.07.2019
@Entity
@Table(schema = "productservice" , name = "privilege")

public class Privilege {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long privilegeId;
	@NotEmpty
	@Size(min = 3 , max = 15)
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
