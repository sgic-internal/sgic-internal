package com.sgic.internal.defecttracker.defect.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.internal.defecttracker.defect.repositories.DefectRepository;
import com.sgic.internal.defecttracker.defect.services.DashboardService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@SuppressWarnings("unused")
@RestController
public class DashboardController {

  @Autowired
  private DashboardService dashboardService;

  @Autowired
  private DefectRepository defectRepo;

  private static Logger logger = LogManager.getLogger(DashboardService.class);
  private long count;
  private int reject;
  private int low;
  private int High;
  private int rejectlow;
  private int rejectHigh;
  private int medium;
  private int rejectmedium;

  @GetMapping("/getlowcount")
  public ResponseEntity<Float> getTotalCount() {
    return new ResponseEntity<>(dashboardService.CalculateLow(count, reject, low, rejectlow),
        HttpStatus.OK);

  }

  @GetMapping("/gethightcount")
  public ResponseEntity<Float> getTotalCounthighseverity() {
    return new ResponseEntity<>(
        dashboardService.Calculatseverityhigh(count, reject, High, rejectHigh), HttpStatus.OK);

  }

  @GetMapping("/getcountmedium")
  public ResponseEntity<Float> getTotalCountmedium() {
    return new ResponseEntity<>(
        dashboardService.CalculateMedium(count, rejectlow, medium, rejectmedium), HttpStatus.OK);

  }

  @GetMapping("/getseverityindex")
  public ResponseEntity<Double> getSeverityIndex() {
    return new ResponseEntity<>(dashboardService.calculateSeverityIndex(), HttpStatus.OK);

  }

  // <--Total Severity Low Defect Count Controller-->
  @GetMapping("/getseveritylowcount")
  public ResponseEntity<Integer> countseveritytotalLow() {
    try {
      logger.info("Dashboard Controller--> successfully get Total Severity Low ");
      return new ResponseEntity<>(dashboardService.countseveritytotalLow(), HttpStatus.OK);
      // defectRepo.countBySeverity(),HttpStatus.OK);
    } catch (Exception e) {
      logger.error("Dashboard Controller--> Error" + e.getMessage());
    }
    return null;

  }

  // <--Total Severity Medium Defect Count Controller-->
  @GetMapping("/getseveritymediumcount")
  public ResponseEntity<Integer> countseveritytotalmedium() {
    try {
      logger.info("Dashboard Controller--> successfully get Total Severity Low ");
      return new ResponseEntity<>(dashboardService.countseveritytotalmedium(), HttpStatus.OK);
      // defectRepo.countBySeverityMedium(), HttpStatus.OK);
      // defectRepo.countBySeverity(),HttpStatus.OK);
    } catch (Exception e) {
      logger.error("Dashboard Controller--> Error" + e.getMessage());
    }
    return null;

  }

  // <--Total Severity High Defect Count Controller-->
  @GetMapping("/getseverityhigcount")
  public ResponseEntity<Integer> countseveritytotalhigh() {
    try {
      logger.info("Dashboard Controller--> successfull ");
      return new ResponseEntity<>(dashboardService.countseveritytotalhig(), HttpStatus.OK);
      // defectRepo.countBySeverityMedium(), HttpStatus.OK);
      // defectRepo.countBySeverity(),HttpStatus.OK);
    } catch (Exception e) {
      logger.error("Dashboard Controller--> Error" + e.getMessage());
    }
    return null;

  }

  // <--Total Severity High Defect Count Controller-->
  @GetMapping("/gettoatalcount")
  public ResponseEntity<Long> Totaldefectcount() {
    try {
      logger.info("Dashboard Controller--> successfull ");
      return new ResponseEntity<>(dashboardService.counttotaldefect(), HttpStatus.OK);
    } catch (Exception e) {
      logger.error("Dashboard Controller--> Error" + e.getMessage());
    }
    return null;

  }

}
