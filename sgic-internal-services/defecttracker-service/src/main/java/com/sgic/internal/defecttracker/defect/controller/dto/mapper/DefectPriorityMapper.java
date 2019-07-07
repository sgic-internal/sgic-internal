package com.sgic.internal.defecttracker.defect.controller.dto.mapper;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.internal.defecttracker.defect.controller.dto.DefectPriorityDto;
import com.sgic.internal.defecttracker.defect.controller.dto.converter.DefectPriorityConverter;
import com.sgic.internal.defecttracker.defect.entities.DefectPriority;
import com.sgic.internal.defecttracker.defect.services.DefectPriorityService;
import com.sgic.internal.defecttracker.defect.services.impl.DefectPriorityServiceImpl;
import com.sgic.internal.defecttracker.defect.services.impl.DefectSeverityServiceImpl;

@Service
public class DefectPriorityMapper {
	@Autowired
	private DefectPriorityService defectPriorityService;

	@Autowired
	private DefectPriorityConverter defectPriorityConverter;

	private static Logger logger = LogManager.getLogger(DefectPriorityServiceImpl.class);

	// Mapper for creating defect priority
	public Boolean createDefectPriority(DefectPriorityDto defectPriorityDto) {
		// BasicConfigurator.configure();
		DefectPriority defectPriority = defectPriorityConverter.defectPriorityDtoToDefectPriority(defectPriorityDto);
		defectPriorityService.createDefectPriority(defectPriority);
		logger.info("Defect Priority Create Mapper");
		return true;
	}
	
	// Mapper for listing all defect priorities
		public List<DefectPriorityDto> getAllDefectPriority(){
			//BasicConfigurator.configure();
			List<DefectPriority> defectPriorityList = defectPriorityService.findAllDefectPriority();
			if(defectPriorityList != null) {
				logger.info("Defect Priority List Mapper");
				return (defectPriorityConverter.defectPriorityToDefectPriorityDto(defectPriorityList));
			}
			else {
				logger.warn("No Defect Priorities");
				return null;
			}				
		}
		
		//Mapper for getting defect priority by id
		public DefectPriorityDto getDefectPriorityById(Long id) {
			//BasicConfigurator.configure();		
			DefectPriority defectPriorityList =defectPriorityService.findDefecPriorityById(id);
		    if (defectPriorityList != null) {
		    	logger.info("Defect Priority Get By Id Mapper");
		    	return defectPriorityConverter.defectPriorityToDefectPriorityDto(defectPriorityList);
		    }
		    else {
		    	logger.warn("No Defect Priority By Id");
		    	return null;
		    }	    
		}
		
		// Mapper for delete defect priority
		public Boolean deleteDefectPriority(Long id) {
			//BasicConfigurator.configure();
			if(defectPriorityService.deleteDefectPriorityById(id)) {
				logger.info("Defect Priority Delete Mapper");
				return true;
			}
			else {
				logger.warn("No Defect Priority");
				return false;
			}		
		}
		
		// Mapper for update defect priority
		public Boolean updateDefectPriority(Long id, DefectPriorityDto defectPriorityDto) {
			//BasicConfigurator.configure();
			DefectPriority defectPriority = defectPriorityConverter.defectPriorityDtoToDefectPriority(defectPriorityDto);
			DefectPriority defectPriorityList =defectPriorityService.findDefecPriorityById(id);
			if(defectPriorityList == null) {
				logger.warn("No Defect Priority By Id");
				return false;
			}
			else {
				defectPriority.setId(id);
				defectPriorityService.createDefectPriority(defectPriority);
				logger.info("Defect Priority Update Mapper");
				return true;
			}		
		}
}
