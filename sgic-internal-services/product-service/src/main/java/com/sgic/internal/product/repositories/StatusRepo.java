package com.sgic.internal.product.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sgic.internal.product.entities.DefectStatus;

public interface StatusRepo extends JpaRepository<DefectStatus, Long> {
	DefectStatus findDefectStatusById(Long id);
}
