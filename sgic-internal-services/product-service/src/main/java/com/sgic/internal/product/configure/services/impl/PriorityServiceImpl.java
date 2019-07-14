package com.sgic.internal.product.configure.services.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.internal.product.configure.entities.DefectPriority;
import com.sgic.internal.product.configure.repository.PriorityRepo;
import com.sgic.internal.product.configure.services.PriorityService;
import com.sgic.internal.product.repositories.CompanyRepository;

@Service
public class PriorityServiceImpl implements PriorityService {

	@Autowired
	PriorityRepo priorityRepo;

	private static Logger logger = LogManager.getLogger(CompanyRepository.class);

	@Override
	public DefectPriority createDefectPriority(DefectPriority defectPriority) {
		logger.info("Priority Service INFO -> Create Defect Priority Method Started");
		try {
			logger.info("Priority service INFO -> Save DefectPriority");
			return priorityRepo.save(defectPriority);
		} catch (Exception ex) {
			logger.error("Priority Service ERROR! -> " + ex.getMessage());
		} finally {
			logger.info("Priority Service INFO -> Create Defect Priority Method Finished");
		}
		return null;
	}

	@Override
	public DefectPriority updateDefectPriority(DefectPriority defectPriority) {
		logger.info("Priority Service INFO -> Update Defect Priority Method Started");
		try {
			Long id = defectPriority.getId();
			boolean isExist = priorityRepo.findDefectPriorityById(id) != null;
			if (isExist) {
				logger.info("Priority Service started -> Defect Priority Id Found");
				logger.info("Priority Service INFO ->  Defect Priority Updated ");
				return priorityRepo.save(defectPriority);
			} else {
				logger.warn("Priority Service WARNING! -> Defect Priority Id Not Found");
			}
		} catch (Exception ex) {
			logger.error("Priority Service ERROR! -> " + ex.getMessage());
		} finally {
			logger.info("Priority service INFO -> Update Defect Priority Method Finished");
		}
		return null;
	}

	@Override
	public DefectPriority getDefectPriorityById(Long priorityId) {
		logger.info("Priority Service INFO -> Get Defect Priority By Id Method Started");
		try {
		logger.info("Priority Service INFO -> Get Defect Priority Id");
		return priorityRepo.findDefectPriorityById(priorityId);
		} catch (Exception ex) {
			logger.error("Priority Service ERROR! -> " + ex.getMessage());
		} finally {
			logger.info("Priority service INFO -> Get Defect Priority By Id Method Finished");
		}
		return null;
	}

	@Override
	public List<DefectPriority> getAllDefectPriority() {
		logger.info("Priority Service INFO -> Get All Defect Priority Method Started");
		try {
		logger.info("Priority Service INFO -> Get All DefectPriority");
		return priorityRepo.findAll();
		} catch (Exception ex) {
			logger.error("Priority Service ERROR! -> " + ex.getMessage());
		} finally {
			logger.info("Priority service INFO -> Get All Defect Priority Method Finished");
		}
		return null;
	}

	@Override
	public DefectPriority deleteDefectPriorityById(Long priorityId) {
		logger.info("Priority Service INFO -> Delete Defect Priority Method Started");
		try {
		logger.info("Priority Service INFO -> Delete DefectPriority");
		priorityRepo.deleteById(priorityId);
		} catch (Exception ex) {
			logger.error("Priority Service ERROR! -> " + ex.getMessage());
		} finally {
			logger.info("Priority service INFO -> Delete Defect Defect Priority Method Finished");
		}
		return null;
	}

}
