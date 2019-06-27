package com.sgic.internal.defecttracker.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.internal.defecttracker.project.services.ModuleService;

@RestController
public class ModuleController {

	@Autowired
	public ModuleService  moduleService;
	
}
