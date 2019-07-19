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

import java.sql.Date;
import java.util.List;
import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sgic.internal.defecttracker.defect.controller.dto.DefectData;
import com.sgic.internal.defecttracker.defect.controller.dto.mapper.DefectDataMapper;
import com.sgic.internal.defecttracker.defect.entities.Defect;
import com.sgic.internal.defecttracker.defect.repositories.DefectRepository;
import com.sgic.internal.defecttracker.defect.services.DefectService;
import com.sgic.internal.defecttracker.project.entities.Module;
import com.sgic.internal.defecttracker.project.entities.Project;
import com.sgic.internal.defecttracker.project.services.ModuleService;
import com.sgic.internal.defecttracker.project.services.ProjectService;
@CrossOrigin
@RestController
public class DefectController {

	@Autowired
	private DefectDataMapper defectDataMapper;
	
	@Autowired
	private ModuleService moduleService;
	
	@Autowired
	private DefectService defectService;
	
	@Autowired
	private DefectRepository defectRepository;
	
	@Autowired
	private ProjectService projectService;
	

	private static Logger logger = LogManager.getLogger(DefectDataMapper.class);

	@GetMapping(value = "/getAllDefects")
	public List<DefectData> getAllDefects() {
		logger.info("Controller -> getAllDefects Successfull");
		return defectDataMapper.getAllDefects();
	}

	@GetMapping(value = "/getDefectById/{defectId}")
	public DefectData getByDefectId(@PathVariable(name = "defectId") String defectId) {
		logger.info("Controller -> getByDefectId Successfull");
		return defectDataMapper.getByDefectId(defectId);

	}

	
	@GetMapping(value = "/getAllDefectsByProjectId/{projectId}")
	public List<DefectData> getByProjectId(@PathVariable(name = "projectId") String projectId) {
		logger.info("Controller -> getByProjectId Successfull");
		return defectDataMapper.getAllDefectByProjectById(projectId);
	}

	@GetMapping(value = "/getAllDefectsByModuleId/{moduleId}")
	public List<DefectData> getByModuleId(@PathVariable(name = "moduleId") String moduleId) {
		logger.info("Controller -> getBymoduleId Successfull");
		return defectDataMapper.getAllDefectByModuleById(moduleId);
	}
	
	@GetMapping(value = "/getAllDefectsByDate/{dateAndTime}")
	public List<DefectData> getByDate(@PathVariable(name = "dateAndTime") Date dateAndTime) {
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
	@GetMapping(value = "/getDefectsByStatus/{status}")
	public List<DefectData> getByStatus(@PathVariable(name = "status") String status) {
		logger.info("Controller -> getByDate Successfull");
		return defectDataMapper.getAllDefectByStatus(status);
	}
	@GetMapping(value = "/getDefectsByPriority/{priority}")
	public List<DefectData> getByPriority(@PathVariable(name = "priority") String priority) {
		logger.info("Controller -> getByDate Successfull");
		return defectDataMapper.getAllDefectByPriority(priority);
	}
	@GetMapping(value = "/getDefectsBySeverity/{severity}")
	public List<DefectData> getBySeverity(@PathVariable(name = "severity") String severity) {
		logger.info("Controller -> getByDate Successfull");
		return defectDataMapper.getAllDefectBySeverity(severity);
	}
	@GetMapping(value = "/getDefectsByType/{type}")
	public List<DefectData> getByType(@PathVariable(name = "type") String type) {
		logger.info("Controller -> getByDate Successfull");
		return defectDataMapper.getAllDefectByType(type);
	}
	@GetMapping(value = "/getDefectsByAvailableIn/{availableIn}")
	public List<DefectData> getByAvailableIn(@PathVariable(name = "availableIn") String availableIn) {
		logger.info("Controller -> getByDate Successfull");
		return defectDataMapper.getAllDefectByAvailableIn(availableIn);
	}
	@GetMapping(value = "/getDefectsByFoundIn/{foundIn}")
	public List<DefectData> getByFoundIn(@PathVariable(name = "foundIn") String foundIn) {
		logger.info("Controller -> getByfoundIn Successfull");
		return defectDataMapper.getAllDefectByFoundIn(foundIn);
	}
	@GetMapping(value = "/getDefectsByFixedIn/{fixedIn}")
	public List<DefectData> getByFixedIn(@PathVariable(name = "fixedIn") String fixedIn) {
		logger.info("Controller -> getByfixedIn Successfull");
		return defectDataMapper.getAllDefectByFixedIn(fixedIn);
	}
	
	
	@GetMapping(value = "/getMockDefect")
	public DefectData getMockDefect() {
		return new DefectData();
	}
	
	@GetMapping(value = "/getCount")
	public Long getCount() {
		return defectService.countDefect();
		
	}
	
	@GetMapping(value = "/getDefectDensity")
	public double getDefectDensity() {
		return defectService.countDefectDensity();
		
	}
	
	
	//Create defect service
	@PutMapping("/defect/module/{moduleId}")
	public Defect createNewDefect(@PathVariable(name = "moduleId") String moduleId,
			@RequestBody DefectData defectData) {
		
		Module module = moduleService.getByModuleId(moduleId);
		List<Defect> defect = defectRepository.findDefectByModule(module);
		int def = defect.size();
		String defectSerial = moduleId+"-"+def;
		 
		 Defect defects= new Defect();
		 
		 Project project = projectService.getByprojectId(defectData.getProjectId());
		
			
		    defects.setDefectId(defectSerial);
			
			
			defects.setProject(project);
			defects.setModule(module);
		    defects.setAbbre(defectData.getAbbre());
		    defects.setDefectDescription(defectData.getDefectDescription());
			defects.setStepsToRecreate(defectData.getStepsToRecreate());
			defects.setAssignTo(defectData.getAssignTo());
			defects.setReassignTo(defectData.getReassignTo());
			defects.setEnteredBy(defectData.getEnteredBy());
			defects.setFixedBy(defectData.getFixedBy());
			defects.setDateAndTime(defectData.getDateAndTime());
			defects.setAvailableIn(defectData.getAvailableIn());
			defects.setFoundIn(defectData.getFoundIn());
			defects.setFixedIn(defectData.getFixedIn());
		 
		 
		 
				return defectRepository.save(defects);
	}
	
	//Hari matrix
	
	@GetMapping(value = "/getStatusNew")
	public Long getStatusNew() {
		return defectService.getStatusNew();	
	}
	
	@GetMapping(value = "/getStatusOpen")
	public Long getStatusOpen() {
		return defectService.getStatusOpen();	
	}
	
	@GetMapping(value = "/getStatusClose")
	public Long getStatusClose() {
		return defectService.getStatusClose();
	}
	
	@GetMapping(value = "/getStatusRejected")
	public Long getStatusRejected() {
		return defectService.getStatusRejected();
	}
	
	@GetMapping(value = "/getStatusReOpen")
	public Long getStatusReOpen() {
		return defectService.getStatusReOpen();
	}
	
	@GetMapping(value = "/getStatusFixed")
	public Long getStatusFixed() {
		return defectService.getStatusFixed();
	}
	
	@GetMapping(value = "/getStatusDefered")
	public Long getStatusDefered() {
		return defectService.getStatusDefered();
	}
	
}