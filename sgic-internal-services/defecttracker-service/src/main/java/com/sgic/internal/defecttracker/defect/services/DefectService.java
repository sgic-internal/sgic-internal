package com.sgic.internal.defecttracker.defect.services;


import java.util.List;

import org.springframework.stereotype.Service;

import com.sgic.internal.defecttracker.defect.entities.Defect;

@Service
public interface DefectService {

	public Defect createDefect(Defect defect);   
	public Defect getByDefectId(String defectId);
	public Defect updateDefect(Defect defect);
	public Defect deleteDefect(String defectId);   
	public List<Defect> getAllDefects(); 
	
	//Depended services
	public Defect updateDefectStatus(int statusId); 
	public Defect updateReassignTo(String reassignTo); 
	public Defect updateDefectComment(int commentId); 
	public Defect updateDefectAttachment(int attachmentId);
	public List<Defect> getAllDefectByStatus (int statusId); 
	public List<Defect> getProjectById (String projectId); 
	public List<Defect> getModuleById (String moduleId); 
	public List<Defect> getAllSeverityById (int severityId); 
	public List<Defect> getAllPriorityById (int priorityId);
	public List<Defect> getDefectByDate (String dateAndTime);
	public boolean isDefectAlreadyExist(String defectId);           
	     	
}
