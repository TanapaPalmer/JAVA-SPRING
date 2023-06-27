package com.codingdojoSaveTravels.controllers;

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

import com.codingdojoSaveTravels.models.Expense;
import com.codingdojoSaveTravels.services.SaveTravelsService;

@Controller
@RequestMapping("/expenses")
public class SaveTravelsController {

	
	@Autowired
	SaveTravelsService travelService;
	
	
//----------------------------------------------------------------------
	
	
	//SHOW ALL EXPENSES
	@GetMapping("")
	public String index(@ModelAttribute("expense") Expense expense, Model model) {
		List<Expense> expenses = travelService.allExpenses();
		model.addAttribute("expenses", expenses);
		return "index.jsp";
	}
	
	
//----------------------------------------------------------------------

	
	//ADD EXPENSE
	@PostMapping("/new")
	public String createExpense(@Valid @ModelAttribute("expense") Expense expense, BindingResult result, Model model) {
		if (result.hasErrors()) {
			List<Expense> expenses = travelService.allExpenses();
			model.addAttribute("expenses", expenses);
			return "index.jsp";
		}
		travelService.createExpense(expense);
		return "redirect:/expenses";
	}
	
	
//----------------------------------------------------------------------
	
	
	//SHOW EACH EXPENSE BY ID
	@GetMapping("/{id}")
	public String showEachExpense(@PathVariable("id") Long id, Model model) {
		Expense expense = travelService.findExpense(id);
		model.addAttribute("expense", expense);
		return "show.jsp";
	}
	
	
//----------------------------------------------------------------------
	
	
	//EDIT AN EXPENSE
	
	@GetMapping("/edit/{id}")
	public String editExpense(@PathVariable("id") Long id, @ModelAttribute ("expense") Expense expense, Model model) {
		model.addAttribute("expense", travelService.findExpense(id));
		return "edit.jsp";
	}

    
//----------------------------------------------------------------------
	
    
	//UPDATE AN EXPENSE
	@PostMapping("/update/{id}")
	public String updateExpense(@Valid @ModelAttribute("expense") Expense expense, BindingResult result, @PathVariable("id") Long id, Model model) {
		if(result.hasErrors()) {
		model.addAttribute("expense", expense);
		return "edit.jsp";
		}
		travelService.updateExpense(expense);
		return "redirect:/expenses";
	}	
	

//----------------------------------------------------------------------
	
	
	//DELETE AN EXPENSE
	
	@RequestMapping("/delete/{id}")
	public String deleteExpense(@PathVariable("id") Long id) {
		Expense expense = travelService.findExpense(id);
		travelService.deleteExpense(expense);
		return "redirect:/expenses";
	}
}
