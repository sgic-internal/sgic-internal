package com.sgic.internal.product.services;

import java.util.List;
import com.sgic.internal.product.entities.DefectType;

public interface TypeService {
	// Create DefectType
	public DefectType createDefectType(DefectType defectType);
	// Update DefectType
	public DefectType updateDefectType(DefectType defectType);
	// Get DefectType By Id
	public DefectType getDefectTypeById(Long typeId);
	// Get All DefectType 
	public List<DefectType> getAllDefectType();
	// Delete DefectType Id
	public DefectType deleteDefectTypeById(Long typeId);
}
