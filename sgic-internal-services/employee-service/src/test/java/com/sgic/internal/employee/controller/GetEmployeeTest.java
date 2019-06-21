package com.sgic.internal.employee.controller;

import com.sgic.internal.employee.EmployeeTest;
import com.sgic.internal.employee.repositories.EmployeeRepository;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.client.RestClientException;

public class GetEmployeeTest extends EmployeeTest{

	@Autowired
	  JdbcTemplate jdbcTemplate;
	
	@SuppressWarnings("unused")
	private static Logger logger = LogManager.getLogger(EmployeeRepository.class);
	
	@Before
	  public void setup() {
		logger.info("successfully Insert values");
	  String Getemploye = "INSERT INTO employeeservice.employee (emp_id, designation, email, name) VALUES ('emp002', 'Software Engineer', 'tyronne90@gmail.com', 'tyronne')";
	  jdbcTemplate.execute(Getemploye);
	  }
	
	@Test
	  public void getEmployeeSuccessfull() throws IOException, RestClientException {
	    ResponseEntity<String> response =
	        testRestTemplate.exchange("http://localhost:8080/employeeservice" + "/getallemployee", HttpMethod.GET,
	        		   new HttpEntity<>(httpHeaders), String.class);
	    assertEquals(HttpStatus.OK, response.getStatusCode());
	   }
	   
	  @After
	  public void tearDown() {

	  }
	  public final class EmployeeConstant{
		    
		    public EmployeeConstant() {
		    }
		    
		    @SuppressWarnings("unused")
			private static final String GETEMPLOYEE_RESPONSE =
		    		"[ {\\\"empId\\\": \\\"emp001\\\", \\\"name\\\": \\\"tyronne\\\",\\\"email\\\": \\\"tyronne@gmail.com\\\",\\\"designation\\\": \\\"QA\\\"} ]";
		  }

	  
	  
}
