package com.sgic.internal.defecttracker.dashBoard.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.internal.defecttracker.dashBoard.service.DashboardService;

@RestController
public class DashboardController {
	
	private DashboardService dashboardService;


	@GetMapping("/getlowcount")
	public ResponseEntity<Long> getTotalCount() {
		return new ResponseEntity<>(dashboardService.count(), HttpStatus.OK);

  }
}
