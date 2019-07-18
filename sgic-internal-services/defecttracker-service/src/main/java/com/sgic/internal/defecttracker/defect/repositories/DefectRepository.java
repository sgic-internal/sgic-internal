package com.sgic.internal.defecttracker.defect.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.sgic.internal.defecttracker.defect.entities.Defect;
import com.sgic.internal.defecttracker.project.entities.Module;

public interface DefectRepository extends JpaRepository<Defect, String> {

	Defect getByDefectId(String defectId);

	@Query(value = "FROM Defect WHERE project_id =:projectId")
	List<Defect> getByProjectId(@Param("projectId") String projectId);

	@Query(value = "FROM Defect WHERE module_id =:moduleId")
	List<Defect> getByModuleId(@Param("moduleId") String moduleId);

	@Query(value = "FROM Defect WHERE date_and_time =:dateAndTime")
	List<Defect> getByDefectDate(@Param("dateAndTime") Date dateAndTime);

	@Query(value = "FROM Defect WHERE available_in =:availableIn")
	List<Defect> getByAvailableIn(@Param("availableIn") String availableIn);


	@Query(value = "FROM Defect WHERE found_in =:foundIn")
	List<Defect> getByFoundIn(@Param("foundIn") String foundIn);

	@Query(value = "FROM Defect WHERE fixed_in =:fixedIn")
	List<Defect> getByFixedIn(@Param("fixedIn") String fixedIn);

	List<Defect> findDefectByModule(Module module);

	@Query(value = "SELECT d FROM Defect d WHERE status =:status")
	List<Defect> getByStatus(@Param("status") String status);

	@Query(value = "SELECT d FROM Defect d WHERE priority =:priority")
	List<Defect> getByPriority(@Param("priority") String priority);

	@Query(value = "SELECT d FROM Defect d WHERE severity =:severity")
	List<Defect> getBySeverity(@Param("severity") String severity);

	@Query(value = "SELECT d FROM Defect d WHERE type =:type")
	List<Defect> getByType(@Param("type") String type);

	@Query("SELECT COUNT(severity) FROM Defect WHERE severity='low'")
	int countBySeverity();
	
	@Query("SELECT COUNT(severity) FROM Defect WHERE severity='Medium'")
	int countBySeverityMedium();
	
	@Query("SELECT COUNT(severity) FROM Defect WHERE severity='High'")
	int countBySeverityhigh();
	
	@Query("SELECT COUNT(status) FROM Defect WHERE status='Rejected' ")
	int countByStatusRejected();
	
	@Query("SELECT COUNT(severity) FROM Defect WHERE status='Rejected' AND severity = 'low'")
	int countByStatusRejectedlow();
	
	@Query("SELECT COUNT(severity) FROM Defect WHERE status='Rejected' AND severity = 'High'")
	int countByStatusRejectedHigh();

	public long count();
}