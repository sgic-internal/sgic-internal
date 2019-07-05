package com.sgic.internal.defecttracker.project.controller.dtomapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.internal.defecttracker.project.controller.converter.ModuleConverter;
import com.sgic.internal.defecttracker.project.controller.dto.ModuleDto;
import com.sgic.internal.defecttracker.project.entities.Module;
import com.sgic.internal.defecttracker.project.services.ModuleService;

@Service
public class ModuleDtoMapper {
	
	@Autowired
	public ModuleService moduleService;
	
	public List<ModuleDto>getAllModuleForMapper(){
		List<Module>moduleList =moduleService.getallDetails();
		return ModuleConverter.moduleToModuleDto(moduleList);
	}
	
	public Module saveModuleforMapper(ModuleDto moduleDto) {
		Module module = ModuleConverter.moduleDtoToModule(moduleDto);
		return moduleService.createModule(module);
	}

	public ModuleDto getByModuleId(String moduleId) {
		Module module = moduleService.getByModuleId(moduleId);
		return ModuleConverter.moduleToModuleDto(module);
		
	}
	
	public List<ModuleDto> getBymoduleNameForMapper (String moduleName){
		List<Module> module = moduleService.getBymoduleName(moduleName);
		return ModuleConverter.moduleToModuleDto(module);
	}
	
	public Module UpdateModule(String moduleId, ModuleDto moduleDto) {
		Module module = ModuleConverter.moduleDtoToModule(moduleDto);
		return moduleService.updateModule(moduleId, module);
	}
	
	public ModuleDto deleteById(String moduleId) {
		moduleService.deleteById(moduleId);
		return null;
	}

}
