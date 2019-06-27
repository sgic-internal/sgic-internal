package com.sgic.internal.product.controller.dto.converter;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.sgic.internal.product.controller.dto.CompanyData;
import com.sgic.internal.product.entities.Company;

@Service
public class CompanyConverter {
	private static Logger logger = LogManager.getLogger(CompanyData.class);

	// Convert All List Company's Entity to DTO
	public static List<CompanyData> CompanyEntityTOCompanyDataList(List<Company> companyList) {
		if (companyList != null) {
			logger.info("Company Converter -> Convert Lists Entity to DTO");
			List<CompanyData> listCompanyData = new ArrayList<>();
			for (Company company : companyList) {
				CompanyData companyData = new CompanyData();

				companyData.setCompanyId(company.getId());
				companyData.setCompanyName(company.getName());
				companyData.setCompanyAbbrivation(company.getAbbrivation());
				companyData.setCompanyRegNo(company.getRegNo());
				companyData.setCompanyAdminName(company.getCompanyAdminName());
				companyData.setCompanyAdminEmail(company.getAdminEmail());
				companyData.setCompanyLicenseType(company.getLicenseType());
				companyData.setCompanyLicensePeriod(company.getLicensePeriod());
				companyData.setLicenseStartDate(company.getStartDate());
				companyData.setLicenseEndDate(company.getEndDate());
				companyData.setCompanyDescription(company.getDescription());

				listCompanyData.add(companyData);
			}
			return listCompanyData;
		}
		return null;
	}

	// Convert CompanyData To CompanyEntity
		public static Company companyDataToCompanyEntity(CompanyData companyData) {
			Company company = new Company();
			if (companyData != null) {
				logger.info("Company Converter -> Convert Object DTO to Entity");
				company.setId(companyData.getCompanyId());
				company.setName(companyData.getCompanyName());
				company.setAbbrivation(companyData.getCompanyAbbrivation());
				company.setRegNo(companyData.getCompanyRegNo());
				company.setCompanyAdminName(companyData.getCompanyAdminName());
				company.setAdminEmail(companyData.getCompanyAdminEmail());
				company.setLicenseType(companyData.getCompanyLicenseType());
				company.setLicensePeriod(companyData.getCompanyLicensePeriod());
				company.setStartDate((Date) companyData.getLicenseStartDate());
				company.setEndDate((Date) companyData.getLicenseEndDate());
				company.setDescription(companyData.getCompanyDescription());
				return company;
			}
			return null;
		}

		// Convert CompanyEntity To CompanyData
		public static CompanyData CompanyEntityToCompanyData(Company company) {
			CompanyData companyData = new CompanyData();
			if (company != null) {
				logger.info("Company Converter -> Convert Object Entity to DTO");
				companyData.setCompanyId(company.getId());
				companyData.setCompanyName(company.getName());
				companyData.setCompanyAbbrivation(company.getAbbrivation());
				companyData.setCompanyRegNo(company.getRegNo());
				companyData.setCompanyAdminName(company.getCompanyAdminName());
				companyData.setCompanyAdminEmail(company.getAdminEmail());
				companyData.setCompanyLicenseType(company.getLicenseType());
				companyData.setCompanyLicensePeriod(company.getLicensePeriod());
				companyData.setLicenseStartDate(company.getStartDate());
				companyData.setLicenseEndDate(company.getEndDate());
				companyData.setCompanyDescription(company.getDescription());
				return companyData;
			}
			return null;
		}

}
