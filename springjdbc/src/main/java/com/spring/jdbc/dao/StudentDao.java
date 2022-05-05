


package com.spring.jdbc.dao;

import java.util.List;

import com.spring.jdbc.entites.Student;

public interface StudentDao {

	public int insert(Student student);       // abstract method .Implemented in tStudnetDaoImpl class

	public int change(Student student);           //TO update record.

	public int delete(int studentId);        // To remove
	
	public Student getStudent(int studentId);   // To perform selcet 1 row ,here row mapper will be used to fetch the data

	public List<Student> getAllStudents();        //To display all content
}
