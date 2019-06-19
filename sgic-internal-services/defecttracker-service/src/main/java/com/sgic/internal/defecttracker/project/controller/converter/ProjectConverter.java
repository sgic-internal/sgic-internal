package com.sgic.internal.defecttracker.project.controller.converter;

import java.util.ArrayList;
import java.util.List;

import com.sgic.internal.defecttracker.project.controller.dto.ProjectData;
import com.sgic.internal.defecttracker.project.entities.Project;

public class ProjectConverter {
	
	private ProjectConverter() {    
	  }
	public static ProjectData projectToProjectData(Project project ) {
		ProjectData projectData = new ProjectData();
	    
	    if(project != null) {
	    	projectData.setProjectId(project.getProjectId());
	    	projectData.setProjectName(project.getProjectName());
	    	projectData.setType(project.getType());
	    	projectData.setStartDate(project.getStartDate());
	    	projectData.setEndDate(project.getEndDate());
	    	projectData.setDuration(project.getDuration());
	    	projectData.setStatus(project.getStatus());
	    	projectData.setConfigId(project.getConfigId());
	    	
	    return projectData;
	    }
	    return null;
	}
	    
	    public static Project projectDataToProject(ProjectData projectData) {
	    	Project project = new Project();

	    	project.setProjectId(projectData.getProjectId());
	    	project.setProjectName(projectData.getProjectName());
	    	project.setType(projectData.getType());
	    	project.setStartDate(projectData.getStartDate());
	    	project.setEndDate(projectData.getEndDate());
	    	project.setDuration(projectData.getDuration());
	    	project.setStatus(projectData.getStatus());
	    	project.setConfigId(projectData.getConfigId());
	        return project;
	      }
	    public static List<ProjectData> projectToProjectData(List<Project> projectList) {    
	        
	        if(projectList != null) {
	          List<ProjectData> lProjectData = new ArrayList<>();
	          for (Project project : projectList) {
	        	  ProjectData projectData = new ProjectData();
	            
	        	  projectData.setProjectId(project.getProjectId());
	        	  projectData.setProjectName(project.getProjectName());
	        	  projectData.setType(project.getType());
	        	  projectData.setStartDate(project.getStartDate());
	        	  projectData.setEndDate(project.getEndDate());
	        	  projectData.setDuration(project.getDuration());
	        	  projectData.setStatus(project.getStatus());
	        	  projectData.setConfigId(project.getConfigId());
	        	  lProjectData.add(projectData);
	          }
	        
	        return lProjectData;
	        }
	        return null;

	      }

	      

	  }


