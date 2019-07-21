package com.sgic.internal.product.privileges.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgic.internal.product.privileges.entities.ProductPrivilege;

public interface ProductPrivilegeRepo  extends JpaRepository<ProductPrivilege, Long> {
	ProductPrivilege findProductPrivilegeById(Long productPrivilegeId);
}
