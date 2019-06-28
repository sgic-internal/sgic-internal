package com.sgic.internal.defecttracker.defect.controller.dto.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sgic.internal.defecttracker.defect.controller.dto.AuditLogData;
import com.sgic.internal.defecttracker.defect.controller.dto.CommentData;
import com.sgic.internal.defecttracker.defect.entities.AuditLog;
import com.sgic.internal.defecttracker.defect.entities.Comments;
import com.sgic.internal.defecttracker.defect.entities.Defect;

@Service
public class AuditLogDtoConverter {

	public AuditLog DTOtoEntity( AuditLogData auditLogData) {
		AuditLog auditLog = new AuditLog();
		auditLog.setAuditId(auditLogData.getAuditId());
		auditLog.setStatus(auditLogData.getStatus());
		auditLog.setUser(auditLogData.getUser());
		auditLog.setFixDate(auditLogData.getFixDate());
		
		Defect defect = new Defect();
		defect.setDefectId(auditLogData.getDefectId());
		auditLog.setDefect(defect);
		
		return auditLog;
	}
	
	public AuditLogData EntitytoDTO( AuditLog auditLog) {
		   
		AuditLogData auditLogData =new AuditLogData();
		
		auditLogData.setAuditId(auditLog.getAuditId());
		auditLogData.setStatus(auditLog.getStatus());
		auditLogData.setUser(auditLog.getUser());
		auditLogData.setFixDate(auditLog.getFixDate());
		auditLogData.setDefectId(auditLog.getDefect().getDefectId());
		
		return auditLogData;
	}
	
    public  List<AuditLogData> ListEntityToDTO(List<AuditLog> auditLogs  ) {
		
		
		ArrayList<AuditLogData> list=new ArrayList<>();
		for(AuditLog auditLog : auditLogs) {
			
			AuditLogData auditLogData = new AuditLogData();
			
			auditLogData.setAuditId(auditLog.getAuditId());
			auditLogData.setStatus(auditLog.getStatus());
			auditLogData.setUser(auditLog.getUser());
			auditLogData.setFixDate(auditLog.getFixDate());
			auditLogData.setDefectId(auditLog.getDefect().getDefectId());
			
			list.add(auditLogData);
		}
		return list;		
	}
}
