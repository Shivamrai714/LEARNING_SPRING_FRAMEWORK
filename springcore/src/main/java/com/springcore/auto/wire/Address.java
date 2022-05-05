package com.springcore.auto.wire;

public class Address {
	
	// here the  type are String type or primitives, so Autowireing works only for Reference type objects

private String street;
private String city;


public String getStreet() {
	return street;
}
public void setStreet(String street) {
	this.street = street;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}

@Override
public String toString() {
	return "Address [street=" + street + ", city=" + city + "]";
}

	
}
