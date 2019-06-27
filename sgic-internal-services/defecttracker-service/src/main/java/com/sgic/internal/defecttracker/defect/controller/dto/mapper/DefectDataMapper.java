package com.sgic.internal.defecttracker.defect.controller.dto.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.sgic.internal.defecttracker.defect.controller.dto.DefectData;
import com.sgic.internal.defecttracker.defect.controller.dto.converter.DefectDataConverter;
import com.sgic.internal.defecttracker.defect.entities.Defect;
import com.sgic.internal.defecttracker.defect.services.DefectService;

@Service
public class DefectDataMapper {

	@Autowired
	private DefectService defectService;

	@Autowired
	private DefectDataConverter defectDataConverter;

	private static Logger logger = LogManager.getLogger(DefectData.class);

//===========================Creating New defects============================================

	@SuppressWarnings("static-access")
	public Defect createDefect(DefectData defectData) {
		logger.info("DefectData Mapper -> Defect Details Saved");
		Defect defect = defectDataConverter.defectDataToDefect(defectData);
		return defectService.createDefect(defect);

	}

//===========================Get defect by Id================================================
	
	@SuppressWarnings("static-access")
	public DefectData getDefectById(String defectId) {
		logger.info("DefectData Mapper -> getDefectById");
		Defect defect =defectService.getByDefectId(defectId);
		return defectDataConverter.defectEntityToDefectData(defect);
}
	
//===========================Delete defect details================================================
	
	public DefectData deleteDefectById(String defectId) {
		logger.info("DefectData Mapper -> deleteDefectById");
		defectService.deleteDefect(defectId);		
		return null;
	}
	
//===========================Get all defect details================================================
	
	@SuppressWarnings("static-access")
	public List<DefectData> getAllCompany() {
		logger.info("DefectData Mapper -> All Defect Data Retrieved");
		List<Defect> defectList = defectService.getAllDefects();
		return defectDataConverter.defectEntityToDefectData(defectList);
	}
	
	
//===========================List all defect details by status============================================
	
	@SuppressWarnings("static-access")
	public List<DefectData> getAllDefectByStatusId(int statusId){
		logger.info("DefectData Mapper -> getAllDefectByStatusId");	
		List<Defect> defect = defectService.getAllDefectByStatus(statusId);
		return defectDataConverter.defectEntityToDefectData(defect);
		
	}
	
}
