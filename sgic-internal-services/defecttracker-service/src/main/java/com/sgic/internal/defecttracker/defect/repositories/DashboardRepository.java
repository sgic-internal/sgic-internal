package com.sgic.internal.defecttracker.defect.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgic.internal.defecttracker.defect.entities.SeverityCount;


public interface DashboardRepository extends JpaRepository<SeverityCount, Long> {

}
