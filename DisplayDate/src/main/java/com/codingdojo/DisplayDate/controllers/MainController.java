package com.codingdojo.DisplayDate.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	@GetMapping("/")
	public String home() {
		return "index.jsp";
	}
	
	@GetMapping("/date")
	public String date(Model model) {
		SimpleDateFormat dateformat = new SimpleDateFormat("EEEE, MMM d, yyyy");
		
		Date date = new Date();
		
		model.addAttribute("date", dateformat.format(date));
		
		return "date.jsp";
	}
	
	@GetMapping("/time")
	public String time(Model model) {
		SimpleDateFormat timeformat = new SimpleDateFormat("h:mm a");
		
		Date date = new Date();
		
		model.addAttribute("time", timeformat.format(date));
		
		return "time.jsp";
	}
}
