package com.sgic.internal.defecttracker.project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sgic.internal.defecttracker.project.entities.Project;

public interface ProjectRepository  extends JpaRepository<Project, String> {
	Project getByprojectId(String projectid);

	// Find Project By Project_Name Method
	@Query(value = "FROM Project WHERE project_name= :projectName")
	List<Project> getByprojectName(@Param("projectName") String projectName);

	// Find Project By Project_Type Method
	@Query(value = "FROM Project WHERE type= :type")
	List<Project> getBytype(String type);

	// Find Project By Project_StartDate Method
	@Query(value = "FROM Project WHERE start_date= :date")
	List<Project> getBystartDate(String date);

	// Find Project By Project_Duration Method
	@Query(value = "FROM Project WHERE duration= :duration")
	List<Project> getByduration(Long duration);

	// Find Project By Project_Status Method
	@Query(value = "FROM Project WHERE status= :status")
	List<Project> getBystatus(String status);
}
