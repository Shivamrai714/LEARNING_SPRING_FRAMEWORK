//      ERROR:            THIS HAS NOT BE COMPLETED BEACUSE NOT ABLE TO PUT THE DEPENDENCIES TO .POM FILE  FOR POST CONSTRUCTOR 


package com.springcore.lifecycle;

//not supported these two :
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Example {
	
private String subject;

public String getSubject() {
	return subject;
}

public void setSubject(String subject) {
	this.subject = subject;
}

public Example() {
	super();
	// TODO Auto-generated constructor stub
}

@Override
public String toString() {
	return "Example [subject=" + subject + "]";
}
/////////////////////////////////////////////////////////////////////

@PostConstruct
public void start()
{System.out.println("starting method");}
@PreDestroy
public void end()
{System.out.println("ending method");}



}


/*   .pom file not supported this.
<!--  This annotaions dependcy is included to use @preconstructed in implementing the Bean lifecycle using annotaions 
And then update the project sprincore ->maven ->update project.
Currently its givig me error : after including this it shows Nomain class found test.   

<dependency>
<groupId>javax.annotation</groupId>
<artifactId>javax.annotation-api</artifactId>
<version>1.3.2</version>
</dependency>

//not WORKING                THIS HAS NOT BE COMPLETED BEACUSE NOT ABLE TO PUT THE DEPENDENCIES TO .POM FILE  FOR POST CONSTRUCTOR 

-->
*/