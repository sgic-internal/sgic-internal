package com.sgic.internal.product.controller;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.sql.Date;

import org.junit.Before;
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

public class CompanyAddTest extends CompanyControllerTest{
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private String BASE_URL = "http://localhost:8083/productservice";
	private String ADD_API = "/SaveCompany";
	private String GET_API = "/GetAllCompany";
	private String PUT_API = "/UpdateMainClassification";
	private String GET_BY_ID_API = "/GetCompanyById/";
	private Long companyId = 1L;
	
	private static final String GET_COMPANY_RESPONSE = "["
			+ "{\"companyId\":1,\"companyName\":\"EFGH\",\"companyAbbrivation\":\"EFG\",\"companyRegNo\":\"reg-01\",\"companyAdminName\":\"Admin\",\"companyAdminEmail\":\"abc@gmail.com\",\"companyLicenseType\":\"free\",\"companyLicensePeriod\":1,\"licenseStartDate\":\"2018-02-02\",\"licenseEndDate\":\"2019-02-02\",\"companyDescription\":\"some desc\"},"
			+ "{\"companyId\":2,\"companyName\":\"EFGH\",\"companyAbbrivation\":\"EFG\",\"companyRegNo\":\"reg-01\",\"companyAdminName\":\"Admin\",\"companyAdminEmail\":\"abc@gmail.com\",\"companyLicenseType\":\"free\",\"companyLicensePeriod\":1,\"licenseStartDate\":\"2018-02-02\",\"licenseEndDate\":\"2019-02-02\",\"companyDescription\":\"some desc\"}"
			+ "]";
	private static final String PUT_COMPANY_RESPONSE = "{\"mainClassId\":1,\"mainClassName\":\"ABCD\"}";
	private static final String GET_COMPANY_BY_ID_RESPONSE = "{\"companyId\":1,\"companyName\":\"EFGH\",\"companyAbbrivation\":\"EFG\",\"companyRegNo\":\"reg-01\",\"companyAdminName\":\"Admin\",\"companyAdminEmail\":\"abc@gmail.com\",\"companyLicenseType\":\"free\",\"companyLicensePeriod\":1,\"licenseStartDate\":\"2018-02-02\",\"licenseEndDate\":\"2019-02-02\",\"companyDescription\":\"some desc\"}";
	
	
	
	@Before
	public void setup() {
		String createMainClass = "INSERT INTO librarysystem.mainclassification"+
								"(abbrivation, admin_email, company_admin_name, description, end_date, license_period, license_type, name, reg_no, start_date)" +
								" VALUES "+
								"('EFG','abc@gmail.com','Admin','some desc','2019-02-02','1','free','EFGH','reg-01','2018-02-02')";
		jdbcTemplate.execute(createMainClass);
	}

	@Test
	public void addMainClassification() throws IOException, RestClientException {
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
		
		HttpEntity<CompanyData> request = new HttpEntity<CompanyData>(companyData,
				httpHeaders);
		ResponseEntity<String> postResponse = testRestTemplate.postForEntity(BASE_URL + ADD_API, request,
				String.class);
		assertEquals(200, postResponse.getStatusCodeValue());
		
//		ResponseEntity<String> getResponse = testRestTemplate.exchange(BASE_URL + GET_BY_ID_API + 2,
//				HttpMethod.GET, new HttpEntity<>(httpHeaders), String.class);
//		assertEquals(HttpStatus.OK, getResponse.getStatusCode());
//		assertEquals(GET_COMPANY_BY_ID_RESPONSE, getResponse.getBody());
	}
	
	@Test
	public void addMainClassificationCheckNull() throws IOException, RestClientException {
		CompanyData companyData = new CompanyData();
		companyData.setCompanyName("");
		companyData.setCompanyAbbrivation("EFG");
		companyData.setCompanyRegNo("reg-01");
		companyData.setCompanyAdminName("Admin");
		companyData.setCompanyAdminEmail("abc@gmail.com");
		companyData.setCompanyLicenseType("free");
		companyData.setCompanyLicensePeriod(1);
		companyData.setLicenseStartDate(Date.valueOf("2018-02-02"));
		companyData.setLicenseEndDate(Date.valueOf("2019-02-02"));
		companyData.setCompanyDescription("some desc");
		
		HttpEntity<CompanyData> request = new HttpEntity<CompanyData>(companyData,
				httpHeaders);
		ResponseEntity<String> postResponse = testRestTemplate.postForEntity(BASE_URL + ADD_API, request,
				String.class);
		assertEquals(200, postResponse.getStatusCodeValue());
		
		ResponseEntity<String> getResponse = testRestTemplate.exchange(BASE_URL + GET_BY_ID_API + companyId,
				HttpMethod.GET, new HttpEntity<>(httpHeaders), String.class);
		assertEquals(HttpStatus.OK, getResponse.getStatusCode());
		assertEquals(GET_COMPANY_BY_ID_RESPONSE, getResponse.getBody());
	}
	
	
	

	
}
