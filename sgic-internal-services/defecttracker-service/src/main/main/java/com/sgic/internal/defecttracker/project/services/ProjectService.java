package com.sgic.internal.defecttracker.project.services;


import java.util.List;

import com.sgic.internal.defecttracker.project.entities.Project;

public interface ProjectService {
	public Project createProject(Project project);
	public boolean isProjectAlreadyExists(Long id);
	public List<Project>getallDetails();
	public void deleteById(Long id);
	public Project updateProject(Long projectid, Project project);  //Update projectid
	Project getByprojectId(Long id);
	public List<Project>getByprojectName (String name);
	public List<Project>getBytype (String type);
	public List<Project>getBystartDate (String date);
	public List<Project>getByduration (String duration);
	public List<Project>getBystatus (String status);

}
