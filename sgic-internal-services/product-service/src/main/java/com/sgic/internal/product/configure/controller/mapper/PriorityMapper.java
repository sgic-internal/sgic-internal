package com.sgic.internal.product.configure.controller.mapper;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.internal.product.configure.controller.dto.PriorityDto;
import com.sgic.internal.product.configure.controller.dto.converter.PriorityConverter;
import com.sgic.internal.product.configure.entities.DefectPriority;
import com.sgic.internal.product.configure.services.PriorityService;

@Service
public class PriorityMapper {
	@Autowired
	private PriorityConverter priorityConverter;
	@Autowired
	private PriorityService priorityService;

	private static Logger logger = LogManager.getLogger(PriorityDto.class);

	// Get All Priority
	@SuppressWarnings("static-access")
	public List<PriorityDto> getAllPriority() {
		logger.info("Priority Mapper -> All Priority Data Retrieved");
		List<DefectPriority> defectPriorityList = priorityService.getAllDefectPriority();
		return priorityConverter.EntityListTODtoList(defectPriorityList);
	}

	// Save Priority
	@SuppressWarnings("static-access")
	public DefectPriority saveDefectPriority(PriorityDto priorityDto) {
		logger.info("Priority Mapper -> Priority Saved");
		return priorityService.createDefectPriority(priorityConverter.DtoToEntity(priorityDto));
	}

	// Update Priority
	@SuppressWarnings("static-access")
	public DefectPriority updateDefectPriority(PriorityDto priorityDto) {
		logger.info("Priority Mapper -> Priority Updated ");
		return priorityService.updateDefectPriority(priorityConverter.DtoToEntityUpdate(priorityDto));
	}

	// Delete Priority
	public PriorityDto deleteDefectPriorityById(Long priorityId) {
		logger.info("Priority Mapper -> Priority Deleted");
		priorityService.deleteDefectPriorityById(priorityId);
		return null;
	}

	// Get Priority By Id
	@SuppressWarnings("static-access")
	public PriorityDto getDefectPriorityById(Long priorityId) {
		logger.info("Priority Mapper -> Priority Id Found");
		DefectPriority defectPriority = priorityService.getDefectPriorityById(priorityId);
		return priorityConverter.EntityToDto(defectPriority);
	}

}
