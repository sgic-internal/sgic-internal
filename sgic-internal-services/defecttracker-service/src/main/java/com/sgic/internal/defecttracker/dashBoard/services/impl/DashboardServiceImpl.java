package com.sgic.internal.defecttracker.dashBoard.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.internal.defecttracker.dashBoard.repository.DashboardRepository;
import com.sgic.internal.defecttracker.dashBoard.service.DashboardService;
import com.sgic.internal.defecttracker.defect.repositories.DefectRepository;


@Service
public class DashboardServiceImpl implements DashboardService {
	
	@SuppressWarnings("unused")
	@Autowired
	private DashboardRepository dashboardRepository;

	private DefectRepository defectRepository;

	@Override
	public long count() {
		String low = null;
		defectRepository.countlow(low);
		return 0;
	}
}
