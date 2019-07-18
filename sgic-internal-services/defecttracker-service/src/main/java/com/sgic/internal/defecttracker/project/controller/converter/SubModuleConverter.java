package com.sgic.internal.defecttracker.project.controller.converter;


import java.util.ArrayList;
import java.util.List;

import com.sgic.internal.defecttracker.project.controller.dto.SubModuleData;
import com.sgic.internal.defecttracker.project.entities.Module;
import com.sgic.internal.defecttracker.project.entities.SubModule;

public class SubModuleConverter {
	
	private SubModuleConverter() {
	}

	public static SubModuleData subModuleToSubModuleData(SubModule subModule) {
		SubModuleData subModuleData = new SubModuleData();

		if (subModule != null) {
			
			subModuleData.setSubModuleId(subModule.getSubModuleId());
			subModuleData.setSubModuleName(subModule.getSubModuleName());
//			subModuleData.setAbbre(subModule.getAbbre());
			//get module  id
			@SuppressWarnings("unused")
			SubModule subModule1=new SubModule();
			subModuleData.setModuleId(subModule.getModule().getModuleId());
			return subModuleData;
	}
		return null;
	}
		public static SubModule subModuleDataToSubModule(SubModuleData subModuleData) {
			SubModule subModule = new SubModule();
			
			// module constructor
			Module module = new Module();
			
			subModule.setSubModuleId(subModuleData.getSubModuleId());;
			subModule.setSubModuleName(subModuleData.getSubModuleName());
			// get by module id
			module.setModuleId(subModuleData.getModuleId());
			subModule.setModule(module);
//			project.setProjectId(moduleData.getProjectid());
//			module.setProject(project);
			
//			subModule.setAbbre(subModuleData.getAbbre());
			return subModule;
		}
		
		public static List<SubModuleData>subModuleToSubModuleData(List<SubModule> subModuleList) {

			if (subModuleList != null) {
				List<SubModuleData> lSubModuleData = new ArrayList<>();
				for (SubModule submodule : subModuleList) {
					SubModuleData submoduleData = new SubModuleData();
					
					submoduleData.setSubModuleId(submodule.getSubModuleId());
					submoduleData.setSubModuleName(submodule.getSubModuleName());
//					submoduleData.setAbbre(submodule.getAbbre());
					
					
					submoduleData.setModuleId(submodule.getModule().getModuleId());
					lSubModuleData.add(submoduleData);
				}

				return lSubModuleData;
			}
			return null;

		}

	}

		

