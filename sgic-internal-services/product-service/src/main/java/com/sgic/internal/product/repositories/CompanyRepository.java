package com.sgic.internal.product.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgic.internal.product.entities.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {
	Company findCompanyById(Long id);
}
