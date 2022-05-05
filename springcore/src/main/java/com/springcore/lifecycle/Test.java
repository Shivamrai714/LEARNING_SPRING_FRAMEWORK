package com.springcore.lifecycle;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// Error : When i try to import the dependecy of the annotaions of @postConstruct , its giveing error could not find main class

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	 
AbstractApplicationContext context = new ClassPathXmlApplicationContext("com/springcore/lifecycle/config.xml" );
context.registerShutdownHook();   //it is always required to call destroy method , either use init in arguments or by implementing interfaces.


 Samosa obj=(Samosa)context.getBean("s1");
 System.out.println(obj);
 //  THE DESTROY METHOD IS NOT CALLED NORMALLY SO WE NEED TO USE 
 // CONTEXT.PRESHUTDOWNHOOK() , USE ABSTRACTaPPLICATION CONTEXT
 
 
 System.out.println("+++++++++++++++++++++++++++++++++++");
 
 Pepsi obj2=(Pepsi)context.getBean("p1");
 System.out.println(obj2);
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 /*   Not worked for this.
 Example example = (Example) context.getBean("example");
System.out.println("  ....................  "+example+ " Failed--- Not worked through the @PostConstruct annotaions "); 
 */


 
 
 
 
	}

}
