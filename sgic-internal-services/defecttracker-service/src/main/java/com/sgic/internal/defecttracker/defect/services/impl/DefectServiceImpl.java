package com.sgic.internal.defecttracker.defect.services.impl;

import java.sql.Date;
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
	public Defect getByDefectId(Long defectId) {
		logger.info("DefectService started -> GetAllDefectById");
		return defectRepository.getByDefectId(defectId);
	}
	
	@Override
	public Defect updateDefect(Defect defect) {
	
		logger.info("DefectService started -> updateDefect");
		Long defectId=defect.getDefectId();
		logger.info("DefectService started -> getDefectId");
		boolean isExist = defectRepository.getByDefectId(defectId)!= null;
		if (isExist) {
			logger.info("DefectService started -> Updateed By DefectId");
			return defectRepository.save(defect);
		} else {
			logger.info("DefectService started -> DefectId Not Found");
		}
		return null;
	}
	
	@Override
	public Defect deleteDefect(Long defectId) {
	     logger.info("DefectService started -> DeleteDefectById");
		 defectRepository.deleteById(defectId);
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
	public List<Defect> getProjectById(Long projectId) {
		logger.info("DefectService started -> getProjectById");
		return defectRepository.getByProjectId(projectId);
	}

	@Override
	public List<Defect> getModuleById(Long moduleId) {
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
	public boolean isDefectAlreadyExist(Long defectId) {
		logger.info("DefectService started -> isDefectAlreadyExist");
		return defectRepository.existsById(defectId);
	}

	@Override
	public List<Defect> getDefectByDate(Date dateAndTime) {
		logger.info("DefectService started -> getDefectByDate");
		return defectRepository.getByDefectDate(dateAndTime);
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
	public List<Defect> getDefectByAvailableIn(String availableIn) {
		logger.info("DefectService started -> getDefectByAvailableIn");
		return defectRepository.getByAvailableIn(availableIn);
	}

	@Override
	public List<Defect> getDefectByFoundIn(String foundIn) {
		logger.info("DefectService started -> getDefectByFoundIn");
		return defectRepository.getByFoundIn(foundIn);
	}

	@Override
	public List<Defect> getDefectByFixedIn(String fixedIn) {
		logger.info("DefectService started -> getDefectByfixedIn");
		return defectRepository.getByFixedIn(fixedIn);
	}


	
}
