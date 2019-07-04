package com.sgic.internal.defecttracker.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgic.internal.defecttracker.project.entities.DefectSeverity;

public interface DefectSeverityRepository extends JpaRepository<DefectSeverity, Long> {

}
