package com.sgic.internal.defecttracker.project.controller.dto;

public class ResourceAllocationDto {

	
//	<---Initialize Variable for Attribute of Resource Allocation DTO--->
	private Long resourceId;
//	private String resourceName;
	private String projectName;
	private String projectId;
	private Long empId;
	private String employeeid;
	private String name;
	private String firstname;
	private String email;
	private int availability;
	private boolean bench = false;
	private Long designationid;
	private String designationname;
	
	
//	<--- Resource Allocation DTO--- Getter Setter --->
	public Long getResourceId() {
		return resourceId;
	}
	public void setResourceId(Long resourceId) {
		this.resourceId = resourceId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
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
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
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
	
	
	
	
}
