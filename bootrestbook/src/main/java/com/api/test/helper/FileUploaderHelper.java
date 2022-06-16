package com.api.test.helper;

//ERROR COMMING DURING DYNAMIC VIDEO 27 : link not showing image on browser.

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component                    //so that its object can be autowired.
public class FileUploaderHelper {

	//use the double \\ in windows to give path of STatic folder
	
	//  VIDEO 26 :this is static path (computer dependent)
	//public final String UPLOAD_DIR="C:\\Users\\SHIVAM RAI\\Documents\\workspace-spring-tool-suite-4-4.14.1.RELEASE\\bootrestbook\\src\\main\\resources\\static\\image";
	
	//using the dynamic path :
	//VIDEO 27 :     ClassPathResource - give path till the resources , after we add in static/image/ , it give the Object so convert to path using Absolute path .
	public final String UPLOAD_DIR= new ClassPathResource("static/image/").getFile().getAbsolutePath();   // to remove the error from it, give the constructor and thorows IOException form it.
	public FileUploaderHelper() throws IOException {
		
	}





	public boolean  uploadFile(MultipartFile multipartFile)
	{
		boolean f= false;
		
		try {
			
			//read the file using inputStream 
			InputStream is= multipartFile.getInputStream();
			byte data[]= new byte[is.available()];
			is.read(data);

           //now write the data , on desired path using filePUtputStream
			//  file.seperator= \\
			FileOutputStream fos= new FileOutputStream(UPLOAD_DIR+File.separator+multipartFile.getOriginalFilename());
			
			fos.write(data);     //will save img to image folder
			
			fos.flush();
			fos.close();
			f=true;
			

//			OR USE THE NIo and comment other the above entire code
	//		Files.copy(multipartFile.getInputStream(), Paths.get(UPLOAD_DIR+File.separator+multipartFile.getOriginalFilename()) , StandardCopyOption.REPLACE_EXISTING);
			
			
		} catch (Exception e) {
		e.printStackTrace();
		}
		
		return f;
	}
	
}
