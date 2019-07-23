package com.sgic.internal.product.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sgic.internal.product.entities.DefectSeverity;

public interface SeverityRepo extends JpaRepository<DefectSeverity, Long> {
	DefectSeverity findDefectSeverityById(Long id);
}
