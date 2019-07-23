package com.sgic.internal.product.services;

import java.util.List;
import com.sgic.internal.product.entities.ProductPrivilege;


public interface ProductPrivilegeService {
	// Get ProductPrivilege By Id
	public ProductPrivilege getProductPrivilegeById(Long productPrivilegeId);

	// Save ProductPrivilege
	public ProductPrivilege saveProductPrivilege(ProductPrivilege productPrivilege);

	// List all ProductPrivilege
	public List<ProductPrivilege> getAllProductPrivilege();

	// Delete ProductPrivilege
	public ProductPrivilege deleteProductPrivilegeById(Long productPrivilegeId);

	// Update ProductPrivilege
	public ProductPrivilege updateProductPrivilege(ProductPrivilege productPrivilege);
}
