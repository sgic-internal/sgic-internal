package com.sgic.internal.product.services;

import java.util.List;
import com.sgic.internal.product.entities.DefectStatus;

public interface StatusService {
	// Create DefectStatus
	public DefectStatus createDefectStatus(DefectStatus defectStatus);
	// Update DefectStatus
	public DefectStatus updateDefectStatus(DefectStatus defectStatus);
	// Get DefectStatus By Id
	public DefectStatus getDefectStatusById(Long severeId);
	// Get All DefectStatus 
	public List<DefectStatus> getAllDefectStatus();
	// Delete DefectStatus Id
	public DefectStatus deleteDefectStatusById(Long severeId);
}
