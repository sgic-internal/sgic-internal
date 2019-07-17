package com.sgic.internal.product.privileges.controller.dto.mapper;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.internal.product.privileges.controller.dto.ProductPrivilegeDto;
import com.sgic.internal.product.privileges.controller.dto.converter.ProductPrivilegeConverter;
import com.sgic.internal.product.privileges.entities.ProductPrivilege;
import com.sgic.internal.product.privileges.services.ProductPrivilegeService;


@Service
public class ProductPrivilegeMapper {
	@Autowired
	private ProductPrivilegeConverter productPrivilegeConverter;
	@Autowired
	private ProductPrivilegeService productPrivilegeService;

	private static Logger logger = LogManager.getLogger(ProductPrivilegeDto.class);

	// Get All ProductPrivilege
	@SuppressWarnings("static-access")
	public List<ProductPrivilegeDto> getAllProductPrivilege() {
		logger.info("Product Privilege Mapper INFO -> Get All Product Privilege Method Started");
		try {
		List<ProductPrivilege> productPrivilegeList = productPrivilegeService.getAllProductPrivilege();
		return productPrivilegeConverter.EntityListTODtoList(productPrivilegeList);
		} finally {
			logger.info("Product Privilege Mapper INFO -> Get All Product Privilege Method Finished");
		}
	}

	
	// Save ProductPrivilege
	@SuppressWarnings("static-access")
	public ProductPrivilege saveProductPrivilege(ProductPrivilegeDto productPrivilegeDto) {
		logger.info("Product Privilege Mapper INFO -> Save Product Privilege Method Started");
		try {
		return productPrivilegeService.saveProductPrivilege(productPrivilegeConverter.DtoToEntity(productPrivilegeDto));
		} finally {
			logger.info("Product Privilege Mapper INFO -> Save Product Privilege Method Finished");
		}
	}

	// Update ProductPrivilege
	@SuppressWarnings("static-access")
	public ProductPrivilege updateProductPrivilege(ProductPrivilegeDto productPrivilegeDto) {
		logger.info("Product Privilege Mapper INFO -> Update Product Privilege Method Started");
		try {
		return productPrivilegeService.updateProductPrivilege(productPrivilegeConverter.DtoToEntityUpdate(productPrivilegeDto));
		} finally {
			logger.info("Product Privilege Mapper INFO -> Update Product Privilege Method Finished");
		}
	}

	// Delete ProductPrivilege
	public ProductPrivilegeDto deleteProductPrivilegeById(Long productPrivilegeId) {
		logger.info("Product Privilege Mapper INFO -> Delete Product Privilege Method Started");
		try {
		productPrivilegeService.deleteProductPrivilegeById(productPrivilegeId);
		} finally {
			logger.info("Product Privilege Mapper INFO -> Delete Product Privilege Method Finished");
		}
		return null;
	}

	// Get ProductPrivilege By Id
	@SuppressWarnings("static-access")
	public ProductPrivilegeDto getProductPrivilegeById(Long productPrivilegeId) {
		logger.info("Product Privilege Mapper INFO -> Get Product Privilege By Id Method Started");
		try {
		ProductPrivilege productPrivilege = productPrivilegeService.getProductPrivilegeById(productPrivilegeId);
		return productPrivilegeConverter.EntityToDto(productPrivilege);
	} finally {
		logger.info("Product Privilege Mapper INFO -> Get Product Privilege By Id  Method Finished");
	}
	}

	

}
