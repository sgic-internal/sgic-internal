package com.sgic.internal.defecttracker.project.controller.dtomapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.internal.defecttracker.project.controller.converter.ModuleConverter;
import com.sgic.internal.defecttracker.project.controller.dto.ModuleData;
import com.sgic.internal.defecttracker.project.entities.Module;
import com.sgic.internal.defecttracker.project.services.ModuleService;

@Service
public class ModuleDataMapper {
	
	@Autowired
	public  ModuleService moduleService;
	
	public List<ModuleData>getAllModuleForMapper(){
		List<Module>moduleList =moduleService.getallDetails();
		return ModuleConverter.moduleToModuleData(moduleList);
	}
	public Module saveModuleforMapper(ModuleData moduleData) {
		Module module = ModuleConverter.moduleDataToModule(moduleData);
		return moduleService.createModule(module);
	}

	public ModuleData getByModuleId(String moduleId) {
		Module module = moduleService.getByModuleId(moduleId);
		return ModuleConverter.moduleToModuleData(module);
		
	}
	
	public List<ModuleData> getBymoduleNameForMapper (String moduleName){
		List<Module> module = moduleService.getBymoduleName(moduleName);
		return ModuleConverter.moduleToModuleData(module);
	}
	
	public Module UpdateModule(String moduleId, ModuleData moduleData) {
		Module module = ModuleConverter.moduleDataToModule(moduleData);
		return moduleService.updateModule(moduleId, module);
	}
	
	public ModuleData deleteById(String moduleId) {
		moduleService.deleteById(moduleId);
		return null;
	}


}
