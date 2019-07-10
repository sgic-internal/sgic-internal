package com.sgic.internal.product.configure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgic.internal.product.configure.entities.DefectSeverity;

public interface SeverityRepo extends JpaRepository<DefectSeverity, Long> {

}
