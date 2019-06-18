package com.sgic.internal.defecttracker.defect.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sgic.internal.defecttracker.defect.entities.DefectType;
import com.sgic.internal.defecttracker.defect.repositories.DefectTypeRepository;
import com.sgic.internal.defecttracker.defect.services.DefectTypeService;

@Service
public class DefectTypeServiceImpl implements DefectTypeService {

	@Autowired
	private DefectTypeRepository defectTypeRepository;

	@Override
	public Object createDefectType(DefectType defectType) {
		return defectTypeRepository.save(defectType);
	}

	@Override
	@Transactional(readOnly = true)
	public boolean isDefectTypeAlreadyExists(Long id) {
		return defectTypeRepository.existsById(id);
	}

	@Override
	public List<DefectType> findAll() {
		List<DefectType> defectTypes = defectTypeRepository.findAll();
		return defectTypes;
	}

	@Override
	public Boolean deleteDefectTypeById(long id) {
		defectTypeRepository.deleteById(id);
		return true;

	}

	@Override
	public DefectType findDefectTypeById(long id) {
		return defectTypeRepository.findById(id).orElse(null);
	}
}
