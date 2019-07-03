package com.sgic.internal.defecttracker.defect.controller.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Lob;

import org.springframework.data.annotation.Id;

public class FileData {

	private String fileName;
	private String fileDownloadUri;
	private String fileType;
	private String defectId;
	private Long size;

	public FileData() {

	}

	public FileData(String fileName, String fileDownloadUri, String fileType, long size, String defectId) {
		this.fileName = fileName;
		this.fileDownloadUri = fileDownloadUri;
		this.fileType = fileType;
		this.size = size;
		this.defectId = defectId;
	}

	public String getDefectId() {
		return defectId;
	}

	public void setDefectId(String defectId) {
		this.defectId = defectId;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileDownloadUri() {
		return fileDownloadUri;
	}

	public void setFileDownloadUri(String fileDownloadUri) {
		this.fileDownloadUri = fileDownloadUri;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

}