package com.sgic.internal.product.configure.controller.mapper;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.internal.product.configure.controller.dto.StatusDto;
import com.sgic.internal.product.configure.controller.dto.converter.StatusConverter;
import com.sgic.internal.product.configure.entities.DefectStatus;
import com.sgic.internal.product.configure.services.StatusService;


@Service
public class StatusMapper {
	@Autowired
	private StatusConverter statusConverter;
	@Autowired
	private StatusService statusService;

	private static Logger logger = LogManager.getLogger(StatusDto.class);

	// Get All Status
	@SuppressWarnings("static-access")
	public List<StatusDto> getAllStatus() {
		logger.info("Status Mapper -> All Status Data Retrieved");
		List<DefectStatus> defectStatusList = statusService.getAllDefectStatus();
		return statusConverter.EntityListTODtoList(defectStatusList);
	}

	// Save Status
	@SuppressWarnings("static-access")
	public DefectStatus saveDefectStatus(StatusDto statusDto) {
		logger.info("Status Mapper -> Status Saved");
		return statusService.createDefectStatus(statusConverter.DtoToEntity(statusDto));
	}

	// Update Status
	@SuppressWarnings("static-access")
	public DefectStatus updateDefectStatus(StatusDto statusDto) {
		logger.info("Status Mapper -> Status Updated ");
		return statusService.updateDefectStatus(statusConverter.DtoToEntityUpdate(statusDto));
	}

	// Delete Status
	public StatusDto deleteDefectStatusById(Long statusId) {
		logger.info("Status Mapper -> Status Deleted");
		statusService.deleteDefectStatusById(statusId);
		return null;
	}

	// Get Status By Id
	@SuppressWarnings("static-access")
	public StatusDto getDefectStatusById(Long statusId) {
		logger.info("Status Mapper -> Status Id Found");
		DefectStatus defectSeverity = statusService.getDefectStatusById(statusId);
		return statusConverter.EntityToDto(defectSeverity);
	}
}
