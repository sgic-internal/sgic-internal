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

public class UpdateDefectStatusTest extends DefectStatusAppTest{
	
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
	
	private static final String UPDATE_DEFECT_STATUS = "{\"id\":2,\"name\":\"kenn\",\"value\":\"closed\"}";
	private static final String CHECK_UPDATE_DEFECT_STATUS = "{\"id\":2,\"name\":\"kenn Updated\",\"value\":\"closed Updated\"}";

	DefectStatusDto defectStatusDto = new DefectStatusDto();
	
	// Testing for update defect type
		@Test
		public void updateDefectStatusTest() throws IOException, RestClientException {
			Long id = (long) 2;
			ResponseEntity<String> getResponse = testRestTemplate.exchange(BASE_URL + "/defectstatus/" + id, HttpMethod.GET,
					new HttpEntity<>(httpHeaders), String.class);
			assertEquals(UPDATE_DEFECT_STATUS, getResponse.getBody());
			defectStatusDto.setName("kenn Updated");
			defectStatusDto.setValue("closed Updated");

			HttpEntity<DefectStatusDto> request = new HttpEntity<DefectStatusDto>(defectStatusDto, httpHeaders);
			testRestTemplate.exchange(BASE_URL + "/defectstatus/" + id, HttpMethod.PUT, request, String.class);

			ResponseEntity<String> getUpdatedResponse = testRestTemplate.exchange(BASE_URL + "/defectstatus/" + id,
					HttpMethod.GET, new HttpEntity<>(httpHeaders), String.class);
			assertEquals(CHECK_UPDATE_DEFECT_STATUS, getUpdatedResponse.getBody());
		}
		@After
		public void tearDown() {

		}

}
