package com.sgic.internal.defecttracker.configure.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sgic.internal.defecttracker.configure.entity.RolePrivileges;

public interface RolePrivilegesRepository  extends JpaRepository<RolePrivileges, Long>{
	RolePrivileges findRolePrivilegesById(Long id);
	
	String FETCH_ALL_PRODUCT_PRIVILEGE_ID = "SELECT productprivilege_id FROM role_privilege";
	@Query(value = FETCH_ALL_PRODUCT_PRIVILEGE_ID, nativeQuery=true)
	<T> List<T> GetAllProductPrivilegeId();
}
