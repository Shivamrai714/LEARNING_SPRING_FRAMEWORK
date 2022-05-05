//  Autowiring : spring container will pass the ref of obj in anoother class without explictily mentioning in ref="" inb bean tag.
// Can be done 1.By autowire =""  in bean tag : a) byName b)byType c)constructor
//Can be done 2. By autowire annotaion. (next video)



package com.springcore.auto.wire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) 
	{
	
	ApplicationContext  context = new ClassPathXmlApplicationContext("com/springcore/auto/wire/autoconfig.xml");
		
		Emp emp=(Emp)context.getBean("emp1");		// TO avoid type casting the Emp directly use the .   ( getBean("name" , "Emp") )
	System.out.println(emp);
		
	}

}
