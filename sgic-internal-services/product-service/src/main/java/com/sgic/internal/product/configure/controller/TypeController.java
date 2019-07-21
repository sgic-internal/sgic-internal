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

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
public class TypeController {
	@Autowired
	private TypeMapper typeMapper;
	private static Logger logger = LogManager.getLogger(TypeMapper.class);

	// Get All Type
	@GetMapping("/Types")
	public List<TypeDto> getAllTypes() {
		logger.info("Controller -> Data Retrieved Successfull");
		return typeMapper.getAllDefectType();
	}

	 //Get Type By Id
	@GetMapping("/Type/{typeId}")
	public TypeDto getTypeById(@PathVariable(name = "typeId") Long typeId) {
		logger.info("Controller -> Data Retrieved Successfull");
		return typeMapper.getDefectTypeById(typeId);
	}
	

	// Save All Type
	@PostMapping("/Type")
	public ResponseEntity<String> saveType(@Valid @RequestBody TypeDto typeDto) {
		if (typeMapper.saveDefectType(typeDto) != null) {
			logger.info("Type Controller -> Type Created Successful");
			return new ResponseEntity<>("Priority added succesfully", HttpStatus.OK);
		}
		logger.info("Type Controller -> Type creation FAILED!!!");
		return new ResponseEntity<>("SAVE FAILED!", HttpStatus.BAD_REQUEST);
	}

	// Update Type
	@PutMapping("/Type")
	public ResponseEntity<String> updateType(@RequestBody TypeDto typeDto) {
		logger.info("Type Controller -> Type Updated Successful");
		if (typeMapper.updateDefectType(typeDto) != null) {
			return new ResponseEntity<>("Sucessfully Updateed Company", HttpStatus.OK);
		}
		logger.info("Type Controller -> Type Updated Failed!!!");
		return new ResponseEntity<>("Update FAILED!!!", HttpStatus.BAD_REQUEST);
	}

	// Delete Type
	@DeleteMapping("/Type/{typeId}")
	public ResponseEntity<String> deleteType(@PathVariable(name = "typeId") Long typeId) {
		System.out.print(typeId);
		if (typeMapper.getDefectTypeById(typeId) != null) {
			if (typeMapper.deleteDefectTypeById(typeId) == null) {
				logger.info("Type Controller -> Type Deleted Successful");
				return new ResponseEntity<>("Type Sucessfully deleted", HttpStatus.OK);
			}
		} else {
			logger.info("Type Controller -> Type Id Not Found");
			return new ResponseEntity<>("Type Id Not FOUND!!!", HttpStatus.BAD_REQUEST);
		}
		logger.info("Type Controller -> Type Deleted Failed!!!");
		return new ResponseEntity<>("Delete FAILED!!!", HttpStatus.BAD_REQUEST);
	}
}
