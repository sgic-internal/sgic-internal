package com.sgic.internal.product.services.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sgic.internal.product.entities.DefectType;
import com.sgic.internal.product.repositories.CompanyRepository;
import com.sgic.internal.product.repositories.TypeRepo;
import com.sgic.internal.product.services.TypeService;

@Service
public class TypeServiceImpl implements TypeService{

	@Autowired
	TypeRepo typeRepo;
	
	private static Logger logger = LogManager.getLogger(CompanyRepository.class);
		
	@Override
	public DefectType createDefectType(DefectType defectType) {
		logger.info("service started -> Get DefectType Id");
		return typeRepo.save(defectType);
	}

	@Override
	public DefectType updateDefectType(DefectType defectType) {
		logger.info("service started -> Update DefectType");
		Long id = defectType.getId();
		logger.info("service started -> getDefectTypeId");
		boolean isExist = typeRepo.findDefectTypeById(id) != null;
		if (isExist) {
			logger.info("service started -> Updated By DefectTypeId");
			return typeRepo.save(defectType);
		} else {
			logger.info("service started -> DefectType Id Not Found");
		}
		return null;
	}

	@Override
	public DefectType getDefectTypeById(Long typeId) {
		logger.info("service started -> Get DefectType Id");
		return typeRepo.findDefectTypeById(typeId);
	}

	@Override
	public List<DefectType> getAllDefectType() {
		logger.info("service started -> Get All DefectType");
		return typeRepo.findAll();
	}

	@Override
	public DefectType deleteDefectTypeById(Long typeId) {
		logger.info("service started -> Delete DefectType");
		typeRepo.deleteById(typeId);
		return null;
	}

}
