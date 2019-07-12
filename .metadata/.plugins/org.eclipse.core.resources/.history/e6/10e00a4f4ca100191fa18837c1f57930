package com.sgic.internal.defecttracker.defecttypes.controller;

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

import com.sgic.internal.defecttracker.defecttypes.DefectStatusAppTest;
import com.sgic.internal.defecttracker.project.controller.dto.DefectStatusDto;

public class CreateDefectStatusTest extends DefectStatusAppTest {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Before
	public void setup() {
		
	
	}
	
	
	private String BASE_URL = "http://localhost:8081/defectservice";
	
	private static final String CREATE_DEFECT_STATUS = "{\"id\":1,\"name\":\"john\",\"value\":\"open\"}";
	
	DefectStatusDto defectStatusDto = new DefectStatusDto();
	
	// Testing for save defect type
		@Test
		public void createDefectStatusTest() throws IOException {
			defectStatusDto.setName("john");
			defectStatusDto.setValue("open");
			HttpEntity<DefectStatusDto> request = new HttpEntity<DefectStatusDto>(defectStatusDto, httpHeaders);
			ResponseEntity<String> postResponse = testRestTemplate.exchange(BASE_URL + "/defectstatus", HttpMethod.POST,
					request, String.class);
			assertEquals(HttpStatus.OK, postResponse.getStatusCode());
			ResponseEntity<String> getResponse = testRestTemplate.exchange(BASE_URL + "/defectstatus/1", HttpMethod.GET,
					new HttpEntity<>(httpHeaders), String.class);
			assertEquals(CREATE_DEFECT_STATUS, getResponse.getBody());
		}
		
		@After
		public void tearDown() {

		}
	
	
	

}
