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

import com.sgic.internal.defecttracker.defecttypes.DefectTypeAppTest;
import com.sgic.internal.defecttracker.defect.controller.dto.DefectTypeDto;

public class CreateDefectTypeTest extends DefectTypeAppTest{
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private String BASE_URL = "http://localhost:8080/defectservice";
	
	private static final String CREATE_DEFECT_TYPE = "{\"id\":1,\"name\":\"UI\",\"value\":\"User Interface\"}";

	DefectTypeDto defectTypeDto = new DefectTypeDto();
	
	@Before
	public void setup() {
		
	}
	
	// Testing for save defect type
	@Test
	public void createDefectTypeTest() throws IOException {
		defectTypeDto.setName("UI");
		defectTypeDto.setValue("User Interface");
		HttpEntity<DefectTypeDto> request = new HttpEntity<DefectTypeDto>(defectTypeDto, httpHeaders);
		ResponseEntity<String> postResponse = testRestTemplate.exchange(BASE_URL + "/defecttype", HttpMethod.POST,
				request, String.class);
		assertEquals(HttpStatus.OK, postResponse.getStatusCode());
		ResponseEntity<String> getResponse = testRestTemplate.exchange(BASE_URL + "/defecttype/1", HttpMethod.GET,
				new HttpEntity<>(httpHeaders), String.class);
		assertEquals(CREATE_DEFECT_TYPE, getResponse.getBody());
	}
	
	@After
	public void tearDown() {

	}
	
}
