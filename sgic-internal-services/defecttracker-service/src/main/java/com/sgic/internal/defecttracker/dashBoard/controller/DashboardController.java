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

	@GetMapping("/getlowcount")
	public ResponseEntity<Integer> getTotalCount() {
		try {
			return new ResponseEntity<>(dashboardService.countLow(), HttpStatus.OK);
		} catch (Exception e) {
			logger.error(" Dashboard Controller :-->their was an error" + e.getMessage());
		}
		return null;

	}

	@GetMapping("/getcountmedium")
	public ResponseEntity<Integer> getTotalCountmedium() {
		return new ResponseEntity<>(dashboardService.countMedium(), HttpStatus.OK);

	}

	@GetMapping("/getcounthigh")
	public ResponseEntity<Integer> getTotalCounthigh() {
		return new ResponseEntity<>(dashboardService.countHigh(), HttpStatus.OK);

	}

	@GetMapping("/getallcount")
	public ResponseEntity<Long> getTotalCountAll() {
		return new ResponseEntity<>(dashboardService.TotalCount(), HttpStatus.OK);

	}
	
	@GetMapping("/gethighweight")
	public ResponseEntity<Integer> getHighWeight() {
		return new ResponseEntity<>(dashboardService.fetchHighWeight(), HttpStatus.OK);

	}
	
	@GetMapping("/getmediumweight")
	public ResponseEntity<Integer> getMediumWeight() {
		return new ResponseEntity<>(dashboardService.fetchMediumWeight(), HttpStatus.OK);

	}
	
	@GetMapping("/getlowweight")
	public ResponseEntity<Integer> getLowWeight() {
		return new ResponseEntity<>(dashboardService.fetchLowWeight(), HttpStatus.OK);

	}
	
	@GetMapping("/getseverityindex")
	public ResponseEntity<Double> getSeverityIndex() {
		return new ResponseEntity<>(dashboardService.calculateSeverityIndex(), HttpStatus.OK);

	}
}
