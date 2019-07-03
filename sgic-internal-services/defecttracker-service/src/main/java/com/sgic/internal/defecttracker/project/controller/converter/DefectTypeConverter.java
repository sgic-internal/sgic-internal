package com.sgic.internal.defecttracker.project.controller.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sgic.internal.defecttracker.project.controller.dto.DefectTypeDto;
import com.sgic.internal.defecttracker.project.entities.DefectType;

@Service
public class DefectTypeConverter {
	
	private DefectTypeConverter() {
		
	}
	
	// Convert entity to dto
	public DefectTypeDto defectTypeToDefectTypeDto(DefectType defectType) {
		DefectTypeDto defectTypeDto = new DefectTypeDto();
		
		if(defectType != null) {
			defectTypeDto.setId(defectType.getId());
			defectTypeDto.setName(defectType.getName());
			defectTypeDto.setValue(defectType.getValue());
			return defectTypeDto;
		}
		return null;
	}
	
	// Convert dto to entity 
	public DefectType defectTypeDtoToDefectType(DefectTypeDto defectTypeDto) {
		DefectType defectType = new DefectType();
		defectType.setId(defectTypeDto.getId());
		defectType.setName(defectTypeDto.getName());
		defectType.setValue(defectTypeDto.getValue());
		return defectType;
	}
	
	// Convert entity to dto list
	public List<DefectTypeDto> defectTypeToDefectTypeDto(List<DefectType> defectTypeList){
		if(defectTypeList != null) {
			List<DefectTypeDto> listDefectTypeDto = new ArrayList<>();
			for (DefectType defectType: defectTypeList) {
				DefectTypeDto defectTypeDto = new DefectTypeDto();
				
				defectTypeDto.setId(defectType.getId());
				defectTypeDto.setName(defectType.getName());
				defectTypeDto.setValue(defectType.getValue());
				listDefectTypeDto.add(defectTypeDto);
			}
			return listDefectTypeDto;
		}
		return null;
	}
}
