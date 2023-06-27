package com.codingdojo.BookBroker.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.BookBroker.models.LoginUser;
import com.codingdojo.BookBroker.models.User;
import com.codingdojo.BookBroker.repositories.UserRepository;

@Service
public class UserService {
	
	
    @Autowired
    private UserRepository userRepo;
    
    
//**********************************************************************************************

    
    //METHOD SHOULD MATCH IN THE CONTROLLER FILE BECAUSE IT WILL BE CALLED FROM THE CONTROLLER
    //VALIDATION METHOD - USER WILL SEE THIS VALIDATION BY SUBMITTING THE REGISTRATION FROM WHEN THE CONDITION IS NOT MET
    
    public User register(User newUser, BindingResult result) {
        
        
        // EMAIL CAN'T BE TAKEN
    	Optional<User> optionalUser = userRepo.findByEmail(newUser.getEmail());
    	
    	if (optionalUser.isPresent()) {
    		
    		result.rejectValue("email", "Matches", "Account with this email already exists!");
    	}
    	
    	
        // THE CONFIRM PASSWORD HAS TO BE MATCHED
    	if(!newUser.getPassword().equals(newUser.getConfirm())) {
    		
    	    result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
    	    
    	}
        
    	
        // RETURN NULL IF ERRORS    	
    	if(result.hasErrors()) {
    		
    		return null;
    		
    	}
    
    	
        // HASH PASSWORD        
    	String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
        
        newUser.setPassword(hashed);
        
        
        //IF NO ERRORS, SEND THE NEW USER TO DB TO SAVE IT
        return userRepo.save(newUser);
              
    }
    
    
//**********************************************************************************************
    
    
    //METHOD SHOULD MATCH IN THE CONTROLLER FILE BECAUSE IT WILL BE CALLED FROM THE CONTROLLER
    //VALIDATION METHOD - USER WILL SEE THIS VALIDATION BY SUBMITTING THE LOGIN FROM WHEN THE CONDITION IS NOT MET
    
    public User login(LoginUser newLogin, BindingResult result) {
        

        // FIND USER IN THE DB BY EMAIL - EMAIL HAS TO BE MATCHED
    	Optional<User> optionalUser = userRepo.findByEmail(newLogin.getEmail());
    	
    	if (!optionalUser.isPresent()) {
    		
    		result.rejectValue("email", "Matches", "User not found!");
    		
    		return null;
    	}
    	
    	
    	// USER EXISTS, RETRIEVE USER FROM DB
    	User user = optionalUser.get();
        
    	
        // HASH PASSWORD HAS TO BE MATCHED
    	if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
    		
    	    result.rejectValue("password", "Matches", "Invalid Password!");
    	    
    	}
    	
    	
        // RETURN NULL IF ERRORS
    	if(result.hasErrors()) {
    		
    		return null;
    		
    	}
    	
    	
        // OTHERWISE, RETURN THE USER OBJECT
        return user;
    }
    
    
//**********************************************************************************************

    
    //METHOD SHOULD MATCH IN THE CONTROLLER FILE BECAUSE IT WILL BE CALLED FROM THE CONTROLLER
    //RETRIEVES A USER - FIND USER BY EMAIL
    
	public User findByEmail(String email) {
		
		Optional<User> optionalUser = userRepo.findByEmail(email);
		
		if(optionalUser.isPresent()) {
			
			return optionalUser.get();
			
		}
		
		return null;
	}
	

//**********************************************************************************************
	
	
    //METHOD SHOULD MATCH IN THE CONTROLLER FILE BECAUSE IT WILL BE CALLED FROM THE CONTROLLER
    //RETRIEVES A USER - FIND USER BY ID
	
	public User findById(Long id) {
		
		Optional<User> optionalUser = userRepo.findById(id);
		
		if(optionalUser.isPresent()) {
			
			return optionalUser.get();
			
		}
		
		return null;
	}
}
