package com.sgic.internal.defecttracker.defect.entities;

public class SampleConfig2 {
	
	private int id;
	private int projectId;
	private String name;

	public SampleConfig2(int id, int projectId, String name) {
		super();
		this.id = id;
		this.projectId = projectId;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
