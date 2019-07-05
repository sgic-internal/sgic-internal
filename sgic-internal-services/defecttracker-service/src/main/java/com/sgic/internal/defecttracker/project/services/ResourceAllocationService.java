package com.sgic.internal.defecttracker.project.services;

import java.util.List;

import com.sgic.internal.defecttracker.project.entities.ResourceAllocation;

public interface ResourceAllocationService {
	
	public ResourceAllocation saveresource (ResourceAllocation resourceAllocation);
	
	public List<ResourceAllocation> gettAllResource();
	


}
