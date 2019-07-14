package com.sgic.internal.product.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.internal.product.controller.dto.CompanyData;
import com.sgic.internal.product.controller.dto.mapper.CompanyMapper;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
public class CompanyController {

	@Autowired
	private CompanyMapper companyMapper;
	private static Logger logger = LogManager.getLogger(CompanyMapper.class);

	// Get All Company
	@GetMapping("/Companys")
	public List<CompanyData> getAllCompany() {
		logger.info("Company Controller INFO -> Get All Company Method Started");
		try {
		return companyMapper.getAllCompany();
		} finally {
			logger.info("Company Controller INFO -> Get All Company Method Finished");
		}
	}

	 //Get Company By Id
	@GetMapping("/Company/{companyId}")
	public Object getCompanyById(@PathVariable(name = "companyId") Long companyId) {
		logger.info("Company Controller INFO -> Get Company By Id Method Started");
		try {
			// Check the Company Id
			if(companyMapper.getCompanyById(companyId)!=null) {
				logger.info("Company Controller INFO -> Company Id Found, Company Id : "+companyId);
		return companyMapper.getCompanyById(companyId);
			}
			else {
				logger.warn("Company Controller WARNING! -> Company Id Not Found, Company Id : "+companyId);
				return "Company Id : "+ companyId+" Not Found ";
			}
		} finally {
			logger.info("Company Controller INFO -> Get Company By Id Method Finished");
		}
	}
	

	// Save All Company
	@PostMapping("/Company")
	public ResponseEntity<String> saveCompany(@Valid @RequestBody CompanyData companyData) {
		logger.info("Company Controller INFO -> Save Company Method Started");
		try {
		if (companyMapper.saveCompany(companyData) != null) {
			logger.info("Company Controller INFO -> Company Saved Successfully");
			return new ResponseEntity<>("Company added succesfully", HttpStatus.OK);
		}
		logger.warn("Company Controller WARNING! -> Company Saved FAILED!");
		return new ResponseEntity<>("Company Saved FAILED!", HttpStatus.BAD_REQUEST);
		} finally {
			logger.info("Company Controller INFO -> Save Company Method Finished");
		}
	}

	// Update Company
	@PutMapping("/Company")
	public ResponseEntity<String> updateCompany(@RequestBody CompanyData companyData) {
		logger.info("Company Controller INFO -> Update Company Method Started");
		try {
		if (companyMapper.updateCompany(companyData) != null) {
			return new ResponseEntity<>("Company Updated Sucessfully", HttpStatus.OK);
		}
		logger.warn("Company Controller WARNING! -> Company Updated Failed!!!");
		return new ResponseEntity<>("Update FAILED!!!", HttpStatus.BAD_REQUEST);
		} finally {
			logger.info("Company Controller INFO -> Update Company Method Finished");
		}
	}

	// Delete Company
	@DeleteMapping("/Company/{companyId}")
	public ResponseEntity<String> deleteCompany(@PathVariable(name = "companyId") Long companyId) {
		logger.info("Company Controller INFO -> Delete Company Method Started");
		try {
			//check the company id for delete
		if (companyMapper.getCompanyById(companyId) != null) {
			if (companyMapper.deleteCompanyById(companyId) == null) {
				logger.info("Company Controller -> Company Successfully Deleted , Company Id Found -> Company ID : "+companyId);
				return new ResponseEntity<>("Company Sucessfully deleted", HttpStatus.OK);
			}
		} else {
			logger.warn("Company Controller WARNING! -> Company Deleted Failed, Company Id Not Found -> Company ID : "+companyId);
			return new ResponseEntity<>("Company Deleted Failed, Company Id : "+ companyId+" NOT FOUND!", HttpStatus.BAD_REQUEST);
		}
		} finally {
			logger.info("Company Controller INFO -> Delete Company Method Finished");
		}
		return null;

	}

}
