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
import com.sgic.internal.defecttracker.defect.controller.dto.DefectTypeDto;

public class UpdateDefectTypeTest extends DefectTypeAppTest{
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
	
	private static final String UPDATE_DEFECT_TYPE = "{\"id\":2,\"name\":\"Performance\",\"value\":\"Functionality\"}";
	private static final String CHECK_UPDATE_DEFECT_TYPE = "{\"id\":2,\"name\":\"Performance Updated\",\"value\":\"Functionality Updated\"}";
	
	DefectTypeDto defectTypeDto = new DefectTypeDto();
	
	// Testing for update defect type
		@Test
		public void updateDefectTypeTest() throws IOException, RestClientException {
			Long id = (long) 2;
			ResponseEntity<String> getResponse = testRestTemplate.exchange(BASE_URL + "/defecttype/" + id, HttpMethod.GET,
					new HttpEntity<>(httpHeaders), String.class);
			assertEquals(UPDATE_DEFECT_TYPE, getResponse.getBody());
			defectTypeDto.setName("Performance Updated");
			defectTypeDto.setValue("Functionality Updated");
			
			HttpEntity<DefectTypeDto> request = new HttpEntity<DefectTypeDto>(defectTypeDto, httpHeaders);
			testRestTemplate.exchange(BASE_URL + "/defecttype/" + id, HttpMethod.PUT,
					request, String.class);
			
			ResponseEntity<String> getUpdatedResponse = testRestTemplate.exchange(BASE_URL + "/defecttype/" + id, HttpMethod.GET,
					new HttpEntity<>(httpHeaders), String.class);
			assertEquals(CHECK_UPDATE_DEFECT_TYPE, getUpdatedResponse.getBody());
		}

		@After
		public void tearDown() {

		}

}
