package com.codingdojoSaveTravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojoSaveTravels.models.Expense;
import com.codingdojoSaveTravels.repositories.SaveTravelsRepository;

@Service
public class SaveTravelsService {
	
	private SaveTravelsRepository travelRepo;
	
	private SaveTravelsService(SaveTravelsRepository travelRepo) {
		this.travelRepo = travelRepo;
	}
	
	
//----------------------------------------------------------------------
	
	
	// RETURNS ALL THE EXPENSES
	public List<Expense> allExpenses() {
		return travelRepo.findAll();
	}

	
//----------------------------------------------------------------------
	
	
	// CREATES AN EXPENSE
	public Expense createExpense(Expense expense) {
		return travelRepo.save(expense);
	}

	
//----------------------------------------------------------------------
	
	
	// RETRIEVES AN EXPENSE
	public Expense findExpense(Long id) {
		Optional<Expense> optionalExpense = travelRepo.findById(id);
		if(optionalExpense.isPresent()) {
			return optionalExpense.get();
		} else {
			return null;
		}
	}
	
//----------------------------------------------------------------------
	
	
	// UPDATE AN EXPENSE
	public Expense updateExpense(Expense expense) {
		return travelRepo.save(expense);
	}
	
	
//----------------------------------------------------------------------
	
	
	// UPDATE AN EXPENSE
	public void deleteExpense(Expense expense) {
		travelRepo.delete(expense);
	}
	
}
