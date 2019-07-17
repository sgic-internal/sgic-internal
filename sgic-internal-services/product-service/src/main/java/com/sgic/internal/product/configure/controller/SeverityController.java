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

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class SeverityController {
	@Autowired
	private SeverityMapper severityMapper;
	private static Logger logger = LogManager.getLogger(SeverityMapper.class);

	// Get All Severity
	@GetMapping("/Severitys")
	public List<SeverityDto> getAllSeverity() {
		try {
			logger.info("Severity Controller INFO -> Get All Severity Method Started");
			return severityMapper.getAllSeverity();
		} catch (Exception ex) {
			logger.error("Severity Controller INFO -> Get All Severity Method Failed!");
			logger.error("Severity Controller ERROR! :-> " + ex.getMessage());
		} finally {
			logger.info("Severity Controller INFO -> Get All Severity Method Finished");
		}
		return null;
	}

	// Get Severity By Id
	@GetMapping("/Severity/{severityId}")
	public Object getSeverityById(@PathVariable(name = "severityId") Long severityId) {
		try {
			logger.info("Severity Controller INFO -> Get Severity By Id Method Started");
			//check severity id
			if (severityMapper.getDefectSeverityById(severityId) != null) {
				logger.info("Severity Controller INFO -> Severity Id Found -> Severity Id : " + severityId);
				return severityMapper.getDefectSeverityById(severityId);
			} else {
				logger.warn("Severity Controller WARNING! -> Severity Id Not Found -> Severity Id : " + severityId);
				return "Severity Not Found For this Id : " + severityId;
			}
		} catch (Exception ex) {
			logger.error("Severity Controller ERROR! :-> " + ex.getMessage());
		} finally {
			logger.info("Severity Controller INFO -> Get All Severity Method Finished");
		}
		return null;
	}

	// Save All Severity
	@PostMapping("/Severity")
	public ResponseEntity<String> saveSeverity(@Valid @RequestBody SeverityDto severityDto) {
		try {
			logger.info("Severity Controller INFO -> Save Severity Method Started");
			if (severityMapper.saveDefectSeverity(severityDto) != null) {
				logger.info("Severity Controller -> Severity Created Successful");
				return new ResponseEntity<>("Severity added succesfully", HttpStatus.OK);
			}
			logger.info("Severity Controller INFO -> Severity creation FAILED!!!");
			return new ResponseEntity<>("SAVE FAILED!", HttpStatus.BAD_REQUEST);
		} catch (Exception ex) {
			logger.error("Severity Controller ERROR! :-> " + ex.getMessage());
		} finally {
			logger.info("Severity Controller INFO -> Save Severity Method Finished");
		}
		return null;
	}

	// Update Severity
	@PutMapping("/Severity")
	public ResponseEntity<String> updateSeverity(@RequestBody SeverityDto severityDto) {
		logger.info("Severity Controller -> Update Severity Method Started");
		try {
			if (severityMapper.updateDefectSeverity(severityDto) != null) {
				return new ResponseEntity<>("Severity Updated Sucessfully", HttpStatus.OK);
			}
			logger.info("Severity Controller -> Severity Updated Failed!!!");
			return new ResponseEntity<>("Update FAILED!!!", HttpStatus.BAD_REQUEST);
		} finally {
			logger.info("Severity Controller -> Update Severity Method Finished");
		}
	}

	// Delete Severity
	@DeleteMapping("/Severity/{severityId}")
	public ResponseEntity<String> deleteSeverity(@PathVariable(name = "severityId") Long severityId) {
		System.out.print(severityId);
		logger.info("Severity Controller -> Delete Severity Method Started");
		try {
			//check severity id
			if (severityMapper.getDefectSeverityById(severityId) != null) {
				//deleted severity by id
				if (severityMapper.deleteDefectSeverityById(severityId) == null) {
					logger.info("Severity Controller -> Severity Deleted Successful");
					return new ResponseEntity<>("Severity Sucessfully deleted", HttpStatus.OK);
				} else {
					logger.info("Severity Controller -> Delete Severity Failed, Severity Id Not Found -> Severity Id :"
							+ severityId);
					return new ResponseEntity<>("No Severity Found For This Id : " + severityId,
							HttpStatus.BAD_REQUEST);
				}
			}
		} finally {
			logger.info("Severity Controller -> Delete Severity Method Finished");
		}
		return null;
	}
}
