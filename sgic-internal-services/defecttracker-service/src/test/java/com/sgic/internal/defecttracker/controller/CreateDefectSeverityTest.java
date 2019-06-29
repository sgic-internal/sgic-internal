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

import com.sgic.internal.defecttracker.DefectSeverityAppTest;
import com.sgic.internal.defecttracker.defect.controller.dto.DefectSeverityDto;

public class CreateDefectSeverityTest extends DefectSeverityAppTest {
	@Autowired
	JdbcTemplate jdbcTemplate;

	private String BASE_URL = "http://localhost:8080/defectservice";

	private static final String CREATE_DEFECT_SEVERITY = "{\"id\":1,\"name\":\"L\",\"value\":\"Low\",\"icon\":\"lIcon\",\"color\":\"lColor\"}";

	DefectSeverityDto defectSeverityDto = new DefectSeverityDto();

	@Before
	public void setup() {

	}
	
	// Testing for create defect severity
		@Test
		public void createDefectSeverityTest() throws IOException {
			defectSeverityDto.setName("L");
			defectSeverityDto.setValue("Low");
			defectSeverityDto.setIcon("lIcon");
			defectSeverityDto.setColor("lColor");
			HttpEntity<DefectSeverityDto> request = new HttpEntity<DefectSeverityDto>(defectSeverityDto, httpHeaders);
			ResponseEntity<String> postResponse = testRestTemplate.exchange(BASE_URL + "/defectseverity", HttpMethod.POST,
					request, String.class);
			assertEquals(HttpStatus.OK, postResponse.getStatusCode());
			ResponseEntity<String> getResponse = testRestTemplate.exchange(BASE_URL + "/defectseverity/1", HttpMethod.GET,
					new HttpEntity<>(httpHeaders), String.class);
			assertEquals(CREATE_DEFECT_SEVERITY, getResponse.getBody());
		}

		@After
		public void tearDown() {

		}
}
