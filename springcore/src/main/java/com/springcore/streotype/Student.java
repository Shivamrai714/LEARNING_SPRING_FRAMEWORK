package com.springcore.streotype;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("ob")         //streotyoe annotations  //also can give obj name here @Component("ob") then no need to take camel case obj in test.java, also if ("") not given then use Camel case to use getBean()
@Scope("prototype")
public class Student 
{  
	@Value("Shivam")
	private String studName;
	@Value("Lucknow")
	private String city;
	
	@Value("#{temp}")
	private List<String> addresses;      //To insert the list / collection type using annotaion 1. make the standalone coll. in .xml -> then use @value in .java file
	

	
	
	public List<String> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<String> addresses) {
		this.addresses = addresses;
	}
	public String getStudName() {
		return studName;
	}
	public void setStudName(String studName) {
		this.studName = studName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	@Override
	public String toString() {
		return "Student [studName=" + studName + ", city=" + city + "]";
	}
	
	

}
