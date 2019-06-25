package com.sgic.internal.defecttracker.defect.services;

import com.sgic.internal.defecttracker.defect.entities.Defect;

public interface DefectService {
	public Defect getDefectById(String defectId);
}
