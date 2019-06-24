package com.sgic.internal.employee.dto;

public class EmployeeDTO {

//	Initialize Variable for Attribute of EmployeeDTO
	private String empId;
	private String name;
	private String email;
	private String designation;

	

	public EmployeeDTO() {
		super();
	}

	public EmployeeDTO(String empId, String name, String email, String designation) {
		super();
		this.empId = empId;
		this.name = name;
		this.email = email;
		this.designation = designation;
	}

	

	// getter setter methods
	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

}