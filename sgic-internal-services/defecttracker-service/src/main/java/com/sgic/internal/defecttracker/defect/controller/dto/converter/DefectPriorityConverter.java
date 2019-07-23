package com.sgic.internal.defecttracker.defect.controller.dto.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sgic.internal.defecttracker.defect.controller.dto.DefectPriorityDto;
import com.sgic.internal.defecttracker.defect.entities.DefectPriority;

@Service
public class DefectPriorityConverter {
	
	private DefectPriorityConverter() {

	}
	
	// Convert Entity to Dto
		public static DefectPriorityDto defectPriorityToDefectPriorityDto(DefectPriority defectPriority) {
			DefectPriorityDto defectPriorityDto = new DefectPriorityDto();

			if (defectPriority != null) {
				defectPriorityDto.setId(defectPriority.getId());
				defectPriorityDto.setName(defectPriority.getName());
				defectPriorityDto.setValue(defectPriority.getValue());
				defectPriorityDto.setIcon(defectPriority.getIcon());
				defectPriorityDto.setColor(defectPriority.getColor());
				return defectPriorityDto;
			}
			return null;
		}

		// Convert Dto to Entity
		public static DefectPriority defectPriorityDtoToDefectPriority(DefectPriorityDto defectPriorityDto) {
			DefectPriority defectPriority = new DefectPriority();
			defectPriority.setId(defectPriorityDto.getId());
			defectPriority.setName(defectPriorityDto.getName());
			defectPriority.setValue(defectPriorityDto.getValue());
			defectPriority.setIcon(defectPriorityDto.getIcon());
			defectPriority.setColor(defectPriorityDto.getColor());
			return defectPriority;
		}

		// Convert Entity To Dto List
		public static List<DefectPriorityDto> defectPriorityToDefectPriorityDto(List<DefectPriority> defectPriorityList) {
			if(defectPriorityList != null) {
				List<DefectPriorityDto> defectPriorityDtoList = new ArrayList<>();
				for(DefectPriority defectPriority : defectPriorityList) {
					DefectPriorityDto defectPriorityDto = new DefectPriorityDto();
					defectPriorityDto.setId(defectPriority.getId());
					defectPriorityDto.setName(defectPriority.getName());
					defectPriorityDto.setValue(defectPriority.getValue());
					defectPriorityDto.setIcon(defectPriority.getIcon());
					defectPriorityDto.setColor(defectPriority.getColor());
					defectPriorityDtoList.add(defectPriorityDto);
				}
				return defectPriorityDtoList;
			}
			return null;
		}
}
