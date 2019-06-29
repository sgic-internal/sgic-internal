package com.sgic.internal.defecttracker.defect.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgic.internal.defecttracker.defect.entities.DefectSeverity;

public interface DefectSeverityRepository extends JpaRepository<DefectSeverity, Long>{

}
