//package com.sgic.internal.employee.controller;
//
//import com.sgic.internal.employee.EmployeeTest;
//import com.sgic.internal.employee.dto.EmployeeDTO;
//import static org.junit.Assert.assertEquals;
//
//import java.io.IOException;
//
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.web.client.RestClientException;
//
//public class GetEmployeeTest extends EmployeeTest{
//
//	@Autowired
//	JdbcTemplate jdbcTemplate;
//
//	@SuppressWarnings("unused")
//	private EmployeeDTO employee = new EmployeeDTO();
//
////	common URL
//	private String BASE_URL = "http://localhost:8084/employeeservice";
////	Post API
//	private String ADD_API_URL = "/createemployee";
//
////	Get API
//	private String GET_API_URL = "/getallemployee";
//
////	Save unit Test expected Response
//	private static final String GET_EMPLOYEE_RESPONSE = "[{\"empId\":\"EMP003\",\"name\":\"Dali\",\"email\":\"dali@gmail.com\",\"designation\":\"SoftwareEngineer\"}]";
//
//	@Test
//	public void testCreateEmployee() throws IOException, RestClientException {
//		EmployeeDTO employeeDTO = new EmployeeDTO("EMP003", "Dali", "dali@gmail.com", "SoftwareEngineer");
//		HttpHeaders httpHeaders = new HttpHeaders();
//		HttpEntity<EmployeeDTO> request = new HttpEntity<EmployeeDTO>(employeeDTO, httpHeaders);
//		ResponseEntity<String> postresponse = testRestTemplate
//				.postForEntity(BASE_URL + ADD_API_URL, request, String.class);
//		assertEquals(200, postresponse.getStatusCodeValue());
//
//		ResponseEntity<String> getresponse = testRestTemplate.exchange(BASE_URL + GET_API_URL, HttpMethod.GET,
//				new HttpEntity<>(httpHeaders), String.class);
//		assertEquals(HttpStatus.OK, getresponse.getStatusCode());
//
//		assertEquals(GET_EMPLOYEE_RESPONSE, getresponse.getBody());
//	}
//	  
//	  
//}
