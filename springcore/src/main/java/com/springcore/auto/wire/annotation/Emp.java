package com.springcore.auto.wire.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Emp {
          @Autowired      //This autowired can be used at also before #setter method, #before constructot
	@Qualifier("address")     //When multiple bean are present use this to show the name of bean
   private Address address;   //this name will be searched in autowiring , to find 

	public Address getAddress() {
		return address;
	}
	// @Autowired  -can be used here also to link obj of Address in Emp
	public void setAddress(Address address) {
		System.out.println("Setting Values : called in byName and byType ");
		this.address = address;
	}

	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}

	// @Autowired  -can be used here also to link obj of Address in Emp
	public Emp(Address address) {
		super();
		this.address = address;
		System.out.println("Constructor is called if used constructor");
	}

	@Override
	public String toString() {
		return "Emp [address=" + address + "]";
	}
	
	
	
}
