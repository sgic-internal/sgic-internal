package com.sgic.internal.product.configure.services;

import java.util.List;

import com.sgic.internal.product.configure.entities.DefectSeverity;

public interface SeverityService {
	
	public DefectSeverity createSeverity(DefectSeverity severity);
	public DefectSeverity updateSeverity(DefectSeverity severity);
	public DefectSeverity getSeverityById(Long severeId);
	public List<DefectSeverity> getAllSeverity();
	public DefectSeverity deleteSeverityById(Long severeId);

}
