package zpracticemvc.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
public class FileuploadController {

	@RequestMapping("/fileform")
	public String showuploadForm()
	{
		return "fileform";
	}
	
	@RequestMapping(value="/uploadimage" , method=RequestMethod.POST)
	public String fileupload(@RequestParam("profile") CommonsMultipartFile file ,HttpSession s)
	{
		System.out.println("This is file upload handler");
        System.out.println("File size:"+ file.getSize());
        System.out.println("File name:"+ file.getOriginalFilename());
        
        byte[] data= file.getBytes();
        // we want to save this file on server , but what eclipse do is it save the project on wtpwebapps folder , there spring follow structre of project and save this file : this problem is not present when we deploy project on server
      String path=  s.getServletContext().getRealPath("/")+"WEB-INF"+File.separator+"resources"+File.separator+"image"
        +File.separator+file.getOriginalFilename();
      
      // will save file on images folder of secret directory of spring
      
        System.out.println(path);

        try {
			FileOutputStream fos= new FileOutputStream(path);
			fos.write(data);
			fos.close();
			
			System.out.println("File uploaded in desired folder");
        	
        	
		} catch (IOException e) {
			
			e.printStackTrace();
			System.out.println("Uploading / file writtning error ");
		}
        
        
        return "filesuccess";
	}
	
}
