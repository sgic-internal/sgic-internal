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

import com.sgic.internal.defecttracker.DefectPriorityAppTest;
import com.sgic.internal.defecttracker.defect.controller.dto.DefectPriorityDto;

public class CreateDefectPriorityTest extends DefectPriorityAppTest {
	@Autowired
	JdbcTemplate jdbcTemplate;

	private String BASE_URL = "http://localhost:8080/defectservice";

	private static final String CREATE_DEFECT_PRIORITY = "{\"id\":1,\"name\":\"HI\",\"value\":\"High\",\"icon\":\"hIcon\",\"color\":\"hColor\"}";

	DefectPriorityDto defectPriorityDto = new DefectPriorityDto();

	@Before
	public void setup() {

	}

	// Testing for create defect priority
	@Test
	public void createDefectPriorityTest() throws IOException {
		defectPriorityDto.setName("HI");
		defectPriorityDto.setValue("High");
		defectPriorityDto.setIcon("hIcon");
		defectPriorityDto.setColor("hColor");
		HttpEntity<DefectPriorityDto> request = new HttpEntity<DefectPriorityDto>(defectPriorityDto, httpHeaders);
		ResponseEntity<String> postResponse = testRestTemplate.exchange(BASE_URL + "/defectpriority", HttpMethod.POST,
				request, String.class);
		assertEquals(HttpStatus.OK, postResponse.getStatusCode());
		ResponseEntity<String> getResponse = testRestTemplate.exchange(BASE_URL + "/defectpriority/1", HttpMethod.GET,
				new HttpEntity<>(httpHeaders), String.class);
		assertEquals(CREATE_DEFECT_PRIORITY, getResponse.getBody());
	}

	@After
	public void tearDown() {

	}
}
