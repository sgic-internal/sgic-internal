package com.sgic.internal.defecttracker.dashBoard.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

	@Autowired
	DefectRepository defectRepo;

	private static Logger logger = LogManager.getLogger(DashboardService.class);
	private long count;
	private int reject;
	private int low;
	private int rejectlow;
	private int medium;
	private int rejectmedium;

	@GetMapping("/getlowcount")
	public ResponseEntity<Float> getTotalCount() {

		return new ResponseEntity<>(dashboardService.CalculateLow(count, reject, low, rejectlow), HttpStatus.OK);

	}

	@GetMapping("/getcountmedium")
	public ResponseEntity<Float> getTotalCountmedium() {
		return new ResponseEntity<>(dashboardService.CalculateMedium(count, rejectlow, medium, rejectmedium),HttpStatus.OK);

	}

//	@GetMapping("/getcounthigh")
//	public ResponseEntity<Integer> getTotalCounthigh() {
//		return new ResponseEntity<>(dashboardService.countHigh(), HttpStatus.OK);
//
//	}
//
//	@GetMapping("/getallcount")
//	public ResponseEntity<Long> getTotalCountAll() {
//		return new ResponseEntity<>(defectRepo.count(), HttpStatus.OK);
//
//	}
//
//	@GetMapping("/getrejectedcount")
//	public ResponseEntity<Integer> getRejectedCountAll() {
//		return new ResponseEntity<>(dashboardService.countReject(), HttpStatus.OK);
//
//	}
	

	@GetMapping("/getseverityindex")
	public ResponseEntity<Double> getSeverityIndex() {
		return new ResponseEntity<>(dashboardService.calculateSeverityIndex(), HttpStatus.OK);

	}

}
