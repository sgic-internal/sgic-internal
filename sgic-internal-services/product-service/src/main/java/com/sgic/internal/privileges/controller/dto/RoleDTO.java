package com.sgic.internal.privileges.controller.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

public class RoleDTO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long privilageId;
	@NotNull
	private String privilageName;
	
	public Long getPrivilageId() {
		return privilageId;
	}
	public void setPrivilageId(Long privilageId) {
		this.privilageId = privilageId;
	}
	public String getPrivilageName() {
		return privilageName;
	}
	public void setPrivilageName(String privilageName) {
		this.privilageName = privilageName;
	}

}
