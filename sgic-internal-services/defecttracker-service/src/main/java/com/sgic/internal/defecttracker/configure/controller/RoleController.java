package com.sgic.internal.defecttracker.configure.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.internal.defecttracker.configure.entity.Role;
import com.sgic.internal.defecttracker.configure.services.RoleService;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
public class RoleController {
	@Autowired
	private RoleService roleService;
	
	// Save Role
	@PostMapping("/Role")
	public ResponseEntity<String> saveCompany() {
		if (roleService.saveRole() != null) {
			return new ResponseEntity<>("Roles added succesfully", HttpStatus.OK);
		}
		return new ResponseEntity<>("SAVE FAILED!", HttpStatus.BAD_REQUEST);
	}

	// Get All Role
	@GetMapping("/Roles")
	public List<Role> getAllCompanyLicenseType() {
		return roleService.getAllRole();
	}
	
}
