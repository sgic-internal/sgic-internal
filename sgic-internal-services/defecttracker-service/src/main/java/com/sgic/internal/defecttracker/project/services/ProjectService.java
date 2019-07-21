package com.sgic.internal.defecttracker.project.services;

import java.util.List;

import com.sgic.internal.defecttracker.project.entities.Project;

public interface ProjectService {

	// Method for Save Project Entity
	public Project createProject(Project project);

	// Method for Exists Project Entity
	public boolean isProjectAlreadyExists(String projectid);

	// Method for Get all Project Entity
	public List<Project> getallDetails();

	// Method for Delete Project Entity
	public void deleteById(String projectid);

	// Method for Update Project Entity
	public Project updateProject(String projectid, Project project); 

	// Method for GetProjectId in Project Entity
	public Project getByprojectId(String projectid);

	// Method for GetProjectName in Project Entity
	public List<Project> getByprojectName(String name);

	// Method for GetProjectType in Project Entity
	public List<Project> getBytype(String type);

	// Method for GetProjectStartDate in Project Entity
	public List<Project> getBystartDate(String date);

	// Method for GetProjectDuration in Project Entity
	public List<Project> getByduration(Long duration);

	// Method for GetProjectStatus in Project Entity
	public List<Project> getBystatus(String status);

}
