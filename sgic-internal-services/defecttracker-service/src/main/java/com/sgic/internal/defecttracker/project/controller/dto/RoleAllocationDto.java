package com.sgic.internal.defecttracker.project.controller.dto;

import org.springframework.stereotype.Component;

@Component
public class RoleAllocationDto {

	private Long roleId;
	private String rId;
	private String role;
	private int availability;
//	private Long empId;
	private String firstname;
	private String designationname;
	
	
	
	
//    private String subModuleId;

	// getterSetter for subModuleId
//	public String getSubModuleId() {
//		return subModuleId;
//	}
//
//	public void setSubModuleId(String subModuleId) {
//		this.subModuleId = subModuleId;
//	}

//	public Long getEmpId() {
//		return empId;
//	}
//
//	public void setEmpId(Long empId) {
//		this.empId = empId;
//	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getDesignationname() {
		return designationname;
	}

	public void setDesignationname(String designationname) {
		this.designationname = designationname;
	}

	public String getrId() {
		return rId;
	}

	public void setrId(String rId) {
		this.rId = rId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getAvailability() {
		return availability;
	}

	public void setAvailability(int availability) {
		this.availability = availability;
	}

}
