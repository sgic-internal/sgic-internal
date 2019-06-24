package com.sgic.internal.defecttracker.defect.controller.dto.converter;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;

import com.sgic.internal.defecttracker.defect.controller.dto.DefectData;
import com.sgic.internal.defecttracker.defect.entities.Defect;

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
				defectData.setProjectId(defect.getProjectId());
				defectData.setModuleId(defect.getModuleId());
				defectData.setSeverityId(defect.getSeverityId());
				defectData.setPriorityId(defect.getPriorityId());
				defectData.setTypeId(defect.getTypeId());
				defectData.setStatusId(defect.getStatusId());
				defectData.setDefectDescription(defect.getDefectDescription());
				defectData.setStepsToRecreate(defect.getStepsToRecreate());
				defectData.setAssignTo(defect.getAssignTo());
				defectData.setReassignTo(defect.getReassignTo());
				defectData.setEnteredBy(defect.getEnteredBy());
				defectData.setFixedBy(defect.getFixedBy());
				defectData.setCommentId(defect.getCommentId());
				defectData.setAttachmentId(defect.getAttachmentId());
				defectData.setDateAndTime(defect.getDateAndTime());

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
			defectData.setProjectId(defect.getProjectId());
			defectData.setModuleId(defect.getModuleId());
			defectData.setSeverityId(defect.getSeverityId());
			defectData.setPriorityId(defect.getPriorityId());
			defectData.setTypeId(defect.getTypeId());
			defectData.setStatusId(defect.getStatusId());
			defectData.setDefectDescription(defect.getDefectDescription());
			defectData.setStepsToRecreate(defect.getStepsToRecreate());
			defectData.setAssignTo(defect.getAssignTo());
			defectData.setReassignTo(defect.getReassignTo());
			defectData.setEnteredBy(defect.getEnteredBy());
			defectData.setFixedBy(defect.getFixedBy());
			defectData.setCommentId(defect.getCommentId());
			defectData.setAttachmentId(defect.getAttachmentId());
			defectData.setDateAndTime(defect.getDateAndTime());

			return defectData;
		}
		return null;
	}

	
//========================To convert DefectDTO to DefectEntity =====================================================
	
	public static Defect defectDataToDefect(DefectData defectData) {
		Defect defect = new Defect();
		if (defectData != null) {
			logger.info("Coverting DefectData to DefectEntity");

			defect.setDefectId(defectData.getDefectId());
			defect.setProjectId(defectData.getProjectId());
			defect.setModuleId(defectData.getModuleId());
			defect.setSeverityId(defectData.getSeverityId());
			defect.setPriorityId(defectData.getPriorityId());
			defect.setTypeId(defectData.getTypeId());
			defect.setStatusId(defectData.getStatusId());
			defect.setDefectDescription(defectData.getDefectDescription());
			defect.setStepsToRecreate(defectData.getStepsToRecreate());
			defect.setAssignTo(defectData.getAssignTo());
			defect.setReassignTo(defectData.getReassignTo());
			defect.setEnteredBy(defectData.getEnteredBy());
			defect.setFixedBy(defectData.getFixedBy());
			defect.setCommentId(defectData.getCommentId());
			defect.setAttachmentId(defectData.getAttachmentId());
			defect.setDateAndTime(defectData.getDateAndTime());

			return defect;
		}
		return null;
	}

}
