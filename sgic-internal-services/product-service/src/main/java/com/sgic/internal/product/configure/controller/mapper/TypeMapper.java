package com.sgic.internal.product.configure.controller.mapper;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.internal.product.configure.controller.dto.TypeDto;
import com.sgic.internal.product.configure.controller.dto.converter.TypeConverter;
import com.sgic.internal.product.configure.entities.DefectType;
import com.sgic.internal.product.configure.services.TypeService;


@Service
public class TypeMapper {
	@Autowired
	private TypeConverter typeConverter;
	@Autowired
	private TypeService typeService;

	private static Logger logger = LogManager.getLogger(TypeDto.class);

	// Get All Status
	@SuppressWarnings("static-access")
	public List<TypeDto> getAllDefectType() {
		logger.info("Defect Type Mapper INFO -> Get All Defect Type Method Started");
		try {
		List<DefectType> defectTypeList = typeService.getAllDefectType();
		return typeConverter.EntityListTODtoList(defectTypeList);
		} finally {
			logger.info("Defect Type Mapper INFO -> Get All Defect Type Method Finished");
		}
	}

	// Save Status
	@SuppressWarnings("static-access")
	public DefectType saveDefectType(TypeDto typeDto) {
		logger.info("Defect Type Mapper INFO -> Save Defect Type Method Started");
		try {
		return typeService.createDefectType(typeConverter.DtoToEntity(typeDto));
		} finally {
			logger.info("Defect Type Mapper INFO -> Save Defect Type Method Finished");
		}
	}

	// Update Status
	@SuppressWarnings("static-access")
	public DefectType updateDefectType(TypeDto typeDto) {
		logger.info("Defect Type Mapper INFO -> Update Defect Type Method Started");
		try {
		return typeService.updateDefectType(typeConverter.DtoToEntityUpdate(typeDto));
		} finally {
			logger.info("Defect Type Mapper INFO -> Update Defect Type Method Finished");
		}
	}

	// Delete Status
	public TypeDto deleteDefectTypeById(Long typeId) {
		logger.info("Defect Type Mapper INFO -> Delete Defect Type Method Started");
		try {
		typeService.deleteDefectTypeById(typeId);
	} finally {
		logger.info("Defect Type Mapper INFO -> Delete Defect Type Method Finished");
	}
		return null;
	}

	// Get Status By Id
	@SuppressWarnings("static-access")
	public TypeDto getDefectTypeById(Long typeId) {
		logger.info("Defect Type Mapper INFO -> Get Defect Type By Id Method Started");
		try {
		DefectType defectType = typeService.getDefectTypeById(typeId);
		return typeConverter.EntityToDto(defectType);
		} finally {
			logger.info("Defect Type Mapper INFO -> Get Defect Type By Id Method Finished");
		}
	}
}
