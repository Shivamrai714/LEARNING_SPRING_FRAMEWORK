package com.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * Hello world!  To run this eg we need 3 files: app.java , Student.java, config.xml 
 * 
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       // work done by ioc , he creates obj for us and we just take that obj using this "application context"
    	//link with config file then using the getBean Method.
        
    	ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");  //"com/springcore/config.xml"  Optional to be used when config file is present inside package.
    
        System.out.println( "\nFirst Object : ( used value tag ) " );
        Student stu1= (Student) context.getBean("student1");  
        System.out.println(stu1);
       
        System.out.println( "\nSecond Object : ( used value attribute )  " );
        Student obj2= (Student)context.getBean("student2");   
        System.out.println(obj2);
      
      
        System.out.println( "\nThird object : ( used single line declaration ) " );
        Student obj3= (Student)context.getBean("student3");   
        System.out.println(obj3);
      
      
      
      System.out.println( "Exit" );
      
    }
}
