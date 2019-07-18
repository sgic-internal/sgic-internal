package com.sgic.internal.defecttracker.defect.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgic.internal.defecttracker.defect.entities.DefectStatus;

public interface DefectStatusRepository extends JpaRepository<DefectStatus, Long>{

	
}
