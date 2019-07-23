package com.sgic.internal.defecttracker.defect.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgic.internal.defecttracker.defect.entities.DefectPriority;

public interface DefectPriorityRepository extends JpaRepository<DefectPriority, Long>{

}
