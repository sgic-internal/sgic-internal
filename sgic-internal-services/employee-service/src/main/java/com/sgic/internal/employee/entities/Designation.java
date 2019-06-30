package com.sgic.internal.employee.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("serial")
@Entity
@Table(schema = "employeeservice", name = "designation")
public class Designation implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Long designationid;
	private String designationname;
	
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@OneToMany(mappedBy="designation",cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Employee> employees;


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
