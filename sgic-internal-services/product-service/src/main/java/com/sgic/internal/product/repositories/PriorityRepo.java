package com.sgic.internal.product.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sgic.internal.product.entities.DefectPriority;


public interface PriorityRepo extends JpaRepository<DefectPriority, Long> {
	DefectPriority findDefectPriorityById(Long id);
}
