package com.sgic.internal.defecttracker.defect.repositories;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sgic.internal.defecttracker.defect.entities.Defect;

public interface DefectRepository extends JpaRepository<Defect, String >{

Defect getByDefectId(String defectId);

@Query(value ="FROM Defect WHERE project_id =:projectId") 
List<Defect>getByProjectId(@Param("projectId")String projectId); 

@Query(value ="FROM Defect WHERE module_id =:moduleId") 
List<Defect>getByModuleId(@Param("moduleId")String moduleId);

@Query(value ="FROM Defect WHERE severity_id =:severityId") 
List<Defect>getBySeverityId(@Param("severityId")int severityId);

@Query(value ="FROM Defect WHERE priority_id =:priorityId") 
List<Defect>getByPriorityId(@Param("priorityId")int priorityId);

@Query(value ="FROM Defect WHERE status_id =:statusId") 
List<Defect>getByStatusId(@Param("statusId")int statusId);

@Query(value ="FROM Defect WHERE date_and_time =:dateAndTime") 
List<Defect>getByDefectDate(@Param("dateAndTime")String dateAndTime);


}
