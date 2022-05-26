package com.aop.services;

public class PaymentServiceImpl implements PaymentService
{
	public void makePayment( int amount )
	{
		System.out.println(amount+" Amount debited____");
		
		
		
		System.out.println( amount+ "Amount creedited___");
	}

	public void makepay() {
		// TODO Auto-generated method stub
		System.out.println("Amount not mentioned :");
	}


	
}
