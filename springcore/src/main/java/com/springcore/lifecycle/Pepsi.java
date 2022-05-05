package com.springcore.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

// Here we are going to look interfaces , to use init and destroy method.
//Just declare bean /class in xml file and here implements the interface , 
// and click on pepsi to include their method 
public class Pepsi implements InitializingBean , DisposableBean
{
	private int price;

	public Pepsi() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		System.out.println("Setting the prop of Pepsi : ");
		this.price = price;
	}

	@Override
	public String toString() {
		return "Pepsi [price=" + price + "]";
	}

	public void afterPropertiesSet() throws Exception {
	// Fom interfACE DECLARED
		
		System.out.println(" Init Methiod Pepsi: using interface Initializaiton bean");
	}
	
	
	public void destroy() throws Exception {
// From the interface declared		
		System.out.println(" Destroy Methiod Pepsi: using interface Disposable bean");
			
		
	}

	

	
}
