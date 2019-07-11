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


@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
public class StatusController {
	@Autowired
	private StatusMapper statusMapper;
	private static Logger logger = LogManager.getLogger(StatusMapper.class);

	// Get All Status
	@GetMapping("/Statuses")
	public List<StatusDto> getAllStatus() {
		logger.info("Controller -> Data Retrieved Successfull");
		return statusMapper.getAllStatus();
	}

	 //Get Status By Id
	@GetMapping("/Status/{statusId}")
	public StatusDto getStatusById(@PathVariable(name = "statusId") Long statusId) {
		logger.info("Controller -> Data Retrieved Successfull");
		return statusMapper.getDefectStatusById(statusId);
	}
	
	// Save All Status
	@PostMapping("/Status")
	public ResponseEntity<String> saveStatus(@Valid @RequestBody StatusDto statusDto) {
		if (statusMapper.saveDefectStatus(statusDto) != null) {
			logger.info("Status Controller -> Status Created Successful");
			return new ResponseEntity<>("Priority added succesfully", HttpStatus.OK);
		}
		logger.info("Status Controller -> Status creation FAILED!!!");
		return new ResponseEntity<>("SAVE FAILED!", HttpStatus.BAD_REQUEST);
	}

	// Update Status
	@PutMapping("/Status")
	public ResponseEntity<String> updateStatus(@RequestBody StatusDto statusDto) {
		logger.info("Status Controller -> Status Updated Successful");
		if (statusMapper.updateDefectStatus(statusDto) != null) {
			return new ResponseEntity<>("Sucessfully Updateed Company", HttpStatus.OK);
		}
		logger.info("Status Controller -> Status Updated Failed!!!");
		return new ResponseEntity<>("Update FAILED!!!", HttpStatus.BAD_REQUEST);
	}

	// Delete Status
	@DeleteMapping("/Status/{statusId}")
	public ResponseEntity<String> deleteStatus(@PathVariable(name = "statusId") Long statusId) {
		System.out.print(statusId);
		if (statusMapper.getDefectStatusById(statusId) != null) {
			if (statusMapper.deleteDefectStatusById(statusId) == null) {
				logger.info("Status Controller -> Status Deleted Successful");
				return new ResponseEntity<>("Status Sucessfully deleted", HttpStatus.OK);
			}
		} else {
			logger.info("Status Controller -> Status Id Not Found");
			return new ResponseEntity<>("Status Id Not FOUND!!!", HttpStatus.BAD_REQUEST);
		}
		logger.info("Status Controller -> Status Deleted Failed!!!");
		return new ResponseEntity<>("Delete FAILED!!!", HttpStatus.BAD_REQUEST);
	}
}
