package com.springcore.collections;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String args[]) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/springcore/collections/collectionconfig.xml");

		Emp obj1 = (Emp) context.getBean("emp1");

		System.out.println(obj1.getName());
		System.out.println(obj1.getPhones());
		System.out.println(obj1.getAddresses());
		System.out.println(obj1.getCourses());
        System.out.println(obj1.getProps());
	}

}