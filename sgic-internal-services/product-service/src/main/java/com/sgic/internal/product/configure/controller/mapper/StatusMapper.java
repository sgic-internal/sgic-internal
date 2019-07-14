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
		logger.info("Defect Status Mapper INFO -> Get All Defect Status Method Started");
		try {
			List<DefectStatus> defectStatusList = statusService.getAllDefectStatus();
			return statusConverter.EntityListTODtoList(defectStatusList);
		} finally {
			logger.info("Defect Status Mapper INFO -> Get All Defect Status Method Finished");
		}
	}

	// Save Status
	@SuppressWarnings("static-access")
	public DefectStatus saveDefectStatus(StatusDto statusDto) {
		logger.info("Defect Status Mapper INFO -> Save Defect Status Method Started");
		try {
			return statusService.createDefectStatus(statusConverter.DtoToEntity(statusDto));
		} finally {
			logger.info("Defect Status Controller INFO -> Save Defect Status Method Finished");
		}
	}

	// Update Status
	@SuppressWarnings("static-access")
	public DefectStatus updateDefectStatus(StatusDto statusDto) {
		logger.info("Defect Status Mapper INFO -> Update Defect Status Method Started");
		try {
			return statusService.updateDefectStatus(statusConverter.DtoToEntityUpdate(statusDto));
		} finally {
			logger.info("Defect Status Mapper INFO -> Update Defect Status Method Finished");
		}
	}

	// Delete Status
	public StatusDto deleteDefectStatusById(Long statusId) {
		logger.info("Defect Status Mapper INFO -> Delete Defect Status Method Started");
		try {
			statusService.deleteDefectStatusById(statusId);
		} finally {
			logger.info("Defect Status Mapper INFO -> Delete Defect Status Method Finished");
		}
		return null;
	}

	// Get Status By Id
	@SuppressWarnings("static-access")
	public StatusDto getDefectStatusById(Long statusId) {
		logger.info("Defect Status Mapper INFO -> Get Defect Status By Id Method Started");
		try {
			DefectStatus defectSeverity = statusService.getDefectStatusById(statusId);
			return statusConverter.EntityToDto(defectSeverity);
		} finally {
			logger.info("Defect Status Mapper INFO -> Get Defect Status By Id Method Finished");
		}
	}
}
