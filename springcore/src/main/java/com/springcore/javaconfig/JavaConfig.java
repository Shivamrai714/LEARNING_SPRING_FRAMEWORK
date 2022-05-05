//  Lecture 28 : Not complected : Error is comming


package com.springcore.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {
    
	@Bean
	public void getSamosa() {
		return new Samosa();
	}
	
	
	                           //M1: using bean tag in .xml  M2: using annotaions @Component
	@Bean                          // This is Mthod 3 @Bean to give obj to IOC container 
	public Student getStudent()
	{
		//creating a new object
		Student student = new Student(getSamosa());
		return  student;
	}
	  
}
