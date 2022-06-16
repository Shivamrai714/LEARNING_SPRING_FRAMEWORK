package com.practice.controller;



import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyController {

	@RequestMapping(value="/about" , method = RequestMethod.GET)
	public String about(Model m)
	{
		m.addAttribute("name","Shivma Rai");
		m.addAttribute("currentdate", new Date().toLocaleString());
		System.out.println("Inside the about handler ...");
		return "about";             //about.html page
	}
	
	
	
	//handler iteration
	
	@GetMapping("/example-loop")
	public String iterateHandler(Model m)
	{
		//send the list to iterate
		
		List<String> names = List.of("Shivam","Lakshi","Kunal","Nishant");
		m.addAttribute("names",names);
		
		
		
		return "iterate";
	}
	
	//handler for conditional statements :
	
	@RequestMapping("/condition")
	public String conditionHandler(Model m)
	{
  boolean isActive = false;
  m.addAttribute("isActive",isActive);
  
  m.addAttribute("gender","F");
  
  List<Integer> mylist = List.of(9632,44,15);
  
  m.addAttribute("mylist",mylist);
		System.out.println("Inside the condtion handler of Thymeleaf");
		return "condition";
	}
	
	
	
	// handler for the including- FRAGMENT
	
	@GetMapping("/service")
	public String service(Model m)
	{
		m.addAttribute("title","I like SAMOSA Title");
		m.addAttribute("subtitle",new Date().toLocaleString());
		
		// we can pass the object ,list, useing the model.
		
		return "service";
	}
	
	
	
	//handler for new about/ inheriting the base page
	@GetMapping("/newabout")
	public String newabout()
	{
		return "aboutnew";
	}
	
	
	//handler for contact , inheriting the base the page

	@GetMapping("/newcontact")
	public String newcontact()
	{
		return "newcontact";
	}
	
	
	
	
}
