package com.jpa.test.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.jpa.test.Entities.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	//to enable all functions of DAO / database need to *extends interface CrudRepository<User, Integer>
	//since both are interfaces.
	
	
//Video 12-13 inbuit crud opertions ,in main class of this project	
	
//*************************************************************/

	
//Video 14 	  
	
	//CUSTOM FINDER METHODS / Derived Query Methods 
	
//Using predefined pattern expression to make same method 		
	public List<User> findByName(String name);
	//"findByName" ---->  find is  introducer  here // ByName  is ->property  to be seached	
	
	public List<User> findByNameOrCity(String name,String city);
//	Various other CombinationOf Method can be made here look internet , just declare in intreface , make sure u make mehtod of your available fields(eg name, city) only
	//use https://docs.spring.io/spring-data/jpa/docs/current/refernce/html/#referce website

//other u can use
	
//findByNameStartingWith(String prefix);     //u can only change fiels "Name" , but not the predifined structure
//findByNameContaining(String words);
//findByNameLike(String likepattern);	
//findByAgeLessThan(int age)
//findByAgeGreaterThanEqual(int age)
//findByAgeIn(Collection<Integer> ages)
//findByNameOrderByName(String name)	

//*************************************************************/

	
	//VIDEO 15 :
	//USNIG Use JPQL ,language of query
	
@Query("select u FROM User u")	
public List<User> getAllUsers();	

@Query("select u From User u WHERE u.name=:n or u.city=:t")                      //@Param is used to bind parameter (n)to varible of query
public List<User>getUserByName(@Param("n")  String name , @Param("t") String city);

//USing native query of sql

@Query(  value="select * from user" , nativeQuery = true)
public List<User> getUsers();


	
}
