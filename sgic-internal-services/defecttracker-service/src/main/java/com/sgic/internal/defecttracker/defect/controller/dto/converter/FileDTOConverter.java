package com.sgic.internal.defecttracker.defect.controller.dto.converter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.sgic.internal.defecttracker.defect.controller.dto.FileData;
import com.sgic.internal.defecttracker.defect.entities.DBFile;
import com.sgic.internal.defecttracker.defect.entities.Defect;

@Component
public class FileDTOConverter {
	public DBFile DTOToEntity(FileData fileData) {
		DBFile dbFile=new DBFile();
		dbFile.setFileName(fileData.getFileName());
		dbFile.setFileType(fileData.getFileType());
		dbFile.setFileDownloadUri(fileData.getFileDownloadUri());
		dbFile.setSize(fileData.getSize());
		return dbFile;
	}
	public FileData EntityToDTO(DBFile dbFile) {
		FileData fileData=new FileData();
		fileData.setFileName(dbFile.getFileName());
		fileData.setFileType(dbFile.getFileType());
		fileData.setFileDownloadUri(dbFile.getFileDownloadUri());
		fileData.setSize(dbFile.getSize());
		return fileData;
	}
	public FileData FileToDTO(MultipartFile file) throws IOException {
    	String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		FileData fileData=new FileData();
		fileData.setFileName(fileName);
		fileData.setFileType(file.getContentType());
		fileData.setFileDownloadUri(file.getContentType());
		fileData.setSize(file.getSize());
		return fileData;
	}
	public List<FileData> ListEntityToDTO(List<DBFile> dbFiles) {
		ArrayList<FileData> list=new ArrayList<>();
		for(DBFile dbFile:dbFiles) {
		FileData fileData=new FileData();
		fileData.setFileName(dbFile.getFileName());
		fileData.setFileType(dbFile.getFileType());
		fileData.setFileDownloadUri(dbFile.getFileDownloadUri());
		fileData.setSize(dbFile.getSize());
		list.add(fileData);
		}
		return list;
	}
}