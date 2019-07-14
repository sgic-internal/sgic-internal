package com.sgic.internal.product.configure.services.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.internal.product.configure.entities.DefectSeverity;
import com.sgic.internal.product.configure.repository.SeverityRepo;
import com.sgic.internal.product.configure.services.SeverityService;
import com.sgic.internal.product.repositories.CompanyRepository;

@Service
public class SeverityServiceImpl implements SeverityService {

	@Autowired
	SeverityRepo severityRepo;

	private static Logger logger = LogManager.getLogger(CompanyRepository.class);

	@Override
	public DefectSeverity createDefectSeverity(DefectSeverity severity) {
		logger.info("Severity Service INFO -> Create Defect Severity Method Started");
		try {
			logger.info("Severity Service INFO -> Save DefectPriority");
			return severityRepo.save(severity);
		} catch (Exception ex) {
			logger.error("Severity Service ERROR! -> " + ex.getMessage());
		} finally {
			logger.info("Severity Service INFO -> Create Defect Severity Method Finished");
		}
		return null;
	}

	@Override
	public DefectSeverity updateDefectSeverity(DefectSeverity severity) {
		logger.info("Severity Service INFO -> Update Defect Severity Method Started");
		try {
			Long id = severity.getId();
			logger.info("Severity Service INFO -> getDefectSeverityId");
			boolean isExist = severityRepo.findDefectSeverityById(id) != null;
			if (isExist) {
				logger.info("Severity Service INFO -> Updated By DefectSeverityId");
				return severityRepo.save(severity);
			} else {
				logger.warn("Severity Service INFO -> DefectSeverity Id Not Found");
			}
		} catch (Exception ex) {
			logger.error("Severity Service ERROR! -> " + ex.getMessage());
		} finally {
			logger.info("Severity Service INFO -> Update Defect Severity Method Finished");
		}
		return null;
	}

	@Override
	public DefectSeverity getDefectSeverityById(Long severityId) {
		logger.info("Severity Service INFO -> Get Defect Severity Id Method Started");
		try {
		logger.info("Severity Service INFO -> Get Defect Severity Id");
		return severityRepo.findDefectSeverityById(severityId);
		} catch (Exception ex) {
			logger.error("Severity Service ERROR! -> " + ex.getMessage());
		} finally {
			logger.info("Severity Service INFO -> Get Defect Severity Id Method Finished");
		}
		return null;
	}

	@Override
	public List<DefectSeverity> getAllDefectSeverity() {
		logger.info("Severity Service INFO -> Get All Defect Severity Method Started");
		try {
		logger.info("Severity Service INFO -> Get All Defect Severity");
		return severityRepo.findAll();
		} catch (Exception ex) {
			logger.error("Severity Service ERROR! -> " + ex.getMessage());
		} finally {
			logger.info("Severity Service INFO -> Get All Defect Severity Method Finished");
		}
		return null;
	}

	@Override
	public DefectSeverity deleteDefectSeverityById(Long severityId) {
		logger.info("Severity Service INFO -> Delete Defect Severity Method Started");
		try {
		logger.info("Severity Service INFO -> Delete Defect Severity");
		severityRepo.deleteById(severityId);
		} catch (Exception ex) {
			logger.error("Severity Service ERROR! -> " + ex.getMessage());
		} finally {
			logger.info("Severity Service INFO -> Delete Defect Severity Method Finished");
		}
		return null;
	}

}
