package com.springcore.ci;

import java.util.List;

//  ci -> constuctor injection , no need to use getter and setter now .

public class Person 
{
	private String name;
	private int personId;
	private Certi certi;       // person depend on certifate class , so declare it in xml file 
	private List<String> list;
	
	Person(String name, int personId ,Certi certi, List<String> list )
	{
		this.name=name;
		this.personId=personId;
		this.certi=certi;
		this.list=list;
	}

	@Override
	public String toString() 
	{
		return this.name+" -> "+ this.personId +" -- {" +this.certi.name +"}" + " ::: { " +this.list +" }  ";
	}

	
}
