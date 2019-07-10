package com.sgic.internal.product.configure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgic.internal.product.configure.entities.DefectType;

public interface TypeRepo extends JpaRepository<DefectType, Long> {

}
