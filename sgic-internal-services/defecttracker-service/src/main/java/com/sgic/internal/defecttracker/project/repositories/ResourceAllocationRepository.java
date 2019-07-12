package com.sgic.internal.defecttracker.project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.sgic.internal.defecttracker.project.entities.ResourceAllocation;

public interface ResourceAllocationRepository extends JpaRepository<ResourceAllocation, Long> {

//	<---Get Resource By Id Method--->
	ResourceAllocation findResourceAllocationByresourceId(Long resourceId);

//	<---Custom Query -- use to list Resource by Resource Id --->
	String fetchAllresourceId = "SELECT resource_id FROM resource_allocation";

	@Query(value = fetchAllresourceId, nativeQuery = true)
	<T> List<T> getAllresourceId();

//	<---save Balk Method  --->
	List<ResourceAllocation> save(List<ResourceAllocation> resourceAllocation);

}
