package com.codingdojo.mvc.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.mvc.models.Book;
import com.codingdojo.mvc.services.BookService;

@RestController
public class BooksAPI {
		
	private final BookService bookService;
	
	public BooksAPI(BookService bookService) {
		this.bookService = bookService;
	}
	
	@RequestMapping("/api/books")
    public List<Book> index() {
        return bookService.allBooks();
    }
	
//---------------------------------------------------------------------------------	
	
    //CREATING THE BOOK
    @RequestMapping(value="/api/books", method=RequestMethod.POST)
    public Book create(
    		
    		@RequestParam(value="title") String title,
    		@RequestParam(value="description") String description,
    		@RequestParam(value="language") String lang,
    		@RequestParam(value="pages") Integer numOfPages) {
    	
        Book book = new Book(title, description, lang, numOfPages);
        
        //"createBook" SHOULD MATCH IN BookService!        
        return bookService.createBook(book);
    }

//---------------------------------------------------------------------------------	
    
    //SHOW THE BOOK BY ID    
    @RequestMapping("/api/books/{id}")
    public Book show(@PathVariable("id") Long id) {
        Book book = bookService.findBook(id);
        return book;
    }
    
//---------------------------------------------------------------------------------	
    
    //UPDATING THE BOOK
    @RequestMapping(value="/api/books/{id}", method=RequestMethod.PUT)
    public Book update(
    		@PathVariable("id") Long id, 
    		@RequestParam(value="title") String title, 
    		@RequestParam(value="description") String description, 
    		@RequestParam(value="language") String lang,
    		@RequestParam(value="pages") Integer numOfPages) {
    	
        Book book = new Book(title, description, lang, numOfPages);
        book.setId(id);
        
        //"updateBook" SHOULD MATCH IN BookService!
        book = bookService.updateBook(book);
        return book;
    }
    
//---------------------------------------------------------------------------------	
    
    //DELETING THE BOOK BY ID
    @RequestMapping(value="/api/books/{id}", method=RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
    	
        //"deleteBook" SHOULD MATCH IN BookService!
        bookService.deleteBook(id);
    }
	
}
