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
	public Defect getByDefectId(String defectId) {
		logger.info("DefectService started -> GetAllDefectById");
		return defectRepository.getByDefectId(defectId);
	}
	
	@Override
	public Defect updateDefect(Defect defect) {
	
		logger.info("DefectService started -> updateDefect");
		String defectId=defect.getDefectId();
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
	public Defect deleteDefect(String defectId) {
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
	public boolean isDefectAlreadyExist(String defectId) {
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

	@Override
	public List<Defect> getDefectByStatus(String status) {
		logger.info("DefectService started -> getDefectByStatus");
		return defectRepository.getByStatus(status);
	}

	@Override
	public List<Defect> getDefectByPriority(String priority) {
		logger.info("DefectService started -> getDefectByPriority");
		return defectRepository.getByPriority(priority);
	}

	@Override
	public List<Defect> getDefectBySeverity(String severity) {
		logger.info("DefectService started -> getDefectBySeverity");
		return defectRepository.getBySeverity(severity);
	}

	@Override
	public List<Defect> getDefectByType(String type) {
		logger.info("DefectService started -> getDefectByType");
		return defectRepository.getByType(type);
	}

	@Override
	public Long countDefect() {
		Long totCount = defectRepository.count();
		System.out.println("total count " +totCount);
		Long totRejCount = defectRepository.countByStatus("rejected");
		System.out.println("rejected count " +totRejCount);
		Long ratio =(( totCount-totRejCount)*100)/100;
		System.out.println("ratio " +ratio);
		return ratio;
	}

	@Override
	public double countDefectDensity() {
		
		double kloc= 5000;
		double defectCount=defectRepository.count();
		System.out.println("Total count :"+defectCount);
		double defectDen=defectCount *(1000/kloc);
		System.out.println("Ratio :"+defectDen);
		return defectDen;
	}


	
}
