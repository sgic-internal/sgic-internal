package com.sgic.internal.product.services.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sgic.internal.product.entities.DefectSeverity;
import com.sgic.internal.product.repositories.CompanyRepository;
import com.sgic.internal.product.repositories.SeverityRepo;
import com.sgic.internal.product.services.SeverityService;

@Service
public class SeverityServiceImpl implements SeverityService{

	@Autowired
	SeverityRepo severityRepo;
	
	private static Logger logger = LogManager.getLogger(CompanyRepository.class);
	
	@Override
	public DefectSeverity createDefectSeverity(DefectSeverity severity) {
		logger.info("service started -> Save DefectPriority");
		return severityRepo.save(severity);
	}

	@Override
	public DefectSeverity updateDefectSeverity(DefectSeverity severity) {
		logger.info("service started -> Update DefectSeverity");
		Long id = severity.getId();
		logger.info("service started -> getDefectSeverityId");
		boolean isExist = severityRepo.findDefectSeverityById(id) != null;
		if (isExist) {
			logger.info("service started -> Updated By DefectSeverityId");
			return severityRepo.save(severity);
		} else {
			logger.info("service started -> DefectSeverity Id Not Found");
		}
		return null;
	}

	@Override
	public DefectSeverity getDefectSeverityById(Long severityId) {
		logger.info("service started -> Get DefectSeverity Id");
		return severityRepo.findDefectSeverityById(severityId);
	}

	@Override
	public List<DefectSeverity> getAllDefectSeverity() {
		logger.info("service started -> Get All DefectSeverity");
		return severityRepo.findAll();
	}

	@Override
	public DefectSeverity deleteDefectSeverityById(Long severityId) {
		logger.info("service started -> Delete DefectSeverity");
		severityRepo.deleteById(severityId);
		return null;
	}

}
