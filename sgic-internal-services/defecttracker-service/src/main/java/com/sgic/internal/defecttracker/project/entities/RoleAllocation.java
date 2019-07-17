package com.sgic.internal.defecttracker.project.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(schema = "defectservices", name = "roleallocation")
public class RoleAllocation {

	@Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long roleId;
	private String rId;
	private String role;
	private int availability;
	private Long empId;
	private String firstname;
	private String designationname;
	
	
	
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

	// creating relationship class with add_project
//	@ManyToOne  //(fetch=FetchType.LAZY)
//	@JoinColumn(name = "subModuleId", nullable = false)
//	private SubModule subModule;
//
//	public SubModule getSubModule() {
//		return subModule;
//	}
//
//	public void setSubModule(SubModule subModule) {
//		this.subModule = subModule;
//	}
//	
//	

}
