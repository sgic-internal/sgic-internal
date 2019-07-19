package com.sgic.internal.defecttracker.project.entities;

import java.util.List;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(schema = "defectservices", name = "roleallocation")
public class RoleAllocation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long roleallocationId;
	private String rId;
//	private String role;
	private int availability;
	private Long empId;
	private String firstname;
	private String designationname;

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

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@ManyToOne
	@JoinColumn(name = "roleId", nullable = false)
	public Role role;

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	

}
