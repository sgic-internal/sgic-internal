package com.sgic.internal.defecttracker.project.controller;

import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.internal.defecttracker.project.controller.dto.DefectStatusDto;
import com.sgic.internal.defecttracker.project.controller.dto.mapper.DefectStatusMapper;
import com.sgic.internal.defecttracker.project.services.impl.DefectStatusServiceImpl;

@RestController
@CrossOrigin
public class DefectStatusController {
	private static Logger logger = LogManager.getLogger(DefectStatusServiceImpl.class);

	@Autowired
	private DefectStatusMapper defectStatusMapper;

	// Author : Shawmiya :: Create defect status
	// Create defect status controller
	@PostMapping(value = "/defectstatus")
	public ResponseEntity<Object> createDefectStatus(@RequestBody DefectStatusDto defectStatusDto) {
		BasicConfigurator.configure();
		if (defectStatusMapper.createDefectStatus(defectStatusDto)) {
			logger.info("Defect Status created");
			return new ResponseEntity<>("Defect Status Added Succesfully", HttpStatus.OK);
		} else {
			logger.error("Defect Status Create Fail");
			return new ResponseEntity<>("Defect Status Added Failure", HttpStatus.OK);
		}

	}

	// List all defect statuses controller
	@GetMapping(value = "/defectstatuses")
	public List<DefectStatusDto> getAllDefectStatus() {
		BasicConfigurator.configure();
		logger.info("Defect statuses Listed");
		return defectStatusMapper.getAllDefectStatus();
	}

	// Author : Paheerathan :: Create defect status
	// Get defect status by id controller
	@GetMapping(value = "/defectstatus/{id}")
	public DefectStatusDto getDefectstatusById(@PathVariable Long id) {
		BasicConfigurator.configure();
		logger.info("Defect Status Get By Id Listed");
		return defectStatusMapper.getDefectstatusById(id);
	}

	// Author : Mathura :: Create defect status
	// Delete defect status controller
	@DeleteMapping("/defectstatus/{id}")
	public ResponseEntity<Object> deleteDefectStatus(@PathVariable Long id,
			@RequestBody DefectStatusDto defectStatusDto) {
		BasicConfigurator.configure();
		defectStatusMapper.deleteDefectStatus(id);
		logger.info("Defect Status Deleted");
		return new ResponseEntity<>("Defect Status Deleted Succesfully", HttpStatus.OK);
	}

	// Author : Varnitha :: Create defect status
	// Update defect status controller
	@PutMapping(value = "/defectstatus/{id}")
	public ResponseEntity<Object> updateDefectStatus(@RequestBody DefectStatusDto defectStatusDto,
			@PathVariable Long id) {
		BasicConfigurator.configure();
		defectStatusMapper.updateDefectStatus(id, defectStatusDto);
		logger.info("Defect Status Updated");
		return new ResponseEntity<>("Defect Status Updated Succesfully", HttpStatus.OK);
	}

}
