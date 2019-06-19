package com.sgic.internal.defecttracker.project.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(schema="project_service",name="roleallocation")

public class RoleAllocation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long allocationId;
	private String email;
	private String roll;
	private String employeeAvalibility;
	public long getAllocationId() {
		return allocationId;
	}
	public void setAllocationId(long allocationId) {
		this.allocationId = allocationId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRoll() {
		return roll;
	}
	public void setRoll(String roll) {
		this.roll = roll;
	}
	public String getEmployeeAvalibility() {
		return employeeAvalibility;
	}
	public void setEmployeeAvalibility(String employeeAvalibility) {
		this.employeeAvalibility = employeeAvalibility;
	}
	
//	// create relationship with Module
//				@ManyToOne
//				@JoinColumn(name="moduleId",nullable=false)
//				
//				private RoleAllocation roleAllocation;
//				public RoleAllocation getRoleAllocation() {
//					return roleAllocation;
//				}
//				public void setRoleAllocation(RoleAllocation roleAllocation) {
//					this.roleAllocation = roleAllocation;
//				}
//				
//				
//				
				// create relationship with subModule
				@ManyToOne
				@JoinColumn(name="subModuleId",nullable=false)
				
				private RoleAllocation roleAllocation;
				public RoleAllocation getRoleAllocation() {
					return roleAllocation;
				}
				public void setRoleAllocation(RoleAllocation roleAllocation) {
					this.roleAllocation = roleAllocation;
				}
				
	
	

}
