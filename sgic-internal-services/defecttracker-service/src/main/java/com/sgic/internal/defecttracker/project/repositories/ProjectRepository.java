package com.sgic.internal.defecttracker.project.repositories;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgic.internal.defecttracker.project.entities.Project;

public interface ProjectRepository extends JpaRepository<Project, Long>{
	Project getByprojectId(Long id);
	Project getByprojectName(String name);
	Project getBytype(String type);
	Project getBystartDate(Date date);
	Project getByduration (String duration);
	Project getBystatus (String status);
	
}
