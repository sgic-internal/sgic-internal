package com.sgic.internal.product.privileges.controller;

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

import com.sgic.internal.product.privileges.controller.dto.ProductPrivilegeDto;
import com.sgic.internal.product.privileges.controller.dto.mapper.ProductPrivilegeMapper;
import com.sgic.internal.product.privileges.services.ProductPrivilegeService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ProductPrivilegeController {
	@Autowired
	ProductPrivilegeService repo;
	@Autowired
	private ProductPrivilegeMapper productPrivilegeMapper;
	private static Logger logger = LogManager.getLogger(ProductPrivilegeMapper.class);

	// Get All ProductPrivilege
	@GetMapping("/ProductPrivileges")
	public List<ProductPrivilegeDto> getAllProductPrivilege() {
		logger.info("Product Privilege Controller INFO -> Get All Product Privilege Method Started");
		try {
			return productPrivilegeMapper.getAllProductPrivilege();
		} finally {
			logger.info("Product Privilege Controller INFO -> Get All Product Privilege Method Finished");
		}
	}

	// Get ProductPrivilege By Id
	@GetMapping("/ProductPrivilege/{productPrivilegeId}")
	public Object getProductPrivilegeById(@PathVariable(name = "productPrivilegeId") Long productPrivilegeId) {
		logger.info("Product Privilege Controller INFO -> Get Product Privilege By Id Method Started");
		try {
			if (productPrivilegeMapper.getProductPrivilegeById(productPrivilegeId) != null) {
				logger.info("Product Privilege Controller INFO -> Product Privilege Id Found -> Product Privilege Id : "
						+ productPrivilegeId);
				return productPrivilegeMapper.getProductPrivilegeById(productPrivilegeId);
			} else {
				logger.warn(
						"Product Privilege Controller WARNING! -> Product Privilege Id Not Found! -> Product Privilege Id : "
								+ productPrivilegeId);
				return "Product Privilege Id : "+productPrivilegeId+" Not Found ";
			}
		} finally {
			logger.info("Product Privilege Controller INFO -> Get Product Privilege By Id Method Finished");
		}
	}

	// Save ProductPrivilege
	@PostMapping("/ProductPrivilege")
	public ResponseEntity<String> saveProductPrivilege(@Valid @RequestBody ProductPrivilegeDto productPrivilegeDto) {
		logger.info("Product Privilege Controller INFO -Save Product Privilege Method Started");
		try {
			if (productPrivilegeMapper.saveProductPrivilege(productPrivilegeDto) != null) {
				logger.info("Product Privilege Controller -> ProductPrivilege Created Successful");
				return new ResponseEntity<>("ProductPrivilege added succesfully", HttpStatus.OK);
			}
			logger.warn("Product Privilege Controller -> Product Privilege creation FAILED!!!");
			return new ResponseEntity<>("SAVE FAILED!", HttpStatus.BAD_REQUEST);
		} finally {
			logger.info("Product Privilege Controller INFO -> Save Product Privilege Method Finished");
		}
	}

	// Update ProductPrivilege
	@PutMapping("/ProductPrivilege")
	public ResponseEntity<String> updateProductPrivilege(@RequestBody ProductPrivilegeDto productPrivilegeDto) {
		logger.info("Product Privilege Controller INFO -> Update Product Privilege Method Started");
		try {
			if (productPrivilegeMapper.updateProductPrivilege(productPrivilegeDto) != null) {
				return new ResponseEntity<>("Sucessfully Updated ProductPrivilege", HttpStatus.OK);
			}
			logger.warn("Product Privilege Controller WARNINIG! -> Product Privilege Updated Failed!");
			return new ResponseEntity<>("Update FAILED!!!", HttpStatus.BAD_REQUEST);
		} finally {
			logger.info("Product Privilege Controller INFO -> Update Product Privilege Method Finished");
		}
	}

	// Delete ProductPrivilege
	@DeleteMapping("/ProductPrivilege/{productPrivilegeId}")
	public ResponseEntity<String> deleteProductPrivilege(
			@PathVariable(name = "productPrivilegeId") Long productPrivilegeId) {
		System.out.print(productPrivilegeId);
		logger.info("Product Privilege Controller INFO -> Delete Product Privilege Method Started");
		try {
			if (productPrivilegeMapper.getProductPrivilegeById(productPrivilegeId) != null) {
				if (productPrivilegeMapper.deleteProductPrivilegeById(productPrivilegeId) == null) {
					logger.info(
							"Product Privilege Controller INFO -> Product Privilege Id Found -> Product Privilege Id : "
									+ productPrivilegeId);
					return new ResponseEntity<>("ProductPrivilege Sucessfully deleted", HttpStatus.OK);
				}
			} else {
				logger.warn(
						"Product Privilege Controller WARNING! -> Product Privilege Id Not Found -> Product Privilege Id : "
								+ productPrivilegeId);
				return new ResponseEntity<>("Delete Failed! -> ProductPrivilege Id : "+productPrivilegeId+" Not Found!",
						HttpStatus.BAD_REQUEST);
			}
		} finally {
			logger.info("Product Privilege Controller INFO -> Delete Product Privilege Method Finished");
		}
		return null;
	}

}
