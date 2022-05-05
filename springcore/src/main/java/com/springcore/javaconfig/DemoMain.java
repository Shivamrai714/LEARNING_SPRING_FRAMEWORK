//  Lecture 28 : Not complected : Error is comming


package com.springcore.javaconfig;
//  Initailly we have use config.xml file to declare : but here make it full java dependent.
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoMain
{
	public static void main(String args[])
	{
		//ApplicationContext context = new ClassPathXmlApplicationContext("com/springcore/javaconfig/config.xml");
	   // but here use annotaion to handle java file
		ApplicationContext context=new AnnotationConfigApplicationContext(JavaConfig.class);
		Student s1= context.getBean("getStudent",Student.class);

		System.out.println(s1);
		s1.study();
	}

}
