package com.sgic.internal.defecttracker.project.services;

import java.util.List;

import com.sgic.internal.defecttracker.project.entities.Project;

public interface ProjectService {
	public Project createProject(Project project);

	public boolean isProjectAlreadyExists(String projectid);

	public List<Project> getallDetails();

	public void deleteById(String projectid);

    public Project updateProject(Long projectid, Project project); // Update projectid

	Project getByprojectId(Long projectid);
	
	public Project getByabbrivation(String abbrivation);

	public List<Project> getByprojectName(String name);

	public List<Project> getBytype(String type);

	public List<Project> getBystartDate(String date);

	public List<Project> getByduration(Long duration);

	public List<Project> getBystatus(String status);

//	Project updateProject(String projectid, Project project);



}
