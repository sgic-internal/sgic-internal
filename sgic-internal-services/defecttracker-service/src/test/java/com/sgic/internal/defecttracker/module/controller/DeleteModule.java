package com.sgic.internal.defecttracker.module.controller;

import java.io.IOException;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.client.RestClientException;

import com.sgic.internal.defecttracker.module.ModuleTest;
import com.sgic.internal.defecttracker.project.controller.dto.ModuleData;

public class DeleteModule  extends ModuleTest{
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	ModuleData moduleData;
	
	private String BASE_URL = "http://localhost:8080/defectservices";
	private String ADD_API_URL = "/createmodule";
	private String DELETE_API_URL = "/deleteModuleById/";
	private String moduleId ="1";
	
	private static final String ADD_MODULE_RESPONSE ="[{\"moduleId\":\"1\",\"moduleName\":\"School\"}]";
	private static final String GET_MODULE_RESPONSE ="[{\"moduleId\":\"1\",\"moduleName\":\"School\"}]";
	private static final String DELETE_MODULE_RESPONSE = "Deleted Successfully";
	
	@Test
	public void deleteModule() throws IOException, RestClientException {

	ModuleData moduleData =new ModuleData ("1","School");
	HttpEntity<ModuleData> request  = new HttpEntity<ModuleData>(moduleData,httpHeaders);
	ResponseEntity<String> postResponse = testRestTemplate.postForEntity(BASE_URL+ ADD_API_URL , request,String.class);
	//assertEquals(200,postResponse.getStatusCodeValue());

	ResponseEntity<String> response = testRestTemplate.exchange(BASE_URL+ DELETE_API_URL + moduleId,HttpMethod.DELETE, new HttpEntity<>(httpHeaders), String.class);
	//assertEquals(200, response.getStatusCodeValue());
	}
}
