package com.jpa.test;

import java.util.List;

import javax.management.Query;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.jpa.test.Entities.User;
import com.jpa.test.dao.UserRepository;

@SpringBootApplication
public class BootjpaexampleApplication {

	public static void main(String[] args) {
		ApplicationContext context  = SpringApplication.run(BootjpaexampleApplication.class, args);   //normal rum method return the context obj
	    UserRepository userRepository=context.getBean(UserRepository.class);                   //get bean of user Repository interface

	  User user1= new User(121,"Shivam","Bhopal","Programmer");
	//   User resuser1 = userRepository.save(user1);                       //inbuilt method to save in database of "CRUD Repository interface"
	 // System.out.println(resuser1);
	  
	  
	
	  //CREATE  : 
	  
	  User user3= new User();
	  user3.setName("Shakshi");user3.setCity("Ahmedabad");user3.setStatus("ips");     //id will be automatically generated.
    // User resUser = userRepository.save(user3 );
	 // System.out.println(resUser ); 
	
	  User user4= new User();
	  user4.setName("Shantanu");user4.setCity("Ahmadpur");user4.setStatus("ips dsp");
    // User resUser4 = userRepository.save(user4 );
	 // System.out.println(resUser4 ); 
	  
	  // make a list using technique
	  
	  
// 1 .CREATE AND SAVE ALL TOGETHER OBJECTS using List.of
	
	  /*
	  List<User>users =List.of(user1,user3,user4);                        // fun is above version of java 9
	 Iterable<User> result = userRepository.saveAll(users);
	  
	  result.forEach(user->{
		  System.out.println(user);
		  });
	
	
	*/
	  
//2. UPDATE  TOGETHER	 ;// if id not present then handle in try catch block  

	  /*
	  Optional<User> optional = userRepository.findById(17);            //**** Return the OPTIONAL : when use findById , then collect the Object useing get
	  User user = optional.get();
	  
	  user.setName("Brillant Sakshi ");
	  User res = userRepository.save(user);
	  
	  System.out.println(res);
	
	  */
	  
//3 .GET THE DATA    : findById()   , findALL()
	       
	  
	  // 1.--> findById(id),  --> gives the Optional so get it.  (Refer impl in update section above)
	 
	     // 2. --> User iterable  for findAll() function and  --> use   lambda fun / .forEach() / or use iterator to print the colletions 
	   
	
	  /* 
	  Iterable<User> itr= userRepository.findAll();                     //findAll()   return the iterable , so iterate it and print them.
	 
//A).simple itr printing in java
	  
	  Iterator<User> tempitr = itr.iterator();
	  while(tempitr.hasNext())
	  {
		  User user2= tempitr.next();
		  System.out.println(user2);
	  }
	  */
	  
	 
//B). Or use itr.forEach method , in form of Consumer anonmous class (not used much)
	 
	  /* 
	  Iterable<User> iterable = userRepository.findAll();
	  iterable.forEach(new Consumer<User>() {

		@Override
		public void accept(User t) {
			
			System.out.println(t);
		}
		  
	  });
	  
	  */
	  
	  // /C).Easiest method is to use the lambda function  ***************$$$$$$$$$$$$$$$$$$$$%%%%%%%%%%%%%
	/*
	  
      Iterable<User> itr = userRepository.findAll();
	  itr.forEach(user->{System.out.println(user);});
	  
	 */ 
	  
	  
	  
	  
	  
	  
	  
	  
	  
//  4. DELETE :     deleteById(), deleteAll()   
	  
	  
	  /*
	  userRepository.deleteById(18);
      System.out.println("Deleted");	  
	  */
	  
	  System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");

	  /////////////////////////////
	  
	  
	  
	  
	  
	  
	  
	  
	  
//Video 14
	  
	  
//CUSTOM FINDER METHODS / Derived Query Methods   : Need to declare them in UserRepository interface first;
	  
	  
//No need to write the query , just give the proper name "as short form of query  eg findByName()"	
	  //JUSt make the method in inteface and use here in main class
	  
	  
	  /*
	  List<User> users = userRepository.findByName("Shivam");
	 
	  users.forEach(u->{System.out.println(u);});
	  */
	 /*
	  List<User> user = userRepository.findByNameOrCity("Shakshi","Bhopal");          //other methods also refer video for website link by drugesh  //use https://docs.spring.io/spring-data/jpa/docs/current/refernce/html/#referce website

	  user.forEach(u->{System.out.println(u);});
	  */
	  
	System.out.println("_________________________________");
    System.out.println();
	
	
	
	///////////////////////////////////////////////
	
//	Video 15
    
//Making our own query
	//-> a) Use JPQL (JAVA PERSISTENT QUERY) LANg (same as hibernate query lan) 
	//->  b).	NAtive SQL Query  
//	  Need to use @Query
	  
	
	List<User> allUsers = userRepository.getAllUsers();
	allUsers.forEach(usr -> {System.out.println(usr);});  
	  
	  System.out.println("++++++++++++++++++++++++++\n\n");
	  
	  List<User> userByName = userRepository.getUserByName("Shantanu" , "Bhopal");
	  userByName.forEach(tt->{
		  System.out.println(tt);
		  });
	 
	  System.out.println("++++++++++++++++++++++++++\n\n");
	  System.out.println("\n using native sql  \n");
	  
	  userRepository.getAllUsers().forEach(temp->{System.out.println(temp);});
	  
	  
	  
	  
	  
	  
	  
	  
System.out.println();
System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
System.out.println();

	}
	
	

}
