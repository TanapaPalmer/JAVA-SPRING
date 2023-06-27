package com.codingdojo.DojosAndNinjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.DojosAndNinjas.models.DojosModel;
import com.codingdojo.DojosAndNinjas.models.NinjasModel;
import com.codingdojo.DojosAndNinjas.repositories.NinjasRepository;

@Service
public class NinjasService {

	private NinjasRepository ninjasRepo;
    
    public NinjasService(NinjasRepository ninjasRepo) {
        this.ninjasRepo = ninjasRepo;
    }
    
//----------------------------------------------------------------------
	
	
  	// RETURNS ALL THE NINJAS
    
    public List<NinjasModel> allNinjas() {
        return ninjasRepo.findAll();
    }
    
    
//----------------------------------------------------------------------
	
	
  	// CREATES A NINJA
    
    public NinjasModel createNinja(NinjasModel ninjas) {
        return ninjasRepo.save(ninjas);
    }
    
    
//----------------------------------------------------------------------
	
	
  	// RETRIEVES A NINJA
    
    public NinjasModel findNinja(Long id) {
        Optional<NinjasModel> optionalNinja = ninjasRepo.findById(id);
        if(optionalNinja.isPresent()) {
            return optionalNinja.get();
        } else {
            return null;
        }
    }
 
//----------------------------------------------------------------------
	
	
  	// RETURN THE NINJAS IN EACH DOJO - WHEN dojo_id MATCHES
    
    public List<NinjasModel> byDojo(DojosModel dojo) {
    	return ninjasRepo.findAllByDojo(dojo);
    }
}
