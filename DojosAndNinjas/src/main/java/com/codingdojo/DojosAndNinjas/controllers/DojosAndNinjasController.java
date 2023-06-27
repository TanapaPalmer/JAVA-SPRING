package com.codingdojo.DojosAndNinjas.controllers;

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

import com.codingdojo.DojosAndNinjas.models.DojosModel;
import com.codingdojo.DojosAndNinjas.models.NinjasModel;
import com.codingdojo.DojosAndNinjas.services.DojosService;
import com.codingdojo.DojosAndNinjas.services.NinjasService;

@Controller
public class DojosAndNinjasController {
	
	@Autowired
	private NinjasService ninjas;
	@Autowired
	private DojosService dojos;
	
//----------------------------------------------------------------------
	
	// RENDERING FOR DOJO
	
	@GetMapping("/dojos/new")
	public String newDojo(@ModelAttribute("dojo") DojosModel dojosModel) {
		return "dojos.jsp";
	}
	
	
//----------------------------------------------------------------------
	
	// RENDERING FOR NINJA
	
	@GetMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("ninja") NinjasModel ninjasModel, Model model) {
		model.addAttribute("dojos", dojos.allDojos());
		return "ninjas.jsp";
	}
	
	
//----------------------------------------------------------------------
	
	// SHOW ALL NINJAS ON EACH DOJO - WHEN dojo_id MATCHES

	@GetMapping("/dojos/{id}")
	public String showDojo(@PathVariable("id") Long id, Model model) {

		DojosModel dojo = dojos.findDojo(id);
		model.addAttribute("dojo", dojo);
		
		return "index.jsp";
	}
	
//----------------------------------------------------------------------
	
	// CREATE A DOJO - WITH VALIDATION
	
	@PostMapping("/dojos")
	public String createDojo(@Valid @ModelAttribute("dojo") DojosModel dojosModel, BindingResult result, Model model) {
		
		if (result.hasErrors()) {
			List<DojosModel> dojo = dojos.allDojos();
			model.addAttribute("dojos", dojo);
			return "dojos.jsp";
		}
		
		DojosModel newDojo = dojos.createDojo(dojosModel);		
		return String.format("redirect:/dojos/%s",newDojo.getId());
	}
	
//----------------------------------------------------------------------
	
	// CREATE A NINJA - WITH VALIDATION
	
	@PostMapping("/ninjas")
	public String createNinja(@Valid @ModelAttribute("ninja") NinjasModel ninjasModel, BindingResult result, Model model) {
		
		if (result.hasErrors()) {
			List<NinjasModel> ninja = ninjas.allNinjas();
			model.addAttribute("ninjas", ninja);
			return "ninjas.jsp";
		}
		
		ninjasModel = ninjas.createNinja(ninjasModel);
		return "redirect:/dojos/" + ninjasModel.getDojo().getId();
	}
	
}