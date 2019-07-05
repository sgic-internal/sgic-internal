package com.sgic.internal.defecttracker.project.controller.converter;

import java.util.ArrayList;
import java.util.List;

import com.sgic.internal.defecttracker.project.controller.dto.ModuleData;
import com.sgic.internal.defecttracker.project.entities.Module;
public class ModuleConverter {
	private ModuleConverter() {
	}

	public static ModuleData moduleToModuleData(Module module) {
		ModuleData moduleDto = new ModuleData();

		if (module != null) {
			moduleDto.setModuleId(module.getModuleId());
			moduleDto.setModuleName(module.getModuleName());
			moduleDto.setAbbr(module.getAbbr());
			return moduleDto;
		}
		return null;
	}
	public static Module moduleDataToModule(ModuleData moduleDto) {
		Module module = new Module();  
		
		module.setModuleId(moduleDto.getModuleId());
		module.setModuleName(moduleDto.getModuleName());
		module.setAbbr(moduleDto.getAbbr());
		return module;
	}
	
	public static List<ModuleData> moduleToModuleData(List<Module> moduleList) {

		if (moduleList != null) {
			List<ModuleData> lModuleDto = new ArrayList<>();
			for (Module module : moduleList) {
				ModuleData moduleDto = new ModuleData();
				
				moduleDto.setModuleId(module.getModuleId());
				moduleDto.setModuleName(module.getModuleName());
				moduleDto.setAbbr(module.getAbbr());
				lModuleDto.add(moduleDto);
			}

			return lModuleDto;
		}
		return null;

	}


}
