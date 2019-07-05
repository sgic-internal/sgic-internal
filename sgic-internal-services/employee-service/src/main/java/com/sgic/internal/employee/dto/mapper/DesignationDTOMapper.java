package com.sgic.internal.employee.dto.mapper;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.internal.employee.dto.DesignationDTO;
import com.sgic.internal.employee.dto.converter.DesignationConverter;
import com.sgic.internal.employee.entities.Designation;
import com.sgic.internal.employee.repositories.DesignationRepository;
import com.sgic.internal.employee.services.DesignationService;

@Service
public class DesignationDTOMapper {

	
	@Autowired
	private DesignationService designationService ;

	@Autowired
	private  DesignationConverter designationConverter;

	@SuppressWarnings("unused")
	private static Logger logger = LogManager.getLogger(DesignationRepository.class);
	
	@SuppressWarnings("static-access")
	public Designation savedesignation(DesignationDTO designationDTO) {
		return designationService.savedesignation(designationConverter.DesignationDTOToDesignation(designationDTO));
	}
	
	
	@SuppressWarnings("static-access")
	public List<DesignationDTO> getAllDesignation() {
//		logger.info(" Employee Successfully Listed ");
		List<Designation> designationlist = designationService.getAllDesignation();
		return designationConverter.DesignationToDesignationDTO(designationlist);

	}
}

