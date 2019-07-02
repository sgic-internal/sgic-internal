package com.sgic.internal.defecttracker.project.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.internal.defecttracker.project.entities.Project;
import com.sgic.internal.defecttracker.project.repositories.ProjectRepository;
import com.sgic.internal.defecttracker.project.services.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectRepository projectRepository;

	@Override
	public Project createProject(Project project) {
		Project responseProject = projectRepository.save(project);
		return responseProject;
	}

	@Override
	public boolean isProjectAlreadyExists(String projectid) {
		return projectRepository.existsById(projectid);
	}

	@Override
	public List<Project> getallDetails() {
		return projectRepository.findAll();
	}


}
