package com.sgic.internal.defecttracker.defect.controller.dto.mapper;

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
	
}
