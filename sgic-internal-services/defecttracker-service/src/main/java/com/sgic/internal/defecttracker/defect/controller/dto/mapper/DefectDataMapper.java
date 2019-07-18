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
	public List<DefectData> getAllDefectByProjectById(String projectId){
		logger.info("DefectData Mapper -> Defect List by productId");
		List<Defect> defectProject=defectService.getProjectById(projectId);
		return defectDataConverter.defectEntityToDefectData(defectProject);
	}
	
	@SuppressWarnings("static-access")
	public List<DefectData> getAllDefectByModuleById(String moduleId){
		logger.info("DefectData Mapper -> Defect List by moduleId");
		List<Defect> defectModule=defectService.getModuleById(moduleId);
		return defectDataConverter.defectEntityToDefectData(defectModule);
		
	}
	
	
	@SuppressWarnings("static-access")
	public List<DefectData> getAllDefectByDate(Date dateAndTime){
		logger.info("DefectData Mapper -> Defect List by dateandTimeId ");
		List<Defect> defectDateandTime=defectService.getDefectByDate(dateAndTime);
		return defectDataConverter.defectEntityToDefectData(defectDateandTime);
	}
	
	@SuppressWarnings("static-access")
	public List<DefectData> getAllDefectByAvailableIn(String availableIn){
		List<Defect> defectAvailableIn=defectService.getDefectByAvailableIn(availableIn);
		return defectDataConverter.defectEntityToDefectData(defectAvailableIn);
		
	}
	@SuppressWarnings("static-access")
	public List<DefectData> getAllDefectByFoundIn(String foundIn){
		List<Defect> defectFoundIn=defectService.getDefectByFoundIn(foundIn);
		return defectDataConverter.defectEntityToDefectData(defectFoundIn);
		
	}
	@SuppressWarnings("static-access")
	public List<DefectData> getAllDefectByFixedIn(String fixedIn){
		List<Defect> defectFixedIn=defectService.getDefectByFixedIn(fixedIn);
		return defectDataConverter.defectEntityToDefectData(defectFixedIn);
		
	}
	@SuppressWarnings("static-access")
	public List<DefectData> getAllDefectByStatus(String status) {
		List<Defect> defectStatus=defectService.getDefectByStatus(status);
		return defectDataConverter.defectEntityToDefectData(defectStatus);
	}
	@SuppressWarnings("static-access")
	public List<DefectData> getAllDefectByPriority(String priority) {
		List<Defect> defectPriority=defectService.getDefectByPriority(priority);
		return defectDataConverter.defectEntityToDefectData(defectPriority);
	}
	@SuppressWarnings("static-access")
	public List<DefectData> getAllDefectBySeverity(String severity) {
		List<Defect> defectSeverity=defectService.getDefectBySeverity(severity);
		return defectDataConverter.defectEntityToDefectData(defectSeverity);
	}
	@SuppressWarnings("static-access")
	public List<DefectData> getAllDefectByType(String type) {
		List<Defect> defectType=defectService.getDefectByType(type);
		return defectDataConverter.defectEntityToDefectData(defectType);
	}
	
}
