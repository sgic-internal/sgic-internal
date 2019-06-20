package com.sgic.internal.defecttracker.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.common.Json;
import com.sgic.internal.defecttracker.DefectTypeAppTest;
import com.sgic.internal.defecttracker.defect.entities.DefectType;

public class DefectTypeTest extends DefectTypeAppTest {
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Before
	public void setup() {
		String newSql = "INSERT INTO defectservices.defecttype (name, value) VALUES ('aaa','sss')";
		String newSql2 = "INSERT INTO defectservices.defecttype (name, value) VALUES ('ff','ccc')";
		jdbcTemplate.execute(newSql);
		jdbcTemplate.execute(newSql2);

	}

	private String getRootUrl() {
		return "http://localhost:8081";
	}

	// Testing for get all defect types
	@Test
	public void getDefectTypeTest() throws IOException, RestClientException {
		ResponseEntity<String> response = testRestTemplate.exchange(getRootUrl() + "/defecttypes", HttpMethod.GET,
				new HttpEntity<>(httpHeaders), String.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	// Testing for get defect type by id
	@Test
	public void getDefectTypeByIdTest() throws IOException, RestClientException {
		DefectType defectType = testRestTemplate.getForObject(getRootUrl() + "/defecttype/1", DefectType.class);
		assertNotNull(defectType);
	}

	// Testing for save defect type
	@Test
	public void createDefectTypeTest() throws IOException, RestClientException {
		HttpHeaders header = new HttpHeaders();
		ObjectMapper mapper = new ObjectMapper();
		DefectType defectType = new DefectType();
	    defectType.setId(1);
		defectType.setName("cc");
		defectType.setValue("ddd");
		assertNotNull(defectType);
		String jsonString = mapper.writeValueAsString(defectType);
		System.out.println(jsonString);
		
		ResponseEntity<DefectType> request = testRestTemplate.postForEntity(getRootUrl() + "/defecttype",
				jsonString, DefectType.class);
		assertEquals(HttpStatus.OK, request.getStatusCode());
	}

	// Testing for delete defect type
	@Test
	public void deleteDefectTypeTest() throws IOException, RestClientException {
		int id = 1;
		DefectType defectType = testRestTemplate.getForObject(getRootUrl() + "/defecttype/" + id, DefectType.class);
		assertNotNull(defectType);
		testRestTemplate.delete(getRootUrl() + "/defecttype" + id);
		try {
			defectType = testRestTemplate.getForObject(getRootUrl() + "/defecttype/" + id, DefectType.class);
		} catch (final HttpClientErrorException e) {
			assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
		}
	}

	// Testing for update defect type
	@Test
	public void updateDefectTypeTest() throws IOException, RestClientException {
		int id = 1;
		DefectType defectType = testRestTemplate.getForObject(getRootUrl() + "/defecttype/" + id, DefectType.class);
		assertNotNull(defectType);
		defectType.setName("kkk");
		defectType.setValue("iii");
		testRestTemplate.put(getRootUrl() + "/defecttype" + id, defectType, DefectType.class);
	}

	@After
	public void tearDown() {

	}

	public final class DefectTypeTestConstant {
		public DefectTypeTestConstant() {
		}

		private static final String DEFECTTYPERESPONSE = "[ { \\\"id\\\": 3, \\\"name\\\": \\\"ddd\\\", \\\"value\\\": \\\"ddd\\\" }, { \\\"id\\\": 4, \\\"name\\\": \\\"ee\\\", \\\"value\\\": \\\"ee\\\" }, { \\\"id\\\": 5, \\\"name\\\": \\\"aaa\\\", \\\"value\\\": \\\"sss\\\" } ]";
	}

}
