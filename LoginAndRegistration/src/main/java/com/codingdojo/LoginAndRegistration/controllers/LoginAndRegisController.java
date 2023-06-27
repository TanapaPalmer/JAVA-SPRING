package com.codingdojo.LoginAndRegistration.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.LoginAndRegistration.models.LoginUser;
import com.codingdojo.LoginAndRegistration.models.User;
import com.codingdojo.LoginAndRegistration.services.UserService;

@Controller
public class LoginAndRegisController {
	
	 @Autowired
	 private UserService userService;
	 
	 
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
	     
	     userService.register(newUser, result);
	     
	     if(result.hasErrors()) {
	    	 
	         model.addAttribute("newLogin", new LoginUser());
	         
	         return "index.jsp";
	     }
	     
	     session.setAttribute("userId", newUser.getId());
	 
	     return "redirect:/welcome";
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
	     
	     User user = userService.login(newLogin, result);
	 
	     if(result.hasErrors()) {
	    	 
	         model.addAttribute("newUser", new User());
	         
	         return "index.jsp";
	     }
	 
	     session.setAttribute("userId", user.getId());
	 
	     return "redirect:/welcome";
	 }
	 
	 
//......................................................................................
	 
	 
	 //ONCE USERS IS REGISTERED, USERS CAN LOGOUT 
	 
	 @GetMapping("/logout")
	 public String logout(HttpSession session) {
		 
		 session.setAttribute("userId", null);
		 
		 return "redirect:/";
	 }
	 
	 
//......................................................................................
	 
	 
	 //ONCE USERS IS REGISTERED OR LOGIN (COMPLETELY), USERS WILL REDIRECT TO DASHBOARD PAGE
	 
	 @GetMapping("/welcome")
	 public String welcome(
			 Model model,
			 HttpSession session) {
		 
		 Long userId = (Long) session.getAttribute("userId");
		 
		 if(userId==null) {
			 
			 return "redirect:/";
		 }
		 
		 User user = userService.findById(userId);
		 
		 model.addAttribute("user",user);
		 
		 return "dashboard.jsp";
	 }
}