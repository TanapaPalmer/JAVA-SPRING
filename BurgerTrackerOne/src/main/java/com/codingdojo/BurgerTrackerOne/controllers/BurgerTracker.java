package com.codingdojo.BurgerTrackerOne.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.BurgerTrackerOne.models.Burger;
import com.codingdojo.BurgerTrackerOne.services.BurgerTrackerService;

//VIEW ALL BURGERS, CREATE A BURGER, SHOW A BURGER BY ID, UPDATE A BURGER BY ID, DELETE A BURGER BY ID - IN POSTMAN
//SHOWING LISTS OF BURGERS IN LOCALHOST
@RestController
public class BurgerTracker {

	private final BurgerTrackerService burgertrackerService;
		
	public BurgerTracker(BurgerTrackerService burgertrackerService) {
		this.burgertrackerService = burgertrackerService;
	}
		

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		    
	//ALL BURGERS
	@RequestMapping("/burgerlists")
	public List<Burger> index() {
		return burgertrackerService.allBurgers();
	}		
		
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		    
	//CREATING THE BURGER
	@RequestMapping(value="/burgerlists", method=RequestMethod.POST)
	public Burger create(
				
			@RequestParam(value="burger_name") String burger_name,
			@RequestParam(value="restaurant_name") String restaurant_name,
			@RequestParam(value="rating") Integer rating,
			@RequestParam(value="notes") String notes) {
	
		Burger burger = new Burger(burger_name, restaurant_name, rating, notes);
	
		//"createBurger" SHOULD MATCH IN BurgerTrackerService!
		return burgertrackerService.createBurger(burger);
	
		}
		
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~    
	
    //SHOW THE BURGER BY ID    
    @RequestMapping("/burgerlists/{id}")
    public Burger show(@PathVariable("id") Long id) {
        Burger burger = burgertrackerService.findBurger(id);
        return burger;
    }
    
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    
    //UPDATING THE BURGER
    @RequestMapping(value="/burgerlists/{id}", method=RequestMethod.PUT)
    public Burger update(
    		@PathVariable("id") Long id, 
			@RequestParam(value="burger_name") String burger_name,
			@RequestParam(value="restaurant_name") String restaurant_name,
			@RequestParam(value="rating") Integer rating,
			@RequestParam(value="notes") String notes) {
    	
        Burger burger = new Burger(burger_name, restaurant_name, rating, notes);
        burger.setId(id);
        
        //"updateBurger" SHOULD MATCH IN BurgerTrackerService!
        burger = burgertrackerService.updateBurger(burger);
        return burger;
    }
    
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    
    //DELETING THE BURGER BY ID
    @RequestMapping(value="/burgerlists/{id}", method=RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
    	
        //"deleteBurger" SHOULD MATCH IN BurgerTrackerService!
        burgertrackerService.deleteBurger(id);
    }
			
}
