package com.sgic.internal.defecttracker.project.services;

import java.util.List;

import com.sgic.internal.defecttracker.project.entities.Project;

public interface ProjectService {

	public Project createProject(Project project);

	public boolean isProjectAlreadyExists(String pid);

	public List<Project> getallDetails();
}
