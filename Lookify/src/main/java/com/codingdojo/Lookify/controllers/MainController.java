package com.codingdojo.Lookify.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.Lookify.models.Song;
import com.codingdojo.Lookify.services.SongService;

@Controller
public class MainController {
	
	// ADD ONCE SERVICE IS IMPLEMENTED:
	
	@Autowired
	private SongService songService;
	
	
//**********************************************************************************************
	
    
	// ***HOMEPAGE - INDEX.JSP*** //
		
	// WE'RE USING GETMAPPING TO ANNOTATED METHODS HANDLE THE HTTP GET REQUESTS
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	
//**********************************************************************************************
	
	
	// ***DASHBOARD THAT SHOWS ALL THE SONGS*** //
	
	// WE'RE USING GETMAPPING TO ANNOTATED METHODS HANDLE THE HTTP GET REQUESTS
	@GetMapping("/dashboard")
	public String dashboard(Model model) {
		model.addAttribute("songs", songService.allSongs());
		return "dashboard.jsp";
	}
	
	
//**********************************************************************************************
	
  	// ***DASHBOARD THAT CAN SEARCH AN ARTIST NAME*** //

  	// WE'RE USING POSTMAPPING TO ANNOTATED METHODS HANDLE THE HTTP POST REQUESTS	
	@PostMapping("/dashboard")
	public String dashboard(@RequestParam("artist") String artist, Model model) {
		model.addAttribute("artist", artist);
		return "redirect:/search/"+artist;
	}

//**********************************************************************************************
	
  	// ***SEARCH BY ARTIST NAME*** //
	
	// WE'RE USING GETMAPPING TO ANNOTATED METHODS HANDLE THE HTTP GET REQUESTS	
	@GetMapping("/search/{artist}")
	public String searchResult(@PathVariable("artist") String artist, Model model) {
		model.addAttribute("songs", songService.findByArtist(artist));
		model.addAttribute("searchForArtist", artist);
		return "search.jsp";
	}
	
	
//**********************************************************************************************
    
	
  	// ***CAN ADD NEW SONGS*** //
    
	// WE'RE USING GETMAPPING TO ANNOTATED METHODS HANDLE THE HTTP GET REQUESTS
	@GetMapping("/songs/new")
	public String newSong(@ModelAttribute("song") Song song) {
		return "new.jsp";
	}
	
	
//**********************************************************************************************

	
  	// ***ADD A NEW SONG*** //

  	// WE'RE USING POSTMAPPING TO ANNOTATED METHODS HANDLE THE HTTP POST REQUESTS	
	@PostMapping("/songs/new")
	public String newSong(@Valid @ModelAttribute("song") Song song, BindingResult result) {
		if(result.hasErrors()) {
			return "new.jsp";
		}
		songService.addSong(song);
		return "redirect:/dashboard";
	}
	
	
//**********************************************************************************************
    
    
  	// ***SHOW EACH SONG BY ID*** //
    
	// WE'RE USING GETMAPPING TO ANNOTATED METHODS HANDLE THE HTTP GET REQUESTS
	@GetMapping("/songs/{id}")
	public String viewSong(@PathVariable("id") Long id, Model model) {
		model.addAttribute("song", songService.songById(id));
		return "show.jsp";
	}

//**********************************************************************************************
    
    
  	// ***DELETE A SONG BY ID*** //
    
	// WE'RE USING GETMAPPING TO ANNOTATED METHODS HANDLE THE HTTP GET REQUESTS
	@GetMapping("/songs/delete/{id}")
	public String deleteSong(@PathVariable("id") Long id) {
		songService.deleteSong(songService.songById(id));
		return "redirect:/dashboard";
	}

	
//**********************************************************************************************
    
    
  	// ***SHOW TOP-TEN SONGS BY ORDER*** //
    
	// WE'RE USING GETMAPPING TO ANNOTATED METHODS HANDLE THE HTTP GET REQUESTS
	@GetMapping("/songs/top-ten")
	public String findTopTen(Model model) {
		model.addAttribute("topten", songService.findTopTen());
		return "topten.jsp";
	}
}