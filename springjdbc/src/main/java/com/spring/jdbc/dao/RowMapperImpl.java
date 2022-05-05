


package com.spring.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.entites.Student;

public class RowMapperImpl implements RowMapper<Student>
{
    //REFER VIDEO 37 : 12:30 lERAN CODE WITH DURGESH      
	// IF DO NOT WANT TO SEPERATELY CREATE THIS ROWMAPPER CLASS . USE THE CONCEPT OF ANNONMOUS CLASS, WHERE USE HAVE CREATE THE ROW MAPPER OBJ IN STUDENTDAOiMPL CLASS 
	
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Student student= new Student();
		
		student.setId(rs.getInt(1));
		student.setName(rs.getString(2));
		student.setCity(rs.getString(3));
		
		
		return student;

	// basically here results set rs get the objecet and convet them to Student type
	
	}

}

