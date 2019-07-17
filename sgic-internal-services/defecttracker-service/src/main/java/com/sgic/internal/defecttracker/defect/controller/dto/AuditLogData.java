package com.sgic.internal.defecttracker.defect.controller.dto;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AuditLogData {
	
	private Long auditId;
	private String user;
	private String defectId;
	private String status;
	
	 private static final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	    
	 Date date = new Date();
	 private String fixDate=sdf.format(date);
	 
	public Long getAuditId() {
		return auditId;
	}
	public void setAuditId(Long auditId) {
		this.auditId = auditId;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getDefectId() {
		return defectId;
	}
	public void setDefectId(String defectId) {
		this.defectId = defectId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getFixDate() {
		return fixDate;
	}
	public void setFixDate(String fixDate) {
		this.fixDate = fixDate;
	}


}