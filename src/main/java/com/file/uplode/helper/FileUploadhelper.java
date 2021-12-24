package com.file.uplode.helper;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

// use only first type
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.InputStream;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadhelper {

	public final String UPLOAD_DIR = "/home/muhammad/Documents/workspace-spring-tool-suite-4-4.12.0.RELEASE/fileuplodethroughapi/src/main/resources/static/image/";

	public boolean uploadfile(MultipartFile f) {

		boolean b = false;
// first type how to upload data in folder ;		
//		try {
//			InputStream is = f.getInputStream();
//			byte[] data = new byte[is.available()];
//			is.read(data);
//
//			FileOutputStream fos = new FileOutputStream(UPLOAD_DIR + File.separator + f.getOriginalFilename());
//			fos.write(data);
//			fos.flush();
//			b = true;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return b;

//		Second type how to upload data in folder

		try {
			Files.copy(f.getInputStream(), Paths.get(UPLOAD_DIR + File.separator + f.getOriginalFilename()),
					StandardCopyOption.REPLACE_EXISTING);
			b = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}
}
