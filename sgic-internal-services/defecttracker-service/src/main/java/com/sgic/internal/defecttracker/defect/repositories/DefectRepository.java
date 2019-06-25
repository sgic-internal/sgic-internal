package com.sgic.internal.defecttracker.defect.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgic.internal.defecttracker.defect.entities.Defect;

public interface DefectRepository extends JpaRepository<Defect, String>{
	Defect findDefectByDefectId(String defectId);
}
