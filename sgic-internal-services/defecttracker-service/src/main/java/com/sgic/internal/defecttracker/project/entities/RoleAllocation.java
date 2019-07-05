//package com.sgic.internal.defecttracker.project.entities;
//
//import java.util.List;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//
//import com.fasterxml.jackson.annotation.JsonProperty;
//
//@Entity
//@Table(schema = "defectservices", name = "roleallocation")
//public class RoleAllocation {
//
//	@Id
//	private String id;
//
//	public String getId() {
//		return id;
//	}
//
//	public void setId(String id) {
//		this.id = id;
//	}
//
//	// creating relationship class with add_project
//	@ManyToOne
//	@JoinColumn(name = "subModuleId", nullable = false)
//	private SubModule subModule;
//
//}
