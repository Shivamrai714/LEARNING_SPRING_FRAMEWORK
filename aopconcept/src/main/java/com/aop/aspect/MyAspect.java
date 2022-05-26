package com.aop.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyAspect {

	// give pointcut expression   //* represent all return type will run 
	
	@Before("execution(* com.aop.services.PaymentServiceImpl.makePayment(..))")
	public void printBefore()
	{
		System.out.println("Payment started...");
	}
	
	
	
	@After("execution(* com.aop.services.PaymentServiceImpl.makePayment(..))")
	public void printAfter()
	{
		System.out.println("Payment done...");
	}
	
	@After("execution(* com.aop.services.PaymentServiceImpl.makePayment())")
	public void printlast()
	{
		System.out.println("Lastly no maount");
		
		
	}
	
}
