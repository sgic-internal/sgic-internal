package com.sgic.internal.defecttracker.submodule.controller;

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

import com.sgic.internal.defecttracker.project.controller.dto.ModuleData;
import com.sgic.internal.defecttracker.project.controller.dto.SubModuleData;
import com.sgic.internal.defecttracker.submodule.SubModuleTest;

public class GetBySubModuleId extends SubModuleTest{
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	SubModuleData subModuleData;
	
	private String subModuleId="1";
	
	private static final String GET_BY_ID_RESPONSE ="{\"suModuleId\":\"1\",\"subModuleName\":\"School\"}";

	@Test
	public void GetByModuleId() throws IOException, RestClientException {
		SubModuleData subModuleData = new SubModuleData("1","School");
		HttpHeaders httpHeaders = new HttpHeaders();
		HttpEntity<SubModuleData> request = new HttpEntity<SubModuleData>(subModuleData, httpHeaders);
		ResponseEntity<String> postresponse =testRestTemplate.postForEntity("http://localhost:8080/defectservices/" + "/createsubmodule", request, String.class);

		ResponseEntity<String> getbyidresponse = testRestTemplate.exchange("http://localhost:8080/defectservices" + "/getSubModuleById" + "/1" , HttpMethod.GET,
		new HttpEntity<>(httpHeaders), String.class);
		assertEquals(200, postresponse.getStatusCodeValue());
		assertEquals(GET_BY_ID_RESPONSE,getbyidresponse.getBody());
		assertEquals(HttpStatus.OK, getbyidresponse.getStatusCode());
		}	

}
