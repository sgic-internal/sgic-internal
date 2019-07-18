package com.sgic.internal.defecttracker.dashBoard.service;

public interface DashboardService {

//	<----Calculate severity Low defect --- Method--- >
	public float CalculateLow(long count, int reject, int low, int rejectlow);

	public Integer countlow();

	public Integer countmudium();

	public Integer countHigh();

	public Integer countReject();

//	<----Calculate severity high defect --- Method--- >
	public float Calculatseverityhigh(long count, int reject, int High, int rejectHigh);

	public Integer countseveritylow();

	public Integer countseveritymudium();

	public Integer countseverityHigh();

	public Integer countseverityReject();

}
