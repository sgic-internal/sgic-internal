package com.sgic.internal.defecttracker.project.controller;

import java.util.List;

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

import com.sgic.common.api.enums.RestApiResponseStatus;
import com.sgic.common.api.response.ApiResponse;
import com.sgic.internal.defecttracker.project.controller.dto.ModuleData;
import com.sgic.internal.defecttracker.project.controller.dto.mapper.ModuleDataMapper;
import com.sgic.internal.defecttracker.project.controller.dto.mapper.ProjectDtoMapper;
import com.sgic.internal.defecttracker.project.entities.Module;
import com.sgic.internal.defecttracker.project.entities.Project;
import com.sgic.internal.defecttracker.project.repositories.ModuleRepository;
import com.sgic.internal.defecttracker.project.services.ModuleService;
import com.sgic.internal.defecttracker.project.services.ProjectService;

@RestController
public class ModuleController {

//	private static Logger = LogManager.getLogger(ModuleRepository.class);

	@Autowired
	public ModuleDataMapper moduleDataMapper;
	
	@Autowired
	public ProjectDtoMapper projectDtoMapper;
	
	@Autowired
	public ProjectService projectService;
	
	@Autowired
	public ModuleRepository  moduleRepository;
	
	@Autowired
	public ModuleService moduleService;

	@PostMapping(value = "/module")
	public ResponseEntity<Object> createModule(@RequestBody ModuleData moduleData) {
		moduleDataMapper.saveModuleforMapper(moduleData);
		return new ResponseEntity<>(new ApiResponse(RestApiResponseStatus.OK), HttpStatus.OK);

	}

	// Author :: by Mercy
	// Post Mapping For Create a Project
	@GetMapping(value = "/GetAllmodule")
	public ResponseEntity<List<ModuleData>> listModuleInfo() {
//	logger.info("Module are listed ");
		return new ResponseEntity<>(moduleDataMapper.getAllModuleForMapper(), HttpStatus.OK);
	}

	// Get Mapping For Get Module By Id
	@GetMapping("/GetmoduleById/{moduleId}")
	public ResponseEntity<ModuleData> getModuleById(@PathVariable String moduleId) {
//			logger.info("Projects are get by id ");
		return new ResponseEntity<>(moduleDataMapper.getByModuleId(moduleId), HttpStatus.OK);
	}

	// Delete Mapping For Project
	@DeleteMapping("deleteById/{moduleId}")
	public ResponseEntity<ModuleData> deleteById(@PathVariable String moduleId) {
//			logger.info("Projects are delete by id ");
		return new ResponseEntity<>(moduleDataMapper.deleteById(moduleId), HttpStatus.OK);
	}

	// Put Mapping For Project
	@PutMapping("/updateModule/{moduleId}")
	public ResponseEntity<String> updateModule(@PathVariable(name = "moduleId") String moduleId,
			@RequestBody ModuleData moduleData) {
//			logger.info("Projectcontroller -> updatedproject");
		if (moduleDataMapper.UpdateModule(moduleId, moduleData) != null)
			;
		{
			return new ResponseEntity<>("ok", HttpStatus.OK);
		}
	}

	
	@PutMapping("/module/project/{projectId}")
	public Module createNewModule(@PathVariable(name = "projectId") String projectId,
			@RequestBody ModuleData moduleData) {
		Project project = projectService.getByprojectId(projectId);
		List<Module> modules=moduleRepository.findModuleByProject(project);
		int a=modules.size();
		String moduleSerial=project.getAbbr() +"-"+moduleData.getAbbr()+"-"+ a;
		
		Module module=new Module();
		module.setModuleId(moduleSerial);
		module.setAbbr(moduleData.getAbbr());
		module.setModuleName(moduleData.getModuleName());
		module.setProject(project);
		
		return moduleRepository.save(module);
		
	}

	

}
