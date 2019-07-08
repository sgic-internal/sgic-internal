package com.sgic.internal.defecttracker.controller;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.client.RestClientException;

import com.sgic.internal.defecttracker.DefectPriorityAppTest;

public class GetAllDefectPrioritiesTest extends DefectPriorityAppTest {
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
	
	private static final String GET_ALL_DEFECT_PRIORITIES = "[{\"id\":1,\"name\":\"name1\",\"value\":\"value1\",\"icon\":\"icon1\",\"color\":\"color1\"},{\"id\":2,\"name\":\"name2\",\"value\":\"value2\",\"icon\":\"icon2\",\"color\":\"color2\"}]";
	
	//Testing for get all defect priorities
	@Test
	public void getAllDefectPrioritiesTest() throws IOException, RestClientException {
		ResponseEntity<String> response = testRestTemplate.exchange(BASE_URL + "/defectpriorities", HttpMethod.GET, new HttpEntity<>(httpHeaders), String.class);
		assertEquals(GET_ALL_DEFECT_PRIORITIES, response.getBody());
	}
	
	@Before
	public void tearDown() {
		
	}
}
