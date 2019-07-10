package com.sgic.internal.product.configure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgic.internal.product.configure.entities.DefectStatus;

public interface StatusRepo extends JpaRepository<DefectStatus, Long> {

}
