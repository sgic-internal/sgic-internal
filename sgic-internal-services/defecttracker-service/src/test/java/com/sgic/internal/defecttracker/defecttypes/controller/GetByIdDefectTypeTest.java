package com.sgic.internal.defecttracker.defecttypes.controller;

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

import com.sgic.internal.defecttracker.defecttypes.DefectTypeAppTest;

public class GetByIdDefectTypeTest extends DefectTypeAppTest{
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
	
	private static final String GET_DEFECT_TYPE_BY_ID = "{\"id\":1,\"name\":\"UI\",\"value\":\"User Interface\"}";
	
	// Testing for get defect type by id
		@Test
		public void getDefectTypeByIdTest() throws IOException, RestClientException {
			Long id = (long) 1;
			ResponseEntity<String> response = testRestTemplate.exchange(BASE_URL + "/defecttype/" + id, HttpMethod.GET,
					new HttpEntity<>(httpHeaders), String.class);
			assertEquals(GET_DEFECT_TYPE_BY_ID, response.getBody());
		}
		
		@After
		public void tearDown() {

		}
}
