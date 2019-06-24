package com.sgic.internal.defecttracker.defect.services.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.sgic.internal.defecttracker.defect.entities.Defect;
import com.sgic.internal.defecttracker.defect.repositories.DefectRepository;
import com.sgic.internal.defecttracker.defect.services.DefectService;

@Service
public class DefectServiceImpl implements DefectService {
	@Autowired
	private DefectRepository defectRepository;
	
	private static Logger logger = LogManager.getLogger(DefectRepository.class);

	@Override
	public Defect createDefect(Defect defect) {
	    logger.info("DefectService started -> SaveAllDefects");
		return defectRepository.save(defect);
	}

	@Override
	public Defect getByDefectId(String defectId) {
		logger.info("DefectService started -> GetAllDefectById");
		return defectRepository.getByDefectId(defectId);
	}

	@Override
	public Defect updateDefectStatus(int statusId) {
		
		return null;
	}

	@Override
	public Defect updateReassignTo(String reassignTo) {

		return null;
	}

	@Override
	public Defect updateDefectComment(int commentId) {
		
		return null;
	}

	@Override
	public Defect updateDefectAttachment(int attachmentId) {
		
		return null;
	}

	@Override
	public Defect deleteDefect(String defectId) {
	     logger.info("DefectService started -> DeleteDefectById");
		 defectRepository.delete(defectId);
		 return null;
	}

	@Override
	public List<Defect> getAllDefects() {
	    logger.info("DefectService started -> ListAllDefects");
		return defectRepository.findAll() ;
	}

	@Override
	public List<Defect> getAllDefectByStatus(int statusId) {
		logger.info("DefectService started -> getAllDefectByStatus");
		return defectRepository.getByStatusId(statusId);
	}

	@Override
	public List<Defect> getProjectById(String projectId) {
		logger.info("DefectService started -> getProjectById");
		return defectRepository.getByProjectId(projectId);
	}

	@Override
	public List<Defect> getModuleById(String moduleId) {
		logger.info("DefectService started -> getModuleById");
		return defectRepository.getByModuleId(moduleId);
	}

	@Override
	public List<Defect> getAllSeverityById(int severityId) {
		logger.info("DefectService started -> getAllSeverityById");
		return defectRepository.getBySeverityId(severityId);
	}

	@Override
	public List<Defect> getAllPriorityById(int priorityId) {
		logger.info("DefectService started -> getAllPriorityById");
		return defectRepository.getByPriorityId(priorityId);
	}

	@Override
	public boolean isDefectAlreadyExist(String defectId) {
		logger.info("DefectService started -> isDefectAlreadyExist");
		return defectRepository.exists(defectId);
	}

	@Override
	public List<Defect> getDefectByDate(Date dateAndTime) {
		logger.info("DefectService started -> getDefectByDate");
		return defectRepository.getByDefectDate(dateAndTime);
	}

}
