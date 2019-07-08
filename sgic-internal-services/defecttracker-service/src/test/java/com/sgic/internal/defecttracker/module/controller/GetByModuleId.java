package com.sgic.internal.defecttracker.module.controller;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

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

public class GetByModuleId extends ModuleTest {
	
	
	@Autowired
	JdbcTemplate jdbcTemplate;

//	@SuppressWarnings("unused")
//	private ModuleData moduleData = new ModuleData();
	
	private String moduleId ="1";
	
	
		
		private static final String GET_BY_ID_RESPONSE ="{\"moduleId\":\"1\",\"moduleName\":\"School\"}";

		@Test
		public void GetByModuleId() throws IOException, RestClientException {
			ModuleData moduleData = new ModuleData("1","School");
			HttpHeaders httpHeaders = new HttpHeaders();
			HttpEntity<ModuleData> request = new HttpEntity<ModuleData>(moduleData, httpHeaders);
			ResponseEntity<String> postresponse =testRestTemplate.postForEntity("http://localhost:8080/defectservices/" + "/createmodule", request, String.class);

			ResponseEntity<String> getbyidresponse = testRestTemplate.exchange("http://localhost:8080/defectservices" + "/GetmoduleById" + "/1" , HttpMethod.GET,
			new HttpEntity<>(httpHeaders), String.class);
			assertEquals(200, postresponse.getStatusCodeValue());
			assertEquals(GET_BY_ID_RESPONSE,getbyidresponse.getBody());
			assertEquals(HttpStatus.OK, getbyidresponse.getStatusCode());
			}	

}
