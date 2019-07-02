package com.sgic.internal.defecttracker.project.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@SuppressWarnings("serial")
@Entity
@Table(schema="defectservices" , name="resource_Allocation")
//@SecondaryTable(name = "Employee")
public class ResourceAllocation implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long resourceId;
	private String resourceName;


//    @Column(table = "Employee")
//	private Long empId;

	
	
	@ManyToOne
	@JoinColumn(name = "pid", nullable = false)
	private Project project;
	
	public Long getResourceId() {
		return resourceId;
	}

	public void setResourceId(Long resourceId) {
		this.resourceId = resourceId;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

//	public Long getEmpId() {
//		return empId;
//	}
//
//	public void setEmpId(Long empId) {
//		this.empId = empId;
//	}
	
    
    
}
