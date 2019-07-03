package com.sgic.internal.product.services.impl;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.internal.product.entities.CompanyLicenseType;
import com.sgic.internal.product.repositories.CompanyLicenseTypeRepository;
import com.sgic.internal.product.services.CompanyLicenseTypeService;

@Service
public class CompanyLicenseTypeServiceImpl implements CompanyLicenseTypeService{
	@Autowired
	CompanyLicenseTypeRepository companyLicenseTypeRepository;

	private static Logger logger = LogManager.getLogger(CompanyLicenseTypeRepository.class);

	@Override	
	public List<CompanyLicenseType> saveCompanyLicenseType() {
		logger.info("service started -> saveCompanyLicenseType()");
		CompanyLicenseType l1 = new CompanyLicenseType("Free");
		CompanyLicenseType l2 = new CompanyLicenseType("Silver");
		CompanyLicenseType l3 = new CompanyLicenseType("Gold");
		CompanyLicenseType l4 = new CompanyLicenseType("Platinum");
		
		List<CompanyLicenseType> license = Arrays.asList(l1, l2, l3, l4);
		return companyLicenseTypeRepository.saveAll(license);
	}

	@Override
	public List<CompanyLicenseType> getAllCompanyLicenseType() {
		return companyLicenseTypeRepository.findAll();
	}

}
