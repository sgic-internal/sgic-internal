package com.sgic.internal.product.controller;

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
import com.sgic.internal.product.controller.dto.PriorityDto;
import com.sgic.internal.product.controller.dto.mapper.PriorityMapper;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
public class PriorityController {
	@Autowired
	private PriorityMapper priorityMapper;
	private static Logger logger = LogManager.getLogger(PriorityMapper.class);

	// Get All Priority
	@GetMapping("/Prioritys")
	public List<PriorityDto> getAllPriority() {
		logger.info("Controller -> Data Retrieved Successfull");
		return priorityMapper.getAllPriority();
	}

	 //Get Priority By Id
	@GetMapping("/Priority/{priorityId}")
	public PriorityDto getPriorityById(@PathVariable(name = "priorityId") Long priorityId) {
		logger.info("Controller -> Data Retrieved Successfull");
		return priorityMapper.getDefectPriorityById(priorityId);
	}
	

	// Save All Priority
	@PostMapping("/Priority")
	public ResponseEntity<String> savePriority(@Valid @RequestBody PriorityDto priorityDto) {
		if (priorityMapper.saveDefectPriority(priorityDto) != null) {
			logger.info("Priority Controller -> Priority Created Successful");
			return new ResponseEntity<>("Priority added succesfully", HttpStatus.OK);
		}
		logger.info("Priority Controller -> Priority creation FAILED!!!");
		return new ResponseEntity<>("SAVE FAILED!", HttpStatus.BAD_REQUEST);
	}

	// Update Priority
	@PutMapping("/Priority")
	public ResponseEntity<String> updatePriority(@RequestBody PriorityDto priorityDto) {
		logger.info("Priority Controller -> Priority Updated Successful");
		if (priorityMapper.updateDefectPriority(priorityDto) != null) {
			return new ResponseEntity<>("Sucessfully Updateed Company", HttpStatus.OK);
		}
		logger.info("Priority Controller -> Priority Updated Failed!!!");
		return new ResponseEntity<>("Update FAILED!!!", HttpStatus.BAD_REQUEST);
	}

	// Delete Company
	@DeleteMapping("/Priority/{priorityId}")
	public ResponseEntity<String> deletePriority(@PathVariable(name = "priorityId") Long priorityId) {
		System.out.print(priorityId);
		if (priorityMapper.getDefectPriorityById(priorityId) != null) {
			if (priorityMapper.deleteDefectPriorityById(priorityId) == null) {
				logger.info("Priority Controller -> Priority Deleted Successful");
				return new ResponseEntity<>("Priority Sucessfully deleted", HttpStatus.OK);
			}
		} else {
			logger.info("Priority Controller -> Priority Id Not Found");
			return new ResponseEntity<>("Company Id Not FOUND!!!", HttpStatus.BAD_REQUEST);
		}
		logger.info("Priority Controller -> Priority Deleted Failed!!!");
		return new ResponseEntity<>("Delete FAILED!!!", HttpStatus.BAD_REQUEST);
	}
}
