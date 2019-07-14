package com.sgic.internal.product.configure.services.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.internal.product.configure.entities.DefectType;
import com.sgic.internal.product.configure.repository.TypeRepo;
import com.sgic.internal.product.configure.services.TypeService;
import com.sgic.internal.product.repositories.CompanyRepository;

@Service
public class TypeServiceImpl implements TypeService{

	@Autowired
	TypeRepo typeRepo;
	
	private static Logger logger = LogManager.getLogger(CompanyRepository.class);
		
	@Override
	public DefectType createDefectType(DefectType defectType) {
		logger.info("Defect Type Service ->  Save Defect Type Method Started");
		try {
		return typeRepo.save(defectType);
		} catch (Exception ex) {
			logger.error("Defect Type Service ERROR! -> " + ex.getMessage());
		} finally {
			logger.info("Defect Type Service -> Save Defect Type Method Finished");
		}
		return null;
	}

	@Override
	public DefectType updateDefectType(DefectType defectType) {
		logger.info("Defect Type Service ->  Save Defect Type Method Started");
		try {
		Long id = defectType.getId();
		boolean isExist = typeRepo.findDefectTypeById(id) != null;
		if (isExist) {
			logger.info("Defect Severity Service  -> Defect Type Id Found, Type Id : "+id);
			return typeRepo.save(defectType);
		} else {
			logger.info("Defect Severity Service  -> Defect Type Id Not Found, Type Id :"+id);
		}
		} catch (Exception ex) {
			logger.error("Defect Type Service ERROR! -> " + ex.getMessage());
		} finally {
			logger.info("Defect Type Service -> Save Defect Type Method Finished");
		}
		return null;
	}

	@Override
	public DefectType getDefectTypeById(Long typeId) {
		logger.info("Defect Type Service ->  Get Defect Type By Id Method Started");
		try {
		return typeRepo.findDefectTypeById(typeId);
		} catch (Exception ex) {
			logger.error("Defect Type Service ERROR! -> " + ex.getMessage());
		} finally {
			logger.info("Defect Type Service -> Get Defect Type By Id Method Finished");
		}
		return null;
	}

	@Override
	public List<DefectType> getAllDefectType() {
		logger.info("Defect Type Service ->  Get All Defect Type Method Started");
		try {
		return typeRepo.findAll();
		} catch (Exception ex) {
			logger.error("Defect Type Service ERROR! -> " + ex.getMessage());
		} finally {
			logger.info("Defect Type Service -> Get All Defect Type Method Finished");
		}
		return null;
	}

	@Override
	public DefectType deleteDefectTypeById(Long typeId) {
		logger.info("Defect Type Service ->  Delete Defect Type By Id Method Started");
		try {
		typeRepo.deleteById(typeId);
		} catch (Exception ex) {
			logger.error("Defect Type Service ERROR! -> " + ex.getMessage());
		} finally {
			logger.info("Defect Type Service -> Delete Defect Type By Id Method Finished");
		}
		return null;
	}

}
