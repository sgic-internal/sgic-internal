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
import com.sgic.internal.defecttracker.project.controller.data.ModuleData;
import com.sgic.internal.defecttracker.project.controller.dtomapper.ModuleDataMapper;

@RestController
public class ModuleController {

//	private static Logger = LogManager.getLogger(ModuleRepository.class);

	@Autowired
	public ModuleDataMapper moduleDataMapper;

	@PostMapping(value = "/createmodule")
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
	// Get Mapping For Module Name
		@GetMapping("/getmoduleName/{moduleName}")
		public List<ModuleData> getBymoduleName(@PathVariable String moduleName) {
//				logger.info("Projects are get by name ");
			return moduleDataMapper.getBymoduleName(moduleName), HttpStatus.OK);
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

	

}
