package com.springcore.spel;

import org.springframework.expression.Expression;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class Test 
{
	public static void main(String args[]) {
  ApplicationContext con = new ClassPathXmlApplicationContext("com/springcore/spel/spelconfig.xml");
   Demo d1= con.getBean("demo", Demo.class );
  System.out.println(d1);
  
  // Or can use this way to pass values
  SpelExpressionParser temo = new SpelExpressionParser();
Expression expression=temo.parseExpression("99+1");
  System.out.println(expression.getValue());
  
  
	}
}
