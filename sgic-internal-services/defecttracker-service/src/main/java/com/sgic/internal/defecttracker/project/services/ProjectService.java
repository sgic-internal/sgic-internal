package com.sgic.internal.defecttracker.project.services;

import java.sql.Date;
import java.util.List;

import com.sgic.internal.defecttracker.project.entities.Project;

public interface ProjectService {
	public Project createProject(Project project);
	public boolean isProjectAlreadyExists(Long id);
	public List<Project>getallDetails();
	public void delete(Long id);
	Project updateProject(Project project);
	Project getByprojectId(Long id);
	Project getByprojectName (String name);
	Project getBytype (String type);
	Project getBystartDate (Date date);
	Project getByduration (String duration);
	Project getBystatus (String status);

	

}
