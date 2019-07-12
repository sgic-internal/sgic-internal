package com.sgic.internal.defecttracker.defect.services;

import java.util.List;

import com.sgic.internal.defecttracker.defect.entities.DefectSeverity;

public interface DefectSeverityService {
	public Object createDefectSeverity(DefectSeverity defectSeverity); // Create Defect Severity
	public boolean isDefectSeverityAlreadyExists(Long id); // Defect Severity already exists
	List<DefectSeverity> findAllDefectSeverities(); // Get All Defect Severity
	DefectSeverity findDefectSeverityById(long id); // Get Defect Severity By Id
	Boolean deleteDefectSeverityById(long id); // Delete Defect Severity 
}
