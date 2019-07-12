package com.sgic.internal.defecttracker.defect.controller.dto.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sgic.internal.defecttracker.defect.controller.dto.DefectConfigDto;
import com.sgic.internal.defecttracker.defect.entities.DefectConfig;
import com.sgic.internal.defecttracker.project.entities.Project;

@Service
public class DefectConfigConverter {
	private DefectConfigConverter() {
		
	}
	
	// Convert entity to dto
		public DefectConfigDto defectConfigToDefectConfigDto(DefectConfig defectConfig) {
			DefectConfigDto defectConfigDto = new DefectConfigDto();
			
			if(defectConfig != null) {
				defectConfigDto.setConfigId(defectConfig.getConfigId());
				defectConfigDto.setProjectId(defectConfig.getProject().getProjectId());
				defectConfigDto.setName(defectConfig.getName());
				defectConfigDto.setValue(defectConfig.getValue());
				defectConfigDto.setColor(defectConfig.getColor());
				defectConfigDto.setIcon(defectConfig.getIcon());
				return defectConfigDto;
			}
			return null;
		}
		
		// Convert dto to entity 
		public DefectConfig defectConfigDtoToDefectConfig(DefectConfigDto defectConfigDto) {
			DefectConfig defectConfig = new DefectConfig();
			defectConfig.setConfigId(defectConfigDto.getConfigId());
			
			Project project = new Project();
			project.setProjectId(defectConfigDto.getProjectId());
			
			defectConfig.setName(defectConfigDto.getName());
			defectConfig.setValue(defectConfigDto.getValue());
			defectConfig.setColor(defectConfigDto.getColor());
			defectConfig.setIcon(defectConfigDto.getIcon());
			defectConfig.setProject(project);
			return defectConfig;
		}
		
		// Convert entity to dto list
		public List<DefectConfigDto> defectConfigToDefectConfigDto(List<DefectConfig> defectConfigList){
			if(defectConfigList != null) {
				List<DefectConfigDto> listDefectConfigDto = new ArrayList<>();
				for (DefectConfig defectConfig: defectConfigList) {
					DefectConfigDto defectConfigDto = new DefectConfigDto();
					
					defectConfigDto.setConfigId(defectConfig.getConfigId());
					defectConfigDto.setProjectId(defectConfig.getProject().getProjectId());
					defectConfigDto.setName(defectConfig.getName());
					defectConfigDto.setValue(defectConfig.getValue());
					defectConfigDto.setColor(defectConfig.getColor());
					defectConfigDto.setIcon(defectConfig.getIcon());
					listDefectConfigDto.add(defectConfigDto);
				}
				return listDefectConfigDto;
			}
			return null;
		}

}
