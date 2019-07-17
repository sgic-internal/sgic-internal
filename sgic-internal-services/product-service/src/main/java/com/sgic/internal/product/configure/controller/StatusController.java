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

import com.sgic.internal.product.configure.controller.dto.StatusDto;
import com.sgic.internal.product.configure.controller.mapper.StatusMapper;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class StatusController {
	@Autowired
	private StatusMapper statusMapper;
	private static Logger logger = LogManager.getLogger(StatusMapper.class);

	// Get All Status
	@GetMapping("/Statuses")
	public List<StatusDto> getAllStatus() {
		logger.info("Defect Status Controller INFO -> Create Defect Status Method Started");
		try {
			return statusMapper.getAllStatus();
		} finally {
			logger.info("Defect Status Controller INFO -> Create Defect Status Method Finished");
		}
	}

	// Get Status By Id
	@GetMapping("/Status/{statusId}")
	public Object getStatusById(@PathVariable(name = "statusId") Long statusId) {
		logger.info("Defect Status Controller INFO -> Create Defect Status Method Started");
		try {
			// check status id
			if (statusMapper.getDefectStatusById(statusId) != null) {
				logger.info("Defect Status Controller INFO -> Defect Status Id Found -> Status Id : " + statusId);
				return statusMapper.getDefectStatusById(statusId);
			} else {
				logger.warn("Defect Status Controller -> Defect Status Id Not Found -> Status Id : " + statusId);
				return "Defect Status Not Found For this Id : " + statusId;
			}
		} finally {
			logger.info("Defect Status Controller INFO -> Create Defect Status Method Finished");
		}
	}

	// Save All Status
	@PostMapping("/Status")
	public ResponseEntity<String> saveStatus(@Valid @RequestBody StatusDto statusDto) {
		logger.info("Defect Status Controller INFO -> Save Defect Status Method Started");
		try {
			if (statusMapper.saveDefectStatus(statusDto) != null) {
				logger.info("Defect Status Controller -> Defect Status Created Successful");
				return new ResponseEntity<>("Defect Severity added succesfully", HttpStatus.OK);
			}
			logger.warn("Defect Status Controller -> Defect Status creation FAILED!!!");
			return new ResponseEntity<>("SAVE FAILED!", HttpStatus.BAD_REQUEST);
		} catch (Exception ex) {
			logger.error("Defect Status Controller ERROR! :-> " + ex.getMessage());
		} finally {
			logger.info("Defect Status Controller INFO -> Save Defect Status Method Finished");
		}
		return null;
	}

	// Update Status
	@PutMapping("/Status")
	public ResponseEntity<String> updateStatus(@RequestBody StatusDto statusDto) {
		logger.info("Defect Status Controller INFO -> Update Defect Defect Status Method Started");
		try {
			if (statusMapper.updateDefectStatus(statusDto) != null) {
				return new ResponseEntity<>("Defect Status Updated Sucessfully ", HttpStatus.OK);
			} else {
				logger.warn("Status Controller -> Status Updated Failed!!!");
				return new ResponseEntity<>("Update FAILED!!!", HttpStatus.BAD_REQUEST);
			}
		} finally {
			logger.info("Defect Status Controller INFO -> Update Defect Defect Status Method Finished");
		}
	}

	// Delete Status
	@DeleteMapping("/Status/{statusId}")
	public ResponseEntity<String> deleteStatus(@PathVariable(name = "statusId") Long statusId) {
		System.out.print(statusId);
		logger.info("Defect Status Controller INFO -> Delete Defect Defect Status Method Started");
		try {
			// check status id
			if (statusMapper.getDefectStatusById(statusId) != null) {
				// delete status by id
				if (statusMapper.deleteDefectStatusById(statusId) == null) {
					logger.info("Status Controller -> Status Id Found -> Status Id : " + statusId);
					return new ResponseEntity<>("Status Sucessfully deleted", HttpStatus.OK);
				}
			} else {
				logger.warn("Defect Status Controller -> Defect Status Id Not Found -> Status Id : " + statusId);
				return new ResponseEntity<>("Delete Failed! -> Status Id Not FOUND, Status Id : " + statusId, HttpStatus.BAD_REQUEST);
			}
		} finally {
			logger.info("Defect Status Controller INFO -> Delete Defect Defect Status Method Finished");
		}
		return null;
	}
}
