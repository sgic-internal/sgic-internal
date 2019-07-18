package com.sgic.internal.defecttracker.dashBoard.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.internal.defecttracker.dashBoard.service.DashboardService;
import com.sgic.internal.defecttracker.defect.repositories.DefectRepository;

@Service
public class DashboardServiceImpl implements DashboardService {

	@Autowired
	private DefectRepository defectRepository;

	@Override
	public float CalculateLow(long count, int reject, int low, int rejectlow) {
		// int count1 = (int)count;
		count = (int) defectRepository.count();
		System.out.println(count);
		reject = defectRepository.countByStatusRejected();
		System.out.println(reject);
		low = defectRepository.countBySeverity();
		System.out.println(low);
		rejectlow = defectRepository.countByStatusRejectedlow();
		System.out.println(rejectlow);
		int c = (int) (count - reject);
		System.out.println(c);
		int d = (int) (low - rejectlow);
		System.out.println(d);
		float LowSeverity = (d * 100 / c);
		System.out.println(LowSeverity);
		return LowSeverity;
	}
	public Integer countLow() {
		return defectRepository.countBySeverity();
	}

	@Override
	public Integer countMedium() {
		return defectRepository.countBySeverityMedium();
	}

	@Override
	public Integer countHigh() {
		return defectRepository.countBySeverityhigh();
	}

	@Override
	public Integer fetchHighWeight() {
		return defectRepository.getHighWeight();
	}

	@Override
	public Integer fetchMediumWeight() {
		return defectRepository.getMediumWeight();
	}

	@Override
	public Integer fetchLowWeight() {
		return defectRepository.getLowWeight();
	}

	@Override
	public Long TotalCount() {
		return defectRepository.count();
	}

	@Override
	public Double calculateSeverityIndex() {
		int countLow = countLow();
		int countMedium =countMedium();
		int countHigh =countHigh();
		int fetchHighWeight =fetchHighWeight();
		int fetchMediumWeight =fetchMediumWeight();
		int fetchLowWeight =fetchLowWeight();
		long totalCount =TotalCount()-countReject();
		
		int severityIndex1 = ((countHigh* fetchHighWeight)+(countMedium*fetchMediumWeight)+(countLow*fetchLowWeight));
		double severityIndex1d = severityIndex1;
		
		int totcount =(int)totalCount;
		double totcountd = totcount;
		
		double severityIndex = severityIndex1d/totcountd;
		return severityIndex;
	}


	public Integer countReject() {
		return defectRepository.countByStatusRejected();
	}

	@Override
	public float CalculateMedium(long count, int reject, int medium, int rejectmedium) {
		// int count1 = (int)count;
		count = (int) defectRepository.count();
		System.out.println(count);
		reject = defectRepository.countByStatusRejected();
		System.out.println(reject);
		medium = defectRepository.countBySeverityMedium();
		System.out.println(medium);
		rejectmedium = defectRepository.countByStatusRejectedmedium();
		System.out.println(rejectmedium);
		int c = (int) (count - reject);
		System.out.println(c);
		int d = (int) (medium - rejectmedium);
		System.out.println(d);
		float MediumSeverity = (d * 100 / c);
		System.out.println(MediumSeverity);
		return MediumSeverity;
	}
}
