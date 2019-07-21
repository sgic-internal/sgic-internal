package com.sgic.internal.product.privileges.services.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.internal.product.privileges.entities.ProductPrivilege;
import com.sgic.internal.product.privileges.repository.ProductPrivilegeRepo;
import com.sgic.internal.product.privileges.services.ProductPrivilegeService;

@Service
public class ProductPrivilegeServiceImpl implements ProductPrivilegeService{
	
	@Autowired
	ProductPrivilegeRepo productPrivilegeRepo;
	
	private static Logger logger = LogManager.getLogger(ProductPrivilege.class);

	@Override
	public ProductPrivilege getProductPrivilegeById(Long productPrivilegeId) {
		logger.info("Product Privilege Service ->  Get Product Privilege By Id Method Started");
		try {
		return productPrivilegeRepo.findProductPrivilegeById(productPrivilegeId);
	}

	@Override
	public ProductPrivilege saveProductPrivilege(ProductPrivilege productPrivilege) {
		logger.info("service started -> Save ProductPrivilege");
		return productPrivilegeRepo.save(productPrivilege);
	}

	@Override
	public List<ProductPrivilege> getAllProductPrivilege() {
		logger.info("service started -> Get All ProductPrivilege");
		return productPrivilegeRepo.findAll();
	}

	@Override
	public ProductPrivilege deleteProductPrivilegeById(Long productPrivilegeId) {
		logger.info("service started -> Delete ProductPrivilege");
		 productPrivilegeRepo.deleteById(productPrivilegeId);
		 return null;
	}

	@Override
	public ProductPrivilege updateProductPrivilege(ProductPrivilege productPrivilege) {
		logger.info("service started -> Update ProductPrivilege");
		Long id = productPrivilege.getId();
		logger.info("service started -> getProductPrivilegeId");
		boolean isExist = productPrivilegeRepo.findProductPrivilegeById(id) != null;
		if (isExist) {
			logger.info("service started -> Updated By ProductPrivilegeId");
			return productPrivilegeRepo.save(productPrivilege);
		} else {
			logger.info("service started -> ProductPrivilegeId Not Found");
		}
		return null;
	}

}
