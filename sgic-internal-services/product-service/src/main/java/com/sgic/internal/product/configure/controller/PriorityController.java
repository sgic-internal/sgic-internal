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

import com.sgic.internal.product.configure.controller.dto.PriorityDto;
import com.sgic.internal.product.configure.controller.mapper.PriorityMapper;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class PriorityController {
	@Autowired
	private PriorityMapper priorityMapper;
	private static Logger logger = LogManager.getLogger(PriorityMapper.class);

	// Get All Priority
	@GetMapping("/Prioritys")
	public List<PriorityDto> getAllPriority() {
		try {
			logger.info("Priority Controller INFO -> Get All Priority Method Started");
			return priorityMapper.getAllPriority();
		} catch (Exception ex) {
			logger.error("Priority Controller ERROR! :-> " + ex.getMessage());
		} finally {
			logger.info("Priority Controller INFO -> Get All Priority Finished");
		}
		return null;
	}

	// Get Priority By Id
	@GetMapping("/Priority/{priorityId}")
	public Object getPriorityById(@PathVariable(name = "priorityId") Long priorityId) {
		try {
			logger.info("Priority Controller INFO -> Get Priority By Id  Method Started");
			//Check Priority Id
			if (priorityMapper.getDefectPriorityById(priorityId) != null) {
				logger.info("Priority Controller INFO -> Priority Id Found -> Priority Id : "+priorityId);
				return priorityMapper.getDefectPriorityById(priorityId);
			} else {
				logger.warn("Priority Controller WARNING! -> Priority Id Not Found -> Priority Id : "+priorityId);
				return "Priority Not Found for this Id : " + priorityId;
			}
		} catch (Exception ex) {
			logger.error("Priority Controller ERROR! :-> " + ex.getMessage());
		} finally {
			logger.info("Priority Controller INFO -> Get Priority By Id Method Finished");
		}
		return null;
	}

	// Save All Priority
	@PostMapping("/Priority")
	public ResponseEntity<String> savePriority(@Valid @RequestBody PriorityDto priorityDto) {
		try {
			logger.info("Priority Controller INFO -> Save All Priority  Method Started");
			if (priorityMapper.saveDefectPriority(priorityDto) != null) {
				logger.info("Priority Controller INFO-> Priority Created Successful");
				return new ResponseEntity<>("Priority added succesfully", HttpStatus.OK);
			}
			logger.warn("Priority Controller WARNING! :-> Priority creation FAILED!!!");
			return new ResponseEntity<>("SAVE FAILED!", HttpStatus.BAD_REQUEST);
		} catch (Exception ex) {
			logger.error("Priority Controller ERROR! :-> " + ex.getMessage());
		} finally {
			logger.info("Priority Controller INFO -> Save All Priority  Method Finished");
		}
		return null;
	}

	// Update Priority
	@PutMapping("/Priority")
	public ResponseEntity<String> updatePriority(@RequestBody PriorityDto priorityDto) {
		try {
			logger.info("Priority Controller INFO -> Update Priority  Method Started");
			if (priorityMapper.updateDefectPriority(priorityDto) != null) {
				logger.info("Priority Controller INFO -> Priority Updated Successful");
				return new ResponseEntity<>("Priority Sucessfully Updated", HttpStatus.OK);
			}
			logger.warn("Priority Controller WARNING! -> Priority Updated Failed!!!");
			return new ResponseEntity<>("Update FAILED!!!", HttpStatus.BAD_REQUEST);
		} catch (Exception ex) {
			logger.error("Priority Controller ERROR! -> " + ex.getMessage());
		} finally {
			logger.info("Priority Controller INFO -> Update Priority  Method Finished");
		}
		return null;
	}

	// Delete Company
	@DeleteMapping("/Priority/{priorityId}")
	public ResponseEntity<String> deletePriority(@PathVariable(name = "priorityId") Long priorityId) {
//		System.out.print(priorityId);
		try {
			logger.info("Priority Controller INFO -> Delete Priority  Method Started");
			//check priority Id
			if (priorityMapper.getDefectPriorityById(priorityId) != null) {
				// delete priority by id
				if (priorityMapper.deleteDefectPriorityById(priorityId) == null) {
					logger.info("Priority Controller INFO -> Priority Deleted Successful");
					return new ResponseEntity<>("Priority Sucessfully deleted", HttpStatus.OK);
				}
			} else {
				logger.warn("Priority Controller WARNING! -> Priority Id Not Found -> Priority Id : "+priorityId);
				return new ResponseEntity<>("Priority Id Not FOUND!!!", HttpStatus.BAD_REQUEST);
			}
			logger.warn("Priority Controller WARNING! -> Priority Deleted Failed!!!");
			return new ResponseEntity<>("Delete FAILED!!!", HttpStatus.BAD_REQUEST);
		} catch (Exception ex) {
			logger.error("Priority Controller ERROR! -> " + ex.getMessage());
		} finally {
			logger.info("Priority Controller INFO -> Delete Priority  Method Finished");
		}
		return null;
	}
}
