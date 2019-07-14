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
		try {
			logger.info("Priority Mapper -> Get All Defect Priority Method Started");
			List<DefectPriority> defectPriorityList = priorityService.getAllDefectPriority();
			return priorityConverter.EntityListTODtoList(defectPriorityList);
		} catch (Exception ex) {
			logger.error("Priority Mapper ERROR! -> " + ex.getMessage());
		} finally {
			logger.info("Priority Mapper INFO -> Get All Defect Priority Method Finished");
		}
		return null;
	}

	// Save Priority
	@SuppressWarnings("static-access")
	public DefectPriority saveDefectPriority(PriorityDto priorityDto) {
		try {
			logger.info("Priority Mapper -> Save Defect Priority Method Started");
			return priorityService.createDefectPriority(priorityConverter.DtoToEntity(priorityDto));
		} catch (Exception ex) {
			logger.error("Priority Mapper ERROR! -> " + ex.getMessage());
		} finally {
			logger.info("Priority Mapper INFO -> Save Defect Priority Method Finished");
		}
		return null;
	}

	// Update Priority
	@SuppressWarnings("static-access")
	public DefectPriority updateDefectPriority(PriorityDto priorityDto) {
		logger.info("Priority Mapper INFO -> Update Priority Method Started");
		try {
				return priorityService.updateDefectPriority(priorityConverter.DtoToEntityUpdate(priorityDto));
		} catch (Exception ex) {
			logger.error("Priority Mapper ERROR! -> " + ex.getMessage());
		} finally {
			logger.info("Priority Mapper INFO -> Update Defect Priority Method Finished");
		}
		return null;
	}

	// Delete Priority
	public PriorityDto deleteDefectPriorityById(Long priorityId) {
		try {
			logger.info("Priority Mapper -> Delete Defect Priority Method Started");
			priorityService.deleteDefectPriorityById(priorityId);
		} catch (Exception ex) {
			logger.error("Priority Mapper ERROR! -> " + ex.getMessage());
		} finally {
			logger.info("Priority Mapper INFO -> Delete Defect Priority Method Finished");
		}
		return null;
	}

	// Get Priority By Id
	@SuppressWarnings("static-access")
	public PriorityDto getDefectPriorityById(Long priorityId) {
		logger.info("Priority Mapper -> gET Defect Priority By Id Method Started");
		try {
				DefectPriority defectPriority = priorityService.getDefectPriorityById(priorityId);
				return priorityConverter.EntityToDto(defectPriority);
		} catch (Exception ex) {
			logger.error("Priority Mapper ERROR! -> " + ex.getMessage());
		} finally {
			logger.info("Priority Mapper INFO -> Get Defect Priority By Id Method Finished");
		}
		return null;
	}

}
