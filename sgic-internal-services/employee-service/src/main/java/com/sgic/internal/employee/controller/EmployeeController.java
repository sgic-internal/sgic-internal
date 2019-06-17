package com.sgic.internal.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.common.api.enums.RestApiResponseStatus;
import com.sgic.common.api.response.ApiResponse;
import com.sgic.internal.employee.controller.dto.EmployeeData;
import com.sgic.internal.employee.entities.Employee;
import com.sgic.internal.employee.services.EmployeeService;

@RestController
public class EmployeeController 
{
	
	@Autowired
	private EmployeeService employeeService;
	
	  @PostMapping(value = "/employee")
	  public ResponseEntity<Object> createGrampa(@RequestBody EmployeeData employeeData) {
	    Employee employee =new Employee();
	    employee.setEmail(employeeData.getEmail());
	    employee.setFirstName(employeeData.getFirstName());
	    employee.setLastName(employeeData.getLastName());
	    employeeService.createEmployee(employee);
	    
	    return new ResponseEntity<>(new ApiResponse(RestApiResponseStatus.OK), HttpStatus.OK);
	   
	  }
}
