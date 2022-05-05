package com.spring.orm;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entites.Student;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
     ApplicationContext context= new   ClassPathXmlApplicationContext("com/spring/orm/config.xml");
     StudentDao studentDao=  context.getBean( "studentDao" , StudentDao.class);
        
    Student student = new Student(119, "Eamnttan","lap");
     
   /*  
     //INSERT
     int i = studentDao.insert(student);
      System.out.println("Done " + i);
      
      System.out.println("_____________________________________");
     */ 
    
     /*
     //GET SINGLE STUDENT
      Student student2= studentDao.getStudent(11);
      System.out.println(student2);
      
      System.out.println("_____________________________________");
       
      */
     
     /*
      //GET ALL STUDENT
          
      List<Student> student3= studentDao.getAllStudents();
      for(Student itr:student3)
      {System.out.println(itr);}

      
      System.out.println("_____________________________________");
      
      */
     
   /*
      //DELETE A RECORD  : ITS not working here 
      
       
       studentDao.deleteStudent(85);
      System.out.println("Record deleted successfully" );
      
      
      System.out.println("_____________________________________");

    */
    
      
      
      //UPDATE A record 
       Student studentnew= new Student(85,"Bhopal","Kumar");
      studentDao.updateStudent(studentnew);
      System.out.println("Recod Updated Successfully ");
      
      
      
      
    }
}
