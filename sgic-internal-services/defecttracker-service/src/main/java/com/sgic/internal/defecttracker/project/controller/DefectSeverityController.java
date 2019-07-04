package com.sgic.internal.defecttracker.project.controller;

import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.internal.defecttracker.project.controller.dto.DefectSeverityDto;
import com.sgic.internal.defecttracker.project.controller.dtomapper.DefectSeverityMapper;
import com.sgic.internal.defecttracker.project.services.impl.DefectSeverityServiceImpl;


@RestController
public class DefectSeverityController {
	private static Logger logger = LogManager.getLogger(DefectSeverityServiceImpl.class);
	
	@Autowired
	private DefectSeverityMapper defectSeverityMapper;
	
	// Author : ----- :: Create Defect Severity
	@PostMapping(value = "/defectseverity")
	public ResponseEntity<Object> createDefectSeverity(@RequestBody DefectSeverityDto defectSeverityDto){
		BasicConfigurator.configure();
		if(defectSeverityMapper.createDefectSeverity(defectSeverityDto)) {
			return new ResponseEntity<>("Defect Severity Added Successfully", HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("Defect Severity Added Successfully", HttpStatus.OK);
		}
	}
	
	// Author : ----- :: Get All Defect Severities
	@GetMapping(value = "/defectseverities")
	public List<DefectSeverityDto> getAllDefectSeverities() {
		BasicConfigurator.configure();
		logger.info("Defect Severities Listed");
		return defectSeverityMapper.getAllSeverity();
	}
	
	// Author : ----- :: Get Defect Severity By Id
	@GetMapping(value = "/defectseverity/{id}")
	public DefectSeverityDto getDefectSeverityById(@PathVariable Long id) {
		BasicConfigurator.configure();
		logger.info("Defect Severity Get By Id Listed");
		return defectSeverityMapper.getDefectSeverityById(id);
	}
	
	// Author : ----- :: Update Defect Severity
	@PutMapping(value = "/defectseverity/{id}")
	public ResponseEntity<Object> updateDefectSeverity(@RequestBody DefectSeverityDto defectSeverityDto, @PathVariable Long id) {
		BasicConfigurator.configure();
		defectSeverityMapper.updateDefectSeverity(id, defectSeverityDto);
		logger.info("Defect Severity Updated");
		return new ResponseEntity<>("Defect Severity Updated Successfully", HttpStatus.OK);
	}
	
	// Author : ----- :: Delete Defect Severity
	@DeleteMapping(value = "/defectseverity/{id}")
	public ResponseEntity<Object> deleteDefectSeverity(@PathVariable Long id, @RequestBody DefectSeverityDto defectSeverityDto) {
		BasicConfigurator.configure();
		defectSeverityMapper.deleteDefectSeverity(id);
		logger.info("Defect Severity Deleted");
		return new ResponseEntity<>("Defect Severity Deleted Successfully", HttpStatus.OK);
	}
	
}
