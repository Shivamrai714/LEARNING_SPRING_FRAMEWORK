package com.api.test.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity                       //map class to table in database
@Table(name="book")
public class Book {


	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String title;
	//private String author;
                                   //cascasde  used to reflect the changes in both tables togethoer. , whitout this postMan will not add the data otgethoer.
	@OneToOne(cascade = CascadeType.ALL)                      //from hibernate video series of Mapping 
	@JsonManagedReference
	private Author author;
    
    
	
	
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(int id, String title, Author author) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Author getAuthor() {      //return here Author
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + "]";
	}
	
	
	
}
