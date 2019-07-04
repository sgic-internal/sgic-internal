package com.sgic.internal.defecttracker.project.controller.converter;

import java.util.ArrayList;
import java.util.List;

import com.sgic.internal.defecttracker.project.controller.dto.ModuleData;
import com.sgic.internal.defecttracker.project.entities.Module;

public class ModuleConverter {
	private ModuleConverter() {
	}

	public static ModuleData moduleToModuleData(Module module) {
		ModuleData moduleData = new ModuleData();

		if (module != null) {
			moduleData.setModuleId(module.getModuleId());
			moduleData.setModuleName(module.getModuleName());
			return moduleData;
		}
		return null;
	}
	
	public static Module moduleDataToModule(ModuleData moduleData) {
		Module module = new Module();  
		
		module.setModuleId(moduleData.getModuleId());
		module.setModuleName(moduleData.getModuleName());
		return module;
	}
	
	public static List<ModuleData> moduleToModuleData(List<Module> moduleList) {

		if (moduleList != null) {
			List<ModuleData> lModuleData = new ArrayList<>();
			for (Module module : moduleList) {
				ModuleData moduleData = new ModuleData();
				
				moduleData.setModuleId(module.getModuleId());
				moduleData.setModuleName(module.getModuleName());
				lModuleData.add(moduleData);
			}

			return lModuleData;
		}
		return null;

	}


}
