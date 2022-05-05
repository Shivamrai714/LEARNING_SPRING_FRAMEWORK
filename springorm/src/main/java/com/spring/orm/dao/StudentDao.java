package com.spring.orm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.spring.orm.entites.Student;

public class StudentDao 
{

	private HibernateTemplate hibernateTemplate;
	
	// we use this class to insert the data into Students table 
	// so we need hibernateTemplate obj , so declare it and its getters and setters  

	//1. INSERT DATA   ////////////////////
	@Transactional                            //included for  write operation also go to xml and declare schema of tx by modifying p : and last two line of  context <-> tx  , also enable it by <tx:annotation-driven />   
	public int insert(Student student)
	{
	  Integer i= (Integer) this.hibernateTemplate.save(student); 
		return i;
	}
	
	//2. Select Data of Student
	// no req of @transactional
	public Student getStudent(int studentId)
	{
	Student student=this.hibernateTemplate.get(Student.class, studentId);
     return student;
	}
	
	// 3. Select * students
	public List<Student> getAllStudents()
	{
		List<Student> students= this.hibernateTemplate.loadAll(Student.class);
return students;
	}
	
	
	//4 .Delete 
	@Transactional
	public void deleteStudent(int studentId)
	{
		Student student= this.hibernateTemplate.get(null, getClass(Student.class,studentId));
	this.hibernateTemplate.delete(student);
	}
	
	//5.Update 
	@Transactional
	public void updateStudent(Student student)
	{
		this.hibernateTemplate.update(student);
	}
	
	
	
	
    //getters
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
   //setters 
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public StudentDao() {
		super();
		
	}
	
	
}
