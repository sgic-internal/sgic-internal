package com.sgic.internal.product.controller.dto.mapper;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sgic.internal.product.controller.dto.TypeDto;
import com.sgic.internal.product.controller.dto.converter.TypeConverter;
import com.sgic.internal.product.entities.DefectType;
import com.sgic.internal.product.services.TypeService;


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
		logger.info("Priority Mapper -> All Priority Data Retrieved");
		List<DefectType> defectTypeList = typeService.getAllDefectType();
		return typeConverter.EntityListTODtoList(defectTypeList);
	}

	// Save Status
	@SuppressWarnings("static-access")
	public DefectType saveDefectType(TypeDto typeDto) {
		logger.info("Priority Mapper -> Priority Saved");
		return typeService.createDefectType(typeConverter.DtoToEntity(typeDto));
	}

	// Update Status
	@SuppressWarnings("static-access")
	public DefectType updateDefectType(TypeDto typeDto) {
		logger.info("Priority Mapper -> Priority Updated ");
		return typeService.updateDefectType(typeConverter.DtoToEntityUpdate(typeDto));
	}

	// Delete Status
	public TypeDto deleteDefectTypeById(Long typeId) {
		logger.info("Priority Mapper -> Priority Deleted");
		typeService.deleteDefectTypeById(typeId);
		return null;
	}

	// Get Status By Id
	@SuppressWarnings("static-access")
	public TypeDto getDefectTypeById(Long typeId) {
		logger.info("Priority Mapper -> Priority Id Found");
		DefectType defectType = typeService.getDefectTypeById(typeId);
		return typeConverter.EntityToDto(defectType);
	}
}
