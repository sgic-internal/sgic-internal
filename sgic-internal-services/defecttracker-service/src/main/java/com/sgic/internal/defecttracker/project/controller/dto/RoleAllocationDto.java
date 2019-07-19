package com.sgic.internal.defecttracker.project.controller.dto;

import org.springframework.stereotype.Component;

@Component
public class RoleAllocationDto {

	private Long roleallocationId;
	private String rId;
//	private String role;
	private int availability;
	private Long empId;
	private String firstname;
	private String designationname;
//	private Long roleId;


//	public Long getRoleId() {
//		return roleId;
//	}
//
//	public void setRoleId(Long roleId) {
//		this.roleId = roleId;
//	}

	public Long getRoleallocationId() {
		return roleallocationId;
	}

	public void setRoleallocationId(Long roleallocationId) {
		this.roleallocationId = roleallocationId;
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

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



	public int getAvailability() {
		return availability;
	}

	public void setAvailability(int availability) {
		this.availability = availability;
	}

}
