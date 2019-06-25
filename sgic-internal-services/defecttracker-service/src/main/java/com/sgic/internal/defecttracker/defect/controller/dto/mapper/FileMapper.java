package com.sgic.internal.defecttracker.defect.controller.dto.mapper;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.sgic.internal.defecttracker.defect.controller.dto.FileData;
import com.sgic.internal.defecttracker.defect.controller.dto.converter.FileDTOConverter;
import com.sgic.internal.defecttracker.defect.entities.DBFile;
import com.sgic.internal.defecttracker.defect.services.FileStorageService;

@Component
public class FileMapper {
	@Autowired
	private FileDTOConverter fileDTOConverter;
	
	@Autowired
	private FileStorageService fileStorageService;

//	public DBFile storeFile(FileData fileData) {
//		DBFile responseFile = fileStorageService.storeFile(fileDTOConverter.DTOToEntity(fileData));
//		return responseFile;
//	}
//	
	public FileData fileToDTO(MultipartFile file) throws IOException {
		FileData responseFile = fileDTOConverter.FileToDTO(file);
		return responseFile;
	}
}