package com.sgic.internal.product.configure.controller.dto.converter;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.sgic.internal.product.configure.controller.dto.TypeDto;
import com.sgic.internal.product.configure.entities.DefectType;

@Service
public class TypeConverter {
	private static Logger logger = LogManager.getLogger(DefectType.class);

	// Convert All List<Entity> to List<DTO>
	public static List<TypeDto> EntityListTODtoList(List<DefectType> defectTypeList) {
		if (defectTypeList != null) {
			logger.info("Defect Type Converter -> Convert Lists Entity to DTO");
			List<TypeDto> listTypeDto = new ArrayList<>();
			for (DefectType defectType : defectTypeList) {
				TypeDto typeDto = new TypeDto();
				typeDto.setTypeId(defectType.getId());
				typeDto.setTypeName(defectType.getName());
				typeDto.setTypeValue(defectType.getValue());
				listTypeDto.add(typeDto);
			}
			return listTypeDto;
		}
		return null;
	}

	// Convert Data To Entity
			public static DefectType DtoToEntity(TypeDto typeDto) {
				DefectType defectType = new DefectType();
				if (typeDto != null) {
					logger.info("Defect Type Converter -> Convert Object DTO to Entity For Save");
					defectType.setName(typeDto.getTypeName());
					defectType.setValue(typeDto.getTypeValue());
					return defectType;
				}
				return null;
			}

			// Convert Data To Entity
			public static DefectType DtoToEntityUpdate(TypeDto typeDto) {
				DefectType defectType = new DefectType();
				if (typeDto != null) {
					logger.info("Defect Type Converter -> Convert Object DTO to Entity For Update");
					defectType.setId(typeDto.getTypeId());
					defectType.setName(typeDto.getTypeName());
					defectType.setValue(typeDto.getTypeValue());
					return defectType;
				}
				return null;
			}

			// Convert Entity To Data
		public static TypeDto EntityToDto(DefectType defectType) {
			TypeDto typeDto = new TypeDto();
			if (defectType != null) {
				logger.info("Defect Type Converter -> Convert Object Entity to DTO");
				typeDto.setTypeId(defectType.getId());
				typeDto.setTypeName(defectType.getName());
				typeDto.setTypeValue(defectType.getValue());
				return typeDto;
			}
			return null;
		}
}
