package com.sgic.internal.product.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import java.sql.Date;
import java.util.Set;

import javax.validation.ConstraintViolation;
import org.junit.jupiter.api.Test;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.sgic.internal.product.controller.dto.CompanyData;
import com.sgic.internal.product.entities.Company;

public class CompanyValidationIntegrationTest {

	LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
	
	String correct_email = "abc@gmail.com";
	String wrong_email = "abc@gmail";

	@SuppressWarnings("unused")
	private CompanyData createCompanyData() {
		CompanyData companyData = new CompanyData();
		companyData.setCompanyName("EFGH");
		companyData.setCompanyAbbrivation("EFG");
		companyData.setCompanyRegNo("reg-01");
		companyData.setCompanyAdminName("Admin");
		companyData.setCompanyAdminEmail("abc@gmail.com");
		companyData.setCompanyLicenseType("free");
		companyData.setCompanyLicensePeriod(1);
		companyData.setLicenseStartDate(Date.valueOf("2018-02-02"));
		companyData.setLicenseEndDate(Date.valueOf("2019-02-02"));
		companyData.setCompanyDescription("some desc");
		return companyData;
	}

	@SuppressWarnings("unused")
	private Company createCompany() {
		Company company = new Company();
		company.setName("EFGH");
		company.setAbbrivation("EFG");
		company.setRegNo("reg-01");
		company.setCompanyAdminName("Admin");
		company.setAdminEmail("abc@gmail.com");
		company.setLicenseType("free");
		company.setLicensePeriod(1);
//		company.setStartDate(Date.valueOf("2018-02-02"));
//		company.setEndDate(Date.valueOf("2019-02-02"));
		company.setDescription("some desc");
		return company;
	}

	@Test
	public void ifCompanyNameIsNull_ValidationFails() {
		validator.afterPropertiesSet();
		Company company = new Company();
//		company.setName("EFGH");								//	1
		company.setAbbrivation("EFG");							//	1
		company.setRegNo("reg-01");								//	1
		company.setCompanyAdminName("Admin");					//	1
		company.setAdminEmail("abc@gmail.com");					//	1
		company.setLicenseType("free");							//	1
		company.setLicensePeriod(1);							//	1
		company.setStartDate(Date.valueOf("2018-02-02"));		//	1
		company.setEndDate(Date.valueOf("2019-02-02"));			//	1
		company.setDescription("some desc");					//	1  - This can be null
		Set<ConstraintViolation<Company>> violations = validator.validate(company);
//		assertEquals(violations.isEmpty(), false);
		 assertThat(violations.size()).isEqualTo(1); // Check the validated null value fields and counts. if there is no validated null value fields isEqualTo(0).
	}
	
	@Test
	public void ifCompanyAbbrivationIsNull_ValidationFails() {
		validator.afterPropertiesSet();
		Company company = new Company();
		company.setName("EFGH");
//		company.setAbbrivation("EFG");							//	1
		company.setRegNo("reg-01");
		company.setCompanyAdminName("Admin");
		company.setAdminEmail("abc@gmail.com");
		company.setLicenseType("free");
		company.setLicensePeriod(1);
		company.setStartDate(Date.valueOf("2018-02-02"));
		company.setEndDate(Date.valueOf("2019-02-02"));
		company.setDescription("some desc");
		Set<ConstraintViolation<Company>> violations = validator.validate(company);
		assertThat(violations.size()).isEqualTo(1);
	}
	
	
	@Test
	public void ifCompanyRegNoIsNull_ValidationFails() {
		validator.afterPropertiesSet();
		Company company = new Company();
		company.setName("EFGH");
		company.setAbbrivation("EFG");	
//		company.setRegNo("reg-01");
		company.setCompanyAdminName("Admin");
		company.setAdminEmail("abc@gmail.com");
		company.setLicenseType("free");
		company.setLicensePeriod(1);
		company.setStartDate(Date.valueOf("2018-02-02"));
		company.setEndDate(Date.valueOf("2019-02-02"));
		company.setDescription("some desc");
		Set<ConstraintViolation<Company>> violations = validator.validate(company);
		assertThat(violations.size()).isEqualTo(1);
	}
	
	
	@Test
	public void ifCompanyAdminNameIsNull_ValidationFails() {
		validator.afterPropertiesSet();
		Company company = new Company();
		company.setName("EFGH");
		company.setAbbrivation("EFG");	
		company.setRegNo("reg-01");
//		company.setCompanyAdminName("Admin");
		company.setAdminEmail("abc@gmail.com");
		company.setLicenseType("free");
		company.setLicensePeriod(1);
		company.setStartDate(Date.valueOf("2018-02-02"));
		company.setEndDate(Date.valueOf("2019-02-02"));
		company.setDescription("some desc");
		Set<ConstraintViolation<Company>> violations = validator.validate(company);
		assertThat(violations.size()).isEqualTo(1);
	}
	
	
	@Test
	public void ifCompanyAdminEmailIsNull_ValidationFails() {
		validator.afterPropertiesSet();
		Company company = new Company();
		company.setName("EFGH");
		company.setAbbrivation("EFG");	
		company.setRegNo("reg-01");
		company.setCompanyAdminName("Admin");
//		company.setAdminEmail("abc@gmail.com");
		company.setLicenseType("free");
		company.setLicensePeriod(1);
		company.setStartDate(Date.valueOf("2018-02-02"));
		company.setEndDate(Date.valueOf("2019-02-02"));
		company.setDescription("some desc");
		Set<ConstraintViolation<Company>> violations = validator.validate(company);
		assertThat(violations.size()).isEqualTo(1);
	}
	
