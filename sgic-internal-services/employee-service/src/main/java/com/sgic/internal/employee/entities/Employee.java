package com.sgic.internal.employee.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.lang.Nullable;

@SuppressWarnings("serial")
@Entity
@Table(schema = "employeeservice", name = "employee", uniqueConstraints = {
@UniqueConstraint(columnNames = { "employee_id", "email" }) })
public class Employee implements Serializable {

	// Initialize Variable for Attribute of Employee
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long empId;

	@Column(name = "employee_id", unique = true)
	@NotEmpty
	private String employeeid;

	@NotEmpty
	@Size(min = 2, max = 30)
	@Pattern(regexp = "[a-z-A-Z]*", message = "Username can not contain invalid characters")
	@Column(name = "name")
	private String name;

	
	@NotEmpty
	@Size(min = 2, max = 30)
	@Pattern(regexp = "[a-z-A-Z]*", message = "Username can not contain invalid characters")
	@Column(name = "firstname")
	private String firstname;
	

	@NotEmpty
	@Size(min = 2, max = 50)
//	@Email(message = "{Employee.email.invalid}")
	@Email
//	@NotBlank(message = "{Employee.email.invalid}")
//	@Pattern(regexp="^([a-zA-Z0-9\\-\\.\\_]+)'+'(\\@)([a-zA-Z0-9\\-\\.]+)'+'(\\.)([a-zA-Z]{2,4})$")

	@Column(name = "email", unique = true)
	@Email
	private String email;

	@Nullable
	private int availability;

	@Nullable
	private boolean bench = false;

//	Designation with Designation Entity Relationship
	@ManyToOne
	@JoinColumn(name = "designationid", nullable = false)
	private Designation designation;

//	Designation Object Getter Setter
	public Designation getDesignation() {
		return designation;
	}

	public void setDesignation(Designation designation) {
		this.designation = designation;
	}

//	Employee Entity's Getter Setter
	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
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

	public int getAvailability() {
		return availability;
	}

	public void setAvailability(int availability) {
		this.availability = availability;
	}

	public boolean isBench() {
		return bench;
	}

	public void setBench(boolean bench) {
		this.bench = bench;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

}
