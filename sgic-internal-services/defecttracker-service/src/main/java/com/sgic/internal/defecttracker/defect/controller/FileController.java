package com.sgic.internal.defecttracker.defect.controller;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sgic.internal.defecttracker.defect.controller.dto.FileData;
import com.sgic.internal.defecttracker.defect.controller.dto.mapper.FileMapper;
import com.sgic.internal.defecttracker.defect.entities.Comments;
//import com.sgic.internal.defecttracker.defect.controller.dto.FileData;
//import com.sgic.internal.defecttracker.defect.controller.dto.converter.FileDTOConverter;
//import com.sgic.internal.defecttracker.defect.controller.dto.mapper.FileMapper;
import com.sgic.internal.defecttracker.defect.entities.DBFile;
import com.sgic.internal.defecttracker.defect.payload.UploadFileResponse;
import com.sgic.internal.defecttracker.defect.services.FileStorageService;

@CrossOrigin
@RestController
public class FileController {

	private static final Logger logger = LoggerFactory.getLogger(FileController.class);

	@Autowired
	private FileStorageService fileStorageService;
	@Autowired
	private FileMapper fileMapper;

	/* Post Mapping - Defect Attachment API by Thanushan */
	@PostMapping("/uploadFile")
	public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file,
			@RequestParam("defectId") String defectId) throws IOException {

		String fileName = fileStorageService.storeFile(file);

		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile/")
				.path(fileName).toUriString();
		System.out.println(fileDownloadUri);
		FileData fileData = fileMapper.fileToDTO(file, defectId);
		fileMapper.saveFile(fileData);
		return new UploadFileResponse(fileName, fileDownloadUri, file.getContentType(), file.getSize());
	}

	/* Post Mapping - Defect Attachment API by Thanushan */
	@PostMapping("/uploadMultipleFiles")
	public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files,
			@RequestParam("defectId") String defectId) {
		return Arrays.asList(files).stream().map(file -> {
			try {
				return uploadFile(file, defectId);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}).collect(Collectors.toList());
	}

	/* Get Mapping - Defect comment API by Piratheepan */
	@GetMapping("/downloadFile/{defectId}")
	public ResponseEntity<Resource> downloadFile(@PathVariable String defectId, HttpServletRequest request) {
		List<DBFile> list = fileMapper.getAttachmentsById(defectId);
		System.out.println(list);
		// Try to determine file's content type
		String contentType = null;
		for (DBFile dbFile : list) {
			System.out.println(dbFile.getFileName());
			// this.downloadFile(dbFile.getFileName(), request);

			// Load file as Resource
			Resource resource = fileStorageService.loadFileAsResource(dbFile.getFileName());
			System.out.println(resource);

			try {
				contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
				System.out.println(contentType);
			} catch (IOException ex) {
				logger.info("Could not determine file type.");
			}

			// Fallback to the default content type if type could not be determined
			if (contentType == null) {
				contentType = "application/octet-stream";
			}
			return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
					.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
					.body(resource);
		}
		return null;
	}
    @GetMapping("/downloadFiles/{fileName:.+}")
    public ResponseEntity<Resource> downloadFiles(@PathVariable String fileName, HttpServletRequest request) {
        // Load file as Resource
        Resource resource = fileStorageService.loadFileAsResource(fileName);

        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            logger.info("Could not determine file type.");
        }

        // Fallback to the default content type if type could not be determined
        if(contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

	@GetMapping("/listFile/{defectId}")
	public List<DBFile> listFile(@PathVariable("defectId") String defectId) {
		List<DBFile> list = fileStorageService.getAttachmentById(defectId);
		return list;
	}
	
	/* Delete Mapping - Defect Attachment API by Thuviyan */
	@DeleteMapping("/deleteFile/{id}")
	public void deleteDBFileByDefectId(@PathVariable Long id) {
		fileMapper.deleteById(id);
	}
}
