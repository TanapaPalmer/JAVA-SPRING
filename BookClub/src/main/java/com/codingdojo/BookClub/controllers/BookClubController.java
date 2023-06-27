package com.codingdojo.BookClub.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.BookClub.models.BookClub;
import com.codingdojo.BookClub.models.LoginUser;
import com.codingdojo.BookClub.models.User;
import com.codingdojo.BookClub.services.BookClubService;
import com.codingdojo.BookClub.services.UserService;

@Controller
public class BookClubController {
 
	 @Autowired
	 private UserService users;
	 @Autowired
	 private BookClubService books;

	 
//......................................................................................
	 
	 
	 //HOMEPAGE WHICH HAS REGISTRATION FORM AND LOGIN FORM FOR ALL USERS - INDEX.JSP
	 
	 @GetMapping("/")
	 public String index(Model model) {
	 
	     model.addAttribute("newUser", new User());
	     
	     model.addAttribute("newLogin", new LoginUser());
	     
	     return "index.jsp";
	 }


//......................................................................................

	 
	 //NEW USERS CAN REGISTER - WITH VALIDATION METHOD
	 
	 @PostMapping("/register")
	 public String register(
			 @Valid
			 @ModelAttribute("newUser") User newUser,
	         BindingResult result,
	         Model model,
	         HttpSession session) {
	     
	     users.register(newUser, result);
	     
	     if(result.hasErrors()) {
	    	 
	         model.addAttribute("newLogin", new LoginUser());
	         
	         return "index.jsp";
	     }
	     
	     session.setAttribute("userId", newUser.getId());
	 
	     return "redirect:/books";
	 }
	 
	 
//......................................................................................
	
	 
	 //USERS (THAT HAS ALREADY BEEN REGISTERED) CAN LOGIN - WITH VALIDATION METHOD
	 
	 @PostMapping("/login")
	 public String login(
			 @Valid
			 @ModelAttribute("newLogin") LoginUser newLogin, 
	         BindingResult result,
	         Model model,
	         HttpSession session) {
	     
	     User user = users.login(newLogin, result);
	 
	     if(result.hasErrors()) {
	    	 
	         model.addAttribute("newUser", new User());
	         
	         return "index.jsp";
	     }
	 
	     session.setAttribute("userId", user.getId());
	 
	     return "redirect:/books";
	 }
	 
	 
//......................................................................................
	 
	 
	 //ONCE USERS IS REGISTERED OR LOGIN, USERS CAN LOGOUT 
	 
	 @GetMapping("/logout")
	 public String logout(HttpSession session) {
		 
		 session.setAttribute("userId", null);
		 
		 return "redirect:/";
	 }
	 
	 
//......................................................................................
		
	 
	//CREATE A NEW BOOK
	 
	@PostMapping("/newbook")
	public String createBook(@Valid @ModelAttribute("book") BookClub book, BindingResult result) {

	    if (result.hasErrors()) {
	    	
	    	return "new.jsp";
	    }
	    	
	    books.create(book);
	    	
	return "redirect:/books";
	}
	
	
//......................................................................................
	
	
	//SHOW EACH BOOK BY ID
	
	@GetMapping("/books/{id}")
	public String showPage(Model model, @PathVariable("id") Long id, HttpSession session) {
		
		if(session.getAttribute("userId") == null) {
			
	    	return "redirect:/";
	    }
		
	    BookClub book = books.findById(id);
	    
	    model.addAttribute("book", book);
	   	    
	    model.addAttribute("user", users.findById((Long)session.getAttribute("userId")));
	    	
	    return "show.jsp";
	}
	
	
//......................................................................................

	
	//DASHBOARD THAT SHOW ALL THE BOOKS
	
    @GetMapping("/books")
    public String dashboard(Model model, HttpSession session) {
    	
    	if(session.getAttribute("userId") == null) {
    		
    		return "redirect:/";
    	}
    	
    	model.addAttribute("books", books.all());
    	
    	model.addAttribute("user", users.findById((Long)session.getAttribute("userId")));
    	
    	return "dashboard.jsp";
    }
    
    
    

//......................................................................................

    
    //BRINGING THE USERS TO THE ADDING NEW BOOK PAGE
    
    @GetMapping("/books/new")
    public String addPage(@ModelAttribute("book") BookClub book, Model model, HttpSession session) {
    	
    	User user = users.findById((Long)session.getAttribute("userId"));
    	
    	model.addAttribute("user", user);
    	
    	return "new.jsp";
    }
    
    
//......................................................................................
    
    
	//EDIT BOOK	
    
    @GetMapping("/books/{id}/edit")
    public String editBook(Model model, @PathVariable("id") Long id, HttpSession session) {
    	
    	if(session.getAttribute("userId") == null) {
    		
    		return "redirect:/";
    	}
    	
    	BookClub book = books.findById(id);
    	
    	model.addAttribute("book", book);
    	
    	model.addAttribute("user", users.findById((Long)session.getAttribute("userId")));
    	
    	return "edit.jsp";
    }

    
 //......................................................................................
	
    
	//UPDATE BOOK
    
	@PostMapping("/books/{id}/update")
	public String updateBook(@Valid @ModelAttribute("book") BookClub book,
			BindingResult result,
			@PathVariable("id") Long id,
			Model model) {
		
		if(result.hasErrors()) {
			
		model.addAttribute("book", book);
		
		return "edit.jsp";
	}
		
	books.updateBook(book);
	
	return "redirect:/books";
	}
	
	
//......................................................................................
	
	
	//DELETE BOOK
	
	@RequestMapping("/books/{id}/delete")
	public String deleteBook(@PathVariable("id") Long id) {
		BookClub book = books.findById(id);
		books.deleteBook(book);
		return "redirect:/books";
	}
}
