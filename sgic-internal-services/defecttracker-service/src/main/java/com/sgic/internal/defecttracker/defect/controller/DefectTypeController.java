package com.sgic.internal.defecttracker.defect.controller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.sgic.common.api.enums.RestApiResponseStatus;
import com.sgic.common.api.response.ApiResponse;
import com.sgic.internal.defecttracker.defect.controller.dto.DefectTypeData;
import com.sgic.internal.defecttracker.defect.entities.DefectType;
import com.sgic.internal.defecttracker.defect.services.DefectTypeService;
import com.sgic.internal.defecttracker.defect.services.impl.DefectTypeServiceImpl;

@RestController
public class DefectTypeController {
	private static Logger Logger = LogManager.getLogger(DefectTypeServiceImpl.class);
	
	@Autowired
	private DefectTypeService defectTypeService;
	
	@PostMapping(value = "/defecttype")
	public ResponseEntity<Object> createDefectType(@RequestBody DefectTypeData defectTypeData){
		DefectType defectType = new DefectType();
		//defectType.setId(defectTypeData.getId());
		defectType.setDefectType(defectTypeData.getDefectType());
		defectTypeService.createDefectType(defectType);
		
		Logger.info("Defect Type Created.");
		
		return new ResponseEntity<>(new ApiResponse(RestApiResponseStatus.OK), HttpStatus.OK);
	}
}
