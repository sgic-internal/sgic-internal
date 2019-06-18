package com.sgic.internal.defecttracker.defect.services;

import java.util.List;
import java.util.Optional;

import com.sgic.internal.defecttracker.defect.entities.DefectType;

public interface DefectTypeService {
	public Object createDefectType(DefectType defectType);
	public boolean isDefectTypeAlreadyExists(Long id);
	List<DefectType> findAllDefectType();
	DefectType findDefectTypeById(long id);
	Boolean deleteDefectTypeById(long id);
	
}
