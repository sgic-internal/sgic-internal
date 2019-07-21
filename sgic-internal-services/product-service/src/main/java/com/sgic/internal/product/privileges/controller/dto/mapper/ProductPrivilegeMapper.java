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
		logger.info("ProductPrivilege Mapper -> All ProductPrivilege Data Retrieved");
		List<ProductPrivilege> productPrivilegeList = productPrivilegeService.getAllProductPrivilege();
		return productPrivilegeConverter.EntityListTODtoList(productPrivilegeList);
	}

	// Save ProductPrivilege
	@SuppressWarnings("static-access")
	public ProductPrivilege saveProductPrivilege(ProductPrivilegeDto productPrivilegeDto) {
		logger.info("ProductPrivilege Mapper -> ProductPrivilege Saved");
		return productPrivilegeService.saveProductPrivilege(productPrivilegeConverter.DtoToEntity(productPrivilegeDto));
	}

	// Update ProductPrivilege
	@SuppressWarnings("static-access")
	public ProductPrivilege updateProductPrivilege(ProductPrivilegeDto productPrivilegeDto) {
		logger.info("ProductPrivilege Mapper -> ProductPrivilege Updated ", productPrivilegeDto.getProductPrivilegeId());
		return productPrivilegeService.updateProductPrivilege(productPrivilegeConverter.DtoToEntityUpdate(productPrivilegeDto));
	}

	// Delete ProductPrivilege
	public ProductPrivilegeDto deleteProductPrivilegeById(Long productPrivilegeId) {
		logger.info("ProductPrivilege Mapper -> ProductPrivilege Deleted");
		productPrivilegeService.deleteProductPrivilegeById(productPrivilegeId);
		return null;
	}

	// Get ProductPrivilege By Id
	@SuppressWarnings("static-access")
	public ProductPrivilegeDto getProductPrivilegeById(Long productPrivilegeId) {
		logger.info("ProductPrivilege Mapper -> ProductPrivilege Id Found");
		ProductPrivilege productPrivilege = productPrivilegeService.getProductPrivilegeById(productPrivilegeId);
		return productPrivilegeConverter.EntityToDto(productPrivilege);
	}

}
