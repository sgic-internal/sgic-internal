package com.sgic.internal.defecttracker.project.services.impl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.internal.defecttracker.project.entities.Project;
import com.sgic.internal.defecttracker.project.repositories.ProjectRepository;
import com.sgic.internal.defecttracker.project.services.ProjectService;
@Service
public class ProjectServiceImpl implements  ProjectService {
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Override
	public Project createProject(Project project) {
		Project responseProject = projectRepository.save(project);
		return responseProject;
	}

	@Override
	public boolean isProjectAlreadyExists(Long id) {
		return projectRepository.existsById(id);
	}

	@Override
	public List<Project> getallDetails() {
		return projectRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		projectRepository.deleteById(id);
		
	}

	@Override
	public Project updateProject(Project project) {
		return projectRepository.save(project) ;
	}

	@Override
	public Project getByprojectId(Long id) {
		return projectRepository.getByprojectId(id);
	}

	@Override
	public Project getByprojectName(String name) {
		return projectRepository.getByprojectName(name);
	}

	@Override
	public Project getBytype(String type) {
		return projectRepository.getBytype(type);
	}

	@Override
	public Project getBystartDate(Date date) {
		return projectRepository.getBystartDate(date);
	}
	
	@Override
	public Project  getByduration (String duration) {
		return projectRepository.getByduration(duration);
	}
	
	@Override
	public Project   getBystatus (String status) {
		return projectRepository. getBystatus (status);
	}


	
	
	
}
