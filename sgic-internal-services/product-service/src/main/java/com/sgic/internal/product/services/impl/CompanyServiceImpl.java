package com.sgic.internal.product.services.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.internal.product.entities.Company;
import com.sgic.internal.product.repositories.CompanyRepository;
import com.sgic.internal.product.services.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {
	@Autowired
	CompanyRepository companyRepository;

	private static Logger logger = LogManager.getLogger(CompanyRepository.class);

	// Get Company Method
	@Override
	public Company getCompanyById(Long id) {
		logger.info("Company Service INFO ->  Get Company By Id Method Started");
		try {
		return companyRepository.findCompanyById(id);
		} catch (Exception ex) {
			logger.error("Company Service ERROR! -> " + ex.getMessage());
		} finally {
			logger.info("Company Service INFO -> Get Company By Id Method Finished");
		}
		return null;
	}

	// Save Company Method
	@Override
	public Company saveCompany(Company company) {
		logger.info("Company Service INFO ->  Save Company Method Started");
		try {
		return companyRepository.save(company);
		} catch (Exception ex) {
			logger.error("Company Service ERROR! -> " + ex.getMessage());
		} finally {
			logger.info("Company Service INFO -> Save Company Method Finished");
		}
		return null;
	}

	// Get All Company Method
	@Override
	public List<Company> getAllCompany() {
		logger.info("Company Service INFO ->  Get All Company Method Started");
		try {
		return companyRepository.findAll();
		} catch (Exception ex) {
			logger.error("Company Service ERROR! -> " + ex.getMessage());
		} finally {
			logger.info("Company Service INFO -> Get All Company Method Finished");
		}
		return null;
	}

	// Delete Company Method
	@Override
	public Company deleteCompanyById(Long id) {
		logger.info("Company Service INFO ->  Delete Company Method Started");
		try {
		companyRepository.deleteById(id);
		} catch (Exception ex) {
			logger.error("Company Service ERROR! -> " + ex.getMessage());
		} finally {
			logger.info("Company Service INFO -> Delete Company Method Finished");
		}
		return null;
	}

	// Update Company Method
	@Override
	public Company updateCompany(Company company) {
		logger.info("Company Service INFO ->  Update Company Method Started");
		try {
			// Get company Id
			Long id = company.getId();
			// Check the Company Id Is Null or Not
		boolean isExist = companyRepository.findCompanyById(id) != null;
		if (isExist) {
			logger.info("Company Service INFO -> Updated By Company Id, Company Id : "+id);
			return companyRepository.save(company);
		} else {
			logger.warn("Company Service WARNING! -> Company Id Not Found, Company Id : "+id);
		}
		} catch (Exception ex) {
			logger.error("Company Service ERROR! -> " + ex.getMessage());
		} finally {
			logger.info("Company Service INFO -> Update Company Method Finished");
		}
		return null;
	}

}
