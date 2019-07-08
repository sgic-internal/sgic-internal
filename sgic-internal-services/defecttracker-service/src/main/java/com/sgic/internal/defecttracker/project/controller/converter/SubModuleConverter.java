package com.sgic.internal.defecttracker.project.controller.converter;


import java.util.ArrayList;
import java.util.List;

import com.sgic.internal.defecttracker.project.controller.dto.SubModuleData;
import com.sgic.internal.defecttracker.project.entities.SubModule;

public class SubModuleConverter {
	
	private SubModuleConverter() {
	}

	public static SubModuleData subModuleToSubModuleData(SubModule subModule) {
		SubModuleData subModuleData = new SubModuleData();

		if (subModule != null) {
			
			subModuleData.setSubModuleId(subModule.getSubModuleId());
			subModuleData.setSubModuleName(subModule.getSubModuleName());
			subModuleData.setAbbre(subModule.getAbbre());
			
			return subModuleData;
	}
		return null;
	}
		public static SubModule subModuleDataToSubModule(SubModuleData subModuleData) {
			SubModule subModule = new SubModule();
			
			subModule.setSubModuleId(subModuleData.getSubModuleId());;
			subModule.setSubModuleName(subModuleData.getSubModuleName());
			subModule.setAbbre(subModuleData.getAbbre());
			return subModule;
		}
		
		public static List<SubModuleData>subModuleToSubModuleData(List<SubModule> subModuleList) {

			if (subModuleList != null) {
				List<SubModuleData> lSubModuleData = new ArrayList<>();
				for (SubModule submodule : subModuleList) {
					SubModuleData submoduleData = new SubModuleData();
					
					submoduleData.setSubModuleId(submodule.getSubModuleId());
					submoduleData.setSubModuleName(submodule.getSubModuleName());
					submoduleData.setAbbre(submodule.getAbbre());
					lSubModuleData.add(submoduleData);
				}

				return lSubModuleData;
			}
			return null;

		}

	}

		

