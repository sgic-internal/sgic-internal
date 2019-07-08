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

import com.sgic.internal.defecttracker.DefectPriorityAppTest;
import com.sgic.internal.defecttracker.defect.controller.dto.DefectPriorityDto;

public class UpdateDefectPriorityTest extends DefectPriorityAppTest {
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Before
	public void setup() {
		String sql1 = "INSERT INTO defectservices.defectpriority (name, value, icon, color) VALUES ('name1','value1','icon1','color1')";
		String sql2 = "INSERT INTO defectservices.defectpriority (name, value, icon, color) VALUES ('name2','value2','icon2','color2')";

		jdbcTemplate.execute(sql1);
		jdbcTemplate.execute(sql2);
	}

	private String BASE_URL = "http://localhost:8080/defectservice";

	private static final String UPDATE_DEFECT_PRIORITY = "{\"id\":2,\"name\":\"name2\",\"value\":\"value2\",\"icon\":\"icon2\",\"color\":\"color2\"}";
	private static final String CHECK_UPDATED_DEFECT_PRIORITY = "{\"id\":2,\"name\":\"new name\",\"value\":\"new value\",\"icon\":\"new icon\",\"color\":\"new color\"}";

	DefectPriorityDto defectPriorityDto = new DefectPriorityDto();
	
	//Testing for update defect priority
	@Test
	public void updateDefectPriority() throws IOException, RestClientException {
		long id = 2;
		ResponseEntity<String> response = testRestTemplate.exchange(BASE_URL + "/defectpriority/" + id, HttpMethod.GET, new HttpEntity<>(httpHeaders), String.class);
		assertEquals(UPDATE_DEFECT_PRIORITY, response.getBody());
		
		defectPriorityDto.setName("new name");
		defectPriorityDto.setValue("new value");
		defectPriorityDto.setIcon("new icon");
		defectPriorityDto.setColor("new color");
		HttpEntity<DefectPriorityDto> updateRequest = new HttpEntity<DefectPriorityDto>(defectPriorityDto, httpHeaders);
		testRestTemplate.exchange(BASE_URL + "/defectpriority/" + id, HttpMethod.PUT, updateRequest, String.class);
		
		ResponseEntity<String> getUpdatedResponse = testRestTemplate.exchange(BASE_URL + "/defectpriority/" + id, HttpMethod.GET, new HttpEntity<>(httpHeaders), String.class);
		assertEquals(CHECK_UPDATED_DEFECT_PRIORITY, getUpdatedResponse.getBody());
	}

	@After
	public void tearDown() {

	}
}
