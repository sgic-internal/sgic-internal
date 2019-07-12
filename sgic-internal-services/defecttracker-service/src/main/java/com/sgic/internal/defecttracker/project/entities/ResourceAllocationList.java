package com.sgic.internal.defecttracker.project.entities;

public class ResourceAllocationList {

	
	private Long resourceId;
	private Long empId;
//	private Employee employeeObj;
	private String employeeid;
	private String name;
	private String firstname;
	private String email;
	private int availability;
	private boolean bench = false;
	private Long designationid;
	private String designationname;
	private String projectId;
	private String projectName;
//	private Project projectObj;
	
//	public Project getProjectObj() {
//		return projectObj;
//	}
//
//	public void setProjectObj(Project projectObj) {
//		this.projectObj = projectObj;
//	}

	public Long getResourceId() {
		return resourceId;
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

	public void setResourceId(Long resourceId) {
		this.resourceId = resourceId;
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

//	public Employee getEmployeeObj() {
//		return employeeObj;
//	}
//
//	public void setEmployeeObj(Employee employeeObj) {
//		this.employeeObj = employeeObj;
//	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}


	
	
	
	
}
