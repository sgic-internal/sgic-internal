package com.sgic.internal.defecttracker.project.services.impl;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sgic.internal.defecttracker.project.entities.DefectType;
import com.sgic.internal.defecttracker.project.repositories.DefectTypeRepository;
import com.sgic.internal.defecttracker.project.services.DefectTypeService;

@Service
public class DefectTypeServiceImpl implements DefectTypeService {

	@Autowired
	private DefectTypeRepository defectTypeRepository;
	
	private static Logger logger = LogManager.getLogger(DefectTypeServiceImpl.class);

	// Create defect type service implementation
	@Override
	public Object createDefectType(DefectType defectType) {
		//logger.info("Create Defect Type Service Implementation");
		return defectTypeRepository.save(defectType);
	}

	// Defect type exists implementation
	@Override
	@Transactional(readOnly = true)
	public boolean isDefectTypeAlreadyExists(Long id) {
		//logger.info("Defect Type Exists Service Implementation");
		return defectTypeRepository.existsById(id);
	}

	// List all defect types implementation
	@Override
	public List<DefectType> findAllDefectType() {
		List<DefectType> defectTypes = defectTypeRepository.findAll();
		//logger.info("List All Defect Types Service Implementation");
		return defectTypes;
	}

	// Delete defect type implementation
	@Override
	public Boolean deleteDefectTypeById(long id) {
		defectTypeRepository.deleteById(id);
		//logger.info("Delete Defect Type Service Implementation");
		return true;
	}

	// Find defect type by id implementation
	@Override
	public DefectType findDefectTypeById(long id) {
		//logger.info("Get Defect Type By Id Service Implementation");
		return defectTypeRepository.findById(id).orElse(null);
	}
}
