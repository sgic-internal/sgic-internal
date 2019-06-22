package com.sgic.internal.defecttracker.controller;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.client.RestClientException;

import com.sgic.internal.defecttracker.DefectTypeAppTest;
import com.sgic.internal.defecttracker.defect.controller.dto.DefectTypeDto;

public class DefectTypeTest extends DefectTypeAppTest {
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Before
	public void setup() {
		String newSql = "INSERT INTO defectservices.defecttype (name, value) VALUES ('UI','User Interface')";
		String newSql2 = "INSERT INTO defectservices.defecttype (name, value) VALUES ('Performance','Functionality')";
		String newSql3 = "INSERT INTO defectservices.defecttype (name, value) VALUES ('UI','Dashboard')";
		
		jdbcTemplate.execute(newSql);
		jdbcTemplate.execute(newSql2);
		jdbcTemplate.execute(newSql3);

	}

	private String BASE_URL = "http://localhost:8081/defectservice";

	private static final String CREATE_DEFECT_TYPE = "{\"id\":1,\"name\":\"UI\",\"value\":\"User Interface\"}";
	private static final String GET_ALL_DEFECT_TYPES = "[{\"id\":1,\"name\":\"UI\",\"value\":\"User Interface\"},{\"id\":2,\"name\":\"Performance\",\"value\":\"Functionality\"},{\"id\":3,\"name\":\"UI\",\"value\":\"Dashboard\"}]";
	private static final String GET_DEFECT_TYPE_BY_ID = "{\"id\":1,\"name\":\"UI\",\"value\":\"User Interface\"}";
	private static final String UPDATE_DEFECT_TYPE = "{\"id\":2,\"name\":\"Performance\",\"value\":\"Functionality\"}";
	private static final String CHECK_UPDATE_DEFECT_TYPE = "{\"id\":2,\"name\":\"Performance Updated\",\"value\":\"Functionality Updated\"}";
	private static final String DELETE_DEFECT_TYPE = "{\"id\":3,\"name\":\"UI\",\"value\":\"Dashboard\"}";
	
	DefectTypeDto defectTypeDto = new DefectTypeDto();
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

	// Testing for get all defect types
	@Test
	public void getDefectTypeTest() throws IOException, RestClientException {
		ResponseEntity<String> response = testRestTemplate.exchange(BASE_URL + "/defecttypes", HttpMethod.GET,
				new HttpEntity<>(httpHeaders), String.class);
		assertEquals(GET_ALL_DEFECT_TYPES, response.getBody());
	}

	// Testing for get defect type by id
	@Test
	public void getDefectTypeByIdTest() throws IOException, RestClientException {
		Long id = (long) 1;
		ResponseEntity<String> response = testRestTemplate.exchange(BASE_URL + "/defecttype/" + id, HttpMethod.GET,
				new HttpEntity<>(httpHeaders), String.class);
		assertEquals(GET_DEFECT_TYPE_BY_ID, response.getBody());
	}

	// Testing for delete defect type
	@Test
	public void deleteDefectTypeTest() throws IOException, RestClientException {
		Long id = (long) 3;
		ResponseEntity<String> getResponse = testRestTemplate.exchange(BASE_URL + "/defecttype/" + id, HttpMethod.GET,
				new HttpEntity<>(httpHeaders), String.class);
		assertEquals(DELETE_DEFECT_TYPE, getResponse.getBody());
		ResponseEntity<String> deleteResponse = testRestTemplate.exchange(BASE_URL + "/defecttype/" + id, HttpMethod.DELETE, new HttpEntity<>(httpHeaders),String.class);
		
		assertEquals(true, deleteResponse.getBody().contains("request body is missing"));
	}

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

	public final class DefectTypeTestConstant {
		public DefectTypeTestConstant() {
		}
	}

}
