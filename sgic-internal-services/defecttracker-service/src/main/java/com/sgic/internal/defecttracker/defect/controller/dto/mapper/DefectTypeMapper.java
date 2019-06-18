package com.sgic.internal.defecttracker.defect.controller.dto.mapper;

import org.springframework.beans.factory.annotation.Autowired;

import com.sgic.internal.defecttracker.defect.controller.dto.DefectTypeDto;
import com.sgic.internal.defecttracker.defect.controller.dto.converter.DefectTypeConverter;
import com.sgic.internal.defecttracker.defect.entities.DefectType;
import com.sgic.internal.defecttracker.defect.services.DefectTypeService;

public class DefectTypeMapper {
	@Autowired
	private DefectTypeService defectTypeService;
	
	@Autowired
	private DefectTypeConverter defectTypeConverter;
	
	public Boolean createDefectType (DefectTypeDto defectTypeDto){
		DefectType defectType = defectTypeConverter.defectTypeDtoToDefectType(defectTypeDto);
		defectTypeService.createDefectType(defectType);
		return true;
	}
	
	

}
