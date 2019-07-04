package com.sgic.internal.defecttracker.project.controller.dtomapper;

import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.internal.defecttracker.project.controller.converter.DefectSeverityConverter;
import com.sgic.internal.defecttracker.project.controller.dto.DefectSeverityDto;
import com.sgic.internal.defecttracker.project.entities.DefectSeverity;
import com.sgic.internal.defecttracker.project.services.DefectSeverityService;
import com.sgic.internal.defecttracker.project.services.impl.DefectSeverityServiceImpl;


@Service
public class DefectSeverityMapper {
	
	@Autowired
	private DefectSeverityService defectSeverityService;
	
	@Autowired
	private DefectSeverityConverter defectSeverityConverter;
	
	private static Logger logger = LogManager.getLogger(DefectSeverityServiceImpl.class);
	
	public Boolean createDefectSeverity(DefectSeverityDto defectSeverityDto) {
		BasicConfigurator.configure();
		DefectSeverity defectSeverity = defectSeverityConverter.defectSeverityDtoToDefectSeverity(defectSeverityDto);
		defectSeverityService.createDefectSeverity(defectSeverity);
		logger.info("Defect Severity Create Mapper");
		return true;
	}
	
	public List<DefectSeverityDto> getAllSeverity(){
		BasicConfigurator.configure();
		List<DefectSeverity> defectSeverityList = defectSeverityService.findAllDefectSeverities();
		if(defectSeverityList != null) {
			logger.info("Defect Severities List Mapper");
			return defectSeverityConverter.defectSeverityToDefectSeverityDto(defectSeverityList);
		}
		else {
			logger.warn("No Defect Severities");
			return null;
		}
	}
	
	public DefectSeverityDto getDefectSeverityById(Long id) {
		BasicConfigurator.configure();
		DefectSeverity defectSeverity = defectSeverityService.findDefectSeverityById(id);
		if(defectSeverity != null) {
			logger.info("Defect Severity Get By Id Mapper");
			return defectSeverityConverter.defectSeverityToDefectSeverityDto(defectSeverity);
		}
		else {
			logger.warn("No Defect Severity By Id");
			return null;
		}
	}
	
	public Boolean deleteDefectSeverity(Long id) {
		BasicConfigurator.configure();
		if(defectSeverityService.deleteDefectSeverityById(id)) {
			logger.info("Defect Severity Delete Mapper");
			return true;
		}
		else {
			logger.warn("No Defect Severity");
			return false;
		}
	}
	
	public Boolean updateDefectSeverity(Long id, DefectSeverityDto defectSeverityDto) {
		BasicConfigurator.configure();
		DefectSeverity defectSeverity = defectSeverityConverter.defectSeverityDtoToDefectSeverity(defectSeverityDto);
		DefectSeverity defectSeveritylist = defectSeverityService.findDefectSeverityById(id);
		if(defectSeveritylist == null) {
			logger.warn("No Defect Severity By Id");
			return false;
		}
		else {
			defectSeverity.setId(id);
			defectSeverityService.createDefectSeverity(defectSeverity);
			logger.info("Defect Severity Update Mapper");
			return true;
		}
	}
	
}
