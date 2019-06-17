package com.sgic.internal.defecttracker.defect.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sgic.internal.defecttracker.defect.entities.DefectType;
import com.sgic.internal.defecttracker.defect.repositories.DefectTypeRepository;
import com.sgic.internal.defecttracker.defect.services.DefectTypeService;

@Service
public class DefectTypeServiceImpl implements DefectTypeService{
	
	@Autowired
	private DefectTypeRepository defectTypeRepository;
	
	@Override
	public DefectType createDefectType(DefectType defectType) {
		DefectType responseDefectType = defectTypeRepository.save(defectType);
		return responseDefectType;
	}

	@Override
	@Transactional(readOnly = true)
	public boolean isDefectTypeAlreadyExists(Long id) {
		return defectTypeRepository.existsById(id);
	}
}
