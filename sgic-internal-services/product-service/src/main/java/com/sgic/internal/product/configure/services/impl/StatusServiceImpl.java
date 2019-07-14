package com.sgic.internal.product.configure.services.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.internal.product.configure.entities.DefectStatus;
import com.sgic.internal.product.configure.repository.StatusRepo;
import com.sgic.internal.product.configure.services.StatusService;

@Service
public class StatusServiceImpl implements StatusService {

	@Autowired
	StatusRepo statusRepo;

	private static Logger logger = LogManager.getLogger(DefectStatus.class);

	@Override
	public DefectStatus createDefectStatus(DefectStatus defectStatus) {
		logger.info("Defect Severity Service ->  Save Defect Status Method Started");
		try {
			return statusRepo.save(defectStatus);
		} catch (Exception ex) {
			logger.error("Defect Severity Service ERROR! -> " + ex.getMessage());
		} finally {
			logger.info("Defect Severity Service -> Save Defect Status Method Finished");
		}
		return null;
	}

	@Override
	public DefectStatus updateDefectStatus(DefectStatus defectStatus) {
		logger.info("Defect Severity Service ->  Update Defect Status Method Started");
		Long id = defectStatus.getId();
		try {
			boolean isExist = statusRepo.findDefectStatusById(id) != null;
			if (isExist) {
				logger.info("Defect Severity Service  -> Defect Status Id Found");
				return statusRepo.save(defectStatus);
			} else {
				logger.info("Defect Severity Service  -> Defect Status Id Not Found");
			}
		} catch (Exception ex) {
			logger.error("Defect Severity Service ERROR! -> " + ex.getMessage());
		} finally {
			logger.info("Defect Severity Service -> Update Defect Status Method Finished");
		}
		return null;
	}

	@Override
	public DefectStatus getDefectStatusById(Long severeId) {
		logger.info("Defect Severity Service ->  Get Defect Status By Id Method Started");
		try {
		return statusRepo.findDefectStatusById(severeId);
		} catch (Exception ex) {
			logger.error("Defect Severity Service ERROR! -> " + ex.getMessage());
		} finally {
			logger.info("Defect Severity Service -> Get Defect Status By Id Method Finished");
		}
		return null;
	}

	@Override
	public List<DefectStatus> getAllDefectStatus() {
		logger.info("Defect Severity Service ->  Get All Defect Status Method Started");
		try {
		return statusRepo.findAll();
		} catch (Exception ex) {
			logger.error("Defect Severity Service ERROR! -> " + ex.getMessage());
		} finally {
			logger.info("Defect Severity Service -> Get All  Defect Status Method Finished");
		}
		return null;
	}

	@Override
	public DefectStatus deleteDefectStatusById(Long severeId) {
		logger.info("Defect Severity Service ->  Delete Defect Status Method Started");
		try {
		statusRepo.deleteById(severeId);
		} catch (Exception ex) {
			logger.error("Defect Severity Service ERROR! -> " + ex.getMessage());
		} finally {
			logger.info("Defect Severity Service -> Delete Defect Status Method Finished");
		}
		return null;
	}

}
