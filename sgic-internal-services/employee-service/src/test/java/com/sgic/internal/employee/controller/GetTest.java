//package com.sgic.internal.employee.controller;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import com.sgic.internal.employee.EmployeeTest;
//import com.sgic.internal.employee.dto.EmployeeDTO;
//
//import static org.junit.Assert.assertEquals;
//import java.io.IOException;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.client.RestClientException;
//
//public class GetTest extends EmployeeTest {
//
//	@Autowired
//	JdbcTemplate jdbcTemplate;
//
//	@SuppressWarnings("unused")
//	private EmployeeDTO employeeDTO = new EmployeeDTO();
//
//	@Test
////	<<-------Post Method Unit Test------>>
//	public void createemployee() throws IOException, RestClientException {
//		EmployeeDTO employeeDTO = new EmployeeDTO("emp001", "jothi", "saidputhi@gmail.com", "QA");
////		HttpHeaders httpHeaders = new HttpHeaders();
//		HttpEntity<EmployeeDTO> request = new HttpEntity<EmployeeDTO>(employeeDTO, httpHeaders);
//
//		ResponseEntity<String> response = testRestTemplate
//				.postForEntity("Http://localhost:8080/employeeservice/" + "createemployee", request, String.class);
//		assertEquals(200, response.getStatusCodeValue());
//
//		
////		<<-------Get Method Unit Test------>>
//
//		ResponseEntity<String> response1 = testRestTemplate.exchange(
//				"http://localhost:8080/employeeservice" + "/getallemployee", HttpMethod.GET,
//				new HttpEntity<>(httpHeaders), String.class);
//		assertEquals(HttpStatus.OK, response1.getStatusCode());
//
//		Object body = "[{\"empId\":\"emp001\",\"name\":\"jothi\",\"email\":\"saidputhi@gmail.com\",\"designation\":\"QA\"}]";
//		assertEquals(body, response1.getBody());
//
////		<<-------Delete Method Unit Test------>>
//	}
//
//	@After
//	public void tearDown() {
//
//	}
//
//}
