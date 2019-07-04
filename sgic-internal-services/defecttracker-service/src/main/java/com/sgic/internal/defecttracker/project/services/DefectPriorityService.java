package com.sgic.internal.defecttracker.project.services;

import java.util.List;

import com.sgic.internal.defecttracker.project.entities.DefectPriority;


public interface DefectPriorityService {
	public Object createDefectPriority(DefectPriority defectPriority); // Create Defect Priority
	public boolean isDefectPriorityAlreadyExists(Long id); // Defect Priority already exists
	List<DefectPriority> findAllDefectPriority(); // Get All Defect Priority
	DefectPriority findDefecPriorityById(long id); // Get Defect Priority By Id
	Boolean deleteDefectPriorityById(long id); // Delete Defect Priority 

}
