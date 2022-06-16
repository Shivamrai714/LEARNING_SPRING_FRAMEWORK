package com.api.test.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.api.test.entities.Book;

@Component
public class BookService {

	// here we use the fake service list, u can use the real time database for the
	// same

//________________________________________________________________	

	private static List<Book> list = new ArrayList<>();

	static {

		list.add(new Book(12, "Java Book", "Sumitra"));
		list.add(new Book(13, "one Book", "Nandan"));
		list.add(new Book(14, "World Book", "Ram"));
		list.add(new Book(15, "King Book", "Raja"));

	}

//________________________________________________________________
	
// 1  GET DATA	
	public List<Book> getAllBooks() {
		return list;
	}

// 1  GET ALL DATA	: use @GetMapping
	public Book getBookById(int id) {
		Book b = null;
		
		//Exception comes if id not found to handle using try catch ,otherwise error will come


//Using the modern funtion : to search id of Book  / or manualyy check each id and then return

		
		try {
		b = list.stream().filter(e -> e.getId() == id).findFirst().get();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

//________________________________________________________________	
	
	
	
//  2 :adding the book	: use @PostMapping
	
	
	public Book addBook(Book b) {
		list.add(b);
		return b;
	}

	
//________________________________________________________________	
	
	
	
// 3 : delete book : use @DeleteMapping

	public void deleteBook(int bid) {
		// can use for each fucntion also,  here new books are collected in list, which do not match the bid, that other are deletd form list.
//Or use single line in filter
		
	list=list.stream().filter(book->book.getId()!=bid).collect(Collectors.toList());
		
		
		/*		list=list.stream().filter(book -> {
			if (book.getId() != bid) {
				return true;
			} else {
				return false;
			}
		}).collect(Collectors.toList());
*/
	}
	
	
//________________________________________________________________	
	
	
// 4:  Book update :: use @PUTMapping
	
	public void  updateBook(Book book,int bookId)
	{
		//map fun basically check the obj and return the object.
		
		list=list.stream().map(b->{
			
			if(b.getId()==bookId)
			{
				b.setTitle(book.getTitle());
				b.setAuthor(book.getAuthor());
			}
			
			return b;
		}).collect(Collectors.toList());
		
	}		
//________________________________________________________________	

	
	
	
	
	
	

}
