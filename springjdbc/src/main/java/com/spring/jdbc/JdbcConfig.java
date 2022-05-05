
package com.spring.jdbc;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.dao.StudentDaoImpl;

// Basically this class is being designed to replace the working of the xml file.
//Here @Configuration is used to specify that its is for working like xml
//Using @Bean Notatition for classes beans creatation so that SPRING container can make the objects of classes.


// If we have this config.java file then we can delete the xml file .............


@Configuration
public class JdbcConfig {

	@Bean( name={"ds"})
	public DataSource getDataSource()      // we can also use DataSource inplace of DriverManager as its parent class
	{
	  DriverManagerDataSource ds = new DriverManagerDataSource();
	  ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
	  ds.setUrl("jdbc:mysql://localhost:3306/springjdbc");
	  ds.setUsername("root");
	  ds.setPassword("root");

	    
      return ds;	
      
	}
	
	@Bean(  name={"JdbcTemplate"})           //Or use @Bean("JdbcTemplate")
	public JdbcTemplate getTemplate()
	{
		JdbcTemplate jdbcTemplate= new JdbcTemplate();
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate;
		
	}
	
	@Bean(name={"studentDao"})
	public StudentDao getStudentDao()
	{
        StudentDaoImpl studentDao= new StudentDaoImpl();         //Obj of class StudentDaoImp is made
     	studentDao.setJdbcTemplate(getTemplate());
    
return studentDao;		
	}



}
