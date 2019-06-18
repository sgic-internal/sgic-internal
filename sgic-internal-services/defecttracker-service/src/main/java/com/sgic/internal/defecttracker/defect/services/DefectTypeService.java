package com.sgic.internal.defecttracker.defect.services;

import java.util.Optional;

import com.sgic.internal.defecttracker.defect.entities.DefectType;

public interface DefectTypeService {
	public DefectType createDefectType(DefectType defectType);
	public boolean isDefectTypeAlreadyExists(Long id);
	void deleteDefectTypeById(long id);
	Optional<DefectType> findDefectTypeById(long id);
}
