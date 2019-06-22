package com.sgic.internal.employee.controller;


import static org.junit.Assert.assertEquals;

import java.io.IOException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.client.RestClientException;
import com.sgic.internal.employee.EmployeeTest;
import com.sgic.internal.employee.dto.EmployeeDTO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


public class PostEmployeeTest extends EmployeeTest {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@SuppressWarnings("unused")
	private EmployeeDTO employeeDTO = new EmployeeDTO();
	
	
	@Test
	public void testCreateEmployee() throws IOException, RestClientException{
		EmployeeDTO employeeDTO = new EmployeeDTO("EMP003","Dali","dali@gmail.com","QA");
//		employeeDTO.setEmpId("EMP003");
//		employeeDTO.setName("Dali");
//		employeeDTO.setEmail("dali@gmail.com");
//		employeeDTO.setDesignation("QA");
		HttpHeaders httpHeaders = new HttpHeaders();
		HttpEntity<EmployeeDTO> request = new HttpEntity<EmployeeDTO>(employeeDTO, httpHeaders);
	    ResponseEntity<String> postresponse =
	        testRestTemplate.postForEntity("http://localhost:8084/employeeservice"+"/createemployee", request, String.class);
	    assertEquals(200, postresponse.getStatusCodeValue());
	    
	    ResponseEntity<String> getresponse = testRestTemplate.exchange(
				"http://localhost:8084/employeeservice" + "/getallemployee", HttpMethod.GET,
				new HttpEntity<>(httpHeaders), String.class);
		assertEquals(HttpStatus.OK, getresponse.getStatusCode());
	    
		Object body = "[{\"empId\":\"EMP003\",\"name\":\"Dali\",\"email\":\"dali@gmail.com\",\"designation\":\"QA\"}]";
		assertEquals(body, getresponse.getBody());
	}

}
