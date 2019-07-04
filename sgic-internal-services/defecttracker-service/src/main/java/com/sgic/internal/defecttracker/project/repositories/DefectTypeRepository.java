package com.sgic.internal.defecttracker.project.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.sgic.internal.defecttracker.project.entities.DefectType;


public interface DefectTypeRepository extends JpaRepository<DefectType, Long>{

}