package com.sgic.internal.defecttracker.submodule.controller;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.After;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.client.RestClientException;


import com.sgic.internal.defecttracker.project.controller.dto.SubModuleData;
import com.sgic.internal.defecttracker.submodule.SubModuleTest;

public class GetBySubModuleName  extends SubModuleTest{
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	SubModuleData subModuleData;
	
	@Test
	public void GetBySubModuleName() throws IOException, RestClientException {
   subModuleData.setSubModuleId("1");
   subModuleData.setSubModuleName("School");
   
   HttpHeaders httpHeaders = new HttpHeaders();
	HttpEntity<SubModuleData> request = new HttpEntity<SubModuleData>(subModuleData, httpHeaders);

	ResponseEntity<String> response = testRestTemplate
			.postForEntity("http://localhost:8080/defectservices" + "/createsubmodule", request, String.class);
	assertEquals(200, response.getStatusCodeValue());

	ResponseEntity<String> responseName = testRestTemplate.exchange(
			"http://localhost:8080/defectservices" + "/getSubModuleName"  + "/School", HttpMethod.GET,
			new HttpEntity<>(httpHeaders), String.class);
	assertEquals(HttpStatus.OK, responseName.getStatusCode());
	Object body = "[{\"subModuleId\":\"1\",\"subModuleName\":\"School\"}]";
	assertEquals(body, responseName.getBody());
}

@After
public void tearDown() {
	
	}
}
