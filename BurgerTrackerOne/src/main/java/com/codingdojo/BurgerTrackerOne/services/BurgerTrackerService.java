package com.codingdojo.BurgerTrackerOne.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.BurgerTrackerOne.models.Burger;
import com.codingdojo.BurgerTrackerOne.repositories.BurgerTrackerRepository;

@Service
public class BurgerTrackerService {
	
	private final BurgerTrackerRepository burgertrackerRepository;
	
	
	private BurgerTrackerService(BurgerTrackerRepository burgertrackerRepository) {
		this.burgertrackerRepository = burgertrackerRepository;
	}
	
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	//RETURNS ALL THE BURGERS
	public List<Burger> allBurgers() {
		return burgertrackerRepository.findAll();
	}
	
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	//CREATES A BURGER
	public Burger createBurger(Burger burger) {
		return burgertrackerRepository.save(burger);
	}
	
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	//RETRIEVES A BURGER
	public Burger findBurger(Long id) {
		Optional<Burger> optionalBurger = burgertrackerRepository.findById(id);
		if(optionalBurger.isPresent()) {
			return optionalBurger.get();
		} else {
			return null;
		}
	}
	
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	
	
	//UPDATE A BOOK
	public Burger updateBurger(Burger burger) {
		return burgertrackerRepository.save(burger);
	}
	
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	
	
	//DELETE A BOOK
	public void deleteBurger(Long id) {
		burgertrackerRepository.deleteById(id);
	}
}
