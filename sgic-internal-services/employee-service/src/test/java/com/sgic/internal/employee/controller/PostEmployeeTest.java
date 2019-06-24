package com.sgic.internal.employee.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.sgic.internal.employee.EmployeeTest;
import com.sgic.internal.employee.entities.Employee;


public class PostEmployeeTest extends EmployeeTest {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Before
	public void setup() {
	}

	@Test
	public void postEmployee() {
		Employee employee = new Employee();
		employee.setDesignation("software engineer");
		employee.setEmail("kavitha@gmail.com");
		employee.setName("puthija jothi");
		testRestTemplate.postForEntity("http://localhost:8080/employeeservice" + "/createemployee", employee,
				Employee.class);

	}

}
