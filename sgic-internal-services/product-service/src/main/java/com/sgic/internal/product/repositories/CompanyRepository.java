package com.sgic.internal.product.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgic.internal.product.entities.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {
	// Find Company By Id -> Get Company In Object
	Company findCompanyById(Long id);
}
