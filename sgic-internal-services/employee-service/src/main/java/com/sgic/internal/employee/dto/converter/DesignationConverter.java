package com.sgic.internal.employee.dto.converter;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.sgic.internal.employee.dto.DesignationDTO;
import com.sgic.internal.employee.dto.EmployeeDTO;
import com.sgic.internal.employee.entities.Designation;

@Service
public class DesignationConverter {

	private static Logger logger = LogManager.getLogger(EmployeeDTO.class);

	// Designation Entity To Designation DTO Converter
	public static DesignationDTO DesignationToDesignationDTO(Designation designation) {
		DesignationDTO designationDTO = new DesignationDTO();
		if (designation != null) {
			logger.info("Designation Converter--->Designation to DTO Converter");
			designationDTO.setDesignationid(designation.getDesignationid());
			designationDTO.setDesignationname(designation.getDesignationname());
			return designationDTO;
		}
		return null;

	}

	// Designation DTO To Designation Entity Converter
	public static Designation DesignationDTOToDesignation(DesignationDTO designationDTO) {
		Designation designation = new Designation();
		if (designationDTO != null) {
			logger.info("Designation Converter-->DTO To Entity Converter");
			designation.setDesignationid(designation.getDesignationid());
			;
			designation.setDesignationname(designationDTO.getDesignationname());
			return designation;
		}

		return null;

	}

	// Designation List Converter
	public static List<DesignationDTO> DesignationToDesignationDTO(List<Designation> designationList) {
		if (designationList != null) {
			logger.info(" Designation Converter-->Designation to DTO Converte");
			List<DesignationDTO> listdesignationDto = new ArrayList<>();
			for (Designation designation : designationList) {
				DesignationDTO designationDTO = new DesignationDTO();
				designationDTO.setDesignationid(designation.getDesignationid());
				designationDTO.setDesignationname(designation.getDesignationname());
				listdesignationDto.add(designationDTO);
			}

			return listdesignationDto;
		}
		return null;
	}
}
