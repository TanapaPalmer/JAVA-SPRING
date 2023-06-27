package com.codingdojo.BookBroker.controllers;

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


import com.codingdojo.BookBroker.models.Book;
import com.codingdojo.BookBroker.models.LoginUser;
import com.codingdojo.BookBroker.models.User;
import com.codingdojo.BookBroker.services.BookService;
import com.codingdojo.BookBroker.services.UserService;

@Controller
public class BookController {

	// ADD ONCE SERVICE IS IMPLEMENTED:
	
	@Autowired
	private UserService users;
	@Autowired
	private BookService books;
	

//**********************************************************************************************
	
    
	// ***HOMEPAGE WHICH HAS REGISTRATION FORM AND LOGIN FORM FOR ALL USERS - INDEX.JSP*** //
	
	
	// WE'RE USING GETMAPPING TO ANNOTATED METHODS HANDLE THE HTTP GET REQUESTS
    @GetMapping("/")
    public String index(Model model) {
    	
    
        // BIND EMPTY USER AND LoginUser OBJECTS TO THE JSP
        // TO CAPTURE THE FORM INPUT
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        
        
        // RETURN TO HOMEPAGE (INDEX.JSP)
        return "index.jsp";
    }
    
    
//**********************************************************************************************
    
    
	// ***NEW USERS CAN REGISTER - WITH VALIDATION METHOD*** //
    
    
	// WE'RE USING POSTMAPPING TO ANNOTATED METHODS HANDLE THE HTTP POST REQUESTS
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result,
            Model model,
            HttpSession session) {
        
    	
        // CALL A register METHOD IN THE SERVICE 
        // TO DO SOME EXTRA VALIDATIONS AND CREATE A NEW USER
    	User user = users.register(newUser, result);
    	
        
    	// IF ERRORS
        if(result.hasErrors()) {
        	
        	
            // BE SURE TO SEND IN THE EMPTY LoginUser BEFORE RE-RENDERING THE PAGE
            model.addAttribute("newLogin", new LoginUser());
            
            
            // RETURN TO HOMEPAGE (INDEX.JSP) - IF ERRORS
            return "index.jsp";
        }
        
        
        // STORE THEIR ID FROM THE DB IN SESSION - LOG IN THE USERS
        session.setAttribute("userId", user.getId());
    
        
        // RETURN TO BOOKMARKET PAGE (BOOKMARKET.JSP) - IF NO ERRORS
        return "redirect:/bookmarket";
    }
    
    
//**********************************************************************************************
    
    
  	// ***NEW USERS CAN LOGIN - WITH VALIDATION METHOD*** //
      
      
  	// WE'RE USING POSTMAPPING TO ANNOTATED METHODS HANDLE THE HTTP POST REQUESTS
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result,
            Model model,
            HttpSession session) {
        
    	
        // CALL A login METHOD IN THE SERVICE 
        // TO DO SOME EXTRA VALIDATIONS AND LOGIN A USER
        User user = users.login(newLogin, result);
    
        
        // IF ERRORS
        if(result.hasErrors()) {
        	

            // BE SURE TO SEND IN THE EMPTY User BEFORE RE-RENDERING THE PAGE
            model.addAttribute("newUser", new User());
            
            
            // RETURN TO HOMEPAGE (INDEX.JSP) - IF ERRORS
            return "index.jsp";
        }
    
        
        // STORE THEIR ID FROM THE DB IN SESSION - LOG IN THE USERS
        session.setAttribute("userId", user.getId());
    
        
        // RETURN TO BOOKMARKET PAGE (BOOKMARKET.JSP) - IF NO ERRORS
        // USER CAN LOG IN ONLY WHEN THE EMAIL AND PASSWORDS ARE VALID - ALREADY REGISTERED
        return "redirect:/bookmarket";
    }
    
 
//**********************************************************************************************
    
    
  	// ***DASHBOARD THAT SHOW ALL THE BOOKS*** //
    
    
	// WE'RE USING GETMAPPING TO ANNOTATED METHODS HANDLE THE HTTP GET REQUESTS
    @GetMapping("/bookmarket")
    public String dashboard(Model model, HttpSession session) {
    	
    	
    	if(session.getAttribute("userId") == null) {
    		
    		
            // RETURN TO HOMEPAGE (INDEX.JSP) IF USER ID IS NULL
    		return "redirect:/";
    	}
    	
    	
        // CALL AN all METHOD IN THE SERVICE 
    	model.addAttribute("books", books.allBooks());
    	
    	
        // CALL A findById METHOD IN THE SERVICE
    	model.addAttribute("user", users.findById((Long)session.getAttribute("userId")));
    	
    	
    	// RETURN TO DASHBOARD (DASHBOARD.JSP)
    	return "dashboard.jsp";
    }
    
    
