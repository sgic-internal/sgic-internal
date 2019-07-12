package com.sgic.internal.defecttracker.defect.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgic.internal.defecttracker.defect.entities.DefectConfig;

public interface DefectConfigRepository extends JpaRepository<DefectConfig, Long> {

}
