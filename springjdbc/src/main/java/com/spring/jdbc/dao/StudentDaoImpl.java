

package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.entites.Student;

public class StudentDaoImpl implements StudentDao {
	
	
	private JdbcTemplate jdbcTemplate;

	//getters
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	//setters
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	//--------------------------------------------------------------------------------------------------------------------
	
	
	// INSERT ---------------
	public int insert(Student student)
	{
       //insert query
 String query="insert into student(id,name,city) values(?,?,?)";
int r=this.jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
return r;
  	
	}
	
	//--------------------------------------------------------------------------------------------------------------------
	
	
	// UPDATE /CHANGE --------------
	public int change(Student student) {
		
		String query="update student set name=? , city=? where id=? ";
       int r = this.jdbcTemplate.update(query,student.getName(),student.getCity(),student.getId());		
		return r;
	}
	
	//--------------------------------------------------------------------------------------------------------------------
	
	
	// DELETE RECORD ------------------
	public int delete(int studentId) {
		
		String query="delete from student where id=? " ;
		int r = this.jdbcTemplate.update(query,studentId);
		return r;
	}

	//--------------------------------------------------------------------------------------------------------------------
	
	
	
	// SELECT Single student DataQuery
	
	public Student getStudent(int studentId) {
		String query="select * from student where id=?";
	
		// after creating row mapper impl class.
		
		RowMapper<Student> rowMapper= new RowMapperImpl();   // parent interface is taken as ref obj , and obj is created is of class rowmapperImpl ---same thing parent  interface can represnt the child class obj;
		
		Student student =this.jdbcTemplate.queryForObject(query,rowMapper,studentId);        // this row mapper is basically an interface which helps to convert the result set to Class objects to display them , here its class rowmapperclass will implement the method.
		return student; 
	 
      // here rowmapper inteface via rowmapperImp class helps to convert the selected data to Student type .		
	}
	
	//--------------------------------------------------------------------------------------------------------------------
	
	//SELECT ALL DATA 
	
	public List<Student> getAllStudents() {
		
		String query="select * from student";
		List<Student> students = this.jdbcTemplate.query(query, new RowMapperImpl());
		
		return students;
	}
	
	



	

}
