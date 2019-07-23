package com.sgic.internal.defecttracker.defect.controller;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.common.api.enums.RestApiResponseStatus;
import com.sgic.common.api.response.ApiResponse;
import com.sgic.internal.defecttracker.defect.controller.dto.DefectConfigDto;
import com.sgic.internal.defecttracker.defect.controller.dto.mapper.DefectConfigMapper;
import com.sgic.internal.defecttracker.defect.services.impl.DefectTypeServiceImpl;

@RestController
public class DefectConfigController {
	private static Logger logger = LogManager.getLogger(DefectTypeServiceImpl.class);
	@Autowired DefectConfigMapper defectConfigMapper;
	
	@PostMapping(value = "/defectconfig")
	public ResponseEntity<Object> createDefectConfig(@RequestBody DefectConfigDto defectConfigDto) {
		BasicConfigurator.configure();
		if (defectConfigMapper.createDefectConfig(defectConfigDto)) {
			logger.info("Defect Config created");
			return new ResponseEntity<>(new ApiResponse(RestApiResponseStatus.OK), HttpStatus.OK);
		} else {
			logger.error("Defect Config Create Fail");
			return new ResponseEntity<>("Defect Config Added Failure", HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(value = "/defectconfig/{id}")
	public DefectConfigDto getDefectConfigById(@PathVariable Long id) {
		BasicConfigurator.configure();
		logger.info("Defect Type Get By Id Listed");
		return defectConfigMapper.getDefectConfigById(id);
	}

}
