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

import com.sgic.internal.defecttracker.project.controller.dto.DefectPriorityDto;
import com.sgic.internal.defecttracker.project.controller.dtomapper.DefectPriorityMapper;
import com.sgic.internal.defecttracker.project.services.impl.DefectPriorityServiceImpl;

@RestController
public class DefectPriorityController {

	private static Logger logger = LogManager.getLogger(DefectPriorityServiceImpl.class);

	@Autowired
	private DefectPriorityMapper defectPriorityMapper;

	// Author : ----- :: Create Defect Priority
	@PostMapping(value = "/defectpriority")
	public ResponseEntity<Object> createDefectPriority(@RequestBody DefectPriorityDto defectPriorityDto) {
		BasicConfigurator.configure();
		if (defectPriorityMapper.createDefectPriority(defectPriorityDto)) {
			return new ResponseEntity<>("Defect Priority Added Successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Defect Priority Added Successfully", HttpStatus.OK);
		}
	}

	// Author : ----- :: Get All Defect Priority
	@GetMapping(value = "/defectpriorities")
	public List<DefectPriorityDto> getAllDefectPriorities() {
		BasicConfigurator.configure();
		logger.info("Defect Priorities Listed");
		return defectPriorityMapper.getAllDefectPriority();
	}

	// Author : ----- :: Get Defect Priority By Id
	@GetMapping(value = "/defectpriority/{id}")
	public DefectPriorityDto getDefectPriorityById(@PathVariable Long id) {
		BasicConfigurator.configure();
		logger.info("Defect Priority Get By Id Listed");
		return defectPriorityMapper.getDefectPriorityById(id);
	}

	// Author : ----- :: Update Defect Priority
	@PutMapping(value = "/defectpriority/{id}")
	public ResponseEntity<Object> updateDefectPriority(@RequestBody DefectPriorityDto defectPriorityDto,
			@PathVariable Long id) {
		BasicConfigurator.configure();
		defectPriorityMapper.updateDefectPriority(id, defectPriorityDto);
		logger.info("Defect Priority Updated");
		return new ResponseEntity<>("Defect Priority Updated Successfully", HttpStatus.OK);
	}

	// Author : ----- :: Delete Defect Priority
	@DeleteMapping(value = "/defectpriority/{id}")
	public ResponseEntity<Object> deleteDefectPriority(@PathVariable Long id,
			@RequestBody DefectPriorityDto defectPriorityDto) {
		BasicConfigurator.configure();
		defectPriorityMapper.deleteDefectPriority(id);
		logger.info("Defect Priority Deleted");
		return new ResponseEntity<>("Defect Priority Deleted Successfully", HttpStatus.OK);
	}

}
