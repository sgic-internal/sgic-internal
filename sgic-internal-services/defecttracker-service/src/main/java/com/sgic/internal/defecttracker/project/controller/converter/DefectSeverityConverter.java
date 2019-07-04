package com.sgic.internal.defecttracker.project.controller.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sgic.internal.defecttracker.project.controller.dto.DefectSeverityDto;
import com.sgic.internal.defecttracker.project.entities.DefectSeverity;

@Service
public class DefectSeverityConverter {

	private DefectSeverityConverter() {

	}

	// Convert Entity to Dto
	public static DefectSeverityDto defectSeverityToDefectSeverityDto(DefectSeverity defectSeverity) {
		DefectSeverityDto defectSeverityDto = new DefectSeverityDto();

		if (defectSeverity != null) {
			defectSeverityDto.setId(defectSeverity.getId());
			defectSeverityDto.setName(defectSeverity.getName());
			defectSeverityDto.setValue(defectSeverity.getValue());
			defectSeverityDto.setIcon(defectSeverity.getIcon());
			defectSeverityDto.setColor(defectSeverity.getColor());
			return defectSeverityDto;
		}
		return null;
	}

	// Convert Dto to Entity
	public static DefectSeverity defectSeverityDtoToDefectSeverity(DefectSeverityDto defectSeverityDto) {
		DefectSeverity defectSeverity = new DefectSeverity();
		defectSeverity.setId(defectSeverityDto.getId());
		defectSeverity.setName(defectSeverityDto.getName());
		defectSeverity.setValue(defectSeverityDto.getValue());
		defectSeverity.setIcon(defectSeverityDto.getIcon());
		defectSeverity.setColor(defectSeverityDto.getColor());
		return defectSeverity;
	}

	// Convert Entity To Dto List
	public static List<DefectSeverityDto> defectSeverityToDefectSeverityDto(List<DefectSeverity> defectSeverityList) {
		if(defectSeverityList != null) {
			List<DefectSeverityDto> defectSeverityDtoList = new ArrayList<>();
			for(DefectSeverity defectSeverity : defectSeverityList) {
				DefectSeverityDto defectSeverityDto = new DefectSeverityDto();
				defectSeverityDto.setId(defectSeverity.getId());
				defectSeverityDto.setName(defectSeverity.getName());
				defectSeverityDto.setValue(defectSeverity.getValue());
				defectSeverityDto.setIcon(defectSeverity.getIcon());
				defectSeverityDto.setColor(defectSeverity.getColor());
				defectSeverityDtoList.add(defectSeverityDto);
			}
			return defectSeverityDtoList;
		}
		return null;
	}

}
