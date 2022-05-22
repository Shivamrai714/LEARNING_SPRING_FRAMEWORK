package springmvcsearch;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormController {

	@RequestMapping("/complex")
	public String showForm()
	{System.out.println("Runinng the show form ");
	return "complex_form";
	}
	
	@RequestMapping(path="/handleform" ,method=RequestMethod.POST)
	public String formHandler(@ModelAttribute("student") Student student, BindingResult result)
	{
		if(result.hasErrors())
		{
			return "complex_form";
		}
		
		
System.out.println(student);
	
return "success";
	}
	
}



/*
 * 	public String formHandler(@RequestParam("name") String name,
			@RequestParam("id") Long id
			)
 * 
 * better method is to use a entity to fetch the data not the seperate attributes
 * 
 */
 