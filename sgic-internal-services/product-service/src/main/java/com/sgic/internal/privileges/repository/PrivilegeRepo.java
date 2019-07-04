package com.sgic.internal.privileges.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgic.internal.privileges.entities.Privilege;

public interface PrivilegeRepo extends JpaRepository<Privilege, Long> {

	Privilege findPrivilegeById(Long privilageId);

	Optional<Privilege> findById(Long privilageId);


}
