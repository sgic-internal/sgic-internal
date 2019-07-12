package com.sgic.internal.product.configure.services;

import java.util.List;

import com.sgic.internal.product.configure.entities.DefectSeverity;

public interface SeverityService {
	// Create DefectSeverity
	public DefectSeverity createDefectSeverity(DefectSeverity severity);
	// Update DefectSeverity
	public DefectSeverity updateDefectSeverity(DefectSeverity severity);
	// Get DefectSeverity By Id
	public DefectSeverity getDefectSeverityById(Long severityId);
	// Get All DefectSeverity 
	public List<DefectSeverity> getAllDefectSeverity();
	// Delete DefectSeverity Id
	public DefectSeverity deleteDefectSeverityById(Long severityId);

}
