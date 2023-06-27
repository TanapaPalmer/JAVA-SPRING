package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
@Controller
public class TestProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestProjectApplication.class, args);
	}

	@GetMapping("/")
	public String rGreet() {
		return "demo.jsp";
	}
	@GetMapping("/another-greeting")
	public String rOtherGreeting() {
		return "Another greeting!";
	}
	@GetMapping("/custom-greeting")
	public String rCustomGreeting(@RequestParam(value="message") String message) {
		return message;
	}

	@GetMapping("/custom/{message}")
	public String rCustomGreetingTwo(@PathVariable("message") String message) {
		return message;
	}
}
