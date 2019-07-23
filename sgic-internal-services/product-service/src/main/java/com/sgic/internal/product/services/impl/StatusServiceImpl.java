package com.sgic.internal.product.services.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sgic.internal.product.entities.DefectStatus;
import com.sgic.internal.product.repositories.CompanyRepository;
import com.sgic.internal.product.repositories.StatusRepo;
import com.sgic.internal.product.services.StatusService;

@Service
public class StatusServiceImpl implements StatusService{

	@Autowired
	StatusRepo statusRepo;
	
	private static Logger logger = LogManager.getLogger(CompanyRepository.class);
	
	@Override
	public DefectStatus createDefectStatus(DefectStatus defectStatus) {
		logger.info("service started -> Save DefectStatus");
		return statusRepo.save(defectStatus);
	}

	@Override
	public DefectStatus updateDefectStatus(DefectStatus defectStatus) {
		logger.info("service started -> Update DefectStatus");
		Long id = defectStatus.getId();
		logger.info("service started -> getDefectStatusId");
		boolean isExist = statusRepo.findDefectStatusById(id) != null;
		if (isExist) {
			logger.info("service started -> Updated By DefectStatusId");
			return statusRepo.save(defectStatus);
		} else {
			logger.info("service started -> DefectStatus Id Not Found");
		}
		return null;
	}

	@Override
	public DefectStatus getDefectStatusById(Long severeId) {
		logger.info("service started -> Get DefectStatus Id");
		return statusRepo.findDefectStatusById(severeId);
	}

	@Override
	public List<DefectStatus> getAllDefectStatus() {
		logger.info("service started -> Get All DefectStatus");
		return statusRepo.findAll();
	}

	@Override
	public DefectStatus deleteDefectStatusById(Long severeId) {
		logger.info("service started -> Delete DefectStatus");
		statusRepo.deleteById(severeId);
		return null;
	}

}
