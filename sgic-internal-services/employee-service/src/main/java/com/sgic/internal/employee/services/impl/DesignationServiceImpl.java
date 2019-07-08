package com.sgic.internal.employee.services.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sgic.internal.employee.entities.Designation;
import com.sgic.internal.employee.repositories.DesignationRepository;
import com.sgic.internal.employee.repositories.EmployeeRepository;
import com.sgic.internal.employee.services.DesignationService;

@Service
public class DesignationServiceImpl implements DesignationService {

	@Autowired
	private DesignationRepository designationRepository;
	
	private static Logger logger = LogManager.getLogger(EmployeeRepository.class);

	@Override
	public Designation savedesignation(Designation designation) {
		logger.info("succesfully saved Designation");
		return designationRepository.save(designation);
	}

	@Override
	public List<Designation> getAllDesignation() {
		return designationRepository.findAll();
	}

}
