package com.codingdojo.BurgerTrackerOne.controllers;

import java.util.List;

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

import com.codingdojo.BurgerTrackerOne.models.Burger;
import com.codingdojo.BurgerTrackerOne.services.BurgerTrackerService;

@Controller
public class BurgerTrackerController {
	
	@Autowired
	BurgerTrackerService burgertrackerService;

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	//HOME - SHOW ALL BURGERS
	@GetMapping("/")
	public String index(@ModelAttribute("burger") Burger burger, Model model) {
		List<Burger> burgers = burgertrackerService.allBurgers();
		model.addAttribute("burgers", burgers);
		return "index.jsp";
	}
	
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	//ADD MORE BURGERS ON INDEX PAGE
	@PostMapping("/burgers/new")
	public String create(@Valid @ModelAttribute("burger") Burger burger, BindingResult result, Model model) {
		if (result.hasErrors()) {
			List<Burger> burgers = burgertrackerService.allBurgers();
			model.addAttribute("burgers", burgers);
			return "index.jsp";
		}
		burgertrackerService.createBurger(burger);
		return "redirect:/";
	}
	
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	//EDIT BURGER	
    @RequestMapping("/edit/{id}")
    public String editBurger(@PathVariable("id") Long id, Model model) {
        Burger burger = burgertrackerService.findBurger(id);
        model.addAttribute("burger", burger);
        return "/edit.jsp";
    }

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	//UPDATE BURGER
	@PostMapping("/update/{id}")
	public String updateBurger(@Valid @ModelAttribute("burger") Burger burger, BindingResult result, @PathVariable("id") Long id, Model model) {
		if(result.hasErrors()) {
		model.addAttribute("burger", burger);
		return "index.jsp";
		}
		burgertrackerService.updateBurger(burger);
		return "redirect:/";
	}
}

