package com.api.test.dao;

import org.springframework.data.repository.CrudRepository;

import com.api.test.entities.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {

	public Book findById(int id);
	
	
	
	
}

































// This interface does not have any inside methods when using fake arrayList.