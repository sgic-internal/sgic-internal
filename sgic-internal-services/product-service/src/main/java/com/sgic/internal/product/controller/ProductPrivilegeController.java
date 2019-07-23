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
import com.sgic.internal.product.controller.dto.ProductPrivilegeDto;
import com.sgic.internal.product.controller.dto.mapper.ProductPrivilegeMapper;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
public class ProductPrivilegeController {
	@Autowired
	private ProductPrivilegeMapper productPrivilegeMapper;
	private static Logger logger = LogManager.getLogger(ProductPrivilegeMapper.class);

	// Get All ProductPrivilege
	@GetMapping("/ProductPrivileges")
	public List<ProductPrivilegeDto> getAllProductPrivilege() {
		logger.info("Controller -> Data Retrieved Successfull");
		return productPrivilegeMapper.getAllProductPrivilege();
	}

	 //Get ProductPrivilege By Id
	@GetMapping("/ProductPrivilege/{productPrivilegeId}")
	public ProductPrivilegeDto getProductPrivilegeById(@PathVariable(name = "productPrivilegeId") Long productPrivilegeId) {
		logger.info("Controller -> Data Retrieved Successfull");
		return productPrivilegeMapper.getProductPrivilegeById(productPrivilegeId);
	}
	

	// Save ProductPrivilege
	@PostMapping("/ProductPrivilege")
	public ResponseEntity<String> saveProductPrivilege(@Valid @RequestBody ProductPrivilegeDto productPrivilegeDto) {
		if (productPrivilegeMapper.saveProductPrivilege(productPrivilegeDto) != null) {
			logger.info("ProductPrivilege Controller -> ProductPrivilege Created Successful");
			return new ResponseEntity<>("ProductPrivilege added succesfully", HttpStatus.OK);
		}
		logger.info("ProductPrivilege Controller -> ProductPrivilege creation FAILED!!!");
		return new ResponseEntity<>("SAVE FAILED!", HttpStatus.BAD_REQUEST);
	}

	// Update ProductPrivilege
	@PutMapping("/ProductPrivilege")
	public ResponseEntity<String> updateProductPrivilege(@RequestBody ProductPrivilegeDto productPrivilegeDto) {
		logger.info("ProductPrivilege Controller -> ProductPrivilege Updated Successful");
		if (productPrivilegeMapper.updateProductPrivilege(productPrivilegeDto) != null) {
			return new ResponseEntity<>("Sucessfully Updated ProductPrivilege", HttpStatus.OK);
		}
		logger.info("ProductPrivilege Controller -> ProductPrivilege Updated Failed!!!");
		return new ResponseEntity<>("Update FAILED!!!", HttpStatus.BAD_REQUEST);
	}

	// Delete ProductPrivilege
	@DeleteMapping("/ProductPrivilege/{productPrivilegeId}")
	public ResponseEntity<String> deleteProductPrivilege(@PathVariable(name = "productPrivilegeId") Long productPrivilegeId) {
		System.out.print(productPrivilegeId);
		if (productPrivilegeMapper.getProductPrivilegeById(productPrivilegeId) != null) {
			if (productPrivilegeMapper.deleteProductPrivilegeById(productPrivilegeId) == null) {
				logger.info("ProductPrivilege Controller -> ProductPrivilege Deleted Successful");
				return new ResponseEntity<>("ProductPrivilege Sucessfully deleted", HttpStatus.OK);
			}
		} else {
			logger.info("ProductPrivilege Controller -> ProductPrivilege Id Not Found");
			return new ResponseEntity<>("ProductPrivilege Id Not FOUND!!!", HttpStatus.BAD_REQUEST);
		}
		logger.info("ProductPrivilege Controller -> ProductPrivilege Deleted Failed!!!");
		return new ResponseEntity<>("Delete FAILED!!!", HttpStatus.BAD_REQUEST);
	}

}