//**********************************************************************************************
    
    
  	// ***USERS CAN CREATE NEW BOOKS*** //
    
    
	// WE'RE USING GETMAPPING TO ANNOTATED METHODS HANDLE THE HTTP GET REQUESTS
    @GetMapping("/newbook")
    public String newBook(@ModelAttribute("book") Book book,
    		Model model,
    		HttpSession session) {
    	
    	
        // CALL A findById METHOD IN THE SERVICE
    	User user = users.findById((Long)session.getAttribute("userId"));
    	
    	model.addAttribute("user", user);
    	
    	
    	// RETURN TO THE NEW PAGE
    	return "new.jsp";
    }
    
//**********************************************************************************************
    
    
  	// ***CREATE A NEW BOOK*** //
    
    
  	// WE'RE USING POSTMAPPING TO ANNOTATED METHODS HANDLE THE HTTP POST REQUESTS
    @PostMapping("/books")
    public String createBook(@Valid @ModelAttribute("book") Book book, BindingResult result) {

        // IF ERRORS
    	if (result.hasErrors()) {
    		
            // RETURN TO NEW PAGE - IF ERRORS - FOR THE USER TO CREATE A NEW BOOK AGAIN
    		return "new.jsp";
    	}
    	
        // CALL A create METHOD IN THE SERVICE
    	books.createBook(book);
    	
    	
        // RETURN TO BOOKMARKET PAGE (BOOKMARKET.JSP) - IF NO ERRORS
    	// USER WILL SEE ALL THE BOOKS, INCLUDING A NEW BOOK THAT THE USER JUST ADDED
    	return "redirect:/bookmarket";
    }
    
    
//**********************************************************************************************
    
    
  	// ***SHOW EACH BOOK BY ID*** //
    
    
	// WE'RE USING GETMAPPING TO ANNOTATED METHODS HANDLE THE HTTP GET REQUESTS
    @GetMapping("/books/{id}")
    public String showPage(Model model, @PathVariable("id") Long id, HttpSession session) {
    	
    	
    	if(session.getAttribute("userId") == null) {
    		
    		
            // RETURN TO HOMEPAGE (INDEX.JSP) IF USER ID IS NULL
    		return "redirect:/";
    		
    	}
    	
    	
        // CALL A findById METHOD IN THE SERVICE
    	Book book = books.findById(id);
    	
    	
    	model.addAttribute("book", book);
    	
    	
        // CALL A findById METHOD IN THE SERVICE
    	model.addAttribute("user", users.findById((Long)session.getAttribute("userId")));
    	
    	
        // RETURN TO SHOWBOOK PAGE (SHOWBOOK.JSP)
    	return "showbook.jsp";
    }
    
    
    
//**********************************************************************************************
    
    
  	// ***USER CAN LOGOUT*** //
    
    
	// WE'RE USING GETMAPPING TO ANNOTATED METHODS HANDLE THE HTTP GET REQUESTS
    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	
    	
    	session.invalidate();
    	
        // RETURN TO HOMEPAGE (INDEX.JSP) - FOR THE USER TO BE ABLE TO LOGIN AGAIN
    	return "redirect:/";
    }
    
    
//**********************************************************************************************
    
    
  	// ***USER CAN EDIT A BOOK BY ID**** //
    
    
	// WE'RE USING GETMAPPING TO ANNOTATED METHODS HANDLE THE HTTP GET REQUESTS
    @GetMapping("/books/{id}/edit")
    public String editBook(Model model, @PathVariable("id") Long id, HttpSession session) {
    	
    	
    	if(session.getAttribute("userId") == null) {
    		
    		
            // RETURN TO HOMEPAGE (INDEX.JSP) IF USER ID IS NULL
    		return "redirect:/";
    	}
    	
        // CALL A findById METHOD IN THE SERVICE
    	Book book = books.findById(id);
    	
    	
    	model.addAttribute("book", book);
    	
    	
        // CALL A findById METHOD IN THE SERVICE
    	model.addAttribute("user", users.findById((Long)session.getAttribute("userId")));
    	
    	
    	return "edit.jsp";
    }
    
    
