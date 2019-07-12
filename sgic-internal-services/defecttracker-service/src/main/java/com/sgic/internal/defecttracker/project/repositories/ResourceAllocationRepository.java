package com.sgic.internal.defecttracker.project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sgic.internal.defecttracker.project.entities.ResourceAllocation;

public interface ResourceAllocationRepository extends JpaRepository<ResourceAllocation, Long> {

	ResourceAllocation findResourceAllocationByresourceId(Long resourceId);
	

	String fetchAllresourceId = "SELECT resource_id FROM resource_allocation";
	@Query(value = fetchAllresourceId, nativeQuery=true)
	<T> List<T> getAllresourceId();
	
	
	
}
