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
		} catch (Exception ex) {
			logger.error("Product Privilege Service ERROR! -> " + ex.getMessage());
		} finally {
			logger.info("Product Privilege Service -> Get Product Privilege By Id Method Finished");
		}
		return null;
	}

	@Override
	public ProductPrivilege saveProductPrivilege(ProductPrivilege productPrivilege) {
		logger.info("Product Privilege Service ->  Save Product Privilege Method Started");
		try {
		return productPrivilegeRepo.save(productPrivilege);
		} catch (Exception ex) {
			logger.error("Product Privilege Service ERROR! -> " + ex.getMessage());
		} finally {
			logger.info("Product Privilege Service -> Save Product Privilege Method Finished");
		}
		return null;
	}

	@Override
	public List<ProductPrivilege> getAllProductPrivilege() {
		logger.info("Product Privilege Service ->  Get All Product Privilege Method Started");
		try {
		return productPrivilegeRepo.findAll();
		} catch (Exception ex) {
			logger.error("Product Privilege Service ERROR! -> " + ex.getMessage());
		} finally {
			logger.info("Product Privilege Service -> Get All  Product Privilege Method Finished");
		}
		return null;
	}

	@Override
	public ProductPrivilege deleteProductPrivilegeById(Long productPrivilegeId) {
		logger.info("Product Privilege Service ->  Delete Product Privilege Method Started");
		try {
		 productPrivilegeRepo.deleteById(productPrivilegeId);
		} catch (Exception ex) {
			logger.error("Product Privilege Service ERROR! -> " + ex.getMessage());
		} finally {
			logger.info("Product Privilege Service -> Delete Product Privilege Method Finished");
		}
		return null;
	}

	@Override
	public ProductPrivilege updateProductPrivilege(ProductPrivilege productPrivilege) {
		logger.info("Product Privilege Service ->  Update Product Privilege Method Started");
		Long id = productPrivilege.getId();
		try {
		boolean isExist = productPrivilegeRepo.findProductPrivilegeById(id) != null;
		if (isExist) {
			logger.info("Product Privilege Service  -> Product Privilege Id Found & Updated");
			return productPrivilegeRepo.save(productPrivilege);
		} else {
			logger.info("Product Privilege Service  -> Product Privilege Id Not Found & Update Failed!");
		}
		} catch (Exception ex) {
			logger.error("Product Privilege Service ERROR! -> " + ex.getMessage());
		} finally {
			logger.info("Product Privilege Service -> Update Product Privilege Method Finished");
		}
		return null;
	}


}
