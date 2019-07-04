package com.sgic.internal.defecttracker.project.controller.converter;


import java.util.ArrayList;
import java.util.List;

import com.sgic.internal.defecttracker.project.controller.data.SubModuleData;

import com.sgic.internal.defecttracker.project.entities.SubModule;

public class SubModuleConverter {
	
	private SubModuleConverter() {
	}

	public static SubModuleData subModuleTosubModuleDto(SubModule subModule) {
		SubModuleData subModuleData = new SubModuleData();

		if (subModule != null) {
			
			subModuleData.setSubModuleId(subModule.getSubModuleId());
			subModuleData.setSubModuleName(subModule.getSubModuleName());
			
			return subModuleData;
	}
		return null;
	}
		public static SubModule subModuleDtoToSubModule(SubModuleData subModuleData) {
			SubModule subModule = new SubModule();
			
			subModule.setSubModuleId(subModuleData.getSubModuleId());;
			subModule.setSubModuleName(subModuleData.getSubModuleName());
			return subModule;
		}
		
		public static List<SubModuleData> subModuleToSubModuleDto(List<SubModule> subModuleList) {

			if (subModuleList != null) {
				List<SubModuleData> lSubModuleDto = new ArrayList<>();
				for (SubModule submodule : subModuleList) {
					SubModuleData submoduleDto = new SubModuleData();
					
					submoduleDto.setSubModuleId(submodule.getSubModuleId());
					submoduleDto.setSubModuleName(submodule.getSubModuleName());
					lSubModuleDto.add(submoduleDto);
				}

				return lSubModuleDto;
			}
			return null;

		}

	}

		

