package com.api.book.bootrestbook.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUplaodHelper {
	public final String UPLOAD_DIR="D:\\Navnath\\web\\bookwebproject\\bootrestbook\\src\\main\\resources\\static\\image";
	public boolean fileUplaod(MultipartFile multipartFile) {
		boolean f= false;
		try {
			
			/*
			 * InputStream is =multipartFile.getInputStream(); byte data[]= new
			 * byte[is.available()]; is.read(data);
			 * 
			 * //write
			 * 
			 * FileOutputStream fos = new
			 * FileOutputStream(UPLOAD_DIR+File.separator+multipartFile.getOriginalFilename(
			 * )); fos.write(data); fos.flush(); fos.close();
			 */	
			// another and easy way
			

			Files.copy(multipartFile.getInputStream(), Paths.get(UPLOAD_DIR+File.separator+multipartFile.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
			
			f=true;
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
}
