package com.sgic.internal.defecttracker.defect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import java.util.List;
import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sgic.internal.defecttracker.defect.controller.dto.DefectData;
import com.sgic.internal.defecttracker.defect.controller.dto.mapper.DefectDataMapper;

@RestController
public class DefectController {
	
	@Autowired
	private DefectDataMapper defectDataMapper;
	
	private static Logger logger = LogManager.getLogger(DefectDataMapper.class);
	
	@GetMapping(value="/getAllDefects")
	public List<DefectData>getAllDefects(){
		logger.info("Controller -> getAllDefects Successfull");
		return defectDataMapper.getAllDefects();
	}

	@GetMapping(value="/getDefectById/{defectId}")
	public DefectData getByDefectId(@PathVariable(name = "defectId")String defectId) {
		logger.info("Controller -> getByDefectId Successfull");
		return defectDataMapper.getByDefectId(defectId);
		
	}
	
	
	@PostMapping("/saveDefect")
	public ResponseEntity<String> saveDefect(@Valid @RequestBody DefectData defectData) {
		if ( defectDataMapper.createDefect(defectData)!= null) {
			logger.info("Defect Controller -> Defects Created Successful");
			return new ResponseEntity<>("Company added succesfully", HttpStatus.OK);
		}
		logger.info("Defect Controller -> Defects creation FAILED!!!");
		return new ResponseEntity<>("SAVE FAILED!", HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping("/updateDefect")
	public ResponseEntity<String> updateDefect(@RequestBody DefectData defectData) {
		logger.info("Defect Controller -> Defect Updated Successful");
		if (defectDataMapper.updateDefect(defectData) != null) {
			return new ResponseEntity<>("Sucessfully Updated Defect Detail", HttpStatus.OK);
		}
		logger.info("Defect Controller -> Defect Updated Failed!!!");
		return new ResponseEntity<>("Update FAILED!!!", HttpStatus.BAD_REQUEST);
	}
	
	
	@DeleteMapping("/deleteDefect/{defectId}")
	public ResponseEntity<String> deleteCompany(@PathVariable(name = "defectId") String defectId) {
		System.out.print(defectId);
		if (defectDataMapper.getByDefectId(defectId) != null) {
			if (defectDataMapper.deleteDefect(defectId) == null) {
				logger.info("Defect Controller -> Defect Deleted Successful");
				return new ResponseEntity<>("Defect Sucessfully deleted", HttpStatus.OK);
			}
		} else {
			logger.info("Defect Controller -> Defect Id Not Found");
			return new ResponseEntity<>("Defect Id Not FOUND!!!", HttpStatus.BAD_REQUEST);
		}
		logger.info("Defect Controller -> Defect Deleted Failed!!!");
		return new ResponseEntity<>("Delete FAILED!!!", HttpStatus.BAD_REQUEST);
	}
	
	
	
	@GetMapping(value="/getMockDefect")
	public DefectData getMockDefect() {
		return new DefectData();
	}
}
	