//**********************************************************************************************
    
    
  	// ***USER UPDATE A BOOK BY ID**** //
    
    
	// WE'RE USING POSTMAPPING TO ANNOTATED METHODS HANDLE THE HTTP POST REQUESTS
    @PostMapping("/books/{id}/update")
    public String updateBook(Model model, @Valid @ModelAttribute("book") Book book,
    		BindingResult result,
    		HttpSession session) {
    	
    	
    	if(session.getAttribute("userId") == null) {
    		
    		
            // RETURN TO HOMEPAGE (INDEX.JSP) IF USER ID IS NULL
    		return "redirect:/";
    	}
    	
    	// IF ERROR
    	if(result.hasErrors()) {
    		
    		
            // RETURN TO EDIT PAGE (EDIT.JSP) - IF ERRORS - FOR THE USER TO EDIT AND UPDATE A BOOK AGAIN
    		return "edit.jsp";
    	}
    	
        // CALL AN update METHOD IN THE SERVICE
    	books.updateBook(book);
    	
    	
        // RETURN TO BOOKMARKET PAGE (BOOKMARKET.JSP) - AFTER DELETING THE BOOK
    	return "redirect:/bookmarket";
    }
    
    
//**********************************************************************************************
    
    
  	// ***USER CAN DELETE A BOOK BY ID*** //
    
	// WE'RE USING GETMAPPING TO ANNOTATED METHODS HANDLE THE HTTP GET REQUESTS
    @GetMapping("/books/{id}/delete")
    public String deleteBook(@PathVariable("id") Long id, HttpSession session) {
    	
    	if(session.getAttribute("userId") == null) {
    		
    		
            // RETURN TO HOMEPAGE (INDEX.JSP) IF USER ID IS NULL
    		return "redirect:/";
    	}
    	
    	
        // CALL A findById METHOD IN THE SERVICE
    	Book book = books.findById(id);
    	
    	
        // CALL A delete METHOD IN THE SERVICE
    	books.deleteBook(book);
    	
    	
        // RETURN TO BOOKMARKET PAGE (BOOKMARKET.JSP) - AFTER DELETING THE BOOK
    	return "redirect:/bookmarket";
    }
    
    
//**********************************************************************************************
    
    
  	// ***USERS CAN BORROW THE BOOK - ONLY WHEN THE BOOKS ARE NOT BELONG TO THAT USERS*** //
    
	// WE'RE USING GETMAPPING TO ANNOTATED METHODS HANDLE THE HTTP GET REQUESTS
    @GetMapping("/books/{id}/borrow")
    public String borrowBook(@PathVariable("id") Long id, HttpSession session) {
    	
    	
    	if(session.getAttribute("userId") == null) {
    		
    		
            // RETURN TO HOMEPAGE (INDEX.JSP) IF USER ID IS NULL
    		return "redirect:/";
    		
    	}
    	
    	
        // CALL A findById METHOD IN THE SERVICE
    	Book book = books.findById(id);
    	
    	
        // CALL A setBorrower METHOD IN THE SERVICE
    	book.setBorrower(users.findById((Long)session.getAttribute("userId")));
    	
    	
        // CALL AN update METHOD IN THE SERVICE
    	books.updateBook(book);
    	
    	
        // RETURN TO BOOKMARKET PAGE (BOOKMARKET.JSP) - AFTER BORROWING THE BOOK
    	return "redirect:/bookmarket";
    }
    
    
//**********************************************************************************************
    
    
  	// ***USERS CAN RETURN THE BOOK - ONLY WHEN THE USER HAS ALREADY BORROW THE BOOK*** //
    
    
	// WE'RE USING GETMAPPING TO ANNOTATED METHODS HANDLE THE HTTP GET REQUESTS
    @GetMapping("/books/{id}/return")
    public String returnBook(@PathVariable("id") Long id, HttpSession session) {
    	
    	
    	if(session.getAttribute("userId") == null) {
    		
    		
            // RETURN TO HOMEPAGE (INDEX.JSP) IF USER ID IS NULL
    		return "redirect:/";
    	}
    	
    	
        // CALL A findById METHOD IN THE SERVICE
    	Book book = books.findById(id);
    	
    	
        // CALL A setBorrower METHOD IN THE SERVICE
    	book.setBorrower(null);
    	
    	
        // CALL AN update METHOD IN THE SERVICE
    	books.updateBook(book);
    	
    	
        // RETURN TO BOOKMARKET PAGE (BOOKMARKET.JSP) - AFTER RETURNING THE BOOK
    	return "redirect:/bookmarket";
    }
    
}