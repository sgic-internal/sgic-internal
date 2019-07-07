package com.sgic.internal.defecttracker.module.controller;

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

import com.sgic.internal.defecttracker.module.ModuleTest;
import com.sgic.internal.defecttracker.project.controller.dto.ModuleData;

public class GetByModuleName  extends ModuleTest{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	ModuleData moduleData;
	
	@Test
	public void GetModuleName() throws IOException, RestClientException {
	
	moduleData.setModuleId("1");
	moduleData.setModuleName("School");
	
	HttpHeaders httpHeaders = new HttpHeaders();
	HttpEntity<ModuleData> request = new HttpEntity<ModuleData>(moduleData, httpHeaders);

	ResponseEntity<String> response = testRestTemplate
			.postForEntity("http://localhost:8080/defectservices" + "/createmodule", request, String.class);
	assertEquals(200, response.getStatusCodeValue());

	ResponseEntity<String> responseName = testRestTemplate.exchange(
			"http://localhost:8080/defectservices" + "/getModuleName"  + "/School", HttpMethod.GET,
			new HttpEntity<>(httpHeaders), String.class);
	assertEquals(HttpStatus.OK, responseName.getStatusCode());
	Object body = "[{\"moduleId\":\"1\",\"moduleName\":\"School\"}]";
	assertEquals(body, responseName.getBody());
}

@After
public void tearDown() {

}

}
