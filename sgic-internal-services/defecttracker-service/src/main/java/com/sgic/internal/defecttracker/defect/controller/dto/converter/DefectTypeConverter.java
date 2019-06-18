package com.sgic.internal.defecttracker.defect.controller.dto.converter;

import java.util.ArrayList;
import java.util.List;

import com.sgic.internal.defecttracker.defect.controller.dto.DefectTypeDto;
import com.sgic.internal.defecttracker.defect.entities.DefectType;

public class DefectTypeConverter {
	
	private DefectTypeConverter() {
		
	}
	
	// Convert Dto to Entity
	public static DefectTypeDto defectTypeToDefectTypeDto(DefectType defectType) {
		DefectTypeDto defectTypeDto = new DefectTypeDto();
		
		if(defectType != null) {
			defectTypeDto.setId(defectType.getId());
			defectTypeDto.setDefectType(defectType.getDefectType());
			return defectTypeDto;
		}
		return null;
	}
	
	public static DefectType defectTypeDtoToDefectType(DefectTypeDto defectTypeDto) {
		DefectType defectType = new DefectType();
		defectType.setId(defectTypeDto.getId());
		defectType.setDefectType(defectTypeDto.getDefectType());
		return defectType;
	}
	
	public static List<DefectTypeDto> defectTypeToDefectTypeDto(List<DefectType> defectTypeList){
		if(defectTypeList != null) {
			List<DefectTypeDto> listDafectTypeDto = new ArrayList<>();
			for (DefectType defectType: defectTypeList) {
				DefectTypeDto defectTypeDto = new DefectTypeDto();
				
				defectTypeDto.setId(defectType.getId());
				defectTypeDto.setDefectType(defectType.getDefectType());
				listDafectTypeDto.add(defectTypeDto);
			}
			return listDafectTypeDto;
		}
		return null;
	}

}
