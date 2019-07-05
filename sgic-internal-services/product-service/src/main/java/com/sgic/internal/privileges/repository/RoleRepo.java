package com.sgic.internal.privileges.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgic.internal.privileges.entities.Role;

public interface RoleRepo extends JpaRepository<Role, Long> {

	Role findRoleById(Long roleId);

}
