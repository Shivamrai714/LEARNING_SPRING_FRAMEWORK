package com.practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//This is for video 36 : including images etc

@Controller
public class ExamlpeContoller {

	@GetMapping("/example")
	public String exaple()
	{
		return "example";
	}
	
}
