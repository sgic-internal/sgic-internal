package com.sgic.internal.defecttracker.controller;


import static org.junit.Assert.assertEquals;

import java.io.IOException;

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

import com.sgic.internal.defecttracker.DefectTypeAppTest;

public class DefectTypeTest extends DefectTypeAppTest{
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Before
	public void setup() {
		String newSql = "INSERT INTO defectservices.defecttype (name, value) VALUES ('aaa','sss')";
		jdbcTemplate.execute(newSql);
		
	}
	@Test
	public void getDefectTypeSuccessfull() throws IOException, RestClientException{
		ResponseEntity<String> response = testRestTemplate.exchange("http://localhost:8081" + "/defecttypes" , HttpMethod.GET,
				new HttpEntity<>(httpHeaders),String.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	
	@Test
	public void getDefectTypeByIdSuccessfull() throws IOException, RestClientException{
		ResponseEntity<String> response = testRestTemplate.exchange("http://localhost:8081" + "/defecttype/6" , HttpMethod.GET,
				new HttpEntity<>(httpHeaders),String.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	
	
	@After
	public void tearDown() {
		
	}
	
	public final class DefectTypeTestConstant{
		public DefectTypeTestConstant() {
		}
		private static final String DEFECTTYPERESPONSE = "[ { \\\"id\\\": 3, \\\"name\\\": \\\"ddd\\\", \\\"value\\\": \\\"ddd\\\" }, { \\\"id\\\": 4, \\\"name\\\": \\\"ee\\\", \\\"value\\\": \\\"ee\\\" }, { \\\"id\\\": 5, \\\"name\\\": \\\"aaa\\\", \\\"value\\\": \\\"sss\\\" } ]";
	}
	

}
