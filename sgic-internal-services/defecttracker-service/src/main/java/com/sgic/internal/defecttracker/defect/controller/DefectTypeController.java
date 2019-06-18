package com.sgic.internal.defecttracker.defect.controller;

import java.util.Optional;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.common.api.enums.RestApiResponseStatus;
import com.sgic.common.api.response.ApiResponse;
import com.sgic.internal.defecttracker.defect.controller.dto.DefectTypeData;
import com.sgic.internal.defecttracker.defect.entities.DefectType;
import com.sgic.internal.defecttracker.defect.services.DefectTypeService;
import com.sgic.internal.defecttracker.defect.services.impl.DefectTypeServiceImpl;

@RestController
public class DefectTypeController {
	private static Logger logger = LogManager.getLogger(DefectTypeServiceImpl.class);

	@Autowired
	private DefectTypeService defectTypeService;

	// Author : Varnitha :: Create Defect Type
	@PostMapping(value = "/defecttype")
	public ResponseEntity<Object> createDefectType(@RequestBody DefectTypeData defectTypeData) {
		DefectType defectType = new DefectType();
		defectType.setDefectType(defectTypeData.getDefectType());
		defectTypeService.createDefectType(defectType);
		
		BasicConfigurator.configure();
		logger.info("Defect Type Created.");
		
		return new ResponseEntity<>(new ApiResponse(RestApiResponseStatus.OK), HttpStatus.OK);

	}

	//Author : Shawmiya :: Delete Defect Type
	@DeleteMapping("/defecttype/{id}")
	public ResponseEntity delete(@PathVariable Long id) {
		defectTypeService.deleteDefectTypeById(id);
		
		BasicConfigurator.configure();
		logger.info("Defect Type deleted");
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}
	
	// Author : Varnitha :: Get Defect Type By Id
	@GetMapping(value="/defecttype/{id}")
	public Optional<DefectType> getDefectById(@PathVariable Long id){
		return (defectTypeService.findDefectTypeById(id));
	}
}
