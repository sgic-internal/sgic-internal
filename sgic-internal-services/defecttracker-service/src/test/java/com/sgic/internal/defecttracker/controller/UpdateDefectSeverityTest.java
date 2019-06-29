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

import com.sgic.internal.defecttracker.DefectSeverityAppTest;
import com.sgic.internal.defecttracker.defect.controller.dto.DefectSeverityDto;

public class UpdateDefectSeverityTest extends DefectSeverityAppTest {
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Before
	public void setup() {
		String sql1 = "INSERT INTO defectservices.defectseverity (name, value, icon, color) VALUES ('name1','value1','icon1','color1')";
		String sql2 = "INSERT INTO defectservices.defectseverity (name, value, icon, color) VALUES ('name2','value2','icon2','color2')";

		jdbcTemplate.execute(sql1);
		jdbcTemplate.execute(sql2);
	}

	private String BASE_URL = "http://localhost:8080/defectservice";

	private static final String UPDATE_DEFECT_SEVERITY = "{\"id\":2,\"name\":\"name2\",\"value\":\"value2\",\"icon\":\"icon2\",\"color\":\"color2\"}";
	private static final String CHECK_UPDATED_DEFECT_SEVERITY = "{\"id\":2,\"name\":\"new name\",\"value\":\"new value\",\"icon\":\"new icon\",\"color\":\"new color\"}";

	DefectSeverityDto defectSeverityDto = new DefectSeverityDto();
	
	// Testing for update defect severity
	@Test
	public void updateDefectPriority() throws IOException, RestClientException {
		long id = 2;
		ResponseEntity<String> response = testRestTemplate.exchange(BASE_URL + "/defectseverity/" + id, HttpMethod.GET, new HttpEntity<>(httpHeaders), String.class);
		assertEquals(UPDATE_DEFECT_SEVERITY, response.getBody());
		
		defectSeverityDto.setName("new name");
		defectSeverityDto.setValue("new value");
		defectSeverityDto.setIcon("new icon");
		defectSeverityDto.setColor("new color");
		HttpEntity<DefectSeverityDto> updateRequest = new HttpEntity<DefectSeverityDto>(defectSeverityDto, httpHeaders);
		testRestTemplate.exchange(BASE_URL + "/defectseverity/" + id, HttpMethod.PUT, updateRequest, String.class);
		
		ResponseEntity<String> getUpdatedResponse = testRestTemplate.exchange(BASE_URL + "/defectseverity/" + id, HttpMethod.GET, new HttpEntity<>(httpHeaders), String.class);
		assertEquals(CHECK_UPDATED_DEFECT_SEVERITY, getUpdatedResponse.getBody());
	}

	@After
	public void tearDown() {

	}
}
