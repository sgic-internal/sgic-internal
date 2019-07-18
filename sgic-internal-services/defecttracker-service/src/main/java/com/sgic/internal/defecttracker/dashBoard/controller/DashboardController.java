package com.sgic.internal.defecttracker.dashBoard.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sgic.internal.defecttracker.dashBoard.service.DashboardService;
import com.sgic.internal.defecttracker.defect.repositories.DefectRepository;

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
	int High;
	private int rejectlow;
	private int rejectHigh;

	@GetMapping("/getlowcount")
	public ResponseEntity<Float> getTotalCount() {

		return new ResponseEntity<>(dashboardService.CalculateLow(count, reject, low, rejectlow), HttpStatus.OK);
//				countByStatusRejectedlow(),HttpStatus.OK);

	}

	@GetMapping("/gethightcount")
	public ResponseEntity<Float> getTotalCounthighseverity() {
		return new ResponseEntity<>(dashboardService.Calculatseverityhigh(count,reject, High, rejectHigh),HttpStatus.OK);

		
		
	}

	@GetMapping("/getcountmudium")
	public ResponseEntity<Integer> getTotalCountmedium() {
		return new ResponseEntity<>(dashboardService.countmudium(), HttpStatus.OK);

	}

	@GetMapping("/getcounthigh")
	public ResponseEntity<Integer> getTotalCounthigh() {
		return new ResponseEntity<>(dashboardService.countHigh(), HttpStatus.OK);

	}

	@GetMapping("/getallcount")
	public ResponseEntity<Long> getTotalCountAll() {
		return new ResponseEntity<>(defectRepo.count(), HttpStatus.OK);

	}

	@GetMapping("/getrejectedcount")
	public ResponseEntity<Integer> getRejectedCountAll() {
		return new ResponseEntity<>(dashboardService.countReject(), HttpStatus.OK);

	}
}
