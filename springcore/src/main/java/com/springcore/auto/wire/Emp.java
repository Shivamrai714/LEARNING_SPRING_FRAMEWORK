package com.springcore.auto.wire;
                                 //Autowiring helps to automatically pass the ref of obj in anoother class , no need to use manual ref="" in bean class of .xml
public class Emp {

	private Address address;   //this name will be searched in autowiring , to find 
								// here the  type are String type or primitives, so Autowireing works only for Reference type objects
            
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		System.out.println("Setting Values : called in byName and byType ");
		this.address = address;
	}

	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}

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
