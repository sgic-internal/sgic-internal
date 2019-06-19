package com.sgic.internal.user;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.options;

import org.junit.Rule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.tomakehurst.wiremock.junit.WireMockRule;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles("test")
@SpringBootConfiguration
public class HrmEmployeeApplicationTests {

 @Rule	
  public WireMockRule wireMockRule = new WireMockRule(options().port(7081).httpsPort(7082));

//	protected WireMockServer wireMockServer;
	 
  @Autowired
  protected TestRestTemplate testRestTemplate;
  protected HttpHeaders httpHeaders = new HttpHeaders();
//
//  @Value("http://localhost:7080/hrm_system")
//  protected String HRM_SYSTEM_BASE_URL;
}
	

