package com.sgic.internal.defecttracker.defect.controller.dto.mapper;

import java.sql.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.internal.defecttracker.defect.controller.dto.DefectData;
import com.sgic.internal.defecttracker.defect.controller.dto.converter.DefectDataConverter;
import com.sgic.internal.defecttracker.defect.entities.Defect;
import com.sgic.internal.defecttracker.defect.services.DefectService;

@Service
public class DefectDataMapper {
	@Autowired
	private DefectDataConverter defectDataConverter;
	
	@Autowired
	private DefectService defectService;
	
	private static Logger logger = LogManager.getLogger(DefectData.class);
	
	@SuppressWarnings("static-access")
	public Defect createDefect(DefectData defectData) {
		logger.info("DefectData Mapper -> Defect Saved");
		return defectService.createDefect(defectDataConverter.defectDataToDefectEntity(defectData));
	}
	
	@SuppressWarnings("static-access")
	public List <DefectData>getAllDefects(){
		logger.info("DefectData Mapper -> Defect List");
		List<Defect> defectList= defectService.getAllDefects();
		return defectDataConverter.defectEntityToDefectData(defectList);	
		
	}
	
	public DefectData deleteDefect(String defectId) {
		logger.info("DefectData Mapper -> Defect deleted");
		defectService.deleteDefect(defectId);
		return null;
		
	}
	
	@SuppressWarnings("static-access")
	public DefectData getByDefectId(String defectId) {
		logger.info("DefectData Mapper -> getByDefectId");
		Defect defect= defectService.getByDefectId(defectId);
		return defectDataConverter.defectEntityToDefectData(defect);
	}
	

	@SuppressWarnings("static-access")
	public Defect updateDefect(DefectData defectData) {
		logger.info("DefectData Mapper -> Defect Details Updated ", defectData.getDefectId());
		return defectService.updateDefect(defectDataConverter.defectDataToDefectEntity(defectData));
	}
	
	@SuppressWarnings("static-access")
	public List<DefectData> getAllDefectByStatus(int statusId){
		logger.info("DefectData Mapper -> Defect List by stutusId");
		List<Defect> defactStatus=defectService.getAllDefectByStatus(statusId);
		return defectDataConverter.defectEntityToDefectData(defactStatus);
		
	}
	
	@SuppressWarnings("static-access")
	public List<DefectData> getAllDefectByProjectById(String projectId){
		logger.info("DefectData Mapper -> Defect List by productId");
		List<Defect> defectProject=defectService.getProjectById(projectId);
		return defectDataConverter.defectEntityToDefectData(defectProject);
	}
	
	@SuppressWarnings("static-access")
	public List<DefectData> getAllDefactByModuleById(String moduleId){
		logger.info("DefectData Mapper -> Defect List by moduleId");
		List<Defect> defectModule=defectService.getModuleById(moduleId);
		return defectDataConverter.defectEntityToDefectData(defectModule);
		
	}
	@SuppressWarnings("static-access")
	public List<DefectData> getAllDefactBySeverityById(int severityId){
		logger.info("DefectData Mapper -> Defect List by SeverityId ");
		List<Defect> defectSeverity=defectService.getAllSeverityById(severityId);
		return defectDataConverter.defectEntityToDefectData(defectSeverity);
	}
	
	@SuppressWarnings("static-access")
	public List<DefectData> getAllDefactByPriorityById(int priorityId){
		logger.info("DefectData Mapper -> Defect List by priorityId ");
		List<Defect> defectPriority=defectService.getAllPriorityById(priorityId);
		return defectDataConverter.defectEntityToDefectData(defectPriority);
		
	}
	
	@SuppressWarnings("static-access")
	public List<DefectData> getAllDefactByData(String dateAndTime){
		logger.info("DefectData Mapper -> Defect List by dateandTimeId ");
		List<Defect> defectDateandTime=defectService.getDefectByDate(dateAndTime);
		return defectDataConverter.defectEntityToDefectData(defectDateandTime);
	}
	
}
