package com.sgic.internal.defecttracker.dashBoard.service;

public interface DashboardService {

//	<----Calculate severity Low defect --- Method--- >
	public float CalculateLow(long count, int reject, int low, int rejectlow);

//	public Integer countlow();
//
//	public Integer countmudium();

//	public Integer countHigh();
//
//	public Integer countReject();


	//<----Calculate severity high defect --- Method--- >
	public float Calculatseverityhigh(long count, int reject, int High, int rejectHigh);

	public Integer countseveritylow();

	public Integer countseveritymudium();

	public Integer countseverityHigh();

	public Integer countseverityReject();

	//	<----Calculate severity medium defect --- Method--- >
	public float CalculateMedium(long count, int reject, int medium, int rejectmedium);
	
	//For Severity Index 
	public Integer countLow();
	
	public Integer countMedium();
	
	public Integer countHigh();	
	
	public Integer countReject();
	
	public Integer fetchHighWeight();
	
	public Integer fetchMediumWeight();
	
	public Integer fetchLowWeight();
	
	public Long TotalCount();
	
	public Double calculateSeverityIndex();

//	<--Severity Total Count -->
	public Integer countseveritytotalLow();
	
//	<--Severity Total Count -->
	public Integer countseveritytotalmedium();
	
//	<--Severity Total Count -->
	public Integer countseveritytotalhig();
	
}
