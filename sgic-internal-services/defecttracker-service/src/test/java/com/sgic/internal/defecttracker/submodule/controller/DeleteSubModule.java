package com.sgic.internal.defecttracker.submodule.controller;

import java.io.IOException;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.client.RestClientException;

import com.sgic.internal.defecttracker.project.controller.dto.SubModuleData;
import com.sgic.internal.defecttracker.submodule.SubModuleTest;

public class DeleteSubModule extends SubModuleTest {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	SubModuleData subModuleData;
	
	private String BASE_URL = "http://localhost:8080/defectservices";
	private String ADD_API_URL = "/createsubmodule";
	private String DELETE_API_URL = "/deleteById/";
	private String subModuleId ="1";

	private static final String ADD_SUBMODULE_RESPONSE ="[{\"subModuleId\":\"1\",\"subModuleName\":\"School\"}]";
	private static final String GET_SUBMODULE_RESPONSE ="[{\"subMmoduleId\":\"1\",\"subModuleName\":\"School\"}]";
	private static final String DELETE_SUBMODULE_RESPONSE = "Deleted Successfully";
	@Test
	public void deleteSubModule() throws IOException, RestClientException {

		SubModuleData moduleData =new SubModuleData ("1","School");
	HttpEntity<SubModuleData> request  = new HttpEntity<SubModuleData>(subModuleData,httpHeaders);
	ResponseEntity<String> postResponse = testRestTemplate.postForEntity(BASE_URL+ ADD_API_URL , request,String.class);
	//assertEquals(200,postResponse.getStatusCodeValue());

	ResponseEntity<String> response = testRestTemplate.exchange(BASE_URL+ DELETE_API_URL + subModuleId,HttpMethod.DELETE, new HttpEntity<>(httpHeaders), String.class);
	//assertEquals(200, response.getStatusCodeValue());
	}

}

