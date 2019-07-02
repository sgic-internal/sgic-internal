package com.sgic.internal.defecttracker.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.sgic.internal.defecttracker.project.controller.dto.ResourceAllocationDto;
import com.sgic.internal.defecttracker.project.controller.dtomapper.ResourceAllocationDtoMapper;
import com.sgic.internal.defecttracker.project.entities.ResourceAllocation;
//import com.sgic.internal.employee.dto.EmployeeDTO;

@RestController
public class ResourceAllocationController {

	@Autowired
	private ResourceAllocationDtoMapper resourceAllocationDtoMapper;

	@PostMapping(value="/saveresource")
	public ResourceAllocation createResource(@RequestBody ResourceAllocationDto resourceAllocationDto) {
		return resourceAllocationDtoMapper.saveResource(resourceAllocationDto);

	}
	
	@GetMapping(value = "/getallresource") // List Employee
	public ResponseEntity<List<ResourceAllocationDto>> sortListEmployeeInfo(){
		System.out.println("list");
		resourceAllocationDtoMapper.getAllResource();
		return new ResponseEntity<List<ResourceAllocationDto>>(resourceAllocationDtoMapper.getAllResource(), HttpStatus.OK);	
	}
	
}
