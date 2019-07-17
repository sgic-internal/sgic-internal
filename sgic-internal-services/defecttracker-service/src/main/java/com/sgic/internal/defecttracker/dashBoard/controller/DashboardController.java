package com.sgic.internal.defecttracker.dashBoard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sgic.internal.defecttracker.dashBoard.service.DashboardService;
import com.sgic.internal.defecttracker.defect.repositories.DefectRepository;

@CrossOrigin
@SuppressWarnings("unused")
@RestController
public class DashboardController {

	@Autowired
	private DashboardService dashboardService;
//	DefectRepository defectRepo;

	@GetMapping("/getlowcount")
	public ResponseEntity<Integer> getTotalCount() {
		return new ResponseEntity<>(dashboardService.count(), HttpStatus.OK);

	}

	@GetMapping("/getlowcountmudium")
	public ResponseEntity<Integer> getTotalCountmedium() {
		return new ResponseEntity<>(dashboardService.countmudium(), HttpStatus.OK);

	}
	
	@GetMapping("/getlowcounthigh")
	public ResponseEntity<Integer> getTotalCounthigh() {
		return new ResponseEntity<>(dashboardService.countHigh(),HttpStatus.OK);

	}
}
