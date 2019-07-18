package com.sgic.internal.defecttracker.dashBoard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgic.internal.defecttracker.dashBoard.entiry.SeverityCount;


public interface DashboardRepository extends JpaRepository<SeverityCount,Long>{

}
