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
		logger.info("Severity Mapper INFO -> Get All Severity Method Started");
		try {
			List<DefectSeverity> defectSeverityList = severityService.getAllDefectSeverity();
			return severityConverter.EntityListTODtoList(defectSeverityList);
		} finally {
			logger.info("Severity Mapper INFO -> Get All Severity Method Finished");
		}
	}

	// Save Severity
	@SuppressWarnings("static-access")
	public DefectSeverity saveDefectSeverity(SeverityDto severityDto) {
		logger.info("Severity Mapper INFO -> Save Severity Method Started");
		try {
			logger.info("Severity Mapper INFO -> Severity Saved");
			return severityService.createDefectSeverity(severityConverter.DtoToEntity(severityDto));
		} finally {
			logger.info("Severity Mapper INFO -> Save Severity Method Finished");
		}
	}

	// Update Severity
	@SuppressWarnings("static-access")
	public DefectSeverity updateDefectSeverity(SeverityDto severityDto) {
		logger.info("Severity Mapper INFO -> Update Severity Method Started");
		try {
			return severityService.updateDefectSeverity(severityConverter.DtoToEntityUpdate(severityDto));

		} finally {
			logger.info("Severity Mapper INFO -> Update Severity Method Finished");
		}
	}

	// Delete Severity
	public SeverityDto deleteDefectSeverityById(Long severityId) {
		logger.info("Severity Mapper INFO -> Delete Severity Method Started");
		try {
			severityService.deleteDefectSeverityById(severityId);
		} finally {
			logger.info("Severity Mapper INFO -> Delete Severity Method Finished");
		}
		return null;
	}

	// Get Severity By Id
	@SuppressWarnings("static-access")
	public SeverityDto getDefectSeverityById(Long severityId) {
		logger.info("Severity Mapper -> Get Severity By Id Method Started");
		try {
			DefectSeverity defectSeverity = severityService.getDefectSeverityById(severityId);
			return severityConverter.EntityToDto(defectSeverity);
		} finally {
			logger.info("Severity Mapper -> Get Severity By Id Method Finished");
		}
	}
}
