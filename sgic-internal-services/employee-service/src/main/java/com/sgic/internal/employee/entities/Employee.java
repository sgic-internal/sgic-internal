package com.sgic.internal.employee.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
@Table(schema = "employeeservice", name = "employee")
public class Employee implements Serializable {

	@Id
	// Initialize Variable for Attribute of Employee
	@NotEmpty
	@Size(min = 5, max = 8)
	@Column(name = "emp_id")
	private String empId;

	@NotEmpty
	@Size(min = 2, max = 30)
	@Pattern(regexp = "[a-z-A-Z]*", message = "Username can not contain invalid characters")
	@Column(name = "name")
	private String name;

	@NotEmpty
	@Size(min = 2, max = 50)
	@Email(message = "{Employee.email.invalid}")
	@Email
	@NotBlank(message = "{Employee.email.invalid}")
//	@Pattern(regexp="^([a-zA-Z0-9\\-\\.\\_]+)'+'(\\@)([a-zA-Z0-9\\-\\.]+)'+'(\\.)([a-zA-Z]{2,4})$")

	@Column(unique=true,name = "email")
	private String email;

//	@Temporal(TemporalType.TIMESTAMP)
//	@DateTimeFormat(pattern="yyyy/MM/dd hh:mm:ss")
	
	
	
	@ManyToOne
	@JoinColumn(name = "id", nullable = false)
	private Designation designation;

	public Designation getDesignation() {
		return designation;
	}

	public void setDesignation(Designation designation) {
		this.designation = designation;
	}

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

}
