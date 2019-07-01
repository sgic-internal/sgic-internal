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
import com.sgic.internal.defecttracker.defect.controller.dto.DefectStatusDto;

public class GetAllDefectStatusesTest extends DefectStatusAppTest{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Before
	public void setup() {
		
		String newSql = "INSERT INTO defectservices.defectstatus (name, value) VALUES ('john','open')";
		String newSql2 = "INSERT INTO defectservices.defectstatus (name, value) VALUES ('kenn','closed')";
		String newSql3 = "INSERT INTO defectservices.defectstatus (name, value) VALUES ('jack','open')";

		jdbcTemplate.execute(newSql);
		jdbcTemplate.execute(newSql2);
		jdbcTemplate.execute(newSql3);
		
	
	}
	
	private String BASE_URL = "http://localhost:8081/defectservice";
	
	private static final String GET_ALL_DEFECT_STATUSES = "[{\"id\":1,\"name\":\"john\",\"value\":\"open\"},{\"id\":2,\"name\":\"kenn\",\"value\":\"closed\"},{\"id\":3,\"name\":\"jack\",\"value\":\"open\"}]";
	

	DefectStatusDto defectStatusDto = new DefectStatusDto();
	
	// Testing for get all defect types
		@Test
		public void getDefectStatusesTest() throws IOException, RestClientException {
			ResponseEntity<String> response = testRestTemplate.exchange(BASE_URL + "/defectstatuses", HttpMethod.GET,
					new HttpEntity<>(httpHeaders), String.class);
			assertEquals(GET_ALL_DEFECT_STATUSES, response.getBody());
		}
		
		@After
		public void tearDown() {

		}

}
