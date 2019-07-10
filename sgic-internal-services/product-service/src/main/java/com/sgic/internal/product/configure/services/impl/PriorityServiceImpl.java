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
public class PriorityServiceImpl implements PriorityService{

	@Autowired
	PriorityRepo priorityRepo;
	
	private static Logger logger = LogManager.getLogger(CompanyRepository.class);
	
	@Override
	public DefectPriority createDefectPriority(DefectPriority defectPriority) {
		logger.info("service started -> Save DefectPriority");
		return priorityRepo.save(defectPriority);
	}

	@Override
	public DefectPriority updateDefectPriority(DefectPriority defectPriority) {
		logger.info("service started -> Update DefectPriority");
		Long id = defectPriority.getId();
		logger.info("service started -> getDefectPriorityId");
		boolean isExist = priorityRepo.findDefectPriorityById(id) != null;
		if (isExist) {
			logger.info("service started -> Updated By DefectPriorityId");
			return priorityRepo.save(defectPriority);
		} else {
			logger.info("service started -> DefectPriority Id Not Found");
		}
		return null;
	}

	@Override
	public DefectPriority getDefectPriorityById(Long priorityId) {
		logger.info("service started -> Get DefectPriority Id");
		return priorityRepo.findDefectPriorityById(priorityId);
	}

	@Override
	public List<DefectPriority> getAllDefectPriority() {
		logger.info("service started -> Get All DefectPriority");
		return priorityRepo.findAll();
	}

	@Override
	public DefectPriority deleteDefectPriorityById(Long priorityId) {
		logger.info("service started -> Delete DefectPriority");
		priorityRepo.deleteById(priorityId);
		return null;
	}

}
