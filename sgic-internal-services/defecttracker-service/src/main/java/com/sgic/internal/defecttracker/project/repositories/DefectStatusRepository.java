package com.sgic.internal.defecttracker.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgic.internal.defecttracker.project.entities.DefectStatus;

public interface DefectStatusRepository extends JpaRepository<DefectStatus, Long> {

}