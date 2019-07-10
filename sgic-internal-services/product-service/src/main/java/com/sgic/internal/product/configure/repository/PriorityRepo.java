package com.sgic.internal.product.configure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgic.internal.product.configure.entities.DefectPriority;

public interface PriorityRepo extends JpaRepository<DefectPriority, Long> {

}
