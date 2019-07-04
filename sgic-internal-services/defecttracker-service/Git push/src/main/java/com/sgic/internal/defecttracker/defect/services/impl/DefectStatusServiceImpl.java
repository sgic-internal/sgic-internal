package com.sgic.internal.defecttracker.defect.services.impl;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sgic.internal.defecttracker.defect.entities.DefectStatus;

import com.sgic.internal.defecttracker.defect.repositories.DefectStatusRepository;

import com.sgic.internal.defecttracker.defect.services.DefectStatusService;

@Service
public class DefectStatusServiceImpl implements DefectStatusService {

	@Autowired

	private DefectStatusRepository defectStatusRepository;

	private static Logger logger = LogManager.getLogger(DefectStatusServiceImpl.class);

	// Create defect status implementation
	@Override
	public Object createDefectStatus(DefectStatus defectStatus) {
		logger.info("Create Defect Status Service Implementation");
		return defectStatusRepository.save(defectStatus);
	}

	// Defect status exists implementation
	@Override
	@Transactional(readOnly = true)
	public boolean isDefectStatusAlreadyExists(Long id) {
		logger.info("Defect Status Exists Service Implementation");
		return defectStatusRepository.existsById(id);
	}

	// List all defect status implementation
	@Override
	public List<DefectStatus> findAllDefectStatus() {
		List<DefectStatus> defectStatuses = defectStatusRepository.findAll();
		logger.info("List All  Defect Status Service Implementation");
		return defectStatuses;

	}

	// Delete defect status implementation
	@Override
	public Boolean deleteDefectStatusById(long id) {
		logger.info("Delete Defect Status Service Implementation");
		defectStatusRepository.deleteById(id);
		return true;
	}

	// Find defect status by implementation
	@Override
	public DefectStatus findDefectStatusById(long id) {
		logger.info("Get Defect Status By Id Service Implementation");
		return defectStatusRepository.findById(id).orElse(null);
	}

}
