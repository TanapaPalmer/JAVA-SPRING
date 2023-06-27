package com.codingdojo.Counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CounterController {
	
	@RequestMapping("/")
	public String index(HttpSession session) {
		int count = 0;
		int countbytwo = 0;
		
		if(session.getAttribute("count") == null) {
			session.setAttribute("count", 1);
			
		}else {
			count = (Integer) session.getAttribute("count");
			count++;
			session.setAttribute("count", count);
		}
		
		if(session.getAttribute("countbytwo") == null) {
			session.setAttribute("countbytwo", 2);
			
		}else {
			countbytwo = (Integer) session.getAttribute("countbytwo");
			countbytwo++;
			session.setAttribute("countbytwo", countbytwo+=1);
		}		
		
		return "index.jsp";
	}
	
	
	@RequestMapping("/counter")
	public String counter() {
		return "counter.jsp";
	}

	@RequestMapping("/countbytwo")
	public String twocounts() {
		return "countbytwo.jsp";
	}
	
	@RequestMapping("/reset")
	public String reset(HttpSession session) {
		session.invalidate();
		return "redirect:/counter";
	}	
	
	@RequestMapping("/resetbonus")
	public String resetbonus(HttpSession session) {
		session.invalidate();
		return "redirect:/countbytwo";
		
	}
}