package com.codingdojo.LoginAndRegistration.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.LoginAndRegistration.models.LoginUser;
import com.codingdojo.LoginAndRegistration.models.User;
import com.codingdojo.LoginAndRegistration.repositories.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepo;
    
    
//......................................................................................

    
    //METHOD SHOULD MATCH IN THE CONTROLLER FILE BECAUSE IT WILL BE CALLED FROM THE CONTROLLER
    //VALIDATION METHOD - USER WILL SEE THIS VALIDATION BY SUBMITTING THE REGISTRATION FROM WHEN THE CONDITION IS NOT MET
    
    public User register(User newUser, BindingResult result) {
    	
    	Optional<User> optionalUser = userRepo.findByEmail(newUser.getEmail());
    	
    	if(optionalUser.isPresent()) {
    		
    		result.rejectValue("email", "Matches", "An account with that email already exists!");
    	}

    	
    	if(!newUser.getPassword().equals(newUser.getConfirm())) {
    		
    	    result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
    	}

    	
        if(result.hasErrors()) {
        	
        	return null;
        }
    
        
        String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
        
        newUser.setPassword(hashed);
        
        return userRepo.save(newUser);
    }

    
//......................................................................................

    
    //METHOD SHOULD MATCH IN THE CONTROLLER FILE BECAUSE IT WILL BE CALLED FROM THE CONTROLLER
    //VALIDATION METHOD - USER WILL SEE THIS VALIDATION BY SUBMITTING THE LOGIN FROM WHEN THE CONDITION IS NOT MET
    
    public User login(LoginUser newLoginUser, BindingResult result) {
        
    	Optional<User> optionalUser = userRepo.findByEmail(newLoginUser.getEmail());
    	
    	if(!optionalUser.isPresent()) {
    		
    		result.rejectValue("email", "Matches", "User not found!");
    		
    		return null;
    	}
    	
    	
    	User user = optionalUser.get();
    	
        
    	if(!BCrypt.checkpw(newLoginUser.getPassword(), user.getPassword())) {
    		
    	    result.rejectValue("password", "Matches", "Invalid Password!");
    	}
    	
    	
    	if(result.hasErrors()) {
    		
        	return null;
        }

    	
    	return user;
    }
    
    
//......................................................................................

    
    //RETRIEVES A USER
    
    public User findById(Long id) {
    	
    	Optional<User> optionalUser = userRepo.findById(id);
    	
    	if(optionalUser.isPresent()) {
    		
    		return optionalUser.get();
    	}
    	
    	return null;
    }

}