package com.api.book.bootrestbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.api.book.bootrestbook.helper.FileUplaodHelper;

@RestController
public class FileUploaderController {
	@Autowired
	private FileUplaodHelper fileUplaodHelper;

	@PostMapping("/upload-file")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
		/*
		 * System.out.println("Original file Name: "+file.getOriginalFilename());
		 * System.out.println("File Size: "+file.getSize());
		 * System.out.println("File type: "+file.getContentType());
		 * System.out.println("File Name: "+file.getName());
		 */
		// validation
		try {
			if (file.isEmpty()) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request must contain file");
			}
			if (file.getContentType().equals("image/jpg")) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
						.body("Request only jpeg content are allowed");
			}

			// file upload code
			// we know where to upload file
			boolean f= fileUplaodHelper.fileUplaod(file);
			if(f) {
				return ResponseEntity.ok("uploaded file successfully");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("something went to wrong ! try again.");
	}
}
