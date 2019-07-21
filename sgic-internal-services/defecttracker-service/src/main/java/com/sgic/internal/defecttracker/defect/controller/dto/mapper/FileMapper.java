//package com.sgic.internal.defecttracker.defect.controller.dto.mapper;
//
//import java.io.IOException;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.sgic.internal.defecttracker.defect.controller.dto.FileData;
//import com.sgic.internal.defecttracker.defect.controller.dto.converter.FileDTOConverter;
//import com.sgic.internal.defecttracker.defect.entities.Comments;
//import com.sgic.internal.defecttracker.defect.entities.DBFile;
//import com.sgic.internal.defecttracker.defect.services.FileStorageService;
//
//@Component
//public class FileMapper {
//	@Autowired
//	private FileDTOConverter fileDTOConverter;
//
//	@Autowired
//	private FileStorageService fileStorageService;
//
//	public DBFile saveFile(FileData fileData) {
//		DBFile responseFile = fileStorageService.saveFile(fileDTOConverter.DTOToEntity(fileData));
//		return responseFile;
//	}
//
//	public FileData fileToDTO(MultipartFile file, String defectId) throws IOException {
//		FileData fileData = fileDTOConverter.FileToDTO(file, defectId);
//		return fileData;
//	}
//
//	public List<DBFile> getAttachmentsById(String defectId) {
//		return fileStorageService.getAttachmentById(defectId);
//	}
//	
//	public void deleteById(Long id) {
//		fileStorageService.deleteById(id);
//	}
//}