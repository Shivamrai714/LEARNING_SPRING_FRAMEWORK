package com.springcore.standalone.collections;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	
	public static void main(String[] args) {
	    
		// the work of object creation is being done by Spring container, we need to direclty use the object using the Application Context
		ApplicationContext context= new ClassPathXmlApplicationContext("com/springcore/standalone/collections/aloneconfig.xml");
	Person person1=	context.getBean("person1" , Person.class) ;
	
        System.out.println(person1);
		System.out.println(person1.getFriends().getClass().getName());

		System.out.println("______________________________________________________________");
		System.out.println(person1.getFeestructure());
	System.out.println(person1.getFeestructure().getClass().getName());
	
	System.out.println("____________________________________________________________________");
	System.out.println(person1.getProperties());
	}

}
