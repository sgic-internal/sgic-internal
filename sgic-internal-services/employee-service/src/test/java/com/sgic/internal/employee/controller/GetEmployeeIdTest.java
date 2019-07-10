package com.sgic.internal.employee.controller;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import com.sgic.internal.employee.EmployeeTest;
import com.sgic.internal.employee.dto.EmployeeDTO;

public class GetEmployeeIdTest extends EmployeeTest {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@SuppressWarnings("unused")
	private EmployeeDTO employee = new EmployeeDTO();

	private String empIdV = "EMP001";

	private static final String GET_BY_ID_RESPONSE = "{\"empId\":\"EMP001\",\"name\":\"puthijaJothi\",\"email\":\"kavitha@gmail.com\",\"designation\":\"softwareEngineer\"}";

	@Test
	public void GetByIdTestSuccessfull() throws IOException {

		EmployeeDTO employeeDTO = new EmployeeDTO("EMP001", "puthijaJothi", "kavitha@gmail.com", "softwareEngineer");
		HttpHeaders httpHeaders = new HttpHeaders();
		HttpEntity<EmployeeDTO> request = new HttpEntity<EmployeeDTO>(employeeDTO, httpHeaders);
		ResponseEntity<String> postresponse = testRestTemplate
				.postForEntity("http://localhost:8084/employeeservice/" + "/createemployee", request, String.class);

		ResponseEntity<String> getbyidresponse = testRestTemplate.exchange(
				"http://localhost:8084/employeeservice" + "/getempolyeebyid" + "/" + empIdV, HttpMethod.GET,
				new HttpEntity<>(httpHeaders), String.class);
		assertEquals(200, postresponse.getStatusCodeValue());
		assertEquals(GET_BY_ID_RESPONSE, getbyidresponse.getBody());
		assertEquals(HttpStatus.OK, getbyidresponse.getStatusCode());
	}

}
