package com.sgic.internal.defecttracker.project.entities;

import javax.persistence.Entity;

import javax.persistence.Id;
<<<<<<< HEAD
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
=======

>>>>>>> f1bb3f266238a45ba97d2ec2eb6348085a0c1f87
import javax.persistence.Table;


@Entity
@Table(schema = "defectservices", name = "submodule")
public class SubModule {
	@Id
	private String subModuleId;
	private String subModuleName;
<<<<<<< HEAD
	private String abbr;
=======
>>>>>>> f1bb3f266238a45ba97d2ec2eb6348085a0c1f87

	public String getSubModuleId() {
		return subModuleId;
	}

	public void setSubModuleId(String subModuleId) {
		this.subModuleId = subModuleId;
	}

	public String getSubModuleName() {
		return subModuleName;
	}

	public void setSubModuleName(String subModuleName) {
		this.subModuleName = subModuleName;
	}

<<<<<<< HEAD
	public String getAbbr() {
		return abbr;
	}

	public void setAbbr(String abbr) {
		this.abbr = abbr;
	}
	
	// create relationship with project
		@ManyToOne
		@JoinColumn(name = "projectId", nullable = false)

		private Project project;

		public Project getProject() {
			return project;
		}

		public void setProject(Project project) {
			this.project = project;
		}
=======
	// creating relationship class with module
//	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
//	@OneToMany(mappedBy = "subModule", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	private List<RoleAllocation> roleAllocation;
//
//	public List<RoleAllocation> getRoleAllocation() {
//		return roleAllocation;
//	}
//
//	public void setRoleAllocation(List<RoleAllocation> roleAllocation) {
//		this.roleAllocation = roleAllocation;
//	}
>>>>>>> f1bb3f266238a45ba97d2ec2eb6348085a0c1f87

}
