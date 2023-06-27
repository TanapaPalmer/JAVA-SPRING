package com.codingdojo.BookClub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.BookClub.models.BookClub;
import com.codingdojo.BookClub.repositories.BookClubRepository;

@Service
public class BookClubService {

	@Autowired
	private BookClubRepository bookRepo;
	
	
//......................................................................................
	
	
	private BookClubService(BookClubRepository bookRepo) {
		
		this.bookRepo = bookRepo;
	}
	
	
//......................................................................................
	
	
	//RETRIEVES A BOOK
	
	public BookClub findById(Long id) {
		
		Optional<BookClub> result = bookRepo.findById(id);
		
		if(result.isPresent()) {
			
			return result.get();
		}
		
		return null;
	}
	
	
//......................................................................................
	

	public List<BookClub> all() {
		
		return bookRepo.findAll();
	}
	
	
//......................................................................................

	
	//CREATE A BOOK
	
	public BookClub create(BookClub book) {
		
		return bookRepo.save(book);
	}
	
	
//......................................................................................
	
	
	//UPDATE A BOOK
	
	public BookClub updateBook(BookClub book) {
		return bookRepo.save(book);
	}
		

//......................................................................................
		
	
	//DELETE A BOOK
	
	public void deleteBook(BookClub book) {
		bookRepo.delete(book);
	}
}