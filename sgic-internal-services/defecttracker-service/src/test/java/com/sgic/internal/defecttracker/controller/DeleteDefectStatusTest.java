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

import com.sgic.internal.defecttracker.DefectStatusAppTest;
import com.sgic.internal.defecttracker.defect.controller.dto.DefectStatusDto;

public class DeleteDefectStatusTest extends DefectStatusAppTest {
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
	
	private static final String DELETE_DEFECT_STATUS = "{\"id\":2,\"name\":\"kenn\",\"value\":\"closed\"}";


	DefectStatusDto defectStatusDto = new DefectStatusDto();

	// Testing for delete defect type
		@Test
		public void deleteDefectStatusTest() throws IOException, RestClientException {
			Long id = (long) 2;
			ResponseEntity<String> getResponse = testRestTemplate.exchange(BASE_URL + "/defectstatus/" + id, HttpMethod.GET,
					new HttpEntity<>(httpHeaders), String.class);
			assertEquals(DELETE_DEFECT_STATUS, getResponse.getBody());
			ResponseEntity<String> deleteResponse = testRestTemplate.exchange(BASE_URL + "/defectstatus/" + id,
					HttpMethod.DELETE, new HttpEntity<>(httpHeaders), String.class);

			assertEquals(true, deleteResponse.getBody().contains("request body is missing"));
		}

		@After
		public void tearDown() {

		}
}
