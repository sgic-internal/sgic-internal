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

import com.sgic.internal.product.configure.controller.dto.TypeDto;
import com.sgic.internal.product.configure.controller.mapper.TypeMapper;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class TypeController {
	@Autowired
	private TypeMapper typeMapper;
	private static Logger logger = LogManager.getLogger(TypeMapper.class);

	// Get All Type
	@GetMapping("/Types")
	public List<TypeDto> getAllTypes() {
		logger.info("Defect Type Controller INFO -> Get All Defect Type Method Started");
		try {
			return typeMapper.getAllDefectType();
		} finally {
			logger.info("Defect Type Controller INFO -> Get All Defect Type Method Finished");
		}
	}

	// Get Type By Id
	@GetMapping("/Type/{typeId}")
	public TypeDto getTypeById(@PathVariable(name = "typeId") Long typeId) {
		logger.info("Defect Type Controller INFO -> Get Defect Type By Id Method Started");
		try {
			//check type id
			if (typeMapper.getDefectTypeById(typeId) != null) {
				logger.info("Defect Type Controller INFO -> Defect Type Id Found -> Type Id : " + typeId);
				return typeMapper.getDefectTypeById(typeId);
			} else {
				logger.warn("Defect Type Controller INFO -> Defect Type Id Not Found -> Type Id : " + typeId);
			}
		} finally {
			logger.info("Defect Type Controller INFO -> Get Defect Type By Id Method Finished");
		}
		return null;
	}

	// Save All Type
	@PostMapping("/Type")
	public ResponseEntity<String> saveType(@Valid @RequestBody TypeDto typeDto) {
		logger.info("Defect Type Controller INFO -> Save Defect Type Method Started");
		try {
			if (typeMapper.saveDefectType(typeDto) != null) {
				logger.info("Defect Type Controller -> Defect Type Created Successful");
				return new ResponseEntity<>("Defect Type added succesfully", HttpStatus.OK);
			}
			logger.info("Defect Type Controller -> Defect Type creation FAILED!!!");
			return new ResponseEntity<>("SAVE FAILED!", HttpStatus.BAD_REQUEST);
		}
		finally {
			logger.info("Defect Type Controller INFO -> Save Defect Type Method Finished");
		}
	}

	// Update Type
	@PutMapping("/Type")
	public ResponseEntity<String> updateType(@RequestBody TypeDto typeDto) {
		logger.info("Defect Type Controller INFO -> Update Defect Type Method Started");
		try {
			if (typeMapper.updateDefectType(typeDto) != null) {
				return new ResponseEntity<>("Defect Type Updated Sucessfully", HttpStatus.OK);
			}
			logger.warn("Defect Type Controller WARNING! -> Defect Type Updated Failed!!!");
			return new ResponseEntity<>("Update FAILED!", HttpStatus.BAD_REQUEST);
		} finally {
			logger.info("Defect Type Controller INFO -> Update Defect Type Method Finished");
		}
	}

	// Delete Type
	@DeleteMapping("/Type/{typeId}")
	public ResponseEntity<String> deleteType(@PathVariable(name = "typeId") Long typeId) {
		logger.info("Defect Type Controller INFO -> Delete Defect Type Method Started");
		try {
			// check type id
			if (typeMapper.getDefectTypeById(typeId) != null){
				// delete type by id
				if (typeMapper.deleteDefectTypeById(typeId) == null) {
					logger.info("Defect Type Controller INFO -> Defect Type Deleted Successful -> Type Id :" + typeId);
					return new ResponseEntity<>("Type Sucessfully deleted", HttpStatus.OK);
				}
			} else {
				logger.warn("Defect Type Controller WARNING! -> Delete Failed, Defect Type Id Not Found -> Type Id :" + typeId);
				return new ResponseEntity<>("Defect Type Id Not FOUND! -> Defect Type Id :" + typeId,
						HttpStatus.BAD_REQUEST);
			}
		} finally {
			logger.info("Defect Type Controller INFO -> Delete Defect Type Method Started");
		}
		return null;
	}
}
