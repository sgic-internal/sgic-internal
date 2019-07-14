package com.sgic.internal.product.controller.dto.mapper;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.internal.product.controller.dto.CompanyData;
import com.sgic.internal.product.controller.dto.converter.CompanyConverter;
import com.sgic.internal.product.entities.Company;
import com.sgic.internal.product.services.CompanyService;

@Service
public class CompanyMapper {
	@Autowired
	private CompanyConverter companyConverter;
	@Autowired
	private CompanyService companyService;

	private static Logger logger = LogManager.getLogger(CompanyData.class);

	// Get All Company
	@SuppressWarnings("static-access")
	public List<CompanyData> getAllCompany() {
		logger.info("Company Mapper INFO -> Get All Company Method Started");
		try {
		List<Company> companyList = companyService.getAllCompany();
		return companyConverter.CompanyEntityTOCompanyDataList(companyList);
		} finally {
			logger.info("Defect Company Mapper INFO -> Get All Company Method Finished");
		}
	}

	// Save Company
	@SuppressWarnings("static-access")
	public Company saveCompany(CompanyData companyData) {
		logger.info("Company Mapper INFO -> Get All Company Method Started");
		try {
		return companyService.saveCompany(companyConverter.companyDataToCompanyEntity(companyData));
		} finally {
			logger.info("Company Mapper INFO -> Get All Company Method Finished");
		}
	}

	// Update Company
	@SuppressWarnings("static-access")
	public Company updateCompany(CompanyData companyData) {
		logger.info("Company Mapper INFO -> Update Company Method Started");
		try {
		logger.info("Company Mapper -> Company Updated ", companyData.getCompanyId());
		return companyService.updateCompany(companyConverter.companyDataToCompanyEntity(companyData));
		} finally {
			logger.info("Company Mapper INFO -> Update Company Method Finished");
		}
	}

	// Delete Company
	public CompanyData deleteCompanyById(Long companyId) {
		logger.info("Company Mapper INFO -> Delete Company Method Started");
		try {
		companyService.deleteCompanyById(companyId);
		} finally {
			logger.info("Company Mapper INFO -> Delete Company Method Finished");
		}
		return null;
	}

	// Get Company By Id
	@SuppressWarnings("static-access")
	public CompanyData getCompanyById(Long companyId) {
		logger.info("Company Mapper INFO -> Get Company By Id Method Started");
		try {
		Company company = companyService.getCompanyById(companyId);
		return companyConverter.CompanyEntityToCompanyData(company);
	} finally {
		logger.info("Company Mapper INFO -> Get Company By Id Method Finished");
	}
	}

}
