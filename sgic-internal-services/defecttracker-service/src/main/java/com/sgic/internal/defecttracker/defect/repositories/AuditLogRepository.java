package com.sgic.internal.defecttracker.defect.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sgic.internal.defecttracker.defect.entities.AuditLog;
import com.sgic.internal.defecttracker.defect.entities.Defect;

@Repository
@Transactional
public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {
//
//	   String findCommentsByDefectId ="SELECT a.audit_id, a.user, a.fixDate, a.status, FROM  auditlog a INNER JOIN defect d on a.defectId = d.defectId AND defect d INNER JOIN project p on d.projectId = p.projectId WHERE a.auditlog = d.defectId";
//	   @Query(value = findCommentsByDefectId, nativeQuery = true)
//	    Object[] findCommentsByDefectId();
//	
//	@Query("SELECT c FROM AuditLog c WHERE c.defect.id= :defectId")
//	List<AuditLog> findAudilLogByDefectId(@Param("defectId") String defectId);
}