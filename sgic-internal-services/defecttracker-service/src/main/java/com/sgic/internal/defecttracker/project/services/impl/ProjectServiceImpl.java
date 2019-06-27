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
	public boolean isProjectAlreadyExists(String id) {
		return projectRepository.existsById(id);
	}

	@Override
	public List<Project> getallDetails() {
		return projectRepository.findAll();
	}


//	@Override
//	public Project updateProject(String projectid project) {
//		if(projectRepository.getOne(projectid) !=null) {
//			project.set
//		}
//		return projectRepository.save(project) ;
//	}

	@Override
	public Project getByprojectId(String id) {
		return projectRepository.getByprojectId(id);
	}

	@Override
	public List<Project> getByprojectName(String name) {
		return projectRepository.getByprojectName(name);
	}

	@Override
	public List<Project> getBytype(String type) {
		return projectRepository.getBytype(type);
	}

	
	@Override
	public  List<Project>getByduration (String duration) {
		return projectRepository.getByduration(duration);
	}
	
	@Override
	public  List<Project>getBystatus (String status) {
		return projectRepository. getBystatus (status);
	}

	@Override
	public Project updateProject(String projectid, Project project) {
		if (projectRepository.getOne(projectid) != null) {
			project.setProjectId(projectid);
			projectRepository.save(project);
		}
		return project;
	}

	@Override
	public void deleteById(String id) {
		projectRepository.deleteById(id);
	}

	@Override
	public List<Project> getBystartDate(String date) {
		return projectRepository.getBystartDate(date);
	}

	
	
	
}
