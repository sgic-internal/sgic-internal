package com.sgic.internal.product.services;

import java.util.List;

import com.sgic.internal.product.entities.Company;

public interface CompanyService {
	// Get Company By Id
	public Company getCompanyById(Long companyId);

	// Save Company
	public Company saveCompany(Company company);

	// List all Company
	public List<Company> getAllCompany();

	// Delete Company
	public Company deleteCompanyById(Long id);

	// Update Company
	public Company updateCompany(Company company);
	
}
