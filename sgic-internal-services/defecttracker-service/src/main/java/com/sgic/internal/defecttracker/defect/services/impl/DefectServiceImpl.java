package com.sgic.internal.defecttracker.defect.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.internal.defecttracker.defect.entities.Defect;

import com.sgic.internal.defecttracker.defect.repositories.DefectRepository;
import com.sgic.internal.defecttracker.defect.services.DefectService;

@Service
public class DefectServiceImpl implements DefectService{
	
	@Autowired
	DefectRepository defectRepository;
	
	@Override
	public Defect getDefectById(String defectId) {
		return defectRepository.findDefectByDefectId(defectId);
	}
	

}
