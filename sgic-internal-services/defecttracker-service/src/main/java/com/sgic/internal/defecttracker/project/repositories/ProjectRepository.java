package com.sgic.internal.defecttracker.project.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sgic.internal.defecttracker.project.entities.Project;

public interface ProjectRepository extends JpaRepository<Project, Long>{
	Project getByprojectId(Long id);
	
	@Query(value="FROM Project WHERE project_name= :projectName")
	List <Project>getByprojectName(@Param("projectName")String projectName);
	
	@Query(value="FROM Project WHERE type= :type")
	List <Project> getBytype(String type);
	
	@Query(value="FROM Project WHERE start_date= :date")
	List <Project> getBystartDate(String date);
	
	@Query(value="FROM Project WHERE duration= :duration")
	List <Project>getByduration (String duration);
	
	@Query(value="FROM Project WHERE status= :status")
	List <Project>getBystatus (String status);
	
}
