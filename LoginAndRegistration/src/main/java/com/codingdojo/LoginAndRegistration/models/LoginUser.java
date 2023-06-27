package com.codingdojo.LoginAndRegistration.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class LoginUser {
    
	//IN THIS CASE WE DON'T NEED AN ID BECAUSE THE EMAIL AND PASSWORD IS FROM Users TABLE
	//WE DIDN'T CREATE THE NEW EMAIL AND PASSWORD - WE ONLY HAVE TO MAKE SURE THEY MATCH
	
    @NotEmpty(message="Email is required!")
    @Email(message="Please enter a valid email!")
    private String email;
    
    
    @NotEmpty(message="Password is required!")
    @Size(min=8, max=128, message="Password must be between 8 and 128 characters")
    private String password;
    
    
//......................................................................................


    public LoginUser() {
    }
    
    
//......................................................................................


    //GETTERS AND SETTERS
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}    
}