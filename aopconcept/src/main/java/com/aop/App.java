package com.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aop.services.PaymentService;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World! .. This is normal application running called as joint point" );
      ApplicationContext context= new ClassPathXmlApplicationContext("com/aop/config.xml");
       PaymentService paymentObject=context.getBean("payment",PaymentService.class);
      
       //before validation/authenticating without modifing 
       
       
       
       //paymentObject.makePayment();
       paymentObject.makePayment(123);
       
       paymentObject.makepay();
    }
}
