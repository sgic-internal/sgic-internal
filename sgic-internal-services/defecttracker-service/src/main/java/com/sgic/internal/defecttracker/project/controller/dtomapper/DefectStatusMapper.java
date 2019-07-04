package com.sgic.internal.defecttracker.project.controller.dtomapper;

import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.internal.defecttracker.project.controller.converter.DefectStatusConverter;
import com.sgic.internal.defecttracker.project.controller.dto.DefectStatusDto;
import com.sgic.internal.defecttracker.project.entities.DefectStatus;
import com.sgic.internal.defecttracker.project.services.DefectStatusService;
import com.sgic.internal.defecttracker.project.services.impl.DefectStatusServiceImpl;

@Service
public class DefectStatusMapper {

	@Autowired
	private DefectStatusService defectStatusService;

	@Autowired
	private DefectStatusConverter defectStatusConverter;

	private static Logger logger = LogManager.getLogger(DefectStatusServiceImpl.class);

	// Mapper for crating defect status
	public Boolean createDefectStatus(DefectStatusDto defectStatusDto) {
		BasicConfigurator.configure();
		DefectStatus defectStatus = defectStatusConverter.defectStatusdtotodefectStatus(defectStatusDto);
		defectStatusService.createDefectStatus(defectStatus);
		logger.info("Defect Status Create Mapper");
		return true;
	}

	// Mapper for listing all defect status
	public List<DefectStatusDto> getAllDefectStatus() {
		BasicConfigurator.configure();
		List<DefectStatus> defectStatusList = defectStatusService.findAllDefectStatus();
		if (defectStatusList != null) {
			logger.info("Defect Status List Mapper");
			return (defectStatusConverter.defectStatusTodefectStatusDto(defectStatusList));
		} else {
			logger.warn("No Defect Status");
			return null;
		}

	}

	// Mapper for getting defect status by id
	public DefectStatusDto getDefectstatusById(Long id) {
		BasicConfigurator.configure();
		DefectStatus defectStatusList = defectStatusService.findDefectStatusById(id);
		if (defectStatusList != null) {
			logger.info("Defect Status Get By Id Mapper");
			return defectStatusConverter.defectStatustoDefectStatusDto(defectStatusList);
		} else {
			logger.warn("No Defect Status By Id");
			return null;
		}

	}

	// Mapper for delete defect status
	public Boolean deleteDefectStatus(Long id) {
		BasicConfigurator.configure();
		if (defectStatusService.deleteDefectStatusById(id)) {
			logger.info("Defect Status Delete Mapper");
			return true;
		} else {
			logger.warn("No Defect Status");
			return false;
		}
	}

	// Mapper for update defect status
	public Boolean updateDefectStatus(Long id, DefectStatusDto defectStatusDto) {
		BasicConfigurator.configure();
		DefectStatus defectStatus = defectStatusConverter.defectStatusdtotodefectStatus(defectStatusDto);
		DefectStatus defectStatusList = defectStatusService.findDefectStatusById(id);
		if (defectStatusList == null) {
			logger.warn("No Defect Status By Id");
			return false;
		} else {
			defectStatus.setId(id);
			defectStatusService.createDefectStatus(defectStatus);
			logger.info("Defect Status Update Mapper");
			return true;
		}
	}

}
