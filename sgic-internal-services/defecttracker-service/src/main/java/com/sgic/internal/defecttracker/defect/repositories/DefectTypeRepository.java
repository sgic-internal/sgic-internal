package com.sgic.internal.defecttracker.defect.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgic.internal.defecttracker.defect.entities.DefectType;

public interface DefectTypeRepository extends JpaRepository<DefectType, Long>{

}
