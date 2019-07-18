package com.sgic.internal.defecttracker.dashBoard.service;

public interface DashboardService {
	
	
public float CalculateLow(long count,int reject, int low, int rejectlow);

public float CalculateMedium(long count, int reject, int medium, int rejectmedium);
	
}
