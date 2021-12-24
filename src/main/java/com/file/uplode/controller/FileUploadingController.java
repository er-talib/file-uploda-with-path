package com.file.uplode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.file.uplode.helper.FileUploadhelper;

@RestController
public class FileUploadingController {

	@Autowired
	private FileUploadhelper fileUploadhelper;

	@PostMapping("/upload-file")
	public ResponseEntity<String> uploadFile(@RequestParam("image") MultipartFile file) {

//		System.out.println(file.getOriginalFilename());
//		System.out.println(file.getContentType());
//		System.out.println(file.getName());
//		System.out.println(file.getSize());

		try {

			// validaation file is empity
			if (file.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body("File is empity");
			}

			// validation content is not metch
			if (!file.getContentType().equals("image/jpeg")) {
				return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Content not match");
			}

//			file uploading 
			boolean b = fileUploadhelper.uploadfile(file);
			if (b) {
				return ResponseEntity.ok("file upload succesfuly");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("file is not uploades");

	}

}
