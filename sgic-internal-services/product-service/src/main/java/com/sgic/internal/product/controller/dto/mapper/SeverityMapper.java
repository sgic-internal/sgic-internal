package com.sgic.internal.product.controller.dto.mapper;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sgic.internal.product.controller.dto.SeverityDto;
import com.sgic.internal.product.controller.dto.converter.SeverityConverter;
import com.sgic.internal.product.entities.DefectSeverity;
import com.sgic.internal.product.services.SeverityService;

@Service
public class SeverityMapper {
	@Autowired
	private SeverityConverter severityConverter;
	@Autowired
	private SeverityService severityService;

	private static Logger logger = LogManager.getLogger(SeverityDto.class);

	// Get All Priority
	@SuppressWarnings("static-access")
	public List<SeverityDto> getAllSeverity() {
		logger.info("Severity Mapper -> All Severity Data Retrieved");
		List<DefectSeverity> defectSeverityList = severityService.getAllDefectSeverity();
		return severityConverter.EntityListTODtoList(defectSeverityList);
	}

	// Save Severity
	@SuppressWarnings("static-access")
	public DefectSeverity saveDefectSeverity(SeverityDto severityDto) {
		logger.info("Severity Mapper -> Severity Saved");
		return severityService.createDefectSeverity(severityConverter.DtoToEntity(severityDto));
	}

	// Update Severity
	@SuppressWarnings("static-access")
	public DefectSeverity updateDefectSeverity(SeverityDto severityDto) {
		logger.info("Severity Mapper -> Severity Updated ");
		return severityService.updateDefectSeverity(severityConverter.DtoToEntityUpdate(severityDto));
	}

	// Delete Severity
	public SeverityDto deleteDefectSeverityById(Long severityId) {
		logger.info("Severity Mapper -> Severity Deleted");
		severityService.deleteDefectSeverityById(severityId);
		return null;
	}

	// Get Severity By Id
	@SuppressWarnings("static-access")
	public SeverityDto getDefectSeverityById(Long severityId) {
		logger.info("Severity Mapper -> Severity Id Found");
		DefectSeverity defectSeverity = severityService.getDefectSeverityById(severityId);
		return severityConverter.EntityToDto(defectSeverity);
	}
}
