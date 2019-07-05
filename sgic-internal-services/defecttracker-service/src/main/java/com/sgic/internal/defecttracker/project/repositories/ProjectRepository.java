package com.sgic.internal.defecttracker.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgic.internal.defecttracker.project.entities.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {
	
	Project getByprojectId(Long pid);

	


}
