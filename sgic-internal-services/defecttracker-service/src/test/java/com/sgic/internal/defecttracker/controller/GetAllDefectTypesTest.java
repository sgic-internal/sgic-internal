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

public class GetAllDefectTypesTest extends DefectTypeAppTest{
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
	
	private static final String GET_ALL_DEFECT_TYPES = "[{\"id\":1,\"name\":\"UI\",\"value\":\"User Interface\"},{\"id\":2,\"name\":\"Performance\",\"value\":\"Functionality\"},{\"id\":3,\"name\":\"UI\",\"value\":\"Dashboard\"}]";
	
	// Testing for get all defect types
		@Test
		public void getDefectTypesTest() throws IOException, RestClientException {
			ResponseEntity<String> response = testRestTemplate.exchange(BASE_URL + "/defecttypes", HttpMethod.GET,
					new HttpEntity<>(httpHeaders), String.class);
			assertEquals(GET_ALL_DEFECT_TYPES, response.getBody());
		}
		
		@After
		public void tearDown() {

		}

}
