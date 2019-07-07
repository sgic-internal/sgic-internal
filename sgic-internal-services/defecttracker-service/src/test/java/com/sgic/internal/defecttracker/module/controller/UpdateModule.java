package com.sgic.internal.defecttracker.module.controller;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.client.RestClientException;

import com.sgic.internal.defecttracker.module.ModuleTest;
import com.sgic.internal.defecttracker.project.controller.dto.ModuleData;

public class UpdateModule  extends ModuleTest {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Before
	public void setup() {
		String newSql1 = "INSERT INTO defectservices.module (`module_id`,`module_name`, ) VALUES ('1', 'nn', )";

		jdbcTemplate.execute(newSql1);
	}

		
		private String BASE_URL = "http://localhost:8081/defectservices";
	
		private static final String UPDATE_MODULE_RESPONSE = "{\"moduleId\":\"1\",\"moduleName\":\"School\"}";
		private static final String CHECK_UPDATE_MODULE_RESPONSE ="{\"moduleId\":\"1\",\"moduleName\":\"mmmm\"}";

		ModuleData moduleData= new ModuleData();
		
		@Test
		public void UpdateBymodule() throws IOException, RestClientException {
			String moduleId = "1";
			ResponseEntity<String> getResponse = testRestTemplate.exchange(BASE_URL + "/GetmoduleById/" + moduleId, HttpMethod.GET,
					new HttpEntity<>(httpHeaders), String.class);
//			assertEquals(UPDATE_MODULE_RESPONSE, getResponse.getBody());
		moduleData.setModuleId("1");
		moduleData.setModuleName("School");
		
		HttpEntity<ModuleData> request = new HttpEntity<ModuleData>(moduleData, httpHeaders);
		testRestTemplate.exchange(BASE_URL + "/updateProject/" + moduleId, HttpMethod.PUT,
				request, String.class);
		
		ResponseEntity<String> getUpdatedResponse = testRestTemplate.exchange(BASE_URL + "/GetmoduleById/" + moduleId, HttpMethod.GET,
				new HttpEntity<>(httpHeaders), String.class);
//		assertEquals(CHECK_UPDATE_MODULE_RESPONSE, getUpdatedResponse.getBody());
	}
		@After 
		public void tearDown() {
			
		}
}
