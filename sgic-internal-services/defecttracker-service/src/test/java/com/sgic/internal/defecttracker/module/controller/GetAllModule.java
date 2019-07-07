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

public class GetAllModule extends ModuleTest{
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	ModuleData moduleData;
	
	@Test
	public void GetAllModule() throws IOException, RestClientException {
	
	moduleData.setModuleId("1");
	moduleData.setModuleName("School");
	
	HttpHeaders httpHeaders = new HttpHeaders();
	HttpEntity<ModuleData> request = new HttpEntity<ModuleData>(moduleData, httpHeaders);

	ResponseEntity<String> response = testRestTemplate
			.postForEntity("http://localhost:8081/defectservices" + "/createmodule", request, String.class);
	assertEquals(200, response.getStatusCodeValue());

	ResponseEntity<String> response1 = testRestTemplate.exchange(
			"http://localhost:8081/defectservices" + "/GetAllmodule", HttpMethod.GET,
			new HttpEntity<>(httpHeaders), String.class);
	assertEquals(HttpStatus.OK, response1.getStatusCode());
	Object body = "[{\"moduleId\":\"1\",\"moduleName\":\"SchoolSS\"}]";
//	assertEquals(body, response1.getBody());
}

@After
public void tearDown() {

}
}
