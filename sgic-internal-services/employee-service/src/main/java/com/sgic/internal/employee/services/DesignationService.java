package com.sgic.internal.employee.services;

import java.util.List;

import com.sgic.internal.employee.entities.Designation;

public interface DesignationService {

	
//	save method for Designation 
	public Designation savedesignation(Designation designation);
	
	public List<Designation> getAllDesignation();
	
	
}
