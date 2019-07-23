package com.sgic.internal.product.services;

import java.util.List;
import com.sgic.internal.product.entities.DefectPriority;

public interface PriorityService {
	// Create DefectPriority
	public DefectPriority createDefectPriority(DefectPriority defectPriority);
	// Update DefectPriority
	public DefectPriority updateDefectPriority(DefectPriority defectPriority);
	// Get DefectPriority By Id
	public DefectPriority getDefectPriorityById(Long priorityId);
	// Get All DefectPriority 
	public List<DefectPriority> getAllDefectPriority();
	// Delete DefectPriority Id
	public DefectPriority deleteDefectPriorityById(Long priorityId);
}
