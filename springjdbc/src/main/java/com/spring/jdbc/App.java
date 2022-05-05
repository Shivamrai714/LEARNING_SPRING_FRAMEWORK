package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entites.Student;

public class App 
{
	
	public static void main(String args[])
	{

        System.out.println( " {....Programs for DAtaBase connectivity " );
    
        /*
        //  method 1:  Using xml file for object creating medium for spring container.
       //   THIS IS USED WHEN WE HAVE xml FILE
         ApplicationContext context= 
    	 new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
         */
        
 //*******************************************************************************************************************************

 //*******************************************************************************************************************************
                     
        //method 2: This method is giving error ::  to use Configuration file in place of xml file
                   //I have solved this error but dont know how. better Suggestion to reinsetal from help section the web developer and java interprise tools   ///// or reinstal eclipse with JE web version.
    
        
        ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);

        
     
     // *Main working class is studentDao which has a object variable of JdbcTemplate class , which is responsible for connecting to the database.
     //  *Moreover the interface studentDao contains insert method for inserting,etc      
     
     // *we have here get the bean in interface StudentDao as it is parent of StudentDaoImpl class

        StudentDao studentDao= context.getBean("studentDao", StudentDao.class);  
     
   
		  
		//1INSERT_______________
		     
		     /* 
		     Student student= new Student();
		     student.setId(666);
		     student.setName("John");
		     student.setCity("The don");
		           
		     int result= studentDao.insert(student);
		     System.out.println("Student added "+ result);
		     
		    */
		     
		 //2.UPDATE ___________
		   
		     /*
		     Student student= new Student();
		     student.setId(111);
		     student.setCity("Bhopal");
		     student.setName("Rajkumar");
		     
		     int result = studentDao.change(student);
		     System.out.println("Data changed : " + result);
		    */
		     
		     
		//3.DELETE  ___________
		    
		    
		      int r = studentDao.delete(9);
		       System.out.println("Deleted rows "+r);
		     
		     
		     
		 //SELECT SINGLE ROW 
		     /*
		     	Student student = studentDao.getStudent(111);
		       System.out.println(student);
		     */
		     
		 //SELECT ALL STUDENTS
		     
		     List<Student> students= studentDao.getAllStudents();
		     for(Student s: students)
		     {
		    	 System.out.println(s);
		     }
		     
		     System.out.println("Finally was able to fetch the data using @Configuration");
		    
	
	}

}


















