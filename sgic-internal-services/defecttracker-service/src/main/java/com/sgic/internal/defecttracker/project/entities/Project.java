package com.sgic.internal.defecttracker.project.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("serial")
@Entity
@Table(schema = "defectservices", name = "project")
public class Project implements Serializable {

//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long pid;
//
//
//	@Size(min = 2, max = 50)

	@Id
	private String projectId;

	@Size(min = 2, max = 50)
	private String projectName;



	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@OneToMany(mappedBy = "project", fetch = FetchType.EAGER)
	private List<ResourceAllocation> resourceAllocation;

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
