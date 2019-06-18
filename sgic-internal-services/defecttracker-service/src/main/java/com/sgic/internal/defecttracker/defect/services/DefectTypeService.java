package com.sgic.internal.defecttracker.defect.services;

import java.util.List;
import java.util.Optional;

import com.sgic.internal.defecttracker.defect.entities.DefectType;

public interface DefectTypeService {
	public DefectType createDefectType(DefectType defectType);
	public boolean isDefectTypeAlreadyExists(Long id);
	List<DefectType> findAll();
	Optional<DefectType> findDefectTypeById(long id);
	void deleteDefectTypeById(long id);
	
}
