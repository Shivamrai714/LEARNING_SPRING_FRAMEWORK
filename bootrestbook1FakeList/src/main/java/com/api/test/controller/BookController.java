package com.api.test.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.test.entities.Book;
import com.api.test.services.BookService;


@RestController
public class BookController {

	@Autowired                // [  The use of the @Component /@Service over the class (whose obj is injected here) is to make it autowire automatically ] , otherwise  if using bean(old mehotd :spring core) then ebable this in .xml file as <context:annoation-config />
	private BookService bookService;
	
	//Too send the status code we use the ResponseEntity as the return type of getAllBooks method

//________________________________________________________________	

	@GetMapping("/books")
	public ResponseEntity<List<Book>> getbooks()
	{
		List<Book> list=bookService.getAllBooks();
		if(list.size()==0)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
	return ResponseEntity.of(Optional.of(list));	
	}
	
//________________________________________________________________	
	
	@GetMapping(value="/books/{id}")
	public ResponseEntity<Book> getBook(@PathVariable("id") int id)
	{
		Book book =bookService.getBookById(id);
	if(book == null)
	{
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	return ResponseEntity.of(Optional.of(book));
	}
	
	
	
//________________________________________________________________	
	
	
	// To add the data --> method is POST
	
	@PostMapping("/books")
	public ResponseEntity<Book> addBook(@RequestBody Book b)   //this help to add list by converting   json obj to list type abject.
	{
		Book book=null;
		try {
		book= this.bookService.addBook(b);
        System.out.println(book);
        return ResponseEntity.of(Optional.of(b));
		}catch (Exception e)
		{
e.printStackTrace();
return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		
		}
	}
	

//________________________________________________________________	

	
	//DELETE THE DATA   --> DELETE
	@DeleteMapping("/books/{bookId}")
	public  ResponseEntity<Void> deleteBook(@PathVariable("bookId") int bookId)
	{
try {
		this.bookService.deleteBook(bookId);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
}catch (Exception e) {
e.printStackTrace();	
return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
}	
	
	}	
	

//________________________________________________________________	
	
	
	//UPDATE   -->PUT method
	@PutMapping("/books/{bookId}")
	public ResponseEntity<Book> updateBook(@RequestBody Book book,  @PathVariable("bookId") int bookId)      //RequestBody is used to convert json data to object of list.
	{
		try {
	this.bookService.updateBook(book,bookId);
		return ResponseEntity.ok().body(book);
		
		}
		catch (Exception e) {
			e.printStackTrace();
return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			// TODO: handle exception
		}
	}	

	
	}
	



//________________________________________________________________	
//________________________________________________________________	
//________________________________________________________________	
//________________________________________________________________	
//________________________________________________________________	










/*
 * 
 * 
 time 3 : adding status 
 
  
  old code :: will be modified with the ResponseEntity  : to also give the Status on postMan app
  
  	@GetMapping(value="/books/{id}")
	public Book getBook(@PathVariable("id") int id)
	{
		return bookService.getBookById(id);
		
	}
  
  
 time =2 
 
 
 	@GetMapping("/books")
	public Book getbooks()
	{
		Book book = new Book();
		book.setId(1);
		book.setTitle("The Shivaji");
		book.setAuthor("Modi ji");

		return book;
	// the springboot itself convert the book object to json (suing jakson dependency )and return it using its attached dependecny
	
	*  */






/*
  
 //This was old structure of mvc , but for rest api new above structure ( @RestController ,@GetMapping ) will be followed
 Time 1: 
 
@Controller
public class BookController {

	@RequestMapping(value="/books" ,method = RequestMethod.GET)
	@ResponseBody                                            //@RestController also does the work of ResponseBody*
	public String getbooks()
	{
		return "this is testing first";
	}
	
}
*/