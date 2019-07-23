package com.sgic.internal.defecttracker.defect.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

import com.sgic.internal.defecttracker.project.entities.Project;

@SuppressWarnings("serial")
@Entity
@Table(schema = "defectservices", name = "resource_Allocation")
//@SecondaryTable(name = "Employee")
public class ResourceAllocation implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	<---Initialize Variable for Attribute of Resource Allocation--->
	private Long resourceId;
	
	@NonNull
	private Long empId;

//	<---Project With Resource Allocation Relationship --->
	@ManyToOne
	@JoinColumn(name = "projectId", nullable = false)
	private Project project;

	public ResourceAllocation(Long empId, Project project) {
		super();
		this.empId = empId;
		this.project = project;
	}

	public ResourceAllocation(Project project) {
		super();
		this.project = project;
	}

	public ResourceAllocation() {
		super();
	}

	public ResourceAllocation(Long resourceId, Long empId, Project project) {
		super();
		this.resourceId = resourceId;
		this.empId = empId;
		this.project = project;
	}

	public Long getResourceId() {
		return resourceId;
	}

	public void setResourceId(Long resourceId) {
		this.resourceId = resourceId;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

}