	@Test
	public void ifCompanyAdminEmailIsCorrect_ValidationFails() {
		validator.afterPropertiesSet();
		Company company = new Company();
		company.setName("EFGH");
		company.setAbbrivation("EFG");	
		company.setRegNo("reg-01");
		company.setCompanyAdminName("Admin");
		company.setAdminEmail(correct_email);
		company.setLicenseType("free");
		company.setLicensePeriod(1);
		company.setStartDate(Date.valueOf("2018-02-02"));
		company.setEndDate(Date.valueOf("2019-02-02"));
		company.setDescription("some desc");
		Set<ConstraintViolation<Company>> violations = validator.validate(company);
		assertThat(violations.size()).isEqualTo(0);
	}
	
	@Test
	public void ifCompanyAdminEmailIsWrong_ValidationFails() {
		validator.afterPropertiesSet();
		Company company = new Company();
		company.setName("EFGH");
		company.setAbbrivation("EFG");	
		company.setRegNo("reg-01");
		company.setCompanyAdminName("Admin");
		company.setAdminEmail(wrong_email);
		company.setLicenseType("free");
		company.setLicensePeriod(1);
		company.setStartDate(Date.valueOf("2018-02-02"));
		company.setEndDate(Date.valueOf("2019-02-02"));
		company.setDescription("some desc");
		Set<ConstraintViolation<Company>> violations = validator.validate(company);
		assertThat(violations.size()).isEqualTo(1);
	}
	
	
	@Test
	public void ifCompanyLicenseTypeIsNull_ValidationFails() {
		validator.afterPropertiesSet();
		Company company = new Company();
		company.setName("EFGH");
		company.setAbbrivation("EFG");
		company.setRegNo("reg-01");
		company.setCompanyAdminName("Admin");
		company.setAdminEmail("abc@gmail.com");
//		company.setLicenseType("free");
		company.setLicensePeriod(1);
		company.setStartDate(Date.valueOf("2018-02-02"));
		company.setEndDate(Date.valueOf("2019-02-02"));
		company.setDescription("some desc");
		Set<ConstraintViolation<Company>> violations = validator.validate(company);
		assertThat(violations.size()).isEqualTo(1);
	}
	
	
	@Test
	public void ifCompanyLicensePeriodIsNull_ValidationFails() {
		validator.afterPropertiesSet();
		Company company = new Company();
		company.setName("EFGH");
		company.setAbbrivation("EFG");
		company.setRegNo("reg-01");
		company.setCompanyAdminName("Admin");
		company.setAdminEmail("abc@gmail.com");
		company.setLicenseType("free");
//		company.setLicensePeriod(1);
//		company.setStartDate(Date.valueOf("2018-02-02"));
//		company.setEndDate(Date.valueOf("2019-02-02"));
		company.setDescription("some desc");
		Set<ConstraintViolation<Company>> violations = validator.validate(company);
		assertEquals(violations.isEmpty(), false);
	}
	
	
	@Test
	public void ifCompanyLicenseStartDateIsNull_ValidationFails() {
		validator.afterPropertiesSet();
		Company company = new Company();
		company.setName("EFGH");
		company.setAbbrivation("EFG");
		company.setRegNo("reg-01");
		company.setCompanyAdminName("Admin");
		company.setAdminEmail("abc@gmail.com");
		company.setLicenseType("free");
		company.setLicensePeriod(1);
//		company.setStartDate(Date.valueOf("2018-02-02"));
//		company.setEndDate(Date.valueOf("2019-02-02"));
		company.setDescription("some desc");
		Set<ConstraintViolation<Company>> violations = validator.validate(company);
		assertThat(violations.size()).isEqualTo(1);
	}
	
	@Test
	public void ifCompanyLicenseEndDateIsNull_ValidationFails() {
		validator.afterPropertiesSet();
		Company company = new Company();
		company.setName("EFGH");
		company.setAbbrivation("EFG");
		company.setRegNo("reg-01");
		company.setCompanyAdminName("Admin");
		company.setAdminEmail("abc@gmail.com");
		company.setLicenseType("free");
		company.setLicensePeriod(1);
//		company.setStartDate(Date.valueOf("2018-02-02"));
//		company.setEndDate(Date.valueOf("2019-02-02"));
		company.setDescription("some desc");
		Set<ConstraintViolation<Company>> violations = validator.validate(company);
		assertThat(violations.size()).isEqualTo(1);
	}
	
	@Test
	public void ifCompanyDescriptionIsNull_ValidationFails() {
		validator.afterPropertiesSet();
		Company company = new Company();
		company.setName("EFGH");
		company.setAbbrivation("EFG");
		company.setRegNo("reg-01");
		company.setCompanyAdminName("Admin");
		company.setAdminEmail("abc@gmail.com");
		company.setLicenseType("free");
		company.setLicensePeriod(1);
		company.setStartDate(Date.valueOf("2018-02-02"));
		company.setEndDate(Date.valueOf("2019-02-02"));
//		company.setDescription("some desc");
		Set<ConstraintViolation<Company>> violations = validator.validate(company);
		assertThat(violations.size()).isEqualTo(0);
	}
	
}
