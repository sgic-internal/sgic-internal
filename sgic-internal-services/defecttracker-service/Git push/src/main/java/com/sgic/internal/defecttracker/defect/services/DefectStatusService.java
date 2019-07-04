package com.sgic.internal.defecttracker.defect.services;

import java.util.List;

import com.sgic.internal.defecttracker.defect.entities.DefectStatus;

public interface DefectStatusService {

	public Object createDefectStatus(DefectStatus defectStatus); // Create defect Status

	public boolean isDefectStatusAlreadyExists(Long id); // Check defect status is already exists

	DefectStatus findDefectStatusById(long id); // Get defect status by id

	List<DefectStatus> findAllDefectStatus(); // Get all defect status

	Boolean deleteDefectStatusById(long id); // Delete defect status by id

}
