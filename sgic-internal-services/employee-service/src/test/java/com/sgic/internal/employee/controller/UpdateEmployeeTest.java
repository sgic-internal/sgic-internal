package com.sgic.internal.employee.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import javax.xml.ws.Response;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.client.RestClientException;

import com.sgic.internal.employee.EmployeeTest;
import com.sgic.internal.employee.entities.Employee;

public class UpdateEmployeeTest extends EmployeeTest {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Before
	public void setup() {

	}

	@Test
	public void updateEmployeeSuccessfully() throws IOException, RestClientException {
		int empId = 1;

		Employee employee2 = new Employee();
		employee2.setEmail("saranya@gmail.com");
		employee2.setDesignation("tech lead");
		employee2.setName("puthiya jothi");
		testRestTemplate.put("http://localhost:8080/employeeservice" + "/GetEmpolyeeById/" + empId, employee2,
				Employee.class);

	}

	@After
	public void tearDown() {

	}

	public final class CareerDevelopmentPlanConstant {

		public CareerDevelopmentPlanConstant() {
		}

		@SuppressWarnings("unused")
		private static final String CAREER_DEVELOPMENT_PLAN_RESPONSE = "[{ \\\"empId\\\":\\\"emp006\\\", \\\"firstName\\\":\\\"priyanka\\\", \\\"lastName\\\":\\\"asasas\\\", \\\"email\\\":\\\"ramz@gmail.com\\\", \\\"designation\\\":\\\"software engineer\\\" }]";
	}
}