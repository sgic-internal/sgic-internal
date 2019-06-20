package com.sgic.internal.employee.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(schema = "employeeservice", name = "employee")
public class Employee implements Serializable {

	@Id
	// Initialize Variable for Attribute of Employee 
	@Column(name= "emp_id")
	private String empId;
	
	@Column(name= "name")
	private String name;
	
	@Column(name= "email")
	private String email;
	
	@Column(name= "designation")
	private String designation;

	// Getter and setter Method for all attributes
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
