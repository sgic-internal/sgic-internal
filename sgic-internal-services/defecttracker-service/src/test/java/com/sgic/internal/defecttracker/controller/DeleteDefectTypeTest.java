package com.sgic.internal.defecttracker.controller;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.client.RestClientException;

import com.sgic.internal.defecttracker.DefectTypeAppTest;

public class DeleteDefectTypeTest extends DefectTypeAppTest {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Before
	public void setup() {
		String newSql1 = "INSERT INTO defectservices.defecttype (name, value) VALUES ('UI','User Interface')";
		String newSql2 = "INSERT INTO defectservices.defecttype (name, value) VALUES ('Performance','Functionality')";
		String newSql3 = "INSERT INTO defectservices.defecttype (name, value) VALUES ('UI','Dashboard')";
		
		jdbcTemplate.execute(newSql1);
		jdbcTemplate.execute(newSql2);
		jdbcTemplate.execute(newSql3);

	}

	private String BASE_URL = "http://localhost:8080/defectservice";
	
	private static final String DELETE_DEFECT_TYPE = "{\"id\":3,\"name\":\"UI\",\"value\":\"Dashboard\"}";
	
	// Testing for delete defect type
		@Test
		public void deleteDefectTypeTest() throws IOException, RestClientException {
			Long id = (long) 3;
			ResponseEntity<String> getResponse = testRestTemplate.exchange(BASE_URL + "/defecttype/" + id, HttpMethod.GET,
					new HttpEntity<>(httpHeaders), String.class);
			assertEquals(DELETE_DEFECT_TYPE, getResponse.getBody());
			ResponseEntity<String> deleteResponse = testRestTemplate.exchange(BASE_URL + "/defecttype/" + id, HttpMethod.DELETE, new HttpEntity<>(httpHeaders),String.class);
			
			assertEquals(true, deleteResponse.getBody().contains("request body is missing"));
		}
		
		@After
		public void tearDown() {

		}

}
