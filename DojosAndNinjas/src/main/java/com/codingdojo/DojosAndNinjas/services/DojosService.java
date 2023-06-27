package com.codingdojo.DojosAndNinjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.DojosAndNinjas.models.DojosModel;
import com.codingdojo.DojosAndNinjas.repositories.DojosRepository;

@Service
public class DojosService {
	
	private DojosRepository dojosRepo;
    
    public DojosService(DojosRepository dojosRepo) {
        this.dojosRepo = dojosRepo;
    }
    
    
//----------------------------------------------------------------------
	
	
  	// RETURNS ALL THE DOJOS
    
    public List<DojosModel> allDojos() {
        return dojosRepo.findAll();
    }
    
    
//----------------------------------------------------------------------
	
	
  	// CREATES A DOJO
    
    public DojosModel createDojo(DojosModel dojo) {
        return dojosRepo.save(dojo);
    }
    
    
//----------------------------------------------------------------------
	
	
  	// RETRIEVES A DOJO
    
    public DojosModel findDojo(Long id) {
        Optional<DojosModel> optionalDojos = dojosRepo.findById(id);
        if(optionalDojos.isPresent()) {
            return optionalDojos.get();
        } else {
            return null;
        }
    }
}
