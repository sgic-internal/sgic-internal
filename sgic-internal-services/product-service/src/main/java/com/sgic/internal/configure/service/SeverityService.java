package com.sgic.internal.configure.service;

import java.util.List;

import com.sgic.internal.configure.entities.Severity;

public interface SeverityService {
	
	public Severity createSeverity(Severity severity);
	public Severity updateSeverity(Severity severity);
	public Severity getSeverityById(Long severeId);
	public List<Severity> getAllSeverity();
	public Severity deleteSeverityById(Long severeId);

}
