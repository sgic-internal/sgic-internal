package com.sgic.internal.defecttracker.defect.controller.dto.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
	

//===========================Creating New defects=================================
	
	@SuppressWarnings("static-access")
	public  Defect createDefect(DefectData defectData) {
		logger.info("DefectData Mapper -> Defect Details Saved");
		Defect defect = defectDataConverter.DefectDataToDefect(defectData);
		return defectService.createDefect(defect);
		
	}
	
}
