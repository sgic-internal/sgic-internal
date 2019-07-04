package com.sgic.internal.defecttracker.project.controller.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sgic.internal.defecttracker.project.controller.dto.DefectStatusDto;
import com.sgic.internal.defecttracker.project.entities.DefectStatus;


@Service
public class DefectStatusConverter {
	private DefectStatusConverter() {
	}

// Convert entity to dto
	public DefectStatusDto defectStatustoDefectStatusDto(DefectStatus defectStatus) {
		DefectStatusDto defectStatusdto = new DefectStatusDto();
		if (defectStatus != null) {
			defectStatusdto.setId(defectStatus.getId());
			defectStatusdto.setName(defectStatus.getName());
			defectStatusdto.setValue(defectStatus.getValue());
			return defectStatusdto;
		}
		return null;
	}

// Convert dto to entity
	public DefectStatus defectStatusdtotodefectStatus(DefectStatusDto defectStatusDto) {
		DefectStatus defectStatus = new DefectStatus();

		defectStatus.setId(defectStatusDto.getId());
		defectStatus.setName(defectStatusDto.getName());
		defectStatus.setValue(defectStatusDto.getValue());
		return defectStatus;
	}

// Convert entity to dto list

	public List<DefectStatusDto> defectStatusTodefectStatusDto(List<DefectStatus> defectStatusList) {
		if (defectStatusList != null) {
			List<DefectStatusDto> listDefectStatusDto = new ArrayList<>();
			for (DefectStatus defectStatus : defectStatusList) {
				DefectStatusDto defectStatusDto = new DefectStatusDto();

				defectStatusDto.setId(defectStatus.getId());
				defectStatusDto.setName(defectStatus.getName());
				defectStatusDto.setValue(defectStatus.getValue());
				listDefectStatusDto.add(defectStatusDto);
			}
			return listDefectStatusDto;
		}
		return null;
	}
}
