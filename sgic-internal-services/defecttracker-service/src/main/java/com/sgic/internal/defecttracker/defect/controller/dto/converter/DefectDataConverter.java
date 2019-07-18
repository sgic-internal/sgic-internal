package com.sgic.internal.defecttracker.defect.controller.dto.converter;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;

import com.sgic.internal.defecttracker.defect.controller.dto.DefectData;
import com.sgic.internal.defecttracker.defect.entities.Defect;
import com.sgic.internal.defecttracker.project.entities.Module;
import com.sgic.internal.defecttracker.project.entities.Project;

@Service
public class DefectDataConverter {

	private static Logger logger = LogManager.getLogger(Defect.class);

//========================To list all defect details=============================================================
	public static List<DefectData> defectEntityToDefectData(List<Defect> defectList) {

		if (defectList != null) {
			logger.info("Coverting DefectEntity to DefectData");
			List<DefectData> listDefectData = new ArrayList<>();
			for (Defect defect : defectList) {
				
				DefectData defectData = new DefectData();

				defectData.setDefectId(defect.getDefectId());
							
				defectData.setProjectId(defect.getProject().getProjectId());
				defectData.setProjectName(defect.getProject().getProjectName());
				defectData.setModuleId(defect.getModule().getModuleId());
				defectData.setModuleName(defect.getModule().getModuleName());
				defectData.setDefectDescription(defect.getDefectDescription());
				defectData.setStepsToRecreate(defect.getStepsToRecreate());
				defectData.setAssignTo(defect.getAssignTo());
				defectData.setReassignTo(defect.getReassignTo());
				defectData.setEnteredBy(defect.getEnteredBy());
				defectData.setFixedBy(defect.getFixedBy());
                defectData.setAbbre(defect.getAbbre());
				defectData.setDateAndTime(defect.getDateAndTime());
				defectData.setAvailableIn(defect.getAvailableIn());
				defectData.setFoundIn(defect.getFoundIn());
				defectData.setFixedIn(defect.getFixedIn());
				 defectData.setSeverity(defect.getSeverity());
				 defectData.setPriority(defect.getPriority());
				 defectData.setType(defect.getType());
				 defectData.setStatus(defect.getStatus());
				//defectData.setName(defect.getDefectConfig().getName());
				
				listDefectData.add(defectData);

			}
			return listDefectData;
		}
		return null;
	}

//========================To convert DefectEntity to DefectDTO =====================================================

	@SuppressWarnings("unused")
	public static DefectData defectEntityToDefectData(Defect defect) {
		DefectData defectData = new DefectData();

		if (defectData != null) {
			logger.info("Coverting DefectEntity to DefectDTO");

			defectData.setDefectId(defect.getDefectId());
			defectData.setProjectId(defect.getProject().getProjectId());
			defectData.setProjectName(defect.getProject().getProjectName());
			defectData.setModuleId(defect.getModule().getModuleId());
			defectData.setModuleName(defect.getModule().getModuleName());
			defectData.setDefectDescription(defect.getDefectDescription());
			defectData.setStepsToRecreate(defect.getStepsToRecreate());
			defectData.setAssignTo(defect.getAssignTo());
			defectData.setReassignTo(defect.getReassignTo());
			defectData.setEnteredBy(defect.getEnteredBy());
			defectData.setFixedBy(defect.getFixedBy());
			defectData.setDateAndTime(defect.getDateAndTime());
			defectData.setAvailableIn(defect.getAvailableIn());
			defectData.setFoundIn(defect.getFoundIn());
			defectData.setFixedIn(defect.getFixedIn());
			 defectData.setAbbre(defect.getAbbre());
			 defectData.setSeverity(defect.getSeverity());
			 defectData.setPriority(defect.getPriority());
			 defectData.setType(defect.getType());
			 defectData.setStatus(defect.getStatus());
				//defectData.setName(defect.getDefectConfig().getName());
			return defectData;
		}
		return null;
	}

	
//========================To convert DefectDTO to DefectEntity =====================================================
	
	public static Defect defectDataToDefectEntity(DefectData defectData) {
		Defect defect = new Defect();
		if (defectData != null) {
			logger.info("Coverting DefectData to DefectEntity");
			
			Project project = new Project();
			Module module = new Module();
			
			module.setModuleId(defectData.getModuleId());
			defect.setDefectId(defectData.getDefectId());
			project.setProjectId(defectData.getProjectId());
			defect.setProject(project);
			defect.setModule(module);
			defect.setDefectDescription(defectData.getDefectDescription());
			defect.setStepsToRecreate(defectData.getStepsToRecreate());
			defect.setAssignTo(defectData.getAssignTo());
			defect.setReassignTo(defectData.getReassignTo());
			defect.setEnteredBy(defectData.getEnteredBy());
			defect.setFixedBy(defectData.getFixedBy());
			defect.setDateAndTime(defectData.getDateAndTime());
			defect.setAvailableIn(defectData.getAvailableIn());
			defect.setFoundIn(defectData.getFoundIn());
			defect.setFixedIn(defectData.getFixedIn());
			 defect.setAbbre(defectData.getAbbre());
			 defect.setSeverity(defectData.getSeverity());
			 defect.setPriority(defectData.getPriority());
			 defect.setType(defectData.getType());
			 defect.setStatus(defectData.getStatus());
			return defect;
		}
		return null;
	}

}
