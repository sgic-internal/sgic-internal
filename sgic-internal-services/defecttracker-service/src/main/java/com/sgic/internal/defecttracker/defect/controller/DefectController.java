package com.sgic.internal.defecttracker.defect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sgic.internal.defecttracker.defect.controller.dto.DefectData;
import com.sgic.internal.defecttracker.defect.controller.dto.mapper.DefectDataMapper;
import com.sgic.internal.defecttracker.defect.entities.SampleConfig;
import com.sgic.internal.defecttracker.defect.entities.SampleConfig2;
@CrossOrigin
@RestController
public class DefectController {

	@Autowired
	private DefectDataMapper defectDataMapper;

	private static Logger logger = LogManager.getLogger(DefectDataMapper.class);

	@GetMapping(value = "/getAllDefects")
	public List<DefectData> getAllDefects() {
		logger.info("Controller -> getAllDefects Successfull");
		return defectDataMapper.getAllDefects();
	}

	@GetMapping(value = "/getDefectById/{defectId}")
	public DefectData getByDefectId(@PathVariable(name = "defectId") Long defectId) {
		logger.info("Controller -> getByDefectId Successfull");
		return defectDataMapper.getByDefectId(defectId);

	}

	@GetMapping(value = "/getAllDefectsByStatusId/{statusId}")
	public List<DefectData> getByStatusId(@PathVariable(name = "statusId") int statusId) {
		logger.info("Controller -> getByStatusId Successfull");
		return defectDataMapper.getAllDefectByStatus(statusId);
	}
	
	@GetMapping(value = "/getAllDefectsByProjectId/{projectId}")
	public List<DefectData> getByProjectId(@PathVariable(name = "projectId") Long projectId) {
		logger.info("Controller -> getByProjectId Successfull");
		return defectDataMapper.getAllDefectByProjectById(projectId);
	}

	@GetMapping(value = "/getAllDefectsByModuleId/{moduleId}")
	public List<DefectData> getByModuleId(@PathVariable(name = "moduleId") Long moduleId) {
		logger.info("Controller -> getBymoduleId Successfull");
		return defectDataMapper.getAllDefectByModuleById(moduleId);
	}
	
	@GetMapping(value = "/getAllDefectsBySeverityId/{severityId}")
	public List<DefectData> getBySeverityId(@PathVariable(name = "severityId") int severityId) {
		logger.info("Controller -> getBySeverityId Successfull");
		return defectDataMapper.getAllDefectBySeverityById(severityId);
	}
	
	@GetMapping(value = "/getAllDefectsByPriorityId/{priorityId}")
	public List<DefectData> getByPriorityId(@PathVariable(name = "priorityId") int priorityId) {
		logger.info("Controller -> getByPriorityId Successfull");
		return defectDataMapper.getAllDefectByPriorityById(priorityId);
	}
	
	@GetMapping(value = "/getAllDefectsByDate/{dateAndTime}")
	public List<DefectData> getByDate(@PathVariable(name = "dateAndTime") String dateAndTime) {
		logger.info("Controller -> getByDate Successfull");
		return defectDataMapper.getAllDefectByDate(dateAndTime);
	}


	@PostMapping("/saveDefect")
	public ResponseEntity<String> saveDefect(@Valid @RequestBody DefectData defectData) {
		if (defectDataMapper.createDefect(defectData) != null) {
			logger.info("Defect Controller -> Defects Created Successful");
			return new ResponseEntity<>("Defect added succesfully", HttpStatus.OK);
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
	public ResponseEntity<String> deleteCompany(@PathVariable(name = "defectId") Long defectId) {
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
//	@GetMapping(value = "/getDefectsBy/{dateAndTime}")
//	public List<DefectData> getByDate(@PathVariable(name = "dateAndTime") String dateAndTime) {
//		logger.info("Controller -> getByDate Successfull");
//		return defectDataMapper.getAllDefectByDate(dateAndTime);
//	}
	
	@GetMapping(value = "/getMockDefect")
	public DefectData getMockDefect() {
		return new DefectData();
	}
	
	

// Mock --------------------------------------------------------------------------------------------
	
		// Priority Config
		@GetMapping(value = "/getPriorityConfig")
		public List getPriorityConfig() {
		
			List<SampleConfig> list = new ArrayList();
			
			list.add(new SampleConfig(1,"High"));
			list.add(new SampleConfig(2,"Medium"));
			list.add(new SampleConfig(3,"Low"));
			
			return list;
		}
		
		@GetMapping(value = "/getSeverityConfig")
		public List getSeverityConfig() {
		
			List<SampleConfig> list = new ArrayList();
			
			list.add(new SampleConfig(1,"High"));
			list.add(new SampleConfig(2,"Medium"));
			list.add(new SampleConfig(3,"Low"));
			
			return list;
		}
		
		@GetMapping(value = "/getDefectStatuses")
		public List getDefectStatuses() {
		
			List<SampleConfig> list = new ArrayList();
			
			list.add(new SampleConfig(1,"Opened"));
			list.add(new SampleConfig(2,"Reopened"));
			list.add(new SampleConfig(3,"Closed"));
			list.add(new SampleConfig(4,"Out of scope"));
			list.add(new SampleConfig(5,"Rejected"));
			
			return list;
		}
		
		@GetMapping(value = "/getProjects")
		public List getProjects() {
		
			List<SampleConfig> list = new ArrayList();
			
			list.add(new SampleConfig(1,"SCMS"));
			list.add(new SampleConfig(2,"WeatherApp"));
			
			return list;
		}
		
		@GetMapping(value = "/getModules")
		public List getModules() {
		
			List<SampleConfig2> list = new ArrayList();
			
			list.add(new SampleConfig2(1, 1, "Patient Dashboard"));
			list.add(new SampleConfig2(2, 1, "Setting"));
			list.add(new SampleConfig2(3, 2, "Welcome Screen"));
			list.add(new SampleConfig2(4, 2, "API"));
			list.add(new SampleConfig2(5, 2, "Main Screen"));
			
			return list;
		}
}
