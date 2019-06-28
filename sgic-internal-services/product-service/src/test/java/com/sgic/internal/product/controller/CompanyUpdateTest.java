package com.sgic.internal.product.controller;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.sql.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.client.RestClientException;

import com.sgic.internal.product.CompanyControllerTest;
import com.sgic.internal.product.controller.dto.CompanyData;

public class CompanyUpdateTest extends CompanyControllerTest {
	@Autowired
	JdbcTemplate jdbcTemplate;

	private String BASE_URL = "http://localhost:8083/productservice";
	private String ADD_API = "/SaveCompany";
	private String PUT_API = "/UpdateCompany";
	private String GET_BY_ID_API = "/GetCompanyById/";
	private Long companyId = 1L;

	private static final String PUT_COMPANY_RESPONSE = "{\"companyId\":1,\"companyName\":\"Samuel Gnanam IT Center\",\"companyAbbrivation\":\"EFG\",\"companyRegNo\":\"reg-01\",\"companyAdminName\":\"Admin\",\"companyAdminEmail\":\"efg@gmail.com\",\"companyLicenseType\":\"free\",\"companyLicensePeriod\":1,\"licenseStartDate\":\"2018-02-02\",\"licenseEndDate\":\"2019-02-02\",\"companyDescription\":\"some desc\"}";
	private static final String PUT_COMPANY_RESPONSE1 = "{\"companyId\":2,\"companyName\":\"ABCD\",\"companyAbbrivation\":\"ABC\",\"companyRegNo\":\"reg-02\",\"companyAdminName\":\"Admin\",\"companyAdminEmail\":\"abc@gmail.com\",\"companyLicenseType\":\"free\",\"companyLicensePeriod\":1,\"licenseStartDate\":\"2018-02-02\",\"licenseEndDate\":\"2019-02-02\",\"companyDescription\":\"some desc\"}";

//	void setup() {
//		String createCompany = "INSERT INTO productservice.company"
//				+ "(abbrivation, admin_email, company_admin_name, description, end_date, license_period, license_type, name, reg_no, start_date)"
//				+ " VALUES "
//				+ "('EFG','efg@gmail.com','Admin','some desc','2019-02-02','1','free','EFGH','reg-01','2018-02-02'),"
//				+ "('ABC','abc@gmail.com','Admin','some desc','2019-02-02','1','free','ABCD','reg-02','2018-02-02')";
//		jdbcTemplate.execute(createCompany);
//	}

	@Test
	public void addCompany() throws IOException, RestClientException {
		CompanyData companyData = new CompanyData();
		companyData.setCompanyName("EFGH");
		companyData.setCompanyAbbrivation("EFG");
		companyData.setCompanyRegNo("reg-01");
		companyData.setCompanyAdminName("Admin");
		companyData.setCompanyAdminEmail("efg@gmail.com");
		companyData.setCompanyLicenseType("free");
		companyData.setCompanyLicensePeriod(1);
		companyData.setLicenseStartDate(Date.valueOf("2018-02-02"));
		companyData.setLicenseEndDate(Date.valueOf("2019-02-02"));
		companyData.setCompanyDescription("some desc");

		HttpEntity<CompanyData> request = new HttpEntity<CompanyData>(companyData, httpHeaders);
		ResponseEntity<String> postResponse = testRestTemplate.postForEntity(BASE_URL + ADD_API, request, String.class);
		assertEquals(200, postResponse.getStatusCodeValue());

		CompanyData companyData1 = new CompanyData();
		companyData1.setCompanyName("ABCD");
		companyData1.setCompanyAbbrivation("ABC");
		companyData1.setCompanyRegNo("reg-01");
		companyData1.setCompanyAdminName("Admin");
		companyData1.setCompanyAdminEmail("abc@gmail.com");
		companyData1.setCompanyLicenseType("free");
		companyData1.setCompanyLicensePeriod(1);
		companyData1.setLicenseStartDate(Date.valueOf("2018-02-02"));
		companyData1.setLicenseEndDate(Date.valueOf("2019-02-02"));
		companyData1.setCompanyDescription("some desc");

		HttpEntity<CompanyData> request1 = new HttpEntity<CompanyData>(companyData1, httpHeaders);
		ResponseEntity<String> postResponse1 = testRestTemplate.postForEntity(BASE_URL + ADD_API, request1,
				String.class);
		assertEquals(200, postResponse1.getStatusCodeValue());

	}

	// Test for Update Company
	@Test
	void UpdateCompany() throws IOException, RestClientException {
		CompanyData companyData = new CompanyData();
		companyData.setCompanyId(companyId);
		companyData.setCompanyName("Samuel Gnanam IT Center");
		companyData.setCompanyAbbrivation("EFG");
		companyData.setCompanyRegNo("reg-01");
		companyData.setCompanyAdminName("Admin");
		companyData.setCompanyAdminEmail("efg@gmail.com");
		companyData.setCompanyLicenseType("free");
		companyData.setCompanyLicensePeriod(1);
		companyData.setLicenseStartDate(Date.valueOf("2018-02-02"));
		companyData.setLicenseEndDate(Date.valueOf("2019-02-02"));
		companyData.setCompanyDescription("some desc");

		HttpEntity<CompanyData> updateRequest = new HttpEntity<CompanyData>(companyData, httpHeaders);
		ResponseEntity<String> putResponse = testRestTemplate.exchange(BASE_URL + PUT_API, HttpMethod.PUT,
				updateRequest, String.class);
		assertEquals(200, putResponse.getStatusCodeValue());

		ResponseEntity<String> getResponse = testRestTemplate.exchange(BASE_URL + GET_BY_ID_API + 1, HttpMethod.GET,
				new HttpEntity<>(httpHeaders), String.class);
		assertEquals(HttpStatus.OK, getResponse.getStatusCode());
		assertEquals(PUT_COMPANY_RESPONSE, getResponse.getBody());

	}

//	// Test for Duplicate E-mail Address
//	@Test
//	void UpdateCompanyUsingExistingEmail() throws IOException, RestClientException {
////		CompanyData companyData = new CompanyData();
////		companyData.setCompanyId(companyId);
////		companyData.setCompanyName("Samuel Gnanam IT Center");
////		companyData.setCompanyAbbrivation("EFG");
////		companyData.setCompanyRegNo("reg-01");
////		companyData.setCompanyAdminName("Admin");
////		companyData.setCompanyAdminEmail("efg@gmail.com");
////		companyData.setCompanyLicenseType("free");
////		companyData.setCompanyLicensePeriod(1);
////		companyData.setLicenseStartDate(Date.valueOf("2018-02-02"));
////		companyData.setLicenseEndDate(Date.valueOf("2019-02-02"));
////		companyData.setCompanyDescription("some desc");
////
////		HttpEntity<CompanyData> updateRequest = new HttpEntity<CompanyData>(companyData, httpHeaders);
////		ResponseEntity<String> putResponse = testRestTemplate.exchange(BASE_URL + PUT_API, HttpMethod.PUT,
////				updateRequest, String.class);
////		assertEquals(200, putResponse.getStatusCodeValue());
//
//		ResponseEntity<String> getResponse = testRestTemplate.exchange(BASE_URL + GET_BY_ID_API + 1, HttpMethod.GET,
//				new HttpEntity<>(httpHeaders), String.class);
////		assertEquals(HttpStatus.OK, getResponse.getStatusCode());
//		assertEquals(PUT_COMPANY_RESPONSE, getResponse.getBody());
//	}

}
