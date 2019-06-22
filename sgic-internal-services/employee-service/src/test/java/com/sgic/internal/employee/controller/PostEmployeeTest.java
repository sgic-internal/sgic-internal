package com.sgic.internal.employee.controller;


import java.io.IOException;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import com.sgic.internal.employee.EmployeeTest;
import com.sgic.internal.employee.dto.EmployeeDTO;


public class PostEmployeeTest extends EmployeeTest {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Before
	public void setup() {
	}
	
	@SuppressWarnings("unused")
	private EmployeeDTO employee = new EmployeeDTO();
	
	@Test
	  public void testCreateEmployee() throws IOException {
		
	}

}
