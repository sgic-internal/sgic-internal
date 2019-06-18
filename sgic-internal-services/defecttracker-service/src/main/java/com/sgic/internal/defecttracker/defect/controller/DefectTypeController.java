package com.sgic.internal.defecttracker.defect.controller;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.annotation.DeterminableImports;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.common.api.enums.RestApiResponseStatus;
import com.sgic.common.api.response.ApiResponse;
import com.sgic.internal.defecttracker.defect.controller.dto.DefectTypeDto;
import com.sgic.internal.defecttracker.defect.controller.dto.converter.DefectTypeConverter;
import com.sgic.internal.defecttracker.defect.controller.dto.mapper.DefectTypeMapper;
import com.sgic.internal.defecttracker.defect.entities.DefectType;
import com.sgic.internal.defecttracker.defect.services.DefectTypeService;
import com.sgic.internal.defecttracker.defect.services.impl.DefectTypeServiceImpl;

@RestController
public class DefectTypeController {
	private static Logger logger = LogManager.getLogger(DefectTypeServiceImpl.class);

	@Autowired
	private DefectTypeMapper defectTypeMapper;

	@PostMapping(value = "/defecttype")
	public ResponseEntity<Object> createDefectType(@RequestBody DefectTypeDto defectTypeDto) {
		BasicConfigurator.configure();
		if(defectTypeMapper.createDefectType(defectTypeDto)) {
			logger.info("Defect Type created");
			return new ResponseEntity<>("Defect Type Added Succesfully", HttpStatus.OK);
		}
		logger.error("Defect Type Create Fail");
		return new ResponseEntity<>("Defect Type Added Failure", HttpStatus.OK);
	}

	// Author : Shawmiya :: Delete Defect Type
//	@DeleteMapping("/defecttype/{id}")
//	public ResponseEntity<Object> delete(@PathVariable Long id, @RequestBody DefectTypeDto defectTypeDto) {
//		if(defectTypeService.deleteDefectTypeById(id)) {
//			return new ResponseEntity<>("Defect Type Deleted Succesfully", HttpStatus.OK);
//		}
//		BasicConfigurator.configure();
//		logger.info("Defect Type Deleted.");
//
//		return new ResponseEntity<>("Defect Type Deleted Failure", HttpStatus.BAD_REQUEST);
//	}
	
	// Author : Paheerathan :: Get All Defect Types
//	@GetMapping(value = "/defecttypes")
//	public List<DefectType> getAllDefectTypes() {
//		List<DefectType> defectTypesList = defectTypeService.findAll();
//		
//		BasicConfigurator.configure();
//		logger.info("All Defect Types Listed.");
//		
//		return defectTypesList;
//	}

	// Author : Varnitha :: Get Defect Type By Id
//	@GetMapping(value = "/defecttype/{id}")
//	public ResponseEntity<DefectTypeDto> getDefectById(@PathVariable Long id) {
//		DefectType defectType = defectTypeService.findDefectTypeById(id);
//		
//		BasicConfigurator.configure();
//		logger.info("Get Defect Type By Id.");
//
//		return new ResponseEntity<>(DefectTypeDtoMapping.defectTypeToDefectTypeDto(defectType),HttpStatus.OK);
//	}

	// Author : Mathura :: Defect Type Updated
//	@PutMapping(value = "/defecttype/{id}")
//	public ResponseEntity<Object> updateDefectType(@RequestBody DefectType defectType, @PathVariable Long id) {
//		Optional<DefectType> defectTypeOptional = defectTypeService.findDefectTypeById(id);
//		if (!defectTypeOptional.isPresent()) {
//			return ResponseEntity.notFound().build();
//		}
//		defectType.setId(id);
//		defectTypeService.createDefectType(defectType);
//
//		BasicConfigurator.configure();
//		logger.info("Defect Type Updated.");
//
//		return ResponseEntity.noContent().build();
//	}
}
