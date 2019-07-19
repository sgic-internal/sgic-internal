package com.sgic.internal.defecttracker.project.controller;

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

import com.sgic.common.api.enums.RestApiResponseStatus;
import com.sgic.common.api.response.ApiResponse;
import com.sgic.internal.defecttracker.project.controller.dto.SubModuleData;
import com.sgic.internal.defecttracker.project.controller.dto.mapper.ModuleDataMapper;

import com.sgic.internal.defecttracker.project.controller.dto.mapper.SubModuleDataMapper;
import com.sgic.internal.defecttracker.project.entities.Module;
import com.sgic.internal.defecttracker.project.entities.SubModule;
import com.sgic.internal.defecttracker.project.repositories.SubModuleRepository;
import com.sgic.internal.defecttracker.project.services.ModuleService;
@CrossOrigin
@RestController
public class SubModuleController {

	private static Logger logger = LogManager.getLogger(SubModuleRepository.class);

	@Autowired
	public ModuleDataMapper moduleDataMapper;

	@Autowired
	public ModuleService moduleService;

	@Autowired
	public SubModuleRepository subModuleRepository;

	@Autowired
	public SubModuleDataMapper subModuleDataMapper;

	@PostMapping(value = "/createSubModule")
	public ResponseEntity<Object> createSubModule(@Valid @RequestBody SubModuleData subModuleData) {
		subModuleDataMapper.saveSubModuleforMapper(subModuleData);
		return new ResponseEntity<>(new ApiResponse(RestApiResponseStatus.OK), HttpStatus.OK);
	}

	// Post Mapping For Create a Module
	@GetMapping(value = "/GetAllsubmodule")
	public ResponseEntity<List<SubModuleData>> listSubModuleInfo() {
		logger.info("Module are listed ");
		return new ResponseEntity<>(subModuleDataMapper.getAllSubModuleForMapper(), HttpStatus.OK);

	}

	// Get Mapping For Get Sub Module By Id
	@GetMapping("/getSubModuleById/{subModuleId}")
	public ResponseEntity<SubModuleData> getSubModuleById(@PathVariable String subModuleId) {
		logger.info("Sub Moduleare get by Id ");
		return new ResponseEntity<>(subModuleDataMapper.getBySubModuleId(subModuleId), HttpStatus.OK);
	}

	// Delete Mapping For SubModule
	@DeleteMapping("deleteSubModuleById/{subModuleId}")
	public void  deleteSubModuleById(@PathVariable String subModuleId) {
		logger.info("SubModule are delete by Id ");
		  subModuleDataMapper.deleteSubModuleById(subModuleId);
	}


	// Put Mapping For SubModule
	@PutMapping("/updateSubModule/{submoduleId}")
	public ResponseEntity<String> updateSubModule(@PathVariable(name = "submoduleId") String submoduleId,
			@RequestBody SubModuleData submoduleDto) {
		logger.info("SubModulecontroller -> updatedmodule");
		if (subModuleDataMapper.UpdateSubModule(submoduleId, submoduleDto) != null)
			;
		{
			return new ResponseEntity<>("ok", HttpStatus.OK);
		}
	}

//		// Get Mapping For Submodule Name
	@GetMapping("/getSubModuleName/{submoduleName}")
	public List<SubModuleData> getByprojectName(@PathVariable String submoduleName) {
		logger.info("SubModule are get by name ");
		return subModuleDataMapper.getBysubModuleNameForMapper(submoduleName);
	}
	//////////////////////////////////////////////////////////////
//	//Abbrivation for module
//		@PutMapping("/submodule/module/{moduleId}")
//		public SubModule createNewSubModule(@PathVariable(name = "moduleId") String moduleId,
//				@RequestBody SubModuleData subModuleData) {
//			Module module = moduleService.getByModuleId(moduleId);
//			List<SubModule> submodules=subModuleRepository.findSubModuleByModule(module);
//			int a=submodules.size();
//			String submoduleSerial=module.getModuleId() +"-"+subModuleData.getSubModuleId()+"-"+ a;
//			
//			SubModule submodule=new SubModule();
//			submodule.setSubModuleId(submoduleSerial);
////			submodule.setAbbre(subModuleData.getAbbre());
//			submodule.setSubModuleName(subModuleData.getSubModuleName());
////			submodule.setModule(module);
//			submodule.setModule(module);
//			return subModuleRepository.save(submodule);
//		
//		}
}