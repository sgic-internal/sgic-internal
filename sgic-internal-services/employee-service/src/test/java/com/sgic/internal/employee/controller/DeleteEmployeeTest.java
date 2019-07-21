package com.sgic.internal.employee.controller;

import com.sgic.internal.employee.EmployeeTest;
import static org.junit.Assert.assertEquals;
import java.io.IOException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.client.RestClientException;
import com.sgic.internal.employee.dto.EmployeeDTO;

public class DeleteEmployeeTest extends EmployeeTest {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@SuppressWarnings("unused")
//	Use EmployeeDTO 
	private EmployeeDTO employeeDTO = new EmployeeDTO();

//	common URL
	private String BASE_URL = "http://localhost:8084/employeeservice";
//	Post API
	private String ADD_API_URL = "/createemployee";

//	Delete API
	private String DELETE_API_URL = "/deletebyid/";

// Testing Id for delete Testing
	private String empId = "emp002";

	@SuppressWarnings("unused")
//	Save unit Test expected Response
	private static final String ADD_EMPLOYEE_RESPONSE = "[{\"empId\":\"emp002\",\"name\":\"jothi\",\"email\":\"saidputhi@gmail.com\",\"designation\":\"QA\"}]";
	@SuppressWarnings("unused")

//	Save unit Test expected Response
	private static final String DELETE_EMPLOYEE_RESPONSE = "Deleted Successfully";

	@Test
	public void deleteEmployee() throws IOException, RestClientException {
		EmployeeDTO employeeDTO = new EmployeeDTO("emp002", "jothi", "saidputhi@gmail.com", "QA");
		HttpEntity<EmployeeDTO> request = new HttpEntity<EmployeeDTO>(employeeDTO, httpHeaders);
		ResponseEntity<String> postResponse = testRestTemplate.postForEntity(BASE_URL + ADD_API_URL, request,
				String.class);
		assertEquals(200, postResponse.getStatusCodeValue());

		ResponseEntity<String> getResponse = testRestTemplate.exchange(BASE_URL + DELETE_API_URL + empId,
				HttpMethod.DELETE, new HttpEntity<>(httpHeaders), String.class);
		assertEquals(200, getResponse.getStatusCodeValue());
		assertEquals(DELETE_EMPLOYEE_RESPONSE, getResponse.getBody());

	}

}
