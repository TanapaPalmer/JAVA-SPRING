package com.codingdojo.BookBroker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.BookBroker.models.Book;
import com.codingdojo.BookBroker.repositories.BookRepository;

@Service
public class BookService {

	
	@Autowired
	private BookRepository bookRepo;
	
	
//**********************************************************************************************

	
	private BookService(BookRepository bookRepo) {
		
		this.bookRepo = bookRepo;
		
	}


//**********************************************************************************************

    //METHOD SHOULD MATCH IN THE CONTROLLER FILE BECAUSE IT WILL BE CALLED FROM THE CONTROLLER
	//RETRIEVES A BOOK
	
	public Book findById(Long id) {

		Optional<Book> result = bookRepo.findById(id);
		
		if(result.isPresent()) {
			
			return result.get();
			
		}
		
		return null;
		
	}
	
	
//**********************************************************************************************

    //METHOD SHOULD MATCH IN THE CONTROLLER FILE BECAUSE IT WILL BE CALLED FROM THE CONTROLLER
	//RETRIEVE BOOKS
	
	public List<Book> allBooks() {
		
		return bookRepo.findAll();
		
	}
	
	
//**********************************************************************************************

    //METHOD SHOULD MATCH IN THE CONTROLLER FILE BECAUSE IT WILL BE CALLED FROM THE CONTROLLER
	//UPDATE A BOOK
	
	public Book updateBook(Book book) {
		
		return bookRepo.save(book);
		
	}
	
	
//**********************************************************************************************
	
    //METHOD SHOULD MATCH IN THE CONTROLLER FILE BECAUSE IT WILL BE CALLED FROM THE CONTROLLER
	//CREATE A BOOK
	
	public Book createBook(Book book) {
		
		return bookRepo.save(book);
		
	}
	
	
//**********************************************************************************************

    //METHOD SHOULD MATCH IN THE CONTROLLER FILE BECAUSE IT WILL BE CALLED FROM THE CONTROLLER
	//DELETE A BOOK
	
	public void deleteBook(Book book) {
		
		bookRepo.delete(book);
		
	}
}
