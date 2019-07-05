package com.sgic.internal.privileges.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgic.internal.privileges.entities.Privilege;

public interface PrivilegeRepo extends JpaRepository<Privilege, Long> {

	Privilege findPrivilegeById(Long privilageId);

}
