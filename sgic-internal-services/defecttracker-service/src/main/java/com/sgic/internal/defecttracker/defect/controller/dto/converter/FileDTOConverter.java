package com.sgic.internal.defecttracker.defect.controller.dto.converter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.sgic.internal.defecttracker.defect.controller.dto.FileData;
import com.sgic.internal.defecttracker.defect.entities.DBFile;
import com.sgic.internal.defecttracker.defect.entities.Defect;
import com.sgic.internal.defecttracker.defect.services.FileStorageService;

@Component
public class FileDTOConverter {
	@Autowired
	private FileStorageService fileStorageService;
	private static final String PATH = "//localhost:8081/defectservices/downloadFile/";

	public DBFile DTOToEntity(FileData fileData) {
		DBFile dbFile = new DBFile();
		dbFile.setFileName(fileData.getFileName());
		dbFile.setFileType(fileData.getFileType());
		dbFile.setFileDownloadUri(fileData.getFileDownloadUri());
		dbFile.setSize(fileData.getSize());
		
		Defect defect = new Defect();
		defect.setDefectId(fileData.getDefectId());
		dbFile.setDefect(defect);
		return dbFile;
	}

	public FileData EntityToDTO(DBFile dbFile) {
		FileData fileData = new FileData();
		fileData.setFileName(dbFile.getFileName());
		fileData.setFileType(dbFile.getFileType());
		fileData.setFileDownloadUri(dbFile.getFileDownloadUri());
		fileData.setSize(dbFile.getSize());
		fileData.setDefectId(dbFile.getDefect().getDefectId());
		return fileData;
	}

	public FileData FileToDTO(MultipartFile file, String defectId) throws IOException {
		// String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		String fileName = fileStorageService.storeFile(file);
		String fileurl = PATH + defectId;
		FileData fileData = new FileData();
		fileData.setFileName(fileName);
		fileData.setFileType(file.getContentType());
		fileData.setFileDownloadUri(fileurl);
		fileData.setSize(file.getSize());
		fileData.setDefectId(defectId);
		return fileData;
	}

	public List<FileData> ListEntityToDTO(List<DBFile> dbFiles) {
		ArrayList<FileData> list = new ArrayList<>();
		for (DBFile dbFile : dbFiles) {
			FileData fileData = new FileData();
			fileData.setFileName(dbFile.getFileName());
			fileData.setFileType(dbFile.getFileType());
			fileData.setFileDownloadUri(dbFile.getFileDownloadUri());
			fileData.setSize(dbFile.getSize());
			fileData.setDefectId(dbFile.getDefect().getDefectId());
			list.add(fileData);
		}
		return list;
	}
}
