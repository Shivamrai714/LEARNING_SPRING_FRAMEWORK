package zpracticemvc.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import zpracticemvc.model.User;
import zpracticemvc.service.UserService;

@Controller
public class ContactController {

	@Autowired
	private UserService userService;
	// call its create user mathod in handle form method
	

	
	
	//USAGE 2: 
	@ModelAttribute
	public void commonDataForModel(Model m)
	{
		m.addAttribute("Header"," Durgesh And Shivam");
		m.addAttribute("desc","Pregramming Hub Coaching");
		System.out.println("First all common data is added : before handles method");
		
	}
	
	
	
	
	
	@RequestMapping("/contact")
	public String showForm(Model m) {
		
		//common data placed above
		System.out.println("Creating contact form");
		return "contact";
	}
	
	
	
	
	
	@RequestMapping(path = "/processform", method = RequestMethod.POST)
	public String handleform(@ModelAttribute User user , Model model)
	{
		// USAGE 1:
		//@Modelattribute do all 3 works it 
		//1) fetches the data from form (work of RequestParam )
		//2) binds the field to user object that are filled in form (ie work of setting fields user.setEmail(userEmail);)
		//3) add them in model object to display in next jsp page (work of model.attribute), 
		
		
		//common data placed abopve is used
		
		System.out.println(user);
		
		if(user.getUserName().isBlank())
		{
			return "redirect:/contact";
		}		
		
	
	int createdUser = this.userService.createUser(user);

	model.addAttribute("msg","User Created Successfully with id : "+ createdUser);
	
		return "success";
	}

}






















/* 
 	@RequestMapping(path = "/processform", method = RequestMethod.POST)
	public String handleform(@RequestParam(name = "email", required = true) String userEmail,
			@RequestParam("userName") String userName, @RequestParam("password") String userPassword, Model model) {

		System.out.println("User mail is " + userEmail);
		System.out.println("User Name is " + userName);
		System.out.println("User Password is " + userPassword);

		// process data

		// sending data to view using Model
		model.addAttribute("name", userName);
		model.addAttribute("email", userEmail);
		model.addAttribute("password", userPassword);

		User user = new User();

		return "success";
	}
 
 */


/*
 * Old method of fetching data using HttpServletRequest , getAttribute method
 * 
 * @RequestMapping(path="/processform" , method = RequestMethod.POST) public
 * String handleform(HttpServletRequest request) { String email=
 * request.getParameter("email");
 * 
 * System.out.println("User mail is "+ email); return ""; }
 */
