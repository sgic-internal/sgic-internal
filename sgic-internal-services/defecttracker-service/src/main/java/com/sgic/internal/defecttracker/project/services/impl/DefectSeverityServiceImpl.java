package com.sgic.internal.defecttracker.project.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.internal.defecttracker.project.entities.DefectSeverity;
import com.sgic.internal.defecttracker.project.repositories.DefectSeverityRepository;
import com.sgic.internal.defecttracker.project.services.DefectSeverityService;


@Service
public class DefectSeverityServiceImpl implements DefectSeverityService{

	@Autowired
	private DefectSeverityRepository defectSeverityRepository;
	
	// Create defect severity service implementation
	@Override
	public Object createDefectSeverity(DefectSeverity defectSeverity) {
		return defectSeverityRepository.save(defectSeverity);
	}

	// Defect severity already exists service implementation
	@Override
	public boolean isDefectSeverityAlreadyExists(Long id) {
		return defectSeverityRepository.existsById(id);
	}

	// Get all defect severity service implementation
	@Override
	public List<DefectSeverity> findAllDefectSeverities() {
		return defectSeverityRepository.findAll();
	}

	// Defect severity get by id service implementation
	@Override
	public DefectSeverity findDefectSeverityById(long id) {
		return defectSeverityRepository.findById(id).orElse(null);
	}

	// Delete defect severity service implementation
	@Override
	public Boolean deleteDefectSeverityById(long id) {
		defectSeverityRepository.deleteById(id);
		return true;
	}
	
}
