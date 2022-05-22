package zpracticemvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class ReController {

	@RequestMapping("/one")
	public String one()
	{
		System.out.println("This is one controoller");
		return "redirect:/enjoy";                        //this is redirect view: and takes the relative path
	}
	
	@RequestMapping("/three")
	public RedirectView three()
	{
		System.out.println("This is three handler runnning the redirect view");
		RedirectView redirectView= new RedirectView();
		redirectView.setUrl("https://www.google.com");     // need to given only contact, not /contact 
		
		
		return redirectView;
		
	}
	
	
	
	
	
	
	@RequestMapping("/enjoy")
	public String two()
	{
		System.out.println("This is two controoller");
		return "contact";
	}
	
	
	
	
}
