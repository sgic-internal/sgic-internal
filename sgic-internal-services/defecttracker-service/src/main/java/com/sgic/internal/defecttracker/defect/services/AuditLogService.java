package com.sgic.internal.defecttracker.defect.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sgic.internal.defecttracker.defect.entities.AuditLog;

@Service
public interface AuditLogService {
	
	public AuditLog createAuditLog(AuditLog auditLog);
	public List<AuditLog> getAuditLogById(String defectId);
	public List<AuditLog> getAllAuditLogs();

}
