package com.sgic.internal.defecttracker.defect.services;

import java.util.List;

import com.sgic.internal.defecttracker.defect.entities.ResourceAllocationList;

public interface ResourceAllocationListService {
	
	public ResourceAllocationList findResourceAllocationByresourceId(Long resourceId);
	public List<ResourceAllocationList> getAllresourceList();
}
