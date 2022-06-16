package com.jpa.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

	@RequestMapping("/test")
	@ResponseBody
	public String test()
	{
		int a=0;
		int b=15;
		int c=100;
		
		return "This is just testing sum a and b  and   c is " + (a+b+c);
	}
	
}
