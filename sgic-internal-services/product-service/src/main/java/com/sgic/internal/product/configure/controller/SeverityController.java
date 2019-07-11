package com.sgic.internal.product.configure.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

import com.sgic.internal.product.configure.controller.dto.SeverityDto;
import com.sgic.internal.product.configure.controller.mapper.SeverityMapper;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
public class SeverityController {
	@Autowired
	private SeverityMapper severityMapper;
	private static Logger logger = LogManager.getLogger(SeverityMapper.class);

	// Get All Severity
	@GetMapping("/Severitys")
	public List<SeverityDto> getAllSeverity() {
		logger.info("Controller -> Data Retrieved Successfull");
		return severityMapper.getAllSeverity();
	}

	 //Get Severity By Id
	@GetMapping("/Severity/{severityId}")
	public SeverityDto getSeverityById(@PathVariable(name = "severityId") Long severityId) {
		logger.info("Controller -> Data Retrieved Successfull");
		return severityMapper.getDefectSeverityById(severityId);
	}
	
	// Save All Severity
	@PostMapping("/Severity")
	public ResponseEntity<String> saveSeverity(@Valid @RequestBody SeverityDto severityDto) {
		if (severityMapper.saveDefectSeverity(severityDto) != null) {
			logger.info("Severity Controller -> Severity Created Successful");
			return new ResponseEntity<>("Severity added succesfully", HttpStatus.OK);
		}
		logger.info("Severity Controller -> Severity creation FAILED!!!");
		return new ResponseEntity<>("SAVE FAILED!", HttpStatus.BAD_REQUEST);
	}

	// Update Severity
	@PutMapping("/Severity")
	public ResponseEntity<String> updateSeverity(@RequestBody SeverityDto severityDto) {
		logger.info("Severity Controller -> Severity Updated Successful");
		if (severityMapper.updateDefectSeverity(severityDto) != null) {
			return new ResponseEntity<>("Sucessfully Updateed Company", HttpStatus.OK);
		}
		logger.info("Severity Controller -> Severity Updated Failed!!!");
		return new ResponseEntity<>("Update FAILED!!!", HttpStatus.BAD_REQUEST);
	}

	// Delete Severity
	@DeleteMapping("/Severity/{severityId}")
	public ResponseEntity<String> deleteSeverity(@PathVariable(name = "severityId") Long severityId) {
		System.out.print(severityId);
		if (severityMapper.getDefectSeverityById(severityId) != null) {
			if (severityMapper.deleteDefectSeverityById(severityId) == null) {
				logger.info("Severity Controller -> Severity Deleted Successful");
				return new ResponseEntity<>("Severity Sucessfully deleted", HttpStatus.OK);
			}
		} else {
			logger.info("Severity Controller -> Severity Id Not Found");
			return new ResponseEntity<>("Severity Id Not FOUND!!!", HttpStatus.BAD_REQUEST);
		}
		logger.info("Severity Controller -> Severity Deleted Failed!!!");
		return new ResponseEntity<>("Delete FAILED!!!", HttpStatus.BAD_REQUEST);
	}
}
