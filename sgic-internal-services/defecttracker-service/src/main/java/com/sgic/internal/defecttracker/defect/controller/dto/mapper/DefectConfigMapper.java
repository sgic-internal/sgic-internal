package com.sgic.internal.defecttracker.defect.controller.dto.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.internal.defecttracker.defect.controller.dto.DefectConfigDto;
import com.sgic.internal.defecttracker.defect.controller.dto.DefectTypeDto;
import com.sgic.internal.defecttracker.defect.controller.dto.converter.DefectConfigConverter;
import com.sgic.internal.defecttracker.defect.entities.DefectConfig;
import com.sgic.internal.defecttracker.defect.entities.DefectType;
import com.sgic.internal.defecttracker.defect.services.DefectConfigService;

@Service
public class DefectConfigMapper {
	@Autowired
	private DefectConfigService defectConfigService;
	
	@Autowired
	private DefectConfigConverter defectConfigConverter;
	
	// Mapper for creating defect config
	public boolean createDefectConfig(DefectConfigDto defectConfigDto) {
		DefectConfig defectConfig = defectConfigConverter.defectConfigDtoToDefectConfig(defectConfigDto);
		defectConfigService.createDefectConfig(defectConfig);
		return true;
	}
	
	public DefectConfigDto getDefectConfigById(Long id) {		
	    DefectConfig defectConfigList = defectConfigService.findDefectConfigById(id);
	    if (defectConfigList != null) {
	    	return defectConfigConverter.defectConfigToDefectConfigDto(defectConfigList);
	    }
	    else {
	    	return null;
	    }	    
	}

}
