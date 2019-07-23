package com.sgic.internal.defecttracker.project.controller.converter;

import java.util.ArrayList;
import java.util.List;

import com.sgic.internal.defecttracker.project.controller.dto.ModuleData;
import com.sgic.internal.defecttracker.project.entities.Module;
import com.sgic.internal.defecttracker.project.entities.Project;
import com.sgic.internal.defecttracker.project.entities.SubModule;

public class ModuleConverter {
	
	public static ModuleData moduleToModuleData(Module module) {
		ModuleData moduleData = new ModuleData();

		if (module != null) {
			moduleData.setModuleId(module.getModuleId());
			moduleData.setModuleName(module.getModuleName());

			new Module();
			moduleData.setProjectid(module.getProject().getProjectId());

			//get sub module id
//			Module module2=new Module();
//			moduleData.setSubModuleId(module.getSubModule().getSubModuleId());
//			moduleData.setSubModuleName(module.getSubModule().getSubModuleName());
			
//			moduleData.setAbbr(module.getAbbr());
			return moduleData;
		}
		return null;
	}
	
	public static Module moduleDataToModule(ModuleData moduleData) {
		Module module = new Module();  
		// project constructor
		Project project = new Project();
		
		new SubModule();
		
		module.setModuleId(moduleData.getModuleId());
		module.setModuleName(moduleData.getModuleName());
//		module.setAbbr(moduleData.getAbbr());
		
		// get by project id
		project.setProjectId(moduleData.getProjectid());
		module.setProject(project);
		
		// get by sub module id
//		subModule.setSubModuleId(moduleData.getSubModuleId());
//		subModule.setSubModuleName(moduleData.getSubModuleName());
//		module.setSubModule(subModule);
		
		return module;
	}
	
	public static List<ModuleData> moduleToModuleData(List<Module> moduleList) {

		if (moduleList != null) {
			List<ModuleData> lModuleData = new ArrayList<>();
			for (Module module : moduleList) {
				ModuleData moduleData = new ModuleData();
				
				moduleData.setModuleId(module.getModuleId());
				moduleData.setModuleName(module.getModuleName());
//				moduleData.setAbbr(module.getAbbr());
				// get project id
//				moduleData.setProjectid(module.getProject().getProjectId());
				
				// get sub module id
//				moduleData.setSubModuleId(module.getSubModule().getSubModuleId());
//				moduleData.setSubModuleName(module.getSubModule().getSubModuleName());
				
				lModuleData.add(moduleData);
			}

			return lModuleData;
		}
		return null;

	}


}
