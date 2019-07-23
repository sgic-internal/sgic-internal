package com.sgic.internal.product.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sgic.internal.product.entities.ProductPrivilege;

public interface ProductPrivilegeRepo  extends JpaRepository<ProductPrivilege, Long> {
	ProductPrivilege findProductPrivilegeById(Long productPrivilegeId);
}
