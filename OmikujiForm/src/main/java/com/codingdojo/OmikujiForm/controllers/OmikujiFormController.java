package com.codingdojo.OmikujiForm.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class OmikujiFormController {
	
	
	@GetMapping("/")
	public String home() {
		return "redirect:/omikuji";
	}
	
	@GetMapping("/omikuji")
	public String index() {
		return "index.jsp";
	}
	
	@GetMapping("/omikuji/show")
	public String show(HttpSession session, Model model) {
		String result = (String)session.getAttribute("Submitted");
		model.addAttribute("result", result);
		return "show.jsp";
	}
	
	@PostMapping("/submitForm")
	public String submitting(
			@RequestParam("number") int number,
			@RequestParam("city") String city,
			@RequestParam("person") String person,
			@RequestParam("hobby") String hobby,
			@RequestParam("livingthing") String livingthing,
			@RequestParam("saysomething") String saysomething,
			HttpSession session
			) {
		String Submitted = String.format("In %s years you will live in %s as your roomate, %s. The next time you see a %s, you will have good luck. Also, %s.", number, city, person, hobby, livingthing, saysomething);
		session.setAttribute("Submitted", Submitted);
		return "redirect:/omikuji/show";
	}
}