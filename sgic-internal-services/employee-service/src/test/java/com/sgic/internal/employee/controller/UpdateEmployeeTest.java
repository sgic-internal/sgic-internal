package com.sgic.internal.employee.controller;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.client.RestClientException;

import com.sgic.internal.employee.EmployeeTest;
import com.sgic.internal.employee.dto.EmployeeDTO;

public class UpdateEmployeeTest extends EmployeeTest {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@SuppressWarnings("unused")
	private EmployeeDTO employee = new EmployeeDTO();

	// Save unit Test expected Response private static final String
	private static final String UPDATE_EMPLOYEE_RESPONSE = "Successfully Updated";

	@Test
	public void testUpdateEmployee() throws IOException, RestClientException {
		EmployeeDTO employeeDTO = new EmployeeDTO("EMP002", "rammi", "dali@gmail.com", "QA");
		HttpHeaders httpHeaders = new HttpHeaders();
		HttpEntity<EmployeeDTO> request = new HttpEntity<EmployeeDTO>(employeeDTO, httpHeaders);
		ResponseEntity<String> postresponse = testRestTemplate
				.postForEntity("http://localhost:8084/employeeservice" + "/createemployee", request, String.class);
		assertEquals(200, postresponse.getStatusCodeValue());

		EmployeeDTO employeeDTO1 = new EmployeeDTO("EMP002", "rammi", "rammi@gmail.com", "QA");
		HttpEntity<EmployeeDTO> updaterequest = new HttpEntity<EmployeeDTO>(employeeDTO1, httpHeaders);
		ResponseEntity<String> putResponse = testRestTemplate.exchange(
				"http://localhost:8084/employeeservice" + "/update" + "/EMP002", HttpMethod.PUT, updaterequest,
				String.class);

		assertEquals(UPDATE_EMPLOYEE_RESPONSE, putResponse.getBody());

	}
}