package com.sgic.internal.defecttracker.defect.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.internal.defecttracker.defect.entities.AuditLog;
import com.sgic.internal.defecttracker.defect.repositories.AuditLogRepository;
import com.sgic.internal.defecttracker.defect.services.AuditLogService;

@Service
public class AuditLogServiceImpl implements AuditLogService{

	@Autowired
	private AuditLogRepository auditLogRepository;
	
	@Override
	public AuditLog createAuditLog(AuditLog auditLog) {
		AuditLog responseAuditLog = auditLogRepository.save(auditLog);
		return responseAuditLog;
	}

//	@Override
//	public List<AuditLog> getAuditLogById(String defectId) {
//		// TODO Auto-generated method stub
//		return auditLogRepository.findAudilLogByDefectId(defectId);
//	}

	@Override
	public List<AuditLog> getAllAuditLogs() {
		// TODO Auto-generated method stub
		return auditLogRepository.findAll();
	}

	@Override
	public List<AuditLog> getAuditLogById(String defectId) {
		// TODO Auto-generated method stub
		return null;
	}

	
}