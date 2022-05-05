package com.springcore.streotype;

import javax.naming.Context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.xml.sax.ext.Attributes2;

public abstract class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext context= new ClassPathXmlApplicationContext("com/springcore/streotype/streoconfig.xml");
		
		Student s1= context.getBean("ob",Student.class);   // getting class is camel case letter of main class declared.
		System.out.println(s1);
		
		 
		System.out.println(s1.getAddresses());
		System.out.println(s1.getAddresses().getClass().getName());

System.out.println("++++++++++++++++++++++++++++++++");

System.out.println(s1.hashCode());

Student s2= context.getBean("ob", Student.class);
System.out.println(s2.hashCode());
System.out.println(" Singleton scope :By default spring container given the same object: ie hashcode will be same "
		+ "\nBut if we want to change M1. use <bean class= name=  scope=  "
		+ "\nM2. @Component @Scope() " );	
	

	System.out.println("++++++++++++++++++++++++++++++++");
	System.out.println("++++++++++++++++++++++++++++++++");

Teacher t1=  context.getBean("teacher",Teacher.class);
Teacher t2=  context.getBean("teacher",Teacher.class);
  	
System.out.println(t1.hashCode());
System.out.println(t2.hashCode());


	}
	
}
