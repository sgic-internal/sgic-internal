package com.sgic.internal.product.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.internal.product.controller.dto.CompanyData;
import com.sgic.internal.product.controller.dto.mapper.CompanyMapper;

@RestController
public class CompanyController {

	@Autowired
	private CompanyMapper companyMapper;
	private static Logger logger = LogManager.getLogger(CompanyMapper.class);

	// Get All Company
	@GetMapping("/GetAllCompany")
	public List<CompanyData> getAllCompany() {
		logger.info("Controller -> Data Retrieved Successfull");
		return companyMapper.getAllCompany();
	}

	 //Get Company By Id
	@GetMapping("/GetCompanyById/{companyId}")
	public CompanyData getCompanyById(@PathVariable(name = "companyId") Long companyId) {
		logger.info("Controller -> Data Retrieved Successfull");
		return companyMapper.getCompanyById(companyId);
	}
	

	// Save All Company
	@PostMapping("/SaveCompany")
	public ResponseEntity<String> saveCompany(@Valid @RequestBody CompanyData companyData) {
		System.out.println(companyData.getLicenseStartDate());
		System.out.println(companyData.getLicenseEndDate());
		if (companyMapper.saveCompany(companyData) != null) {
			logger.info("Company Controller -> Company Created Successful");
			return new ResponseEntity<>("Company added succesfully", HttpStatus.OK);
		}
		logger.info("Company Controller -> Company creation FAILED!!!");
		return new ResponseEntity<>("SAVE FAILED!", HttpStatus.BAD_REQUEST);
	}

	// Update Company
	@PutMapping("/UpdateCompany")
	public ResponseEntity<String> updateCompany(@RequestBody CompanyData companyData) {
		logger.info("Company Controller -> Company Updated Successful");
		if (companyMapper.updateCompany(companyData) != null) {
			return new ResponseEntity<>("Sucessfully Updateed Company", HttpStatus.OK);
		}
		logger.info("Company Controller -> Company Updated Failed!!!");
		return new ResponseEntity<>("Update FAILED!!!", HttpStatus.BAD_REQUEST);
	}

	// Delete Company
	@DeleteMapping("/DeleteCompany/{companyId}")
	public ResponseEntity<String> deleteCompany(@PathVariable(name = "companyId") Long companyId) {
		System.out.print(companyId);
		if (companyMapper.getCompanyById(companyId) != null) {
			if (companyMapper.deleteCompanyById(companyId) == null) {
				logger.info("Company Controller -> Company Deleted Successful");
				return new ResponseEntity<>("Company Sucessfully deleted", HttpStatus.OK);
			}
		} else {
			logger.info("Company Controller -> Company Id Not Found");
			return new ResponseEntity<>("Company Id Not FOUND!!!", HttpStatus.BAD_REQUEST);
		}
		logger.info("Company Controller -> Company Deleted Failed!!!");
		return new ResponseEntity<>("Delete FAILED!!!", HttpStatus.BAD_REQUEST);
	}

}
