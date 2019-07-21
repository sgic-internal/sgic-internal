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
		logger.info("Successfully Get Designation Details");
		return designationRepository.findAll();
	}

	@Override
	public Designation getBydesignationid(Long designationid) {
		logger.info("Successfully Get Designation By DesignationId");
		return designationRepository.findBydesignationid(designationid);
	}

	@Override
	public void deleteDesignationBydesignationid(Long designationid) {
		logger.info("Designation Service Impl --> Deleted Successfully");
		designationRepository.deleteDesignationBydesignationid(designationid);

	}

}
