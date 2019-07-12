package com.sgic.internal.product.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.internal.product.controller.dto.mapper.CompanyMapper;
import com.sgic.internal.product.entities.CompanyLicenseType;
import com.sgic.internal.product.services.CompanyLicenseTypeService;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
public class CompanyLicenseTypeController {
	@Autowired
	private CompanyLicenseTypeService companyLicenseTypeService;
	private static Logger logger = LogManager.getLogger(CompanyMapper.class);
	
	// Save All Company
		@PostMapping("/License")
		public ResponseEntity<String> saveCompany() {
			if (companyLicenseTypeService.saveCompanyLicenseType() != null) {
				logger.info("CompanyLicenseType Controller -> CompanyLicenseType Created Successful");
				return new ResponseEntity<>("CompanyLicenseType added succesfully", HttpStatus.OK);
			}
			logger.info("CompanyLicenseType Controller -> CompanyLicenseType creation FAILED!!!");
			return new ResponseEntity<>("SAVE FAILED!", HttpStatus.BAD_REQUEST);
		}
	
		// Get All Company
		@CrossOrigin
		@GetMapping("/Licenses")
		public List<CompanyLicenseType> getAllCompanyLicenseType() {
			logger.info("Controller -> Data Retrieved Successfull");
			return companyLicenseTypeService.getAllCompanyLicenseType();
		}

}
