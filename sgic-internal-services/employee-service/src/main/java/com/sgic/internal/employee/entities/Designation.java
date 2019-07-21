package com.sgic.internal.employee.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("serial")
@Entity
@Table(schema = "employeeservice", name = "designation")
public class Designation implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

//	Initialize Variable for Attribute of Designation
	private Long designationid;

	@NotEmpty
	@Size(min = 2, max = 30)
	private String designationname;

//	Employee with Designation Relationship 
//	cascade=CascadeType.ALL,
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@OneToMany(mappedBy = "designation", fetch = FetchType.EAGER)
	private List<Employee> employees;

//	Designation Entity's getter Setter methods

	public Long getDesignationid() {
		return designationid;
	}

	public void setDesignationid(Long designationid) {
		this.designationid = designationid;
	}

	public String getDesignationname() {
		return designationname;
	}

	public void setDesignationname(String designationname) {
		this.designationname = designationname;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

}
