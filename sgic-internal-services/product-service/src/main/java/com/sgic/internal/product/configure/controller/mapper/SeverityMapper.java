package com.sgic.internal.product.configure.controller.mapper;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.internal.product.configure.controller.dto.SeverityDto;
import com.sgic.internal.product.configure.controller.dto.converter.SeverityConverter;
import com.sgic.internal.product.configure.entities.DefectSeverity;
import com.sgic.internal.product.configure.services.SeverityService;



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
		logger.info("Priority Mapper -> All Priority Data Retrieved");
		List<DefectSeverity> defectSeverityList = severityService.getAllDefectSeverity();
		return severityConverter.EntityListTODtoList(defectSeverityList);
	}

	// Save Severity
	@SuppressWarnings("static-access")
	public DefectSeverity saveDefectPriority(SeverityDto severityDto) {
		logger.info("Priority Mapper -> Priority Saved");
		return severityService.createDefectSeverity(severityConverter.DtoToEntity(severityDto));
	}

	// Update Severity
	@SuppressWarnings("static-access")
	public DefectSeverity updateDefectPriority(SeverityDto severityDto) {
		logger.info("Priority Mapper -> Priority Updated ");
		return severityService.updateDefectSeverity(severityConverter.DtoToEntity(severityDto));
	}

	// Delete Severity
	public SeverityDto deleteDefectPriorityById(Long severityId) {
		logger.info("Priority Mapper -> Priority Deleted");
		severityService.deleteDefectSeverityById(severityId);
		return null;
	}

	// Get Severity By Id
	@SuppressWarnings("static-access")
	public SeverityDto getDefectPriorityById(Long severityId) {
		logger.info("Priority Mapper -> Priority Id Found");
		DefectSeverity defectSeverity = severityService.getDefectSeverityById(severityId);
		return severityConverter.EntityToDto(defectSeverity);
	}
}
