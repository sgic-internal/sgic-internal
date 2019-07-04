package com.sgic.internal.defecttracker.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgic.internal.defecttracker.project.entities.DefectPriority;

public interface DefectPriorityRepository extends JpaRepository<DefectPriority, Long>{

}