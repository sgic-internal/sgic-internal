package com.sgic.internal.product.configure.controller.dto.converter;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.sgic.internal.product.configure.controller.dto.SeverityDto;
import com.sgic.internal.product.configure.entities.DefectSeverity;

@Service
public class SeverityConverter {
	private static Logger logger = LogManager.getLogger(DefectSeverity.class);

	// Convert All List<Entity> to List<DTO>
	public static List<SeverityDto> EntityListTODtoList(List<DefectSeverity> defectSeverityList) {
		if (defectSeverityList != null) {
			logger.info("Defect Severity Converter -> Convert Lists Entity to DTO");
			List<SeverityDto> listSeverityDto = new ArrayList<>();
			for (DefectSeverity defectSeverity : defectSeverityList) {
				SeverityDto severityDto = new SeverityDto();
				severityDto.setSeverityId(defectSeverity.getId());
				severityDto.setSeverityName(defectSeverity.getName());
				severityDto.setSeverityValue(defectSeverity.getValue());
				severityDto.setSeverityIcon(defectSeverity.getIcon());
				severityDto.setSeverityColor(defectSeverity.getColor());
				listSeverityDto.add(severityDto);
			}
			return listSeverityDto;
		}
		return null;
	}

	// Convert Data To Entity
		public static DefectSeverity DtoToEntity(SeverityDto severityDto) {
			DefectSeverity defectSeverity = new DefectSeverity();
			if (severityDto != null) {
				logger.info("Defect Severity Converter -> Convert Object DTO to Entity");
				defectSeverity.setId(severityDto.getSeverityId());
				defectSeverity.setName(severityDto.getSeverityName());
				defectSeverity.setValue(severityDto.getSeverityValue());
				defectSeverity.setIcon(severityDto.getSeverityIcon());
				defectSeverity.setColor(severityDto.getSeverityColor());
				
				return defectSeverity;
			}
			return null;
		}

		// Convert Entity To Data
		public static SeverityDto EntityToDto(DefectSeverity defectSeverity) {
			SeverityDto severityDto = new SeverityDto();
			if (defectSeverity != null) {
				logger.info("Defect Severity Converter -> Convert Object Entity to DTO");
				severityDto.setSeverityId(defectSeverity.getId());
				severityDto.setSeverityName(defectSeverity.getName());
				severityDto.setSeverityValue(defectSeverity.getValue());
				severityDto.setSeverityIcon(defectSeverity.getIcon());
				severityDto.setSeverityColor(defectSeverity.getColor());
				return severityDto;
			}
			return null;
		}
}
