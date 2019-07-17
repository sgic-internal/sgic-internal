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

	@GetMapping("/getlowcount")
	public ResponseEntity<Integer> getTotalCount() {
		try {
			return new ResponseEntity<>(dashboardService.count(), HttpStatus.OK);
		} catch (Exception e) {
			logger.error(" Dashboard Controller :-->their was an error" + e.getMessage());
		}
		return null;

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
}
