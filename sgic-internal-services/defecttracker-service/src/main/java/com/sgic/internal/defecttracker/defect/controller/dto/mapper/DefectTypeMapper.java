package com.sgic.internal.defecttracker.defect.controller.dto.mapper;

import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.internal.defecttracker.defect.controller.dto.DefectTypeDto;
import com.sgic.internal.defecttracker.defect.controller.dto.converter.DefectTypeConverter;
import com.sgic.internal.defecttracker.defect.entities.DefectType;
import com.sgic.internal.defecttracker.defect.services.DefectTypeService;
import com.sgic.internal.defecttracker.defect.services.impl.DefectTypeServiceImpl;


@Service
public class DefectTypeMapper {
	@Autowired
	private DefectTypeService defectTypeService;
	
	@Autowired
	private DefectTypeConverter defectTypeConverter;
	
	@SuppressWarnings("unused")
	private static Logger logger = LogManager.getLogger(DefectTypeServiceImpl.class);
	
	// Mapper for creating defect type
	public Boolean createDefectType (DefectTypeDto defectTypeDto){
		//BasicConfigurator.configure();
		DefectType defectType = defectTypeConverter.defectTypeDtoToDefectType(defectTypeDto);
		defectTypeService.createDefectType(defectType);
		//logger.info("Defect Type Create Mapper");
		return true;
	}
	
	// Mapper for listing all defect types
	public List<DefectTypeDto> getAllDefectType(){
		//BasicConfigurator.configure();
		List<DefectType> defectTypeList = defectTypeService.findAllDefectType();
		if(defectTypeList != null) {
			//logger.info("Defect Types List Mapper");
			return (defectTypeConverter.defectTypeToDefectTypeDto(defectTypeList));
		}
		else {
			//logger.warn("No Defect Types");
			return null;
		}			
	}
	
	//Mapper for getting defect type by id
	public DefectTypeDto getDefectTypeById(Long id) {
		//BasicConfigurator.configure();		
	    DefectType defectTypeList =defectTypeService.findDefectTypeById(id);
	    if (defectTypeList != null) {
	    	//logger.info("Defect Type Get By Id Mapper");
	    	return defectTypeConverter.defectTypeToDefectTypeDto(defectTypeList);
	    }
	    else {
	    	//logger.warn("No Defect Type By Id");
	    	return null;
	    }	    
	}
	
	// Mapper for delete defect type
	public Boolean deleteDefectType(Long id) {
		//BasicConfigurator.configure();
		if(defectTypeService.deleteDefectTypeById(id)) {
			//logger.info("Defect Type Delete Mapper");
			return true;
		}
		else {
			//logger.warn("No Defect Type");
			return false;
		}		
	}
	
	// Mapper for update defect type
	public Boolean updateDefectType(Long id, DefectTypeDto defectTypeDto) {
		//BasicConfigurator.configure();
		DefectType defectType = defectTypeConverter.defectTypeDtoToDefectType(defectTypeDto);
		DefectType defectTypeList =defectTypeService.findDefectTypeById(id);
		if(defectTypeList == null) {
			//logger.warn("No Defect Type By Id");
			return false;
		}
		else {
			defectType.setId(id);
			defectTypeService.createDefectType(defectType);
			//logger.info("Defect Type Update Mapper");
			return true;
		}		
	}
	
	// Mapper for count defect type
	public int getDefectTypeCount() {
		return defectTypeService.getDefectTypeCount();
	}
}
