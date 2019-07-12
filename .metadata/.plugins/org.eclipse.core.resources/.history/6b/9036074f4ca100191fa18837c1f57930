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

import com.sgic.internal.defecttracker.defecttypes.DefectStatusAppTest;
import com.sgic.internal.defecttracker.project.controller.dto.DefectStatusDto;

public class GetByIdDefectStatusTest extends DefectStatusAppTest{
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Before
	public void setup() {
		String newSql = "INSERT INTO defectservices.defectstatus (name, value) VALUES ('john','open')";
		String newSql2 = "INSERT INTO defectservices.defectstatus (name, value) VALUES ('kenn','closed')";
		

		jdbcTemplate.execute(newSql);
		jdbcTemplate.execute(newSql2);
		

	}

	private String BASE_URL = "http://localhost:8081/defectservice";
	
	private static final String GET_DEFECT_STATUS_BY_ID = "{\"id\":1,\"name\":\"john\",\"value\":\"open\"}";
	
	DefectStatusDto defectStatusDto = new DefectStatusDto();
	
	// Testing for get defect type by id
		@Test
		public void getDefectStatusByIdTest() throws IOException, RestClientException {
			Long id = (long) 1;
			ResponseEntity<String> response = testRestTemplate.exchange(BASE_URL + "/defectstatus/" + id, HttpMethod.GET,
					new HttpEntity<>(httpHeaders), String.class);
			assertEquals(GET_DEFECT_STATUS_BY_ID, response.getBody());
		}
		
		@After
		public void tearDown() {

		}



}
