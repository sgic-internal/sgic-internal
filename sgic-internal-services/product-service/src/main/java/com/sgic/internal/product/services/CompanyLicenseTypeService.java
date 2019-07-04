package com.sgic.internal.product.services;

import java.util.List;

import com.sgic.internal.product.entities.CompanyLicenseType;

public interface CompanyLicenseTypeService {
	// Save CompanyLicenseType
		public List<CompanyLicenseType> saveCompanyLicenseType();
		// List all CompanyLicenseType
		public List<CompanyLicenseType> getAllCompanyLicenseType();
}
